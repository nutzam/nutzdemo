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
import cn.nutz_dwz_hr.wage.bean.HourlyWages;

/**
* 计时工资 Module<br>
* 表名：HR_HOURLY_WAGES<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@At("/HourlyWages")
@IocBean(fields={"dao"})
public class HourlyWagesModule extends EntityService<HourlyWages>{

    private static final Log log = Logs.get();
    /**
     * 跳转到添加页面-计时工资
     */
    @At
	@Ok("jsp:jsp.wage.hourlyWages.input")
    public void addUi(){    	
    }
    /**
     * 跳转到修改页面-计时工资
     */
    @At
    @Ok("jsp:jsp.wage.hourlyWages.input")
    public HourlyWages editUi(@Param("..") HourlyWages obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到查看页面-计时工资
     */
    @At
	@Ok("jsp:jsp.wage.hourlyWages.view")
    public HourlyWages view(@Param("..") HourlyWages obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到高级查询页面-计时工资
     */
    @At
	@Ok("jsp:jsp.wage.hourlyWages.query")
    public void queryUi(){    	
    }
	/**
	 * 分页查询-计时工资
	 * @param pageNum 第几页
	 * @param numPerPage  每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:jsp.wage.hourlyWages.list")
	public Object list(@Param("pageNum") int pageNum ,@Param("numPerPage") int numPerPage,@Param("..") HourlyWages obj){
		Pager pager = dao().createPager((pageNum<1)?1:pageNum, (numPerPage < 1)? 20:numPerPage);
		List<HourlyWages> list = dao().query(HourlyWages.class, bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(HourlyWages.class,bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}
	/**
	 * 新增-计时工资
	 * @return
	 */
	@At
	public Object add(@Param("..") HourlyWages obj){
		try{
			//设置id
			obj.setId(UUIDUtil.get());
			//设置日期
			obj.setDate(DateUtil.getCurrentDate());
			//设置创建人
			obj.setCreateUser(WebUtil.getLoginUser());
			//设置创建时间
			obj.setCreateDate(DateUtil.getCurrentDate());
			//设置修改人
			obj.setModifyUser(WebUtil.getLoginUser());
			//设置修改时间
			obj.setModifyDate(DateUtil.getCurrentDate());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"hourlyWages");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 删除-计时工资
	 * @return
	 */
	@At
	public Object delete(@Param("..") HourlyWages obj){
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
			Sql sql = Sqls.create("delete from HR_HOURLY_WAGES where id in("+ids+")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 更新-计时工资
	 * @return
	 */
	@At
	public Object update(@Param("..") HourlyWages obj){
		try{
			HourlyWages hou=dao().fetch(obj);
			//设置创建人
			obj.setCreateUser(hou.getCreateUser());
			//设置创建时间
			obj.setCreateDate(hou.getCreateDate());
			//设置修改人
			obj.setModifyUser(hou.getModifyUser());
			//设置修改时间
			obj.setModifyDate(hou.getModifyDate());
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"hourlyWages");
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
	private Cnd bulidQureyCnd(HourlyWages obj){
		Cnd cnd=null;
		if(obj!=null){
			cnd=Cnd.where("1", "=", 1);
	        //按日期查询
	        if(!Strings.isEmpty(obj.getDate()))
				cnd.and("date", "=", obj.getDate());
	        //按工作时间查询
	        if(null!=obj.getWorkHour())
				cnd.and("workHour", "=", obj.getWorkHour());
	        //按生产单号查询
	        if(!Strings.isEmpty(obj.getProductionOrder()))
				cnd.and("productionOrder", "=", obj.getProductionOrder());
	        //按员工查询
	        if(!Strings.isEmpty(obj.getEmployee()))
				cnd.and("employee", "=", obj.getEmployee());
	        //按工种查询
	        if(!Strings.isEmpty(obj.getTypeOfWork()))
				cnd.and("typeOfWork", "=", obj.getTypeOfWork());
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
	        //按备注查询
	        if(!Strings.isEmpty(obj.getRemarks()))
				cnd.and("remarks", "=", obj.getRemarks());
		}
		return cnd;
	}
}