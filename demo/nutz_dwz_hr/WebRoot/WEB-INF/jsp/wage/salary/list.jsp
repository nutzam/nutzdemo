<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="pagerForm" method="post" action="Salary/list">
	<input type="hidden" name="pageNum" value="${obj.pager.pageNumber}" /> 
	<input type="hidden" name="numPerPage" value="${obj.pager.pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<%-- 员工 --%>
	<input type="hidden" name="employeeId" value="${obj.o.employeeId}"/>
	<%-- 账套 --%>
	<input type="hidden" name="accountId" value="${obj.o.accountId}"/>
	<%-- 薪资日期 --%>
	<input type="hidden" name="salaryDate" value="${obj.o.salaryDate}"/>
	<%-- col00 --%>
    <input type="hidden" name="col00" value="${obj.o.col00}"/>
	<%-- col01 --%>
    <input type="hidden" name="col01" value="${obj.o.col01}"/>
	<%-- col02 --%>
    <input type="hidden" name="col02" value="${obj.o.col02}"/>
	<%-- col03 --%>
    <input type="hidden" name="col03" value="${obj.o.col03}"/>
	<%-- col04 --%>
    <input type="hidden" name="col04" value="${obj.o.col04}"/>
	<%-- col05 --%>
    <input type="hidden" name="col05" value="${obj.o.col05}"/>
	<%-- col06 --%>
    <input type="hidden" name="col06" value="${obj.o.col06}"/>
	<%-- col07 --%>
    <input type="hidden" name="col07" value="${obj.o.col07}"/>
	<%-- col08 --%>
    <input type="hidden" name="col08" value="${obj.o.col08}"/>
	<%-- col09 --%>
    <input type="hidden" name="col09" value="${obj.o.col09}"/>
	<%-- col10 --%>
    <input type="hidden" name="col10" value="${obj.o.col10}"/>
	<%-- col11 --%>
    <input type="hidden" name="col11" value="${obj.o.col11}"/>
	<%-- col12 --%>
    <input type="hidden" name="col12" value="${obj.o.col12}"/>
	<%-- col13 --%>
    <input type="hidden" name="col13" value="${obj.o.col13}"/>
	<%-- col14 --%>
    <input type="hidden" name="col14" value="${obj.o.col14}"/>
	<%-- col15 --%>
    <input type="hidden" name="col15" value="${obj.o.col15}"/>
	<%-- col16 --%>
    <input type="hidden" name="col16" value="${obj.o.col16}"/>
	<%-- col17 --%>
    <input type="hidden" name="col17" value="${obj.o.col17}"/>
	<%-- col18 --%>
    <input type="hidden" name="col18" value="${obj.o.col18}"/>
	<%-- col19 --%>
    <input type="hidden" name="col19" value="${obj.o.col19}"/>
	<%-- col20 --%>
    <input type="hidden" name="col20" value="${obj.o.col20}"/>
	<%-- col21 --%>
    <input type="hidden" name="col21" value="${obj.o.col21}"/>
	<%-- col22 --%>
    <input type="hidden" name="col22" value="${obj.o.col22}"/>
	<%-- col23 --%>
    <input type="hidden" name="col23" value="${obj.o.col23}"/>
	<%-- col24 --%>
    <input type="hidden" name="col24" value="${obj.o.col24}"/>
	<%-- col25 --%>
    <input type="hidden" name="col25" value="${obj.o.col25}"/>
	<%-- col26 --%>
    <input type="hidden" name="col26" value="${obj.o.col26}"/>
	<%-- col27 --%>
    <input type="hidden" name="col27" value="${obj.o.col27}"/>
	<%-- col28 --%>
    <input type="hidden" name="col28" value="${obj.o.col28}"/>
	<%-- col29 --%>
    <input type="hidden" name="col29" value="${obj.o.col29}"/>
	<%-- col30 --%>
    <input type="hidden" name="col30" value="${obj.o.col30}"/>
	<%-- col31 --%>
    <input type="hidden" name="col31" value="${obj.o.col31}"/>
	<%-- col32 --%>
    <input type="hidden" name="col32" value="${obj.o.col32}"/>
	<%-- col33 --%>
    <input type="hidden" name="col33" value="${obj.o.col33}"/>
	<%-- col34 --%>
    <input type="hidden" name="col34" value="${obj.o.col34}"/>
	<%-- col35 --%>
    <input type="hidden" name="col35" value="${obj.o.col35}"/>
	<%-- col36 --%>
    <input type="hidden" name="col36" value="${obj.o.col36}"/>
	<%-- col37 --%>
    <input type="hidden" name="col37" value="${obj.o.col37}"/>
	<%-- col38 --%>
    <input type="hidden" name="col38" value="${obj.o.col38}"/>
	<%-- col39 --%>
    <input type="hidden" name="col39" value="${obj.o.col39}"/>
	<%-- col40 --%>
    <input type="hidden" name="col40" value="${obj.o.col40}"/>
	<%-- col41 --%>
    <input type="hidden" name="col41" value="${obj.o.col41}"/>
	<%-- col42 --%>
    <input type="hidden" name="col42" value="${obj.o.col42}"/>
	<%-- col43 --%>
    <input type="hidden" name="col43" value="${obj.o.col43}"/>
	<%-- col44 --%>
    <input type="hidden" name="col44" value="${obj.o.col44}"/>
	<%-- col45 --%>
    <input type="hidden" name="col45" value="${obj.o.col45}"/>
	<%-- col46 --%>
    <input type="hidden" name="col46" value="${obj.o.col46}"/>
	<%-- col47 --%>
    <input type="hidden" name="col47" value="${obj.o.col47}"/>
	<%-- col48 --%>
    <input type="hidden" name="col48" value="${obj.o.col48}"/>
	<%-- col49 --%>
    <input type="hidden" name="col49" value="${obj.o.col49}"/>
	<%-- col50 --%>
    <input type="hidden" name="col50" value="${obj.o.col50}"/>
	<%-- col51 --%>
    <input type="hidden" name="col51" value="${obj.o.col51}"/>
	<%-- col52 --%>
    <input type="hidden" name="col52" value="${obj.o.col52}"/>
	<%-- col53 --%>
    <input type="hidden" name="col53" value="${obj.o.col53}"/>
	<%-- col54 --%>
    <input type="hidden" name="col54" value="${obj.o.col54}"/>
	<%-- col55 --%>
    <input type="hidden" name="col55" value="${obj.o.col55}"/>
	<%-- col56 --%>
    <input type="hidden" name="col56" value="${obj.o.col56}"/>
	<%-- col57 --%>
    <input type="hidden" name="col57" value="${obj.o.col57}"/>
	<%-- col58 --%>
    <input type="hidden" name="col58" value="${obj.o.col58}"/>
	<%-- col59 --%>
    <input type="hidden" name="col59" value="${obj.o.col59}"/>
	<%-- col60 --%>
    <input type="hidden" name="col60" value="${obj.o.col60}"/>
	<%-- col61 --%>
    <input type="hidden" name="col61" value="${obj.o.col61}"/>
	<%-- col62 --%>
    <input type="hidden" name="col62" value="${obj.o.col62}"/>
	<%-- col63 --%>
    <input type="hidden" name="col63" value="${obj.o.col63}"/>
	<%-- col64 --%>
    <input type="hidden" name="col64" value="${obj.o.col64}"/>
	<%-- col65 --%>
    <input type="hidden" name="col65" value="${obj.o.col65}"/>
	<%-- col66 --%>
    <input type="hidden" name="col66" value="${obj.o.col66}"/>
	<%-- col67 --%>
    <input type="hidden" name="col67" value="${obj.o.col67}"/>
	<%-- col68 --%>
    <input type="hidden" name="col68" value="${obj.o.col68}"/>
	<%-- col69 --%>
    <input type="hidden" name="col69" value="${obj.o.col69}"/>
	<%-- col70 --%>
    <input type="hidden" name="col70" value="${obj.o.col70}"/>
	<%-- col71 --%>
    <input type="hidden" name="col71" value="${obj.o.col71}"/>
	<%-- col72 --%>
    <input type="hidden" name="col72" value="${obj.o.col72}"/>
	<%-- col73 --%>
    <input type="hidden" name="col73" value="${obj.o.col73}"/>
	<%-- col74 --%>
    <input type="hidden" name="col74" value="${obj.o.col74}"/>
	<%-- col75 --%>
    <input type="hidden" name="col75" value="${obj.o.col75}"/>
	<%-- col76 --%>
    <input type="hidden" name="col76" value="${obj.o.col76}"/>
	<%-- col77 --%>
    <input type="hidden" name="col77" value="${obj.o.col77}"/>
	<%-- col78 --%>
    <input type="hidden" name="col78" value="${obj.o.col78}"/>
	<%-- col79 --%>
    <input type="hidden" name="col79" value="${obj.o.col79}"/>
	<%-- col80 --%>
    <input type="hidden" name="col80" value="${obj.o.col80}"/>
	<%-- col81 --%>
    <input type="hidden" name="col81" value="${obj.o.col81}"/>
	<%-- col82 --%>
    <input type="hidden" name="col82" value="${obj.o.col82}"/>
	<%-- col83 --%>
    <input type="hidden" name="col83" value="${obj.o.col83}"/>
	<%-- col84 --%>
    <input type="hidden" name="col84" value="${obj.o.col84}"/>
	<%-- col85 --%>
    <input type="hidden" name="col85" value="${obj.o.col85}"/>
	<%-- col86 --%>
    <input type="hidden" name="col86" value="${obj.o.col86}"/>
	<%-- col87 --%>
    <input type="hidden" name="col87" value="${obj.o.col87}"/>
	<%-- col88 --%>
    <input type="hidden" name="col88" value="${obj.o.col88}"/>
	<%-- col89 --%>
    <input type="hidden" name="col89" value="${obj.o.col89}"/>
	<%-- col90 --%>
    <input type="hidden" name="col90" value="${obj.o.col90}"/>
	<%-- col91 --%>
    <input type="hidden" name="col91" value="${obj.o.col91}"/>
	<%-- col92 --%>
    <input type="hidden" name="col92" value="${obj.o.col92}"/>
	<%-- col93 --%>
    <input type="hidden" name="col93" value="${obj.o.col93}"/>
	<%-- col94 --%>
    <input type="hidden" name="col94" value="${obj.o.col94}"/>
	<%-- col95 --%>
    <input type="hidden" name="col95" value="${obj.o.col95}"/>
	<%-- col96 --%>
    <input type="hidden" name="col96" value="${obj.o.col96}"/>
	<%-- col97 --%>
    <input type="hidden" name="col97" value="${obj.o.col97}"/>
	<%-- col98 --%>
    <input type="hidden" name="col98" value="${obj.o.col98}"/>
	<%-- col99 --%>
    <input type="hidden" name="col99" value="${obj.o.col99}"/>
	<%-- 实发工资 --%>
    <input type="hidden" name="total" value="${obj.o.total}"/>
	<%-- 状态 --%>
	<input type="hidden" name="status" value="${obj.o.status}"/>
	<%-- 描述 --%>
	<input type="hidden" name="description" value="${obj.o.description}"/>
	<%-- 部门 --%>
	<input type="hidden" name="deptid" value="${obj.o.deptid}"/>
	<%-- salarytext00 --%>
	<input type="hidden" name="salarytext00" value="${obj.o.salarytext00}"/>
	<%-- salarytext01 --%>
	<input type="hidden" name="salarytext01" value="${obj.o.salarytext01}"/>
	<%-- salarytext02 --%>
	<input type="hidden" name="salarytext02" value="${obj.o.salarytext02}"/>
	<%-- salarytext03 --%>
	<input type="hidden" name="salarytext03" value="${obj.o.salarytext03}"/>
	<%-- salarytext04 --%>
	<input type="hidden" name="salarytext04" value="${obj.o.salarytext04}"/>
	<%-- salarytext05 --%>
	<input type="hidden" name="salarytext05" value="${obj.o.salarytext05}"/>
	<%-- salarytext06 --%>
	<input type="hidden" name="salarytext06" value="${obj.o.salarytext06}"/>
	<%-- salarytext07 --%>
	<input type="hidden" name="salarytext07" value="${obj.o.salarytext07}"/>
	<%-- salarytext08 --%>
	<input type="hidden" name="salarytext08" value="${obj.o.salarytext08}"/>
	<%-- salarytext09 --%>
	<input type="hidden" name="salarytext09" value="${obj.o.salarytext09}"/>
	<%-- 创建人 --%>
