<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="page">
	<div class="pageContent">
		<form method="post" action="Salary/list" class="pageForm" onsubmit="return navTabSearch(this, 'salary');">
			<div class="pageFormContent" layoutH="58">
<!-- 				<div> -->
<!-- 					<label>请输入检索条件：</label> -->
<!-- 					<input type="text" size="50" minlength="3" maxlength="10"/> -->
<!-- 				</div> -->
				<div class="divider">divider</div>
		        <div>
				<label>员工：</label>
				<input type="text" name="employeeId" value="${obj.o.employeeId}" size="25" />
				<span class="inputInfo">员工</span>
				</div>
		        <div>
				<label>账套：</label>
				<input type="text" name="accountId" value="${obj.o.accountId}" size="25" />
				<span class="inputInfo">账套</span>
				</div>
		        <div>
				<label>薪资日期：</label>
				<input type="text" name="salaryDate" value="${obj.o.salaryDate}" size="25" />
				<span class="inputInfo">薪资日期</span>
				</div>
		        <div>
				<label>col00：</label>
				<input type="text" name="col00" value="${obj.o.col00}" size="25" />
				<span class="inputInfo">col00</span>
				</div>
		        <div>
				<label>col01：</label>
				<input type="text" name="col01" value="${obj.o.col01}" size="25" />
				<span class="inputInfo">col01</span>
				</div>
		        <div>
				<label>col02：</label>
				<input type="text" name="col02" value="${obj.o.col02}" size="25" />
				<span class="inputInfo">col02</span>
				</div>
		        <div>
				<label>col03：</label>
				<input type="text" name="col03" value="${obj.o.col03}" size="25" />
				<span class="inputInfo">col03</span>
				</div>
		        <div>
				<label>col04：</label>
				<input type="text" name="col04" value="${obj.o.col04}" size="25" />
				<span class="inputInfo">col04</span>
				</div>
		        <div>
				<label>col05：</label>
				<input type="text" name="col05" value="${obj.o.col05}" size="25" />
				<span class="inputInfo">col05</span>
				</div>
		        <div>
				<label>col06：</label>
				<input type="text" name="col06" value="${obj.o.col06}" size="25" />
				<span class="inputInfo">col06</span>
				</div>
		        <div>
				<label>col07：</label>
				<input type="text" name="col07" value="${obj.o.col07}" size="25" />
				<span class="inputInfo">col07</span>
				</div>
		        <div>
				<label>col08：</label>
				<input type="text" name="col08" value="${obj.o.col08}" size="25" />
				<span class="inputInfo">col08</span>
				</div>
		        <div>
				<label>col09：</label>
				<input type="text" name="col09" value="${obj.o.col09}" size="25" />
				<span class="inputInfo">col09</span>
				</div>
		        <div>
				<label>col10：</label>
				<input type="text" name="col10" value="${obj.o.col10}" size="25" />
				<span class="inputInfo">col10</span>
				</div>
		        <div>
				<label>col11：</label>
				<input type="text" name="col11" value="${obj.o.col11}" size="25" />
				<span class="inputInfo">col11</span>
				</div>
		        <div>
				<label>col12：</label>
				<input type="text" name="col12" value="${obj.o.col12}" size="25" />
				<span class="inputInfo">col12</span>
				</div>
		        <div>
				<label>col13：</label>
				<input type="text" name="col13" value="${obj.o.col13}" size="25" />
				<span class="inputInfo">col13</span>
				</div>
		        <div>
				<label>col14：</label>
				<input type="text" name="col14" value="${obj.o.col14}" size="25" />
				<span class="inputInfo">col14</span>
				</div>
		        <div>
				<label>col15：</label>
				<input type="text" name="col15" value="${obj.o.col15}" size="25" />
				<span class="inputInfo">col15</span>
				</div>
		        <div>
				<label>col16：</label>
				<input type="text" name="col16" value="${obj.o.col16}" size="25" />
				<span class="inputInfo">col16</span>
				</div>
		        <div>
				<label>col17：</label>
				<input type="text" name="col17" value="${obj.o.col17}" size="25" />
				<span class="inputInfo">col17</span>
				</div>
		        <div>
				<label>col18：</label>
				<input type="text" name="col18" value="${obj.o.col18}" size="25" />
				<span class="inputInfo">col18</span>
				</div>
		        <div>
				<label>col19：</label>
				<input type="text" name="col19" value="${obj.o.col19}" size="25" />
				<span class="inputInfo">col19</span>
				</div>
		        <div>
				<label>col20：</label>
				<input type="text" name="col20" value="${obj.o.col20}" size="25" />
				<span class="inputInfo">col20</span>
				</div>
		        <div>
				<label>col21：</label>
				<input type="text" name="col21" value="${obj.o.col21}" size="25" />
				<span class="inputInfo">col21</span>
				</div>
		        <div>
				<label>col22：</label>
				<input type="text" name="col22" value="${obj.o.col22}" size="25" />
				<span class="inputInfo">col22</span>
				</div>
		        <div>
				<label>col23：</label>
				<input type="text" name="col23" value="${obj.o.col23}" size="25" />
				<span class="inputInfo">col23</span>
				</div>
		        <div>
				<label>col24：</label>
				<input type="text" name="col24" value="${obj.o.col24}" size="25" />
				<span class="inputInfo">col24</span>
				</div>
		        <div>
				<label>col25：</label>
				<input type="text" name="col25" value="${obj.o.col25}" size="25" />
				<span class="inputInfo">col25</span>
				</div>
		        <div>
				<label>col26：</label>
				<input type="text" name="col26" value="${obj.o.col26}" size="25" />
				<span class="inputInfo">col26</span>
				</div>
		        <div>
				<label>col27：</label>
				<input type="text" name="col27" value="${obj.o.col27}" size="25" />
				<span class="inputInfo">col27</span>
				</div>
		        <div>
				<label>col28：</label>
				<input type="text" name="col28" value="${obj.o.col28}" size="25" />
				<span class="inputInfo">col28</span>
				</div>
		        <div>
				<label>col29：</label>
				<input type="text" name="col29" value="${obj.o.col29}" size="25" />
				<span class="inputInfo">col29</span>
				</div>
		        <div>
				<label>col30：</label>
				<input type="text" name="col30" value="${obj.o.col30}" size="25" />
				<span class="inputInfo">col30</span>
				</div>
		        <div>
				<label>col31：</label>
				<input type="text" name="col31" value="${obj.o.col31}" size="25" />
				<span class="inputInfo">col31</span>
				</div>
		        <div>
				<label>col32：</label>
				<input type="text" name="col32" value="${obj.o.col32}" size="25" />
				<span class="inputInfo">col32</span>
				</div>
		        <div>
				<label>col33：</label>
				<input type="text" name="col33" value="${obj.o.col33}" size="25" />
				<span class="inputInfo">col33</span>
				</div>
		        <div>
				<label>col34：</label>
				<input type="text" name="col34" value="${obj.o.col34}" size="25" />
				<span class="inputInfo">col34</span>
				</div>
		        <div>
				<label>col35：</label>
				<input type="text" name="col35" value="${obj.o.col35}" size="25" />
				<span class="inputInfo">col35</span>
				</div>
		        <div>
				<label>col36：</label>
				<input type="text" name="col36" value="${obj.o.col36}" size="25" />
				<span class="inputInfo">col36</span>
				</div>
		        <div>
				<label>col37：</label>
				<input type="text" name="col37" value="${obj.o.col37}" size="25" />
				<span class="inputInfo">col37</span>
				</div>
		        <div>
				<label>col38：</label>
				<input type="text" name="col38" value="${obj.o.col38}" size="25" />
				<span class="inputInfo">col38</span>
				</div>
		        <div>
				<label>col39：</label>
				<input type="text" name="col39" value="${obj.o.col39}" size="25" />
				<span class="inputInfo">col39</span>
				</div>
		        <div>
				<label>col40：</label>
				<input type="text" name="col40" value="${obj.o.col40}" size="25" />
				<span class="inputInfo">col40</span>
				</div>
		        <div>
				<label>col41：</label>
				<input type="text" name="col41" value="${obj.o.col41}" size="25" />
				<span class="inputInfo">col41</span>
				</div>
		        <div>
				<label>col42：</label>
				<input type="text" name="col42" value="${obj.o.col42}" size="25" />
				<span class="inputInfo">col42</span>
				</div>
		        <div>
				<label>col43：</label>
				<input type="text" name="col43" value="${obj.o.col43}" size="25" />
				<span class="inputInfo">col43</span>
				</div>
		        <div>
				<label>col44：</label>
				<input type="text" name="col44" value="${obj.o.col44}" size="25" />
				<span class="inputInfo">col44</span>
				</div>
		        <div>
				<label>col45：</label>
				<input type="text" name="col45" value="${obj.o.col45}" size="25" />
				<span class="inputInfo">col45</span>
				</div>
		        <div>
				<label>col46：</label>
				<input type="text" name="col46" value="${obj.o.col46}" size="25" />
				<span class="inputInfo">col46</span>
				</div>
		        <div>
				<label>col47：</label>
				<input type="text" name="col47" value="${obj.o.col47}" size="25" />
				<span class="inputInfo">col47</span>
				</div>
		        <div>
				<label>col48：</label>
				<input type="text" name="col48" value="${obj.o.col48}" size="25" />
				<span class="inputInfo">col48</span>
				</div>
		        <div>
				<label>col49：</label>
				<input type="text" name="col49" value="${obj.o.col49}" size="25" />
				<span class="inputInfo">col49</span>
				</div>
		        <div>
				<label>col50：</label>
				<input type="text" name="col50" value="${obj.o.col50}" size="25" />
				<span class="inputInfo">col50</span>
				</div>
		        <div>
				<label>col51：</label>
				<input type="text" name="col51" value="${obj.o.col51}" size="25" />
				<span class="inputInfo">col51</span>
				</div>
		        <div>
				<label>col52：</label>
				<input type="text" name="col52" value="${obj.o.col52}" size="25" />
				<span class="inputInfo">col52</span>
				</div>
		        <div>
				<label>col53：</label>
				<input type="text" name="col53" value="${obj.o.col53}" size="25" />
				<span class="inputInfo">col53</span>
				</div>
		        <div>
				<label>col54：</label>
				<input type="text" name="col54" value="${obj.o.col54}" size="25" />
				<span class="inputInfo">col54</span>
				</div>
		        <div>
				<label>col55：</label>
				<input type="text" name="col55" value="${obj.o.col55}" size="25" />
				<span class="inputInfo">col55</span>
				</div>
		        <div>
				<label>col56：</label>
				<input type="text" name="col56" value="${obj.o.col56}" size="25" />
				<span class="inputInfo">col56</span>
				</div>
		        <div>
				<label>col57：</label>
				<input type="text" name="col57" value="${obj.o.col57}" size="25" />
				<span class="inputInfo">col57</span>
				</div>
		        <div>
				<label>col58：</label>
				<input type="text" name="col58" value="${obj.o.col58}" size="25" />
				<span class="inputInfo">col58</span>
				</div>
		        <div>
				<label>col59：</label>
				<input type="text" name="col59" value="${obj.o.col59}" size="25" />
				<span class="inputInfo">col59</span>
				</div>
		        <div>
				<label>col60：</label>
				<input type="text" name="col60" value="${obj.o.col60}" size="25" />
				<span class="inputInfo">col60</span>
				</div>
		        <div>
				<label>col61：</label>
				<input type="text" name="col61" value="${obj.o.col61}" size="25" />
				<span class="inputInfo">col61</span>
				</div>
		        <div>
				<label>col62：</label>
				<input type="text" name="col62" value="${obj.o.col62}" size="25" />
				<span class="inputInfo">col62</span>
				</div>
		        <div>
				<label>col63：</label>
				<input type="text" name="col63" value="${obj.o.col63}" size="25" />
				<span class="inputInfo">col63</span>
				</div>
		        <div>
				<label>col64：</label>
				<input type="text" name="col64" value="${obj.o.col64}" size="25" />
				<span class="inputInfo">col64</span>
				</div>
		        <div>
				<label>col65：</label>
				<input type="text" name="col65" value="${obj.o.col65}" size="25" />
				<span class="inputInfo">col65</span>
				</div>
		        <div>
				<label>col66：</label>
				<input type="text" name="col66" value="${obj.o.col66}" size="25" />
				<span class="inputInfo">col66</span>
				</div>
		        <div>
				<label>col67：</label>
				<input type="text" name="col67" value="${obj.o.col67}" size="25" />
				<span class="inputInfo">col67</span>
				</div>
		        <div>
				<label>col68：</label>
				<input type="text" name="col68" value="${obj.o.col68}" size="25" />
				<span class="inputInfo">col68</span>
				</div>
		        <div>
				<label>col69：</label>
				<input type="text" name="col69" value="${obj.o.col69}" size="25" />
				<span class="inputInfo">col69</span>
				</div>
		        <div>
				<label>col70：</label>
				<input type="text" name="col70" value="${obj.o.col70}" size="25" />
				<span class="inputInfo">col70</span>
				</div>
		        <div>
				<label>col71：</label>
				<input type="text" name="col71" value="${obj.o.col71}" size="25" />
				<span class="inputInfo">col71</span>
				</div>
		        <div>
				<label>col72：</label>
				<input type="text" name="col72" value="${obj.o.col72}" size="25" />
				<span class="inputInfo">col72</span>
				</div>
		        <div>
				<label>col73：</label>
				<input type="text" name="col73" value="${obj.o.col73}" size="25" />
				<span class="inputInfo">col73</span>
				</div>
		        <div>
				<label>col74：</label>
				<input type="text" name="col74" value="${obj.o.col74}" size="25" />
				<span class="inputInfo">col74</span>
				</div>
		        <div>
				<label>col75：</label>
				<input type="text" name="col75" value="${obj.o.col75}" size="25" />
				<span class="inputInfo">col75</span>
				</div>
		        <div>
				<label>col76：</label>
				<input type="text" name="col76" value="${obj.o.col76}" size="25" />
				<span class="inputInfo">col76</span>
				</div>
		        <div>
				<label>col77：</label>
				<input type="text" name="col77" value="${obj.o.col77}" size="25" />
				<span class="inputInfo">col77</span>
				</div>
		        <div>
				<label>col78：</label>
				<input type="text" name="col78" value="${obj.o.col78}" size="25" />
				<span class="inputInfo">col78</span>
				</div>
		        <div>
				<label>col79：</label>
				<input type="text" name="col79" value="${obj.o.col79}" size="25" />
				<span class="inputInfo">col79</span>
				</div>
		        <div>
				<label>col80：</label>
				<input type="text" name="col80" value="${obj.o.col80}" size="25" />
				<span class="inputInfo">col80</span>
				</div>
		        <div>
				<label>col81：</label>
				<input type="text" name="col81" value="${obj.o.col81}" size="25" />
				<span class="inputInfo">col81</span>
				</div>
		        <div>
				<label>col82：</label>
				<input type="text" name="col82" value="${obj.o.col82}" size="25" />
				<span class="inputInfo">col82</span>
				</div>
		        <div>
				<label>col83：</label>
				<input type="text" name="col83" value="${obj.o.col83}" size="25" />
				<span class="inputInfo">col83</span>
				</div>
		        <div>
				<label>col84：</label>
				<input type="text" name="col84" value="${obj.o.col84}" size="25" />
				<span class="inputInfo">col84</span>
				</div>
		        <div>
				<label>col85：</label>
				<input type="text" name="col85" value="${obj.o.col85}" size="25" />
				<span class="inputInfo">col85</span>
				</div>
		        <div>
				<label>col86：</label>
				<input type="text" name="col86" value="${obj.o.col86}" size="25" />
				<span class="inputInfo">col86</span>
				</div>
		        <div>
				<label>col87：</label>
				<input type="text" name="col87" value="${obj.o.col87}" size="25" />
				<span class="inputInfo">col87</span>
				</div>
		        <div>
				<label>col88：</label>
				<input type="text" name="col88" value="${obj.o.col88}" size="25" />
				<span class="inputInfo">col88</span>
				</div>
		        <div>
				<label>col89：</label>
				<input type="text" name="col89" value="${obj.o.col89}" size="25" />
				<span class="inputInfo">col89</span>
				</div>
		        <div>
				<label>col90：</label>
				<input type="text" name="col90" value="${obj.o.col90}" size="25" />
				<span class="inputInfo">col90</span>
				</div>
		        <div>
				<label>col91：</label>
				<input type="text" name="col91" value="${obj.o.col91}" size="25" />
				<span class="inputInfo">col91</span>
				</div>
		        <div>
				<label>col92：</label>
				<input type="text" name="col92" value="${obj.o.col92}" size="25" />
				<span class="inputInfo">col92</span>
				</div>
		        <div>
				<label>col93：</label>
				<input type="text" name="col93" value="${obj.o.col93}" size="25" />
				<span class="inputInfo">col93</span>
				</div>
		        <div>
				<label>col94：</label>
				<input type="text" name="col94" value="${obj.o.col94}" size="25" />
				<span class="inputInfo">col94</span>
				</div>
		        <div>
				<label>col95：</label>
				<input type="text" name="col95" value="${obj.o.col95}" size="25" />
				<span class="inputInfo">col95</span>
				</div>
		        <div>
				<label>col96：</label>
				<input type="text" name="col96" value="${obj.o.col96}" size="25" />
				<span class="inputInfo">col96</span>
				</div>
		        <div>
				<label>col97：</label>
				<input type="text" name="col97" value="${obj.o.col97}" size="25" />
				<span class="inputInfo">col97</span>
				</div>
		        <div>
				<label>col98：</label>
				<input type="text" name="col98" value="${obj.o.col98}" size="25" />
				<span class="inputInfo">col98</span>
				</div>
		        <div>
				<label>col99：</label>
				<input type="text" name="col99" value="${obj.o.col99}" size="25" />
				<span class="inputInfo">col99</span>
				</div>
		        <div>
				<label>实发工资：</label>
				<input type="text" name="total" value="${obj.o.total}" size="25" />
				<span class="inputInfo">实发工资</span>
				</div>
		        <div>
				<label>状态：</label>
				<input type="text" name="status" value="${obj.o.status}" size="25" />
				<span class="inputInfo">状态</span>
				</div>
		        <div>
				<label>描述：</label>
				<input type="text" name="description" value="${obj.o.description}" size="25" />
				<span class="inputInfo">描述</span>
				</div>
		        <div>
				<label>部门：</label>
				<input type="text" name="deptid" value="${obj.o.deptid}" size="25" />
				<span class="inputInfo">部门</span>
				</div>
		        <div>
				<label>salarytext00：</label>
				<input type="text" name="salarytext00" value="${obj.o.salarytext00}" size="25" />
				<span class="inputInfo">salarytext00</span>
				</div>
		        <div>
				<label>salarytext01：</label>
				<input type="text" name="salarytext01" value="${obj.o.salarytext01}" size="25" />
				<span class="inputInfo">salarytext01</span>
				</div>
		        <div>
				<label>salarytext02：</label>
				<input type="text" name="salarytext02" value="${obj.o.salarytext02}" size="25" />
				<span class="inputInfo">salarytext02</span>
				</div>
		        <div>
				<label>salarytext03：</label>
				<input type="text" name="salarytext03" value="${obj.o.salarytext03}" size="25" />
				<span class="inputInfo">salarytext03</span>
				</div>
		        <div>
				<label>salarytext04：</label>
				<input type="text" name="salarytext04" value="${obj.o.salarytext04}" size="25" />
				<span class="inputInfo">salarytext04</span>
				</div>
		        <div>
				<label>salarytext05：</label>
				<input type="text" name="salarytext05" value="${obj.o.salarytext05}" size="25" />
				<span class="inputInfo">salarytext05</span>
				</div>
		        <div>
				<label>salarytext06：</label>
				<input type="text" name="salarytext06" value="${obj.o.salarytext06}" size="25" />
				<span class="inputInfo">salarytext06</span>
				</div>
		        <div>
				<label>salarytext07：</label>
				<input type="text" name="salarytext07" value="${obj.o.salarytext07}" size="25" />
				<span class="inputInfo">salarytext07</span>
				</div>
		        <div>
				<label>salarytext08：</label>
				<input type="text" name="salarytext08" value="${obj.o.salarytext08}" size="25" />
				<span class="inputInfo">salarytext08</span>
				</div>
		        <div>
				<label>salarytext09：</label>
				<input type="text" name="salarytext09" value="${obj.o.salarytext09}" size="25" />
				<span class="inputInfo">salarytext09</span>
				</div>
