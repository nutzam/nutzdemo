<#setting number_format="#">
<div id="right">
    <div class="zsxxlm"><span><a href="${ctx}/nav?navid=19"><img src="${ctx}/template/images/more.gif"/></a></span>最新新闻</div>
       <div class="zsxxnr">
         <ul>
            <#if (newses?exists)&&(newses?size!=0)>
            <#list newses as news>	
             <li>
				<a href="${ctx}/article/detail?nav=102&model=103&article=${news.id}">
					<#if ((news.title?length)>12)>
						${news.title[0..12]}...
					<#else>
						${news.title}
					</#if>
				</a>
			 </li>
            </#list> 
         	</#if>
         </ul>
        </div>
       <div class="zsxxlm mar"><span><a href="#"><img src="${ctx}/template/images/more.gif"/></a></span>最新通知</div>
       <div class="zsxxnr">
         <ul>
         <#if (notices?exists)&&(notices?size!=0)>
            <#list notices as notice>	
             <li>
				<a href="${ctx}/article/detail?nav=102&model=103&article=${notice.id}">
					<#if ((notice.title?length)>12)>
						${notice.title[0..12]}...
					<#else>
						${notice.title}
					</#if>
				</a>
			 </li>
            </#list> 
         </#if>   
         </ul>
      </div>
</div>