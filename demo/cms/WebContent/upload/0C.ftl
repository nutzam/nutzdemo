<#setting number_format="#">
<div id="left">
        <div><img src="${ctx}/template/images/${id}nav.png" width="219" height="106" /></div>
        <dl class="leftnav">
            <#list navs.children as nav>
            	<#if (nav.children?exists) && (nav.children?size>0)>
            		<dt id="settings${nav_index}"><a>${nav.navName}</a></dt>
					<dd id="opciones${nav_index}">
						<ul>
							<#list nav.children as item>
								<li><a href="${ctx}/nav?navid=${item.id}&parent=${navs.id}&deep=2">${item.navName}</a></li>
							</#list>
						</ul>
					</dd>
            	<#else>
            		<dt id="settings99"><a href="${ctx}/nav?navid=${nav.id}&parent=${navs.id}&deep=1">${nav.navName}</a></dt>
            	</#if>
            </#list>
      </dl>    
</div>