<%-- 			    <div>
					<label>创建人：</label>
					<input type="text" name="createUser" value="${obj.o.createUser}" size="25" />
					<span class="inputInfo">创建人</span>
					</div> --%>
<%-- 			    <div>
					<label>创建时间：</label>
					<input type="text" name="createDate" value="${obj.o.createDate}" size="25" />
					<span class="inputInfo">创建时间</span>
					</div> --%>
<%-- 			    <div>
					<label>修改人：</label>
					<input type="text" name="modifyUser" value="${obj.o.modifyUser}" size="25" />
					<span class="inputInfo">修改人</span>
					</div> --%>
<%-- 			    <div>
					<label>修改时间：</label>
					<input type="text" name="modifyDate" value="${obj.o.modifyDate}" size="25" />
					<span class="inputInfo">修改时间</span>
					</div> --%>
<!-- 				<div class="divider">divider</div> -->
<!-- 				<div> -->
<!-- 					<label>排序条件：</label> -->
<!-- 					<select> -->
<!-- 						<option>按客户号倒排</option> -->
<!-- 						<option>按建档日期倒排</option> -->
<!-- 						<option>按信用等级顺排</option> -->
<!-- 						<option>按客户号顺排</option> -->
<!-- 						<option>按建档日期顺排</option> -->
<!-- 						<option>按所属行业顺排</option> -->
<!-- 					</select> -->
<!-- 				</div> -->
			</div>
			<div class="formBar">
				<ul>
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">开始检索</button></div></div></li>
					<li><div class="button"><div class="buttonContent"><button type="reset">清空重输</button></div></div></li>
				</ul>
			</div>
		</form>
	</div>
</div>