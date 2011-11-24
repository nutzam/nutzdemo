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
import cn.nutz_dwz_hr.wage.bean.WageInterface;

/**
* 薪资表接口设置 Module<br>
* 表名：HR_WAGE_INTERFACE<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@At("/WageInterface")
@IocBean(fields={"dao"})
public class WageInterfaceModule extends EntityService<WageInterface>{

    private static final Log log = Logs.get();
    /**
     * 跳转到添加页面-薪资表接口设置
     */
    @At
	@Ok("jsp:jsp.wage.wageInterface.input")
    public void addUi(){    	
    }
    /**
     * 跳转到修改页面-薪资表接口设置
     */
    @At
    @Ok("jsp:jsp.wage.wageInterface.input")
    public WageInterface editUi(@Param("..") WageInterface obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到查看页面-薪资表接口设置
     */
    @At
	@Ok("jsp:jsp.wage.wageInterface.view")
    public WageInterface view(@Param("..") WageInterface obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到高级查询页面-薪资表接口设置
     */
    @At
	@Ok("jsp:jsp.wage.wageInterface.query")
    public void queryUi(){    	
    }
	/**
	 * 分页查询-薪资表接口设置
	 * @param pageNum 第几页
	 * @param numPerPage  每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:jsp.wage.wageInterface.list")
	public Object list(@Param("pageNum") int pageNum ,@Param("numPerPage") int numPerPage,@Param("..") WageInterface obj){
		Pager pager = dao().createPager((pageNum<1)?1:pageNum, (numPerPage < 1)? 20:numPerPage);
		List<WageInterface> list = dao().query(WageInterface.class, bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(WageInterface.class,bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}
	/**
	 * 新增-薪资表接口设置
	 * @return
	 */
	@At
	public Object add(@Param("..") WageInterface obj){
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
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"wageInterface");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 删除-薪资表接口设置
	 * @return
	 */
	@At
	public Object delete(@Param("..") WageInterface obj){
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
			Sql sql = Sqls.create("delete from HR_WAGE_INTERFACE where id in("+ids+")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 更新-薪资表接口设置
	 * @return
	 */
	@At
	public Object update(@Param("..") WageInterface obj){
		try{
			WageInterface wag=dao().fetch(obj);
			//设置创建人
			obj.setCreateUser(wag.getCreateUser());
			//设置创建时间
			obj.setCreateDate(wag.getCreateDate());
			//设置修改人
			obj.setModifyUser(wag.getModifyUser());
			//设置修改时间
			obj.setModifyDate(wag.getModifyDate());
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"wageInterface");
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
	private Cnd bulidQureyCnd(WageInterface obj){
		Cnd cnd=null;
		if(obj!=null){
			cnd=Cnd.where("1", "=", 1);
	        //按工资账套查询
	        if(!Strings.isEmpty(obj.getAccount()))
				cnd.and("account", "=", obj.getAccount());
	        //按工资项目查询
	        if(!Strings.isEmpty(obj.getSalaryitem()))
				cnd.and("salaryitem", "=", obj.getSalaryitem());
	        //按类型查询
	        if(!Strings.isEmpty(obj.getType()))
				cnd.and("type", "=", obj.getType());
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