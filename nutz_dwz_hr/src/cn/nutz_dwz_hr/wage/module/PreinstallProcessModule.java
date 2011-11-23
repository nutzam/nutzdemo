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
import cn.nutz_dwz_hr.wage.bean.PreinstallProcess;

/**
* 预设工序 Module<br>
* 表名：HR_PREINSTALL_PROCESS<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@At("/PreinstallProcess")
@IocBean(fields={"dao"})
public class PreinstallProcessModule extends EntityService<PreinstallProcess>{

    private static final Log log = Logs.get();
    /**
     * 跳转到添加页面-预设工序
     */
    @At
	@Ok("jsp:jsp.wage.preinstallProcess.input")
    public void addUi(){    	
    }
    /**
     * 跳转到修改页面-预设工序
     */
    @At
    @Ok("jsp:jsp.wage.preinstallProcess.input")
    public PreinstallProcess editUi(@Param("..") PreinstallProcess obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到查看页面-预设工序
     */
    @At
	@Ok("jsp:jsp.wage.preinstallProcess.view")
    public PreinstallProcess view(@Param("..") PreinstallProcess obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到高级查询页面-预设工序
     */
    @At
	@Ok("jsp:jsp.wage.preinstallProcess.query")
    public void queryUi(){    	
    }
	/**
	 * 分页查询-预设工序
	 * @param pageNum 第几页
	 * @param numPerPage  每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:jsp.wage.preinstallProcess.list")
	public Object list(@Param("pageNum") int pageNum ,@Param("numPerPage") int numPerPage,@Param("..") PreinstallProcess obj){
		Pager pager = dao().createPager((pageNum<1)?1:pageNum, (numPerPage < 1)? 20:numPerPage);
		List<PreinstallProcess> list = dao().query(PreinstallProcess.class, bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(PreinstallProcess.class,bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}
	/**
	 * 新增-预设工序
	 * @return
	 */
	@At
	public Object add(@Param("..") PreinstallProcess obj){
		try{
			//设置id
			obj.setId(UUIDUtil.get());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"preinstallProcess");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 删除-预设工序
	 * @return
	 */
	@At
	public Object delete(@Param("..") PreinstallProcess obj){
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
			Sql sql = Sqls.create("delete from HR_PREINSTALL_PROCESS where id in("+ids+")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 更新-预设工序
	 * @return
	 */
	@At
	public Object update(@Param("..") PreinstallProcess obj){
		try{
			PreinstallProcess pre=dao().fetch(obj);
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"preinstallProcess");
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
	private Cnd bulidQureyCnd(PreinstallProcess obj){
		Cnd cnd=null;
		if(obj!=null){
			cnd=Cnd.where("1", "=", 1);
	        //按工序查询
	        if(!Strings.isEmpty(obj.getName()))
				cnd.and("name", "=", obj.getName());
		}
		return cnd;
	}
}