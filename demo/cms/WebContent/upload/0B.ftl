<#setting number_format="#">
<!--头部-->
<div id="top">
    <div class="logobox">
        <div class="fl_left"><img src="${ctx}/template/images/logopic.jpg" width="664" height="117" /></div>
        <div class="fl_left">
            <div class="home">
                <span class="swsy"><a href="javascript:SetHome(this,'http://www.life.uestc.edu.cn:8080');">设为首页</a></span>
                <span class="bgxt"><a href="/OA">办公系统</a></span>
                <span class="bbxz"><a href="http://www.life.uestc.edu.cn">旧版网站</a></span>
            </div>
            <div class="sreach">
				<form action='${ctx}/article/search' method='post'>
					<input name="currentPage" value='1' type="hidden"/>
					<input name="title" type="text" class="sreachtextbg"/>
					<input name="" type="submit" class="sreachbtnbg" value="搜索" />
				</form>
			</div>
      </div>
    </div>
    <div class="nav">
    	<ul>
    	   <#list navmodel as nav>
			<#if (nav.indexNav)>
				<li><a href='${ctx}/'>${nav.navName}</a></li>
			<#elseif (!nav.showNav)>
				<li><a href='${ctx}/nav?navid=${nav.id}'>${nav.navName}</a></li>
			</#if>
    	   </#list>
    	</ul>
    </div>
</div>
