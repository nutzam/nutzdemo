<#setting number_format="#">
<!--底部-->
<div id="bottom" class="mar1">
     <div class="copyright">
     <div class="fl_left">
     <a href="mailto:uestclife@uestc.edu.cn">院长信箱</a> | <a href="nav?navid=80&parent=17&deep=1">联系我们</a> | <a href="http://www.uestc.edu.cn">电子科大</a> |  <a href="http://www.life.uestc.edu.cn" target="_blank">旧版网站</a><br />             
<#if site?exists>
	${site.copyright}
<#else>
 Copyright © 2004 - 2010 生命科学与技术学院 All rights reserved
</#if>
	  <br />                              
技术支持：<a href="http://www.scxxs.com" target="_blank">新西软</a></div>
     <div class="fl_right"><img src="${ctx}/template/images/bottompic.gif"/></div>
     </div>
</div>
<!--底部_End-->
