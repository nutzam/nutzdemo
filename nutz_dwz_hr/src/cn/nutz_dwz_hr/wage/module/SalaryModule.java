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
import cn.nutz_dwz_hr.wage.bean.Salary;

/**
* 薪资表 Module<br>
* 表名：HR_SALARY<br>
* @author Dawn  email: csg0328#gmail.com
* @date 2011-11-22
* @version 1.0
*/
@At("/Salary")
@IocBean(fields={"dao"})
public class SalaryModule extends EntityService<Salary>{

    private static final Log log = Logs.get();
    /**
     * 跳转到添加页面-薪资表
     */
    @At
	@Ok("jsp:jsp.wage.salary.input")
    public void addUi(){    	
    }
    /**
     * 跳转到修改页面-薪资表
     */
    @At
    @Ok("jsp:jsp.wage.salary.input")
    public Salary editUi(@Param("..") Salary obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到查看页面-薪资表
     */
    @At
	@Ok("jsp:jsp.wage.salary.view")
    public Salary view(@Param("..") Salary obj){
    	return dao().fetch(obj);
    }
    /**
     * 跳转到高级查询页面-薪资表
     */
    @At
	@Ok("jsp:jsp.wage.salary.query")
    public void queryUi(){    	
    }
	/**
	 * 分页查询-薪资表
	 * @param pageNum 第几页
	 * @param numPerPage  每页显示多少条
	 * @return
	 */
	@At
	@Ok("jsp:jsp.wage.salary.list")
	public Object list(@Param("pageNum") int pageNum ,@Param("numPerPage") int numPerPage,@Param("..") Salary obj){
		Pager pager = dao().createPager((pageNum<1)?1:pageNum, (numPerPage < 1)? 20:numPerPage);
		List<Salary> list = dao().query(Salary.class, bulidQureyCnd(obj), pager);
		Map<String, Object> map = new HashMap<String, Object>();
		if (pager != null) {
			pager.setRecordCount(dao().count(Salary.class,bulidQureyCnd(obj)));
			map.put("pager", pager);
		}
		map.put("o", obj);
		map.put("list", list);
		return map;
	}
	/**
	 * 新增-薪资表
	 * @return
	 */
	@At
	public Object add(@Param("..") Salary obj){
		try{
			//设置id
			obj.setId(UUIDUtil.get());
			//设置薪资日期
			obj.setSalaryDate(DateUtil.getCurrentDate());
			//设置创建人
			obj.setCreateUser(WebUtil.getLoginUser());
			//设置创建时间
			obj.setCreateDate(DateUtil.getCurrentDate());
			//设置修改人
			obj.setModifyUser(WebUtil.getLoginUser());
			//设置修改时间
			obj.setModifyDate(DateUtil.getCurrentDate());
			dao().insert(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"salary");
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 删除-薪资表
	 * @return
	 */
	@At
	public Object delete(@Param("..") Salary obj){
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
			Sql sql = Sqls.create("delete from HR_SALARY where id in("+ids+")");
			dao().execute(sql);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK);
		}catch (Throwable e) {
			if (log.isDebugEnabled())
				log.debug("E!!",e);
			return DwzUtil.dialogAjaxDone(DwzUtil.FAIL);
		}
	}
	/**
	 * 更新-薪资表
	 * @return
	 */
	@At
	public Object update(@Param("..") Salary obj){
		try{
			Salary sal=dao().fetch(obj);
			//设置创建人
			obj.setCreateUser(sal.getCreateUser());
			//设置创建时间
			obj.setCreateDate(sal.getCreateDate());
			//设置修改人
			obj.setModifyUser(sal.getModifyUser());
			//设置修改时间
			obj.setModifyDate(sal.getModifyDate());
			dao().update(obj);
			return DwzUtil.dialogAjaxDone(DwzUtil.OK,"salary");
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
	private Cnd bulidQureyCnd(Salary obj){
		Cnd cnd=null;
		if(obj!=null){
			cnd=Cnd.where("1", "=", 1);
	        //按员工查询
	        if(!Strings.isEmpty(obj.getEmployeeId()))
				cnd.and("employeeId", "=", obj.getEmployeeId());
	        //按账套查询
	        if(!Strings.isEmpty(obj.getAccountId()))
				cnd.and("accountId", "=", obj.getAccountId());
	        //按薪资日期查询
	        if(!Strings.isEmpty(obj.getSalaryDate()))
				cnd.and("salaryDate", "=", obj.getSalaryDate());
	        //按col00查询
	        if(null!=obj.getCol00())
				cnd.and("col00", "=", obj.getCol00());
	        //按col01查询
	        if(null!=obj.getCol01())
				cnd.and("col01", "=", obj.getCol01());
	        //按col02查询
	        if(null!=obj.getCol02())
				cnd.and("col02", "=", obj.getCol02());
	        //按col03查询
	        if(null!=obj.getCol03())
				cnd.and("col03", "=", obj.getCol03());
	        //按col04查询
	        if(null!=obj.getCol04())
				cnd.and("col04", "=", obj.getCol04());
	        //按col05查询
	        if(null!=obj.getCol05())
				cnd.and("col05", "=", obj.getCol05());
	        //按col06查询
	        if(null!=obj.getCol06())
				cnd.and("col06", "=", obj.getCol06());
	        //按col07查询
	        if(null!=obj.getCol07())
				cnd.and("col07", "=", obj.getCol07());
	        //按col08查询
	        if(null!=obj.getCol08())
				cnd.and("col08", "=", obj.getCol08());
	        //按col09查询
	        if(null!=obj.getCol09())
				cnd.and("col09", "=", obj.getCol09());
	        //按col10查询
	        if(null!=obj.getCol10())
				cnd.and("col10", "=", obj.getCol10());
	        //按col11查询
	        if(null!=obj.getCol11())
				cnd.and("col11", "=", obj.getCol11());
	        //按col12查询
	        if(null!=obj.getCol12())
				cnd.and("col12", "=", obj.getCol12());
	        //按col13查询
	        if(null!=obj.getCol13())
				cnd.and("col13", "=", obj.getCol13());
	        //按col14查询
	        if(null!=obj.getCol14())
				cnd.and("col14", "=", obj.getCol14());
	        //按col15查询
	        if(null!=obj.getCol15())
				cnd.and("col15", "=", obj.getCol15());
	        //按col16查询
	        if(null!=obj.getCol16())
				cnd.and("col16", "=", obj.getCol16());
	        //按col17查询
	        if(null!=obj.getCol17())
				cnd.and("col17", "=", obj.getCol17());
	        //按col18查询
	        if(null!=obj.getCol18())
				cnd.and("col18", "=", obj.getCol18());
	        //按col19查询
	        if(null!=obj.getCol19())
				cnd.and("col19", "=", obj.getCol19());
	        //按col20查询
	        if(null!=obj.getCol20())
				cnd.and("col20", "=", obj.getCol20());
	        //按col21查询
	        if(null!=obj.getCol21())
				cnd.and("col21", "=", obj.getCol21());
	        //按col22查询
	        if(null!=obj.getCol22())
				cnd.and("col22", "=", obj.getCol22());
	        //按col23查询
	        if(null!=obj.getCol23())
				cnd.and("col23", "=", obj.getCol23());
	        //按col24查询
	        if(null!=obj.getCol24())
				cnd.and("col24", "=", obj.getCol24());
	        //按col25查询
	        if(null!=obj.getCol25())
				cnd.and("col25", "=", obj.getCol25());
	        //按col26查询
	        if(null!=obj.getCol26())
				cnd.and("col26", "=", obj.getCol26());
	        //按col27查询
	        if(null!=obj.getCol27())
				cnd.and("col27", "=", obj.getCol27());
	        //按col28查询
	        if(null!=obj.getCol28())
				cnd.and("col28", "=", obj.getCol28());
	        //按col29查询
	        if(null!=obj.getCol29())
				cnd.and("col29", "=", obj.getCol29());
	        //按col30查询
	        if(null!=obj.getCol30())
				cnd.and("col30", "=", obj.getCol30());
	        //按col31查询
	        if(null!=obj.getCol31())
				cnd.and("col31", "=", obj.getCol31());
	        //按col32查询
	        if(null!=obj.getCol32())
				cnd.and("col32", "=", obj.getCol32());
	        //按col33查询
	        if(null!=obj.getCol33())
				cnd.and("col33", "=", obj.getCol33());
	        //按col34查询
	        if(null!=obj.getCol34())
				cnd.and("col34", "=", obj.getCol34());
	        //按col35查询
	        if(null!=obj.getCol35())
				cnd.and("col35", "=", obj.getCol35());
	        //按col36查询
	        if(null!=obj.getCol36())
				cnd.and("col36", "=", obj.getCol36());
	        //按col37查询
	        if(null!=obj.getCol37())
				cnd.and("col37", "=", obj.getCol37());
	        //按col38查询
	        if(null!=obj.getCol38())
				cnd.and("col38", "=", obj.getCol38());
	        //按col39查询
	        if(null!=obj.getCol39())
				cnd.and("col39", "=", obj.getCol39());
	        //按col40查询
	        if(null!=obj.getCol40())
				cnd.and("col40", "=", obj.getCol40());
	        //按col41查询
	        if(null!=obj.getCol41())
				cnd.and("col41", "=", obj.getCol41());
	        //按col42查询
	        if(null!=obj.getCol42())
				cnd.and("col42", "=", obj.getCol42());
	        //按col43查询
	        if(null!=obj.getCol43())
				cnd.and("col43", "=", obj.getCol43());
	        //按col44查询
	        if(null!=obj.getCol44())
				cnd.and("col44", "=", obj.getCol44());
	        //按col45查询
	        if(null!=obj.getCol45())
				cnd.and("col45", "=", obj.getCol45());
	        //按col46查询
	        if(null!=obj.getCol46())
				cnd.and("col46", "=", obj.getCol46());
	        //按col47查询
	        if(null!=obj.getCol47())
				cnd.and("col47", "=", obj.getCol47());
	        //按col48查询
	        if(null!=obj.getCol48())
				cnd.and("col48", "=", obj.getCol48());
	        //按col49查询
	        if(null!=obj.getCol49())
				cnd.and("col49", "=", obj.getCol49());
	        //按col50查询
	        if(null!=obj.getCol50())
				cnd.and("col50", "=", obj.getCol50());
	        //按col51查询
	        if(null!=obj.getCol51())
				cnd.and("col51", "=", obj.getCol51());
	        //按col52查询
	        if(null!=obj.getCol52())
				cnd.and("col52", "=", obj.getCol52());
	        //按col53查询
	        if(null!=obj.getCol53())
				cnd.and("col53", "=", obj.getCol53());
	        //按col54查询
	        if(null!=obj.getCol54())
				cnd.and("col54", "=", obj.getCol54());
	        //按col55查询
	        if(null!=obj.getCol55())
				cnd.and("col55", "=", obj.getCol55());
	        //按col56查询
	        if(null!=obj.getCol56())
				cnd.and("col56", "=", obj.getCol56());
	        //按col57查询
	        if(null!=obj.getCol57())
				cnd.and("col57", "=", obj.getCol57());
	        //按col58查询
	        if(null!=obj.getCol58())
				cnd.and("col58", "=", obj.getCol58());
	        //按col59查询
	        if(null!=obj.getCol59())
				cnd.and("col59", "=", obj.getCol59());
	        //按col60查询
	        if(null!=obj.getCol60())
				cnd.and("col60", "=", obj.getCol60());
	        //按col61查询
	        if(null!=obj.getCol61())
				cnd.and("col61", "=", obj.getCol61());
	        //按col62查询
	        if(null!=obj.getCol62())
				cnd.and("col62", "=", obj.getCol62());
	        //按col63查询
	        if(null!=obj.getCol63())
				cnd.and("col63", "=", obj.getCol63());
	        //按col64查询
	        if(null!=obj.getCol64())
				cnd.and("col64", "=", obj.getCol64());
	        //按col65查询
	        if(null!=obj.getCol65())
				cnd.and("col65", "=", obj.getCol65());
	        //按col66查询
	        if(null!=obj.getCol66())
				cnd.and("col66", "=", obj.getCol66());
	        //按col67查询
	        if(null!=obj.getCol67())
				cnd.and("col67", "=", obj.getCol67());
	        //按col68查询
	        if(null!=obj.getCol68())
				cnd.and("col68", "=", obj.getCol68());
	        //按col69查询
	        if(null!=obj.getCol69())
				cnd.and("col69", "=", obj.getCol69());
	        //按col70查询
	        if(null!=obj.getCol70())
				cnd.and("col70", "=", obj.getCol70());
	        //按col71查询
	        if(null!=obj.getCol71())
				cnd.and("col71", "=", obj.getCol71());
	        //按col72查询
	        if(null!=obj.getCol72())
				cnd.and("col72", "=", obj.getCol72());
	        //按col73查询
	        if(null!=obj.getCol73())
				cnd.and("col73", "=", obj.getCol73());
	        //按col74查询
	        if(null!=obj.getCol74())
				cnd.and("col74", "=", obj.getCol74());
	        //按col75查询
	        if(null!=obj.getCol75())
				cnd.and("col75", "=", obj.getCol75());
	        //按col76查询
	        if(null!=obj.getCol76())
				cnd.and("col76", "=", obj.getCol76());
	        //按col77查询
	        if(null!=obj.getCol77())
				cnd.and("col77", "=", obj.getCol77());
	        //按col78查询
	        if(null!=obj.getCol78())
				cnd.and("col78", "=", obj.getCol78());
	        //按col79查询
	        if(null!=obj.getCol79())
				cnd.and("col79", "=", obj.getCol79());
	        //按col80查询
	        if(null!=obj.getCol80())
				cnd.and("col80", "=", obj.getCol80());
	        //按col81查询
	        if(null!=obj.getCol81())
				cnd.and("col81", "=", obj.getCol81());
	        //按col82查询
	        if(null!=obj.getCol82())
				cnd.and("col82", "=", obj.getCol82());
	        //按col83查询
	        if(null!=obj.getCol83())
				cnd.and("col83", "=", obj.getCol83());
	        //按col84查询
	        if(null!=obj.getCol84())
				cnd.and("col84", "=", obj.getCol84());
	        //按col85查询
	        if(null!=obj.getCol85())
				cnd.and("col85", "=", obj.getCol85());
	        //按col86查询
	        if(null!=obj.getCol86())
				cnd.and("col86", "=", obj.getCol86());
	        //按col87查询
	        if(null!=obj.getCol87())
				cnd.and("col87", "=", obj.getCol87());
	        //按col88查询
	        if(null!=obj.getCol88())
				cnd.and("col88", "=", obj.getCol88());
	        //按col89查询
	        if(null!=obj.getCol89())
				cnd.and("col89", "=", obj.getCol89());
	        //按col90查询
	        if(null!=obj.getCol90())
				cnd.and("col90", "=", obj.getCol90());
	        //按col91查询
	        if(null!=obj.getCol91())
				cnd.and("col91", "=", obj.getCol91());
	        //按col92查询
	        if(null!=obj.getCol92())
				cnd.and("col92", "=", obj.getCol92());
	        //按col93查询
	        if(null!=obj.getCol93())
				cnd.and("col93", "=", obj.getCol93());
	        //按col94查询
	        if(null!=obj.getCol94())
				cnd.and("col94", "=", obj.getCol94());
	        //按col95查询
	        if(null!=obj.getCol95())
				cnd.and("col95", "=", obj.getCol95());
	        //按col96查询
	        if(null!=obj.getCol96())
				cnd.and("col96", "=", obj.getCol96());
	        //按col97查询
	        if(null!=obj.getCol97())
				cnd.and("col97", "=", obj.getCol97());
	        //按col98查询
	        if(null!=obj.getCol98())
				cnd.and("col98", "=", obj.getCol98());
	        //按col99查询
	        if(null!=obj.getCol99())
				cnd.and("col99", "=", obj.getCol99());
	        //按实发工资查询
	        if(null!=obj.getTotal())
				cnd.and("total", "=", obj.getTotal());
	        //按状态查询
	        if(!Strings.isEmpty(obj.getStatus()))
				cnd.and("status", "=", obj.getStatus());
	        //按描述查询
	        if(!Strings.isEmpty(obj.getDescription()))
				cnd.and("description", "=", obj.getDescription());
	        //按部门查询
	        if(!Strings.isEmpty(obj.getDeptid()))
				cnd.and("deptid", "=", obj.getDeptid());
	        //按salarytext00查询
	        if(!Strings.isEmpty(obj.getSalarytext00()))
				cnd.and("salarytext00", "=", obj.getSalarytext00());
	        //按salarytext01查询
	        if(!Strings.isEmpty(obj.getSalarytext01()))
				cnd.and("salarytext01", "=", obj.getSalarytext01());
	        //按salarytext02查询
	        if(!Strings.isEmpty(obj.getSalarytext02()))
				cnd.and("salarytext02", "=", obj.getSalarytext02());
	        //按salarytext03查询
	        if(!Strings.isEmpty(obj.getSalarytext03()))
				cnd.and("salarytext03", "=", obj.getSalarytext03());
	        //按salarytext04查询
	        if(!Strings.isEmpty(obj.getSalarytext04()))
				cnd.and("salarytext04", "=", obj.getSalarytext04());
	        //按salarytext05查询
	        if(!Strings.isEmpty(obj.getSalarytext05()))
				cnd.and("salarytext05", "=", obj.getSalarytext05());
	        //按salarytext06查询
	        if(!Strings.isEmpty(obj.getSalarytext06()))
				cnd.and("salarytext06", "=", obj.getSalarytext06());
	        //按salarytext07查询
	        if(!Strings.isEmpty(obj.getSalarytext07()))
				cnd.and("salarytext07", "=", obj.getSalarytext07());
	        //按salarytext08查询
	        if(!Strings.isEmpty(obj.getSalarytext08()))
				cnd.and("salarytext08", "=", obj.getSalarytext08());
	        //按salarytext09查询
	        if(!Strings.isEmpty(obj.getSalarytext09()))
				cnd.and("salarytext09", "=", obj.getSalarytext09());
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