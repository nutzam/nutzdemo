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
import cn.nutz_dwz_hr.wage.bean.PieceRate;

/**
* 计件工资 Module<br>
* 表名：HR_PIECE_RATE<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@At("/PieceRate")
@IocBean(fields={"dao"})
public class PieceRateModule extends EntityService<PieceRate>{

    private static final Log log = Logs.get();
    /**
     * 跳转到添加页面-计件工资
     */
    @At
	@Ok("jsp:jsp.wage.pieceRate.input")
    public void addUi(){    	
    }
    /**
     * 跳转到修改页面-计件工资
     */
    @At
    @Ok("jsp:jsp.wage.pieceRate.input")
    public PieceRate editUi(@Param("..") PieceRate obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到查看页面-计件工资
     */
    @At
	@Ok("jsp:jsp.wage.pieceRate.view")
    public PieceRate view(@Param("..") PieceRate obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到高级查询页面-计件工资
     */
    @At
	@Ok("jsp:jsp.wage.pieceRate.query")
    public void queryUi(){    	
    }
	/**
	 * 分页查询-计件工资
	 * @param pageNum 第几页
	 * @param numPerPage  每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:jsp.wage.pieceRate.list")
	public Object list(@Param("pageNum") int pageNum ,@Param("numPerPage") int numPerPage,@Param("..") PieceRate obj){
		Pager pager = dao().createPager((pageNum<1)?1:pageNum, (numPerPage < 1)? 20:numPerPage);
		List<PieceRate> list = dao().query(PieceRate.class, bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(PieceRate.class,bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}
	/**
	 * 新增-计件工资
	 * @return
	 */
	@At
	public Object add(@Param("..") PieceRate obj){
		try{
			//设置id
			obj.setId(UUIDUtil.get());
			//设置工票日期
			obj.setWtDate(DateUtil.getCurrentDate());
			//设置创建人
			obj.setCreateUser(WebUtil.getLoginUser());
			//设置创建时间
			obj.setCreateDate(DateUtil.getCurrentDate());
			//设置修改人
			obj.setModifyUser(WebUtil.getLoginUser());
			//设置修改时间
			obj.setModifyDate(DateUtil.getCurrentDate());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"pieceRate");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 删除-计件工资
	 * @return
	 */
	@At
	public Object delete(@Param("..") PieceRate obj){
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
			Sql sql = Sqls.create("delete from HR_PIECE_RATE where id in("+ids+")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 更新-计件工资
	 * @return
	 */
	@At
	public Object update(@Param("..") PieceRate obj){
		try{
			PieceRate pie=dao().fetch(obj);
			//设置创建人
			obj.setCreateUser(pie.getCreateUser());
			//设置创建时间
			obj.setCreateDate(pie.getCreateDate());
			//设置修改人
			obj.setModifyUser(pie.getModifyUser());
			//设置修改时间
			obj.setModifyDate(pie.getModifyDate());
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"pieceRate");
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
	private Cnd bulidQureyCnd(PieceRate obj){
		Cnd cnd=null;
		if(obj!=null){
			cnd=Cnd.where("1", "=", 1);
	        //按产品查询
	        if(!Strings.isEmpty(obj.getProduct()))
				cnd.and("product", "=", obj.getProduct());
	        //按工序查询
	        if(!Strings.isEmpty(obj.getProcess()))
				cnd.and("process", "=", obj.getProcess());
	        //按工票日期查询
	        if(!Strings.isEmpty(obj.getWtDate()))
				cnd.and("wtDate", "=", obj.getWtDate());
	        //按人员编号查询
	        if(!Strings.isEmpty(obj.getEmployee()))
				cnd.and("employee", "=", obj.getEmployee());
	        //按合格数量查询
	        if(null!=obj.getQualifiedNumber())
				cnd.and("qualifiedNumber", "=", obj.getQualifiedNumber());
	        //按金额查询
	        if(null!=obj.getMoney())
				cnd.and("money", "=", obj.getMoney());
	        //按废品数量查询
	        if(null!=obj.getQuantityScrapped())
				cnd.and("quantityScrapped", "=", obj.getQuantityScrapped());
	        //按废品扣款查询
	        if(null!=obj.getWasteDeductions())
				cnd.and("wasteDeductions", "=", obj.getWasteDeductions());
	        //按计件金额查询
	        if(null!=obj.getAmount())
				cnd.and("amount", "=", obj.getAmount());
	        //按流水号查询
	        if(null!=obj.getSerialNumber())
				cnd.and("serialNumber", "=", obj.getSerialNumber());
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