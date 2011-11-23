package cn.nutz_dwz_hr.wage.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nutz.dao.Cnd;
import org.nutz.dao.Sqls;
import org.nutz.dao.pager.Pager;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.service.EntityService;

import org.nutz.lang.Strings;
import org.nutz.log.Log;
import org.nutz.log.Logs;

import cn.nutz_dwz_hr.utils.DateUtil;
import cn.nutz_dwz_hr.utils.DwzUtil;
import cn.nutz_dwz_hr.utils.UUIDUtil;
import cn.nutz_dwz_hr.utils.WebUtil;
import cn.nutz_dwz_hr.wage.bean.SalaryItem;

/**
* 工资项目 Module<br>
* 表名：HR_SALARY_ITEM<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@At("/SalaryItem")
@IocBean(fields={"dao"})
public class SalaryItemModule extends EntityService<SalaryItem>{

    private static final Log log = Logs.get();
    /**
     * 跳转到添加页面-工资项目
     */
    @At
	@Ok("jsp:jsp.wage.salaryItem.input")
    public void addUi(){    	
    }
    /**
     * 跳转到修改页面-工资项目
     */
    @At
    @Ok("jsp:jsp.wage.salaryItem.input")
    public SalaryItem editUi(@Param("..") SalaryItem obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到查看页面-工资项目
     */
    @At
	@Ok("jsp:jsp.wage.salaryItem.view")
    public SalaryItem view(@Param("..") SalaryItem obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到高级查询页面-工资项目
     */
    @At
	@Ok("jsp:jsp.wage.salaryItem.query")
    public void queryUi(){    	
    }
	/**
	 * 分页查询-工资项目
	 * @param pageNum 第几页
	 * @param numPerPage  每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:jsp.wage.salaryItem.list")
	public Object list(@Param("pageNum") int pageNum ,@Param("numPerPage") int numPerPage,@Param("..") SalaryItem obj){
		Pager pager = dao().createPager((pageNum<1)?1:pageNum, (numPerPage < 1)? 20:numPerPage);
		List<SalaryItem> list = dao().query(SalaryItem.class, bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(SalaryItem.class,bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}
	/**
	 * 新增-工资项目
	 * @return
	 */
	@At
	public Object add(@Param("..") SalaryItem obj){
		try{
			//设置id
			obj.setId(UUIDUtil.get());
			//设置创建人
			obj.setCreateUser(WebUtil.getLoginUser());
			//设置创建时间
			obj.setCreateDate(DateUtil.getCurrentDate());
			//设置修改人
			obj.setModifyUser(WebUtil.getLoginUser());
			//设置修改时间
			obj.setModifyDate(DateUtil.getCurrentDate());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"salaryItem");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 删除-工资项目
	 * @return
	 */
	@At
	public Object delete(@Param("..") SalaryItem obj){
		try{
			dao().delete(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 根据ids删除数据信息
	 * 
	 * @param ids
	 * @param ioc
	 * @return
	 */
	@At
	public Object delByIds(@Param("ids") String ids) {
		try{		
			Sql sql = Sqls.create("delete from HR_SALARY_ITEM where id in("+ids+")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 更新-工资项目
	 * @return
	 */
	@At
	public Object update(@Param("..") SalaryItem obj){
		try{
			SalaryItem sal=dao().fetch(obj);
			//设置创建人
			obj.setCreateUser(sal.getCreateUser());
			//设置创建时间
			obj.setCreateDate(sal.getCreateDate());
			//设置修改人
			obj.setModifyUser(sal.getModifyUser());
			//设置修改时间
			obj.setModifyDate(sal.getModifyDate());
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"salaryItem");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 构建查询条件
	 * @param obj
	 * @return
	 */
	private Cnd bulidQureyCnd(SalaryItem obj){
		Cnd cnd=null;
		if(obj!=null){
			cnd=Cnd.where("1", "=", 1);
	        //按在薪资表中对应的列查询
	        if(!Strings.isEmpty(obj.getSalaryColumn()))
				cnd.and("salaryColumn", "=", obj.getSalaryColumn());
	        //按工资账套查询
	        if(!Strings.isEmpty(obj.getAccountId()))
				cnd.and("accountId", "=", obj.getAccountId());
	        //按工资项目查询
	        if(!Strings.isEmpty(obj.getItemName()))
				cnd.and("itemName", "=", obj.getItemName());
	        //按项目类型查询
	        if(!Strings.isEmpty(obj.getItemType()))
				cnd.and("itemType", "=", obj.getItemType());
	        //按小数位数查询
	        if(null!=obj.getDecimals())
				cnd.and("decimals", "=", obj.getDecimals());
	        //按舍位方式查询
	        if(!Strings.isEmpty(obj.getRound()))
				cnd.and("round", "=", obj.getRound());
	        //按初始值查询
	        if(null!=obj.getInitialValue())
				cnd.and("initialValue", "=", obj.getInitialValue());
	        //按显示公式查询
	        if(!Strings.isEmpty(obj.getDisplayFormular()))
				cnd.and("displayFormular", "=", obj.getDisplayFormular());
	        //按数据公式查询
	        if(!Strings.isEmpty(obj.getDbFormular()))
				cnd.and("dbFormular", "=", obj.getDbFormular());
	        //按描述查询
	        if(!Strings.isEmpty(obj.getDescription()))
				cnd.and("description", "=", obj.getDescription());
	        //按创建人查询
	        if(!Strings.isEmpty(obj.getCreateUser()))
				cnd.and("createUser", "=", obj.getCreateUser());
	        //按创建时间查询
	        if(!Strings.isEmpty(obj.getCreateDate()))
				cnd.and("createDate", "=", obj.getCreateDate());
	        //按修改人查询
	    	if(!Strings.isEmpty(obj.getModifyUser()))
				cnd.and("modifyUser", "=", obj.getModifyUser());
	        //按修改时间查询
	    	if(!Strings.isEmpty(obj.getModifyDate()))
				cnd.and("modifyDate", "=", obj.getModifyDate());
		}
		return cnd;
	}
}