<%--<input type="hidden" name="createUser" value="${obj.o.createUser}/> --%>
	<%-- 创建时间 --%>
<%--<input type="hidden" name="createDate" value="${obj.o.createDate}/> --%>
	<%-- 修改人 --%>
<%--<input type="hidden" name="modifyUser" value="${obj.o.modifyUser}/> --%>
	<%-- 修改时间 --%>
<%--<input type="hidden" name="modifyDate" value="${obj.o.modifyDate}/> --%>
</form>
<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="Salary/list" method="post">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>员工：<input type="text" name="employeeId" value="${obj.o.employeeId}"/></td>
					<td>账套：<input type="text" name="accountId" value="${obj.o.accountId}"/></td>
					<td>薪资日期：<input type="text" name="salaryDate" value="${obj.o.salaryDate}"/></td>
<%-- 			    	<td>col00：<input type="text" name="col00" value="${obj.o.col00}/></td> --%>			        
<%-- 			    	<td>col01：<input type="text" name="col01" value="${obj.o.col01}/></td> --%>			        
<%-- 			    	<td>col02：<input type="text" name="col02" value="${obj.o.col02}/></td> --%>			        
<%-- 			    	<td>col03：<input type="text" name="col03" value="${obj.o.col03}/></td> --%>			        
<%-- 			    	<td>col04：<input type="text" name="col04" value="${obj.o.col04}/></td> --%>			        
<%-- 			    	<td>col05：<input type="text" name="col05" value="${obj.o.col05}/></td> --%>			        
<%-- 			    	<td>col06：<input type="text" name="col06" value="${obj.o.col06}/></td> --%>			        
<%-- 			    	<td>col07：<input type="text" name="col07" value="${obj.o.col07}/></td> --%>			        
<%-- 			    	<td>col08：<input type="text" name="col08" value="${obj.o.col08}/></td> --%>			        
<%-- 			    	<td>col09：<input type="text" name="col09" value="${obj.o.col09}/></td> --%>			        
<%-- 			    	<td>col10：<input type="text" name="col10" value="${obj.o.col10}/></td> --%>			        
<%-- 			    	<td>col11：<input type="text" name="col11" value="${obj.o.col11}/></td> --%>			        
<%-- 			    	<td>col12：<input type="text" name="col12" value="${obj.o.col12}/></td> --%>			        
<%-- 			    	<td>col13：<input type="text" name="col13" value="${obj.o.col13}/></td> --%>			        
<%-- 			    	<td>col14：<input type="text" name="col14" value="${obj.o.col14}/></td> --%>			        
<%-- 			    	<td>col15：<input type="text" name="col15" value="${obj.o.col15}/></td> --%>			        
<%-- 			    	<td>col16：<input type="text" name="col16" value="${obj.o.col16}/></td> --%>			        
<%-- 			    	<td>col17：<input type="text" name="col17" value="${obj.o.col17}/></td> --%>			        
<%-- 			    	<td>col18：<input type="text" name="col18" value="${obj.o.col18}/></td> --%>			        
<%-- 			    	<td>col19：<input type="text" name="col19" value="${obj.o.col19}/></td> --%>			        
<%-- 			    	<td>col20：<input type="text" name="col20" value="${obj.o.col20}/></td> --%>			        
<%-- 			    	<td>col21：<input type="text" name="col21" value="${obj.o.col21}/></td> --%>			        
<%-- 			    	<td>col22：<input type="text" name="col22" value="${obj.o.col22}/></td> --%>			        
<%-- 			    	<td>col23：<input type="text" name="col23" value="${obj.o.col23}/></td> --%>			        
<%-- 			    	<td>col24：<input type="text" name="col24" value="${obj.o.col24}/></td> --%>			        
<%-- 			    	<td>col25：<input type="text" name="col25" value="${obj.o.col25}/></td> --%>			        
<%-- 			    	<td>col26：<input type="text" name="col26" value="${obj.o.col26}/></td> --%>			        
<%-- 			    	<td>col27：<input type="text" name="col27" value="${obj.o.col27}/></td> --%>			        
<%-- 			    	<td>col28：<input type="text" name="col28" value="${obj.o.col28}/></td> --%>			        
<%-- 			    	<td>col29：<input type="text" name="col29" value="${obj.o.col29}/></td> --%>			        
<%-- 			    	<td>col30：<input type="text" name="col30" value="${obj.o.col30}/></td> --%>			        
<%-- 			    	<td>col31：<input type="text" name="col31" value="${obj.o.col31}/></td> --%>			        
<%-- 			    	<td>col32：<input type="text" name="col32" value="${obj.o.col32}/></td> --%>			        
<%-- 			    	<td>col33：<input type="text" name="col33" value="${obj.o.col33}/></td> --%>			        
<%-- 			    	<td>col34：<input type="text" name="col34" value="${obj.o.col34}/></td> --%>			        
<%-- 			    	<td>col35：<input type="text" name="col35" value="${obj.o.col35}/></td> --%>			        
<%-- 			    	<td>col36：<input type="text" name="col36" value="${obj.o.col36}/></td> --%>			        
<%-- 			    	<td>col37：<input type="text" name="col37" value="${obj.o.col37}/></td> --%>			        
<%-- 			    	<td>col38：<input type="text" name="col38" value="${obj.o.col38}/></td> --%>			        
<%-- 			    	<td>col39：<input type="text" name="col39" value="${obj.o.col39}/></td> --%>			        
<%-- 			    	<td>col40：<input type="text" name="col40" value="${obj.o.col40}/></td> --%>			        
<%-- 			    	<td>col41：<input type="text" name="col41" value="${obj.o.col41}/></td> --%>			        
<%-- 			    	<td>col42：<input type="text" name="col42" value="${obj.o.col42}/></td> --%>			        
<%-- 			    	<td>col43：<input type="text" name="col43" value="${obj.o.col43}/></td> --%>			        
<%-- 			    	<td>col44：<input type="text" name="col44" value="${obj.o.col44}/></td> --%>			        
<%-- 			    	<td>col45：<input type="text" name="col45" value="${obj.o.col45}/></td> --%>			        
<%-- 			    	<td>col46：<input type="text" name="col46" value="${obj.o.col46}/></td> --%>			        
<%-- 			    	<td>col47：<input type="text" name="col47" value="${obj.o.col47}/></td> --%>			        
<%-- 			    	<td>col48：<input type="text" name="col48" value="${obj.o.col48}/></td> --%>			        
<%-- 			    	<td>col49：<input type="text" name="col49" value="${obj.o.col49}/></td> --%>			        
<%-- 			    	<td>col50：<input type="text" name="col50" value="${obj.o.col50}/></td> --%>			        
<%-- 			    	<td>col51：<input type="text" name="col51" value="${obj.o.col51}/></td> --%>			        
<%-- 			    	<td>col52：<input type="text" name="col52" value="${obj.o.col52}/></td> --%>			        
<%-- 			    	<td>col53：<input type="text" name="col53" value="${obj.o.col53}/></td> --%>			        
<%-- 			    	<td>col54：<input type="text" name="col54" value="${obj.o.col54}/></td> --%>			        
<%-- 			    	<td>col55：<input type="text" name="col55" value="${obj.o.col55}/></td> --%>			        
<%-- 			    	<td>col56：<input type="text" name="col56" value="${obj.o.col56}/></td> --%>			        
<%-- 			    	<td>col57：<input type="text" name="col57" value="${obj.o.col57}/></td> --%>			        
<%-- 			    	<td>col58：<input type="text" name="col58" value="${obj.o.col58}/></td> --%>			        
<%-- 			    	<td>col59：<input type="text" name="col59" value="${obj.o.col59}/></td> --%>			        
<%-- 			    	<td>col60：<input type="text" name="col60" value="${obj.o.col60}/></td> --%>			        
<%-- 			    	<td>col61：<input type="text" name="col61" value="${obj.o.col61}/></td> --%>			        
<%-- 			    	<td>col62：<input type="text" name="col62" value="${obj.o.col62}/></td> --%>			        
<%-- 			    	<td>col63：<input type="text" name="col63" value="${obj.o.col63}/></td> --%>			        
<%-- 			    	<td>col64：<input type="text" name="col64" value="${obj.o.col64}/></td> --%>			        
<%-- 			    	<td>col65：<input type="text" name="col65" value="${obj.o.col65}/></td> --%>			        
<%-- 			    	<td>col66：<input type="text" name="col66" value="${obj.o.col66}/></td> --%>			        
<%-- 			    	<td>col67：<input type="text" name="col67" value="${obj.o.col67}/></td> --%>			        
<%-- 			    	<td>col68：<input type="text" name="col68" value="${obj.o.col68}/></td> --%>			        
<%-- 			    	<td>col69：<input type="text" name="col69" value="${obj.o.col69}/></td> --%>			        
<%-- 			    	<td>col70：<input type="text" name="col70" value="${obj.o.col70}/></td> --%>			        
<%-- 			    	<td>col71：<input type="text" name="col71" value="${obj.o.col71}/></td> --%>			        
<%-- 			    	<td>col72：<input type="text" name="col72" value="${obj.o.col72}/></td> --%>			        
<%-- 			    	<td>col73：<input type="text" name="col73" value="${obj.o.col73}/></td> --%>			        
<%-- 			    	<td>col74：<input type="text" name="col74" value="${obj.o.col74}/></td> --%>			        
<%-- 			    	<td>col75：<input type="text" name="col75" value="${obj.o.col75}/></td> --%>			        
<%-- 			    	<td>col76：<input type="text" name="col76" value="${obj.o.col76}/></td> --%>			        
<%-- 			    	<td>col77：<input type="text" name="col77" value="${obj.o.col77}/></td> --%>			        
<%-- 			    	<td>col78：<input type="text" name="col78" value="${obj.o.col78}/></td> --%>			        
<%-- 			    	<td>col79：<input type="text" name="col79" value="${obj.o.col79}/></td> --%>			        
<%-- 			    	<td>col80：<input type="text" name="col80" value="${obj.o.col80}/></td> --%>			        
<%-- 			    	<td>col81：<input type="text" name="col81" value="${obj.o.col81}/></td> --%>			        
<%-- 			    	<td>col82：<input type="text" name="col82" value="${obj.o.col82}/></td> --%>			        
<%-- 			    	<td>col83：<input type="text" name="col83" value="${obj.o.col83}/></td> --%>			        
<%-- 			    	<td>col84：<input type="text" name="col84" value="${obj.o.col84}/></td> --%>			        
<%-- 			    	<td>col85：<input type="text" name="col85" value="${obj.o.col85}/></td> --%>			        
<%-- 			    	<td>col86：<input type="text" name="col86" value="${obj.o.col86}/></td> --%>			        
<%-- 			    	<td>col87：<input type="text" name="col87" value="${obj.o.col87}/></td> --%>			        
<%-- 			    	<td>col88：<input type="text" name="col88" value="${obj.o.col88}/></td> --%>			        
<%-- 			    	<td>col89：<input type="text" name="col89" value="${obj.o.col89}/></td> --%>			        
<%-- 			    	<td>col90：<input type="text" name="col90" value="${obj.o.col90}/></td> --%>			        
<%-- 			    	<td>col91：<input type="text" name="col91" value="${obj.o.col91}/></td> --%>			        
<%-- 			    	<td>col92：<input type="text" name="col92" value="${obj.o.col92}/></td> --%>			        
<%-- 			    	<td>col93：<input type="text" name="col93" value="${obj.o.col93}/></td> --%>			        
<%-- 			    	<td>col94：<input type="text" name="col94" value="${obj.o.col94}/></td> --%>			        
<%-- 			    	<td>col95：<input type="text" name="col95" value="${obj.o.col95}/></td> --%>			        
<%-- 			    	<td>col96：<input type="text" name="col96" value="${obj.o.col96}/></td> --%>			        
<%-- 			    	<td>col97：<input type="text" name="col97" value="${obj.o.col97}/></td> --%>			        
<%-- 			    	<td>col98：<input type="text" name="col98" value="${obj.o.col98}/></td> --%>			        
<%-- 			    	<td>col99：<input type="text" name="col99" value="${obj.o.col99}/></td> --%>			        
<%-- 			    	<td>实发工资：<input type="text" name="total" value="${obj.o.total}/></td> --%>			        
<%-- 			    	<td>状态：<input type="text" name="status" value="${obj.o.status}/></td> --%>			        
<%-- 			    	<td>描述：<input type="text" name="description" value="${obj.o.description}/></td> --%>			        
<%-- 			    	<td>部门：<input type="text" name="deptid" value="${obj.o.deptid}/></td> --%>			        
<%-- 			    	<td>salarytext00：<input type="text" name="salarytext00" value="${obj.o.salarytext00}/></td> --%>			        
<%-- 			    	<td>salarytext01：<input type="text" name="salarytext01" value="${obj.o.salarytext01}/></td> --%>			        
<%-- 			    	<td>salarytext02：<input type="text" name="salarytext02" value="${obj.o.salarytext02}/></td> --%>			        
<%-- 			    	<td>salarytext03：<input type="text" name="salarytext03" value="${obj.o.salarytext03}/></td> --%>			        
<%-- 			    	<td>salarytext04：<input type="text" name="salarytext04" value="${obj.o.salarytext04}/></td> --%>			        
<%-- 			    	<td>salarytext05：<input type="text" name="salarytext05" value="${obj.o.salarytext05}/></td> --%>			        
<%-- 			    	<td>salarytext06：<input type="text" name="salarytext06" value="${obj.o.salarytext06}/></td> --%>			        
<%-- 			    	<td>salarytext07：<input type="text" name="salarytext07" value="${obj.o.salarytext07}/></td> --%>			        
<%-- 			    	<td>salarytext08：<input type="text" name="salarytext08" value="${obj.o.salarytext08}/></td> --%>			        
<%-- 			    	<td>salarytext09：<input type="text" name="salarytext09" value="${obj.o.salarytext09}/></td> --%>			        
<%-- 			    	<td>创建人：<input type="text" name="createUser" value="${obj.o.createUser}/></td> --%>			        
<%-- 			    	<td>创建时间：<input type="text" name="createDate" value="${obj.o.createDate}/></td> --%>			        
<%-- 			    	<td>修改人：<input type="text" name="modifyUser" value="${obj.o.modifyUser}/></td> --%>			        
<%-- 			    	<td>修改时间：<input type="text" name="modifyDate" value="${obj.o.modifyDate}/></td> --%>			        
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
					<li><a class="button" href="Salary/queryUi" target="dialog" mask="true" title="查询框"><span>高级检索</span></a></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="Salary/addUi" target="navTab" rel="newPage" title="添加薪资表"><span>添加</span></a></li>
			<li><a title="确实要删除这些记录吗?" target="selectedTodo" rel="ids" postType="string" href="Salary/delByIds" class="delete"><span>批量删除</span></a></li>
			<li><a class="edit" href="Salary/editUi?id={sid_salary}" target="navTab" rel="newPage" title="修改薪资表"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="#" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="26"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>员工</th>
				<th>账套</th>
				<th>薪资日期</th>
				<th>col00</th>
				<th>col01</th>
				<th>col02</th>
				<th>col03</th>
				<th>col04</th>
				<th>col05</th>
				<th>col06</th>
				<th>col07</th>
				<th>col08</th>
				<th>col09</th>
				<th>col10</th>
				<th>col11</th>
				<th>col12</th>
				<th>col13</th>
				<th>col14</th>
				<th>col15</th>
				<th>col16</th>
				<th>col17</th>
				<th>col18</th>
				<th>col19</th>
				<th>col20</th>
				<th>col21</th>
				<th>col22</th>
				<th>col23</th>
				<th>col24</th>
				<th>col25</th>
				<th>col26</th>
				<th>col27</th>
				<th>col28</th>
				<th>col29</th>
				<th>col30</th>
				<th>col31</th>
				<th>col32</th>
				<th>col33</th>
				<th>col34</th>
				<th>col35</th>
				<th>col36</th>
				<th>col37</th>
				<th>col38</th>
				<th>col39</th>
				<th>col40</th>
				<th>col41</th>
				<th>col42</th>
				<th>col43</th>
				<th>col44</th>
				<th>col45</th>
				<th>col46</th>
				<th>col47</th>
				<th>col48</th>
				<th>col49</th>
				<th>col50</th>
				<th>col51</th>
				<th>col52</th>
				<th>col53</th>
				<th>col54</th>
				<th>col55</th>
				<th>col56</th>
				<th>col57</th>
				<th>col58</th>
				<th>col59</th>
				<th>col60</th>
				<th>col61</th>
				<th>col62</th>
				<th>col63</th>
				<th>col64</th>
				<th>col65</th>
				<th>col66</th>
				<th>col67</th>
				<th>col68</th>
				<th>col69</th>
				<th>col70</th>
				<th>col71</th>
				<th>col72</th>
				<th>col73</th>
				<th>col74</th>
				<th>col75</th>
				<th>col76</th>
				<th>col77</th>
				<th>col78</th>
				<th>col79</th>
				<th>col80</th>
				<th>col81</th>
				<th>col82</th>
				<th>col83</th>
				<th>col84</th>
				<th>col85</th>
				<th>col86</th>
				<th>col87</th>
				<th>col88</th>
				<th>col89</th>
				<th>col90</th>
				<th>col91</th>
				<th>col92</th>
				<th>col93</th>
				<th>col94</th>
				<th>col95</th>
				<th>col96</th>
				<th>col97</th>
				<th>col98</th>
				<th>col99</th>
				<th>实发工资</th>
				<th>状态</th>
				<th>描述</th>
				<th>部门</th>
				<th>salarytext00</th>
				<th>salarytext01</th>
				<th>salarytext02</th>
				<th>salarytext03</th>
				<th>salarytext04</th>
				<th>salarytext05</th>
				<th>salarytext06</th>
				<th>salarytext07</th>
				<th>salarytext08</th>
				<th>salarytext09</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>修改时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${obj.list}" var="sal">
				<tr target="sid_salary" rel="${sal.id }">
				<td><input name="ids" value="'${sal.id}'" type="checkbox"></td>
					<td>${sal.employeeId}</td>
					<td>${sal.accountId}</td>
					<td>${sal.salaryDate}</td>
					<td>${sal.col00}</td>
					<td>${sal.col01}</td>
					<td>${sal.col02}</td>
					<td>${sal.col03}</td>
					<td>${sal.col04}</td>
					<td>${sal.col05}</td>
					<td>${sal.col06}</td>
					<td>${sal.col07}</td>
					<td>${sal.col08}</td>
					<td>${sal.col09}</td>
					<td>${sal.col10}</td>
					<td>${sal.col11}</td>
					<td>${sal.col12}</td>
					<td>${sal.col13}</td>
					<td>${sal.col14}</td>
					<td>${sal.col15}</td>
					<td>${sal.col16}</td>
					<td>${sal.col17}</td>
					<td>${sal.col18}</td>
					<td>${sal.col19}</td>
					<td>${sal.col20}</td>
					<td>${sal.col21}</td>
					<td>${sal.col22}</td>
					<td>${sal.col23}</td>
					<td>${sal.col24}</td>
					<td>${sal.col25}</td>
					<td>${sal.col26}</td>
					<td>${sal.col27}</td>
					<td>${sal.col28}</td>
					<td>${sal.col29}</td>
					<td>${sal.col30}</td>
					<td>${sal.col31}</td>
					<td>${sal.col32}</td>
					<td>${sal.col33}</td>
					<td>${sal.col34}</td>
					<td>${sal.col35}</td>
					<td>${sal.col36}</td>
					<td>${sal.col37}</td>
					<td>${sal.col38}</td>
					<td>${sal.col39}</td>
					<td>${sal.col40}</td>
					<td>${sal.col41}</td>
					<td>${sal.col42}</td>
					<td>${sal.col43}</td>
					<td>${sal.col44}</td>
					<td>${sal.col45}</td>
					<td>${sal.col46}</td>
					<td>${sal.col47}</td>
					<td>${sal.col48}</td>
					<td>${sal.col49}</td>
					<td>${sal.col50}</td>
					<td>${sal.col51}</td>
					<td>${sal.col52}</td>
					<td>${sal.col53}</td>
					<td>${sal.col54}</td>
					<td>${sal.col55}</td>
					<td>${sal.col56}</td>
					<td>${sal.col57}</td>
					<td>${sal.col58}</td>
					<td>${sal.col59}</td>
					<td>${sal.col60}</td>
					<td>${sal.col61}</td>
					<td>${sal.col62}</td>
					<td>${sal.col63}</td>
					<td>${sal.col64}</td>
					<td>${sal.col65}</td>
					<td>${sal.col66}</td>
					<td>${sal.col67}</td>
					<td>${sal.col68}</td>
					<td>${sal.col69}</td>
					<td>${sal.col70}</td>
					<td>${sal.col71}</td>
					<td>${sal.col72}</td>
					<td>${sal.col73}</td>
					<td>${sal.col74}</td>
					<td>${sal.col75}</td>
					<td>${sal.col76}</td>
					<td>${sal.col77}</td>
					<td>${sal.col78}</td>
					<td>${sal.col79}</td>
					<td>${sal.col80}</td>
					<td>${sal.col81}</td>
					<td>${sal.col82}</td>
					<td>${sal.col83}</td>
					<td>${sal.col84}</td>
					<td>${sal.col85}</td>
					<td>${sal.col86}</td>
					<td>${sal.col87}</td>
					<td>${sal.col88}</td>
					<td>${sal.col89}</td>
					<td>${sal.col90}</td>
					<td>${sal.col91}</td>
					<td>${sal.col92}</td>
					<td>${sal.col93}</td>
					<td>${sal.col94}</td>
					<td>${sal.col95}</td>
					<td>${sal.col96}</td>
					<td>${sal.col97}</td>
					<td>${sal.col98}</td>
					<td>${sal.col99}</td>
					<td>${sal.total}</td>
					<td>${sal.status}</td>
					<td>${sal.description}</td>
					<td>${sal.deptid}</td>
					<td>${sal.salarytext00}</td>
					<td>${sal.salarytext01}</td>
					<td>${sal.salarytext02}</td>
					<td>${sal.salarytext03}</td>
					<td>${sal.salarytext04}</td>
					<td>${sal.salarytext05}</td>
					<td>${sal.salarytext06}</td>
					<td>${sal.salarytext07}</td>
					<td>${sal.salarytext08}</td>
					<td>${sal.salarytext09}</td>
					<td>${sal.createUser}</td>
					<td>${sal.createDate}</td>
					<td>${sal.modifyUser}</td>
					<td>${sal.modifyDate}</td>
				<td>
				<a title="删除薪资表" target="ajaxTodo" href="Salary/delete?id=${sal.id }" class="btnDel">删除薪资表</a>
				<a title="查看薪资表" target="navTab" href="Salary/view?id=${sal.id }" class="btnView">查看薪资表</a>
				<a title="编辑薪资表" target="navTab" href="Salary/editUi?id=${sal.id }" class="btnEdit">编辑薪资表</a>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span> 
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
			<c:forEach begin="10" end="40" step="10" varStatus="s">
				<option value="${s.index}" ${obj.pager.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>
			<span>条，共${obj.pager.recordCount}条</span>
		</div>

		<div class="pagination" targetType="navTab" totalCount="${obj.pager.recordCount}" numPerPage="${obj.pager.pageSize}" pageNumShown="10" currentPage="${obj.pager.pageNumber}"></div>

	</div>
</div>