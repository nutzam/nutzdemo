<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="Salary/<c:choose><c:when test="${obj==null}">add</c:when><c:otherwise>update</c:otherwise></c:choose>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="id" value="${obj.id}">
			<p>
				<label>员工：</label>
				<input name="employeeId" type="text" size="30" value="${obj.employeeId}" class="required" maxlength="36"/>
			</p>
			<p>
				<label>账套：</label>
				<input name="accountId" type="text" size="30" value="${obj.accountId}" class="required" maxlength="36"/>
			</p>
			<p>
				<label>col00：</label>
				<input name="col00" type="text" size="30" value="${obj.col00}" class="number" />
			</p>
			<p>
				<label>col01：</label>
				<input name="col01" type="text" size="30" value="${obj.col01}" class="number" />
			</p>
			<p>
				<label>col02：</label>
				<input name="col02" type="text" size="30" value="${obj.col02}" class="number" />
			</p>
			<p>
				<label>col03：</label>
				<input name="col03" type="text" size="30" value="${obj.col03}" class="number" />
			</p>
			<p>
				<label>col04：</label>
				<input name="col04" type="text" size="30" value="${obj.col04}" class="number" />
			</p>
			<p>
				<label>col05：</label>
				<input name="col05" type="text" size="30" value="${obj.col05}" class="number" />
			</p>
			<p>
				<label>col06：</label>
				<input name="col06" type="text" size="30" value="${obj.col06}" class="number" />
			</p>
			<p>
				<label>col07：</label>
				<input name="col07" type="text" size="30" value="${obj.col07}" class="number" />
			</p>
			<p>
				<label>col08：</label>
				<input name="col08" type="text" size="30" value="${obj.col08}" class="number" />
			</p>
			<p>
				<label>col09：</label>
				<input name="col09" type="text" size="30" value="${obj.col09}" class="number" />
			</p>
			<p>
				<label>col10：</label>
				<input name="col10" type="text" size="30" value="${obj.col10}" class="number" />
			</p>
			<p>
				<label>col11：</label>
				<input name="col11" type="text" size="30" value="${obj.col11}" class="number" />
			</p>
			<p>
				<label>col12：</label>
				<input name="col12" type="text" size="30" value="${obj.col12}" class="number" />
			</p>
			<p>
				<label>col13：</label>
				<input name="col13" type="text" size="30" value="${obj.col13}" class="number" />
			</p>
			<p>
				<label>col14：</label>
				<input name="col14" type="text" size="30" value="${obj.col14}" class="number" />
			</p>
			<p>
				<label>col15：</label>
				<input name="col15" type="text" size="30" value="${obj.col15}" class="number" />
			</p>
			<p>
				<label>col16：</label>
				<input name="col16" type="text" size="30" value="${obj.col16}" class="number" />
			</p>
			<p>
				<label>col17：</label>
				<input name="col17" type="text" size="30" value="${obj.col17}" class="number" />
			</p>
			<p>
				<label>col18：</label>
				<input name="col18" type="text" size="30" value="${obj.col18}" class="number" />
			</p>
			<p>
				<label>col19：</label>
				<input name="col19" type="text" size="30" value="${obj.col19}" class="number" />
			</p>
			<p>
				<label>col20：</label>
				<input name="col20" type="text" size="30" value="${obj.col20}" class="number" />
			</p>
			<p>
				<label>col21：</label>
				<input name="col21" type="text" size="30" value="${obj.col21}" class="number" />
			</p>
			<p>
				<label>col22：</label>
				<input name="col22" type="text" size="30" value="${obj.col22}" class="number" />
			</p>
			<p>
				<label>col23：</label>
				<input name="col23" type="text" size="30" value="${obj.col23}" class="number" />
			</p>
			<p>
				<label>col24：</label>
				<input name="col24" type="text" size="30" value="${obj.col24}" class="number" />
			</p>
			<p>
				<label>col25：</label>
				<input name="col25" type="text" size="30" value="${obj.col25}" class="number" />
			</p>
			<p>
				<label>col26：</label>
				<input name="col26" type="text" size="30" value="${obj.col26}" class="number" />
			</p>
			<p>
				<label>col27：</label>
				<input name="col27" type="text" size="30" value="${obj.col27}" class="number" />
			</p>
			<p>
				<label>col28：</label>
				<input name="col28" type="text" size="30" value="${obj.col28}" class="number" />
			</p>
			<p>
				<label>col29：</label>
				<input name="col29" type="text" size="30" value="${obj.col29}" class="number" />
			</p>
			<p>
				<label>col30：</label>
				<input name="col30" type="text" size="30" value="${obj.col30}" class="number" />
			</p>
			<p>
				<label>col31：</label>
				<input name="col31" type="text" size="30" value="${obj.col31}" class="number" />
			</p>
			<p>
				<label>col32：</label>
				<input name="col32" type="text" size="30" value="${obj.col32}" class="number" />
			</p>
			<p>
				<label>col33：</label>
				<input name="col33" type="text" size="30" value="${obj.col33}" class="number" />
			</p>
			<p>
				<label>col34：</label>
				<input name="col34" type="text" size="30" value="${obj.col34}" class="number" />
			</p>
			<p>
				<label>col35：</label>
				<input name="col35" type="text" size="30" value="${obj.col35}" class="number" />
			</p>
			<p>
				<label>col36：</label>
				<input name="col36" type="text" size="30" value="${obj.col36}" class="number" />
			</p>
			<p>
				<label>col37：</label>
				<input name="col37" type="text" size="30" value="${obj.col37}" class="number" />
			</p>
			<p>
				<label>col38：</label>
				<input name="col38" type="text" size="30" value="${obj.col38}" class="number" />
			</p>
			<p>
				<label>col39：</label>
				<input name="col39" type="text" size="30" value="${obj.col39}" class="number" />
			</p>
			<p>
				<label>col40：</label>
				<input name="col40" type="text" size="30" value="${obj.col40}" class="number" />
			</p>
			<p>
				<label>col41：</label>
				<input name="col41" type="text" size="30" value="${obj.col41}" class="number" />
			</p>
			<p>
				<label>col42：</label>
				<input name="col42" type="text" size="30" value="${obj.col42}" class="number" />
			</p>
			<p>
				<label>col43：</label>
				<input name="col43" type="text" size="30" value="${obj.col43}" class="number" />
			</p>
			<p>
				<label>col44：</label>
				<input name="col44" type="text" size="30" value="${obj.col44}" class="number" />
			</p>
			<p>
				<label>col45：</label>
				<input name="col45" type="text" size="30" value="${obj.col45}" class="number" />
			</p>
			<p>
				<label>col46：</label>
				<input name="col46" type="text" size="30" value="${obj.col46}" class="number" />
			</p>
			<p>
				<label>col47：</label>
				<input name="col47" type="text" size="30" value="${obj.col47}" class="number" />
			</p>
			<p>
				<label>col48：</label>
				<input name="col48" type="text" size="30" value="${obj.col48}" class="number" />
			</p>
			<p>
				<label>col49：</label>
				<input name="col49" type="text" size="30" value="${obj.col49}" class="number" />
			</p>
			<p>
				<label>col50：</label>
				<input name="col50" type="text" size="30" value="${obj.col50}" class="number" />
			</p>
			<p>
				<label>col51：</label>
				<input name="col51" type="text" size="30" value="${obj.col51}" class="number" />
			</p>
			<p>
				<label>col52：</label>
				<input name="col52" type="text" size="30" value="${obj.col52}" class="number" />
			</p>
			<p>
				<label>col53：</label>
				<input name="col53" type="text" size="30" value="${obj.col53}" class="number" />
			</p>
			<p>
				<label>col54：</label>
				<input name="col54" type="text" size="30" value="${obj.col54}" class="number" />
			</p>
			<p>
				<label>col55：</label>
				<input name="col55" type="text" size="30" value="${obj.col55}" class="number" />
			</p>
			<p>
				<label>col56：</label>
				<input name="col56" type="text" size="30" value="${obj.col56}" class="number" />
			</p>
			<p>
				<label>col57：</label>
				<input name="col57" type="text" size="30" value="${obj.col57}" class="number" />
			</p>
			<p>
				<label>col58：</label>
				<input name="col58" type="text" size="30" value="${obj.col58}" class="number" />
			</p>
			<p>
				<label>col59：</label>
				<input name="col59" type="text" size="30" value="${obj.col59}" class="number" />
			</p>
			<p>
				<label>col60：</label>
				<input name="col60" type="text" size="30" value="${obj.col60}" class="number" />
			</p>
			<p>
				<label>col61：</label>
				<input name="col61" type="text" size="30" value="${obj.col61}" class="number" />
			</p>
			<p>
				<label>col62：</label>
				<input name="col62" type="text" size="30" value="${obj.col62}" class="number" />
			</p>
			<p>
				<label>col63：</label>
				<input name="col63" type="text" size="30" value="${obj.col63}" class="number" />
			</p>
			<p>
				<label>col64：</label>
				<input name="col64" type="text" size="30" value="${obj.col64}" class="number" />
			</p>
			<p>
				<label>col65：</label>
				<input name="col65" type="text" size="30" value="${obj.col65}" class="number" />
			</p>
			<p>
				<label>col66：</label>
				<input name="col66" type="text" size="30" value="${obj.col66}" class="number" />
			</p>
			<p>
				<label>col67：</label>
				<input name="col67" type="text" size="30" value="${obj.col67}" class="number" />
			</p>
			<p>
				<label>col68：</label>
				<input name="col68" type="text" size="30" value="${obj.col68}" class="number" />
			</p>
			<p>
				<label>col69：</label>
				<input name="col69" type="text" size="30" value="${obj.col69}" class="number" />
			</p>
			<p>
				<label>col70：</label>
				<input name="col70" type="text" size="30" value="${obj.col70}" class="number" />
			</p>
			<p>
				<label>col71：</label>
				<input name="col71" type="text" size="30" value="${obj.col71}" class="number" />
			</p>
			<p>
				<label>col72：</label>
				<input name="col72" type="text" size="30" value="${obj.col72}" class="number" />
			</p>
			<p>
				<label>col73：</label>
				<input name="col73" type="text" size="30" value="${obj.col73}" class="number" />
			</p>
			<p>
				<label>col74：</label>
				<input name="col74" type="text" size="30" value="${obj.col74}" class="number" />
			</p>
			<p>
				<label>col75：</label>
				<input name="col75" type="text" size="30" value="${obj.col75}" class="number" />
			</p>
			<p>
				<label>col76：</label>
				<input name="col76" type="text" size="30" value="${obj.col76}" class="number" />
			</p>
			<p>
				<label>col77：</label>
				<input name="col77" type="text" size="30" value="${obj.col77}" class="number" />
			</p>
			<p>
				<label>col78：</label>
				<input name="col78" type="text" size="30" value="${obj.col78}" class="number" />
			</p>
			<p>
				<label>col79：</label>
				<input name="col79" type="text" size="30" value="${obj.col79}" class="number" />
			</p>
			<p>
				<label>col80：</label>
				<input name="col80" type="text" size="30" value="${obj.col80}" class="number" />
			</p>
			<p>
				<label>col81：</label>
				<input name="col81" type="text" size="30" value="${obj.col81}" class="number" />
			</p>
			<p>
				<label>col82：</label>
				<input name="col82" type="text" size="30" value="${obj.col82}" class="number" />
			</p>
			<p>
				<label>col83：</label>
				<input name="col83" type="text" size="30" value="${obj.col83}" class="number" />
			</p>
			<p>
				<label>col84：</label>
				<input name="col84" type="text" size="30" value="${obj.col84}" class="number" />
			</p>
			<p>
				<label>col85：</label>
				<input name="col85" type="text" size="30" value="${obj.col85}" class="number" />
			</p>
			<p>
				<label>col86：</label>
				<input name="col86" type="text" size="30" value="${obj.col86}" class="number" />
			</p>
			<p>
				<label>col87：</label>
				<input name="col87" type="text" size="30" value="${obj.col87}" class="number" />
			</p>
			<p>
				<label>col88：</label>
				<input name="col88" type="text" size="30" value="${obj.col88}" class="number" />
			</p>
			<p>
				<label>col89：</label>
				<input name="col89" type="text" size="30" value="${obj.col89}" class="number" />
			</p>
			<p>
				<label>col90：</label>
				<input name="col90" type="text" size="30" value="${obj.col90}" class="number" />
			</p>
			<p>
				<label>col91：</label>
				<input name="col91" type="text" size="30" value="${obj.col91}" class="number" />
			</p>
			<p>
				<label>col92：</label>
				<input name="col92" type="text" size="30" value="${obj.col92}" class="number" />
			</p>
			<p>
				<label>col93：</label>
				<input name="col93" type="text" size="30" value="${obj.col93}" class="number" />
			</p>
			<p>
				<label>col94：</label>
				<input name="col94" type="text" size="30" value="${obj.col94}" class="number" />
			</p>
			<p>
				<label>col95：</label>
				<input name="col95" type="text" size="30" value="${obj.col95}" class="number" />
			</p>
			<p>
				<label>col96：</label>
				<input name="col96" type="text" size="30" value="${obj.col96}" class="number" />
			</p>
			<p>
				<label>col97：</label>
				<input name="col97" type="text" size="30" value="${obj.col97}" class="number" />
			</p>
			<p>
				<label>col98：</label>
				<input name="col98" type="text" size="30" value="${obj.col98}" class="number" />
			</p>
			<p>
				<label>col99：</label>
				<input name="col99" type="text" size="30" value="${obj.col99}" class="number" />
			</p>
			<p>
				<label>实发工资：</label>
				<input name="total" type="text" size="30" value="${obj.total}" class="number" class="required"/>
			</p>
			<p>
				<label>状态：</label>
				<input name="status" type="text" size="30" value="${obj.status}" class="required" maxlength="50"/>
			</p>
			<p>
				<label>描述：</label>
				<input name="description" type="text" size="30" value="${obj.description}"  maxlength="255"/>
			</p>
			<p>
				<label>部门：</label>
				<input name="deptid" type="text" size="30" value="${obj.deptid}" class="required" maxlength="36"/>
			</p>
			<p>
				<label>salarytext00：</label>
				<input name="salarytext00" type="text" size="30" value="${obj.salarytext00}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext01：</label>
				<input name="salarytext01" type="text" size="30" value="${obj.salarytext01}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext02：</label>
				<input name="salarytext02" type="text" size="30" value="${obj.salarytext02}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext03：</label>
				<input name="salarytext03" type="text" size="30" value="${obj.salarytext03}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext04：</label>
				<input name="salarytext04" type="text" size="30" value="${obj.salarytext04}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext05：</label>
				<input name="salarytext05" type="text" size="30" value="${obj.salarytext05}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext06：</label>
				<input name="salarytext06" type="text" size="30" value="${obj.salarytext06}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext07：</label>
				<input name="salarytext07" type="text" size="30" value="${obj.salarytext07}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext08：</label>
				<input name="salarytext08" type="text" size="30" value="${obj.salarytext08}"  maxlength="200"/>
			</p>
			<p>
				<label>salarytext09：</label>
				<input name="salarytext09" type="text" size="30" value="${obj.salarytext09}"  maxlength="200"/>
			</p>
		
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
