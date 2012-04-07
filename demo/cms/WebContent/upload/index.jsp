<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电子科技大学生命科学与技术学院-首页</title>
<meta name="keywords" content="生物技术系,生物医学工程"/>
<meta name="description" content="招生信息本科,硕士,博士,专业学位,继续教育,人才培养院士,长江学者,特聘教授,副教授"/>
<link href="${ctx}/template/css/all.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/index.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/index.css" type="text/css" rel="stylesheet" />
<script src="${ctx}/script/jquery.js" type="text/javascript"></script>
<script src="${ctx}/script/slider.js" type="text/javascript"></script>
<script src="${ctx}/script/fontslider.js" type="text/javascript"></script>
<script type=text/javascript src="${ctx}/script/setHome.js"></script>
<!--[if lte IE 6]>
<script src="${ctx}/template/js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a ,span');
    </script>
<![endif]-->
<script type="text/javascript">
function check(){
	var u = $.trim($("#username").val());
	if(u==""){
		alert("请输入用户名");
		$("#username").focus();
		return false;
	}
	var p = $.trim($("#password").val());
	if(p==""){
		alert("请输入密码");
		$("#password").focus();
		return false;
	}
	return true;
}	
</script> 
</head>
<body>
<!--头部-->
<%@include file="/upload/top.html"%>
<!--头部_End-->
<!--login and banner-->
<div class="bannerbox">
  <div class="loginbox fl_left">
    <div class="loginlmbg">用户登录</div>
      <form action="/OA/account.do?method=login" method="post">
      	<input type="hidden" value="web" name="vcode"/>
        <div class="textbox">
            <div class="yonghuming"><span>用户名：</span><input name="username" type="text" id="username"/></div>
            <div class="yonghuming"><span>密　码：</span><input name="password" type="password" id="password"/></div>
            <div class="loginbtn"><input name="" type="submit" value="登&nbsp;录" onclick="return check();"/>&nbsp;<input name="" type="reset" value="重&nbsp;置" /></div>
            <div class="help"><a href="#"><img src="${ctx}/template/images/loginhelp.jpg"/></a></div>
        </div>
      </form>
      <div><img src="${ctx}/template/images/loginbottom.gif" width="262" height="5" /></div>
        <div class="zhaopinpic"><img src="${ctx}/template/images/zhaipin.jpg" border="0" usemap="#Map"/>
          <map name="Map" id="Map">
            <area shape="rect" coords="37,10,111,31" href="${ctx}/nav?navid=99&parent=18&deep=2" />
            <area shape="rect" coords="125,10,197,31" href="${ctx}/nav?navid=100&parent=18&deep=2" />
          </map>
      </div>
  </div>
    <div class="picbox fl_left">
        <div class="bannerpic fl_left" style="position:absolute;">
			<ul style='position:absolute;list-style:none;display:inline;' id='slider'>
				<c:forEach var="pic" items="${pics}">
					<li style='list-style:none;display:inline;'><a href='${pic.href}' target='${pic.target}'><img src="${ctx}/${pic.pic}"/></a></li>
				</c:forEach>
			</ul>
		</div>
        <div class="bannerbtn">
            <ul>
				<c:forEach var="pic" items="${pics}">
					<li><a href="${pic.href}" target='${pic.target}'>${pic.name}</a></li>
				</c:forEach>
            </ul>
        </div>
  </div>
</div>
<!--login and banner_End-->
<!--content-->
<div class="content">
   <div class="left fl_left">
       <div class="zsxxlm"><span><a href="${ctx}/nav?navid=19"><img src="${ctx}/template/images/more.gif"/></a></span>招生信息</div>
       <div class="zsxxnr">
           <ul>
               <li><a href="${ctx}/nav?navid=88&parent=19&deep=2">本科</a></li>
               <li><a href="${ctx}/nav?navid=89&parent=19&deep=2">硕士</a></li>
               <li><a href="${ctx}/nav?navid=91&parent=19&deep=2">专业学位</a></li>
               <li><a href="${ctx}/nav?navid=90&parent=19&deep=2">继续教育</a></li>
           </ul>
       </div>
       <div class="zsxxlm"><span><a href="${ctx}/nav?navid=111"><img src="${ctx}/template/images/more.gif"/></a></span>系级机构</div>
       <div class="zsxxnr">
           <ul>
               <li><a href="${ctx}/nav?navid=114&parent=111&deep=2">生物技术系</a></li>
               <li><a href="${ctx}/nav?navid=115&parent=111&deep=2">生物医学工程</a></li>
           </ul>
       </div>
       <div class="zsxxlm"><span><a href="${ctx}/nav?navid=30&parent=17&deep=1"><img src="${ctx}/template/images/more.gif"/></a></span>重点实验室</div>
       <div class="zsxxnr">
           <ul>
               <li><a href="http://211.83.105.78/" target="_blank">神经信息教育部重点实验室</a></li>
               <li><a href="#">分子细胞生物学与系统生物学实验室</a></li>
               <li><a href="#">生物物理与生物电子技术</a></li>
               <li><a href="#">数字健康工程技术研究中心</a></li>
           </ul>
       </div>
  </div>
   <div class="center fl_left">
      <div class="newslm"><span><a href="${ctx}/nav?navid=103&parent=102"><img src="${ctx}/template/images/more.gif"/></a></span>学院新闻</div>
      <div class="importantnews">
          <dl>
          	<!--图片新闻 -->
              <dd>
              	<object id="bcastr4" data="${ctx}/template/images/xixi.swf?xml=${ctx}/index/xml" type="application/x-shockwave-flash" width="173" height="116">
    				<param name="movie" value="${ctx}/template/images/xixi.swf?xml=${ctx}/index/xml" />
				</object>
              </dd>
              <dt>
              	<!-- 第一条新闻 -->
             	<c:if test="${newses ne null and fn:length(newses) gt 0}">
                  <strong>${fn:substring(newses[0].title,0,20)}......</strong>
				  <p>${fn:substring(fht:delHTMLTag(newses[0].content),0,70)}...</p>
                  <span><a href="${ctx}/article/detail?nav=102&model=103&article=${newses[0].id}">详细&gt;&gt;</a></span>
              	</c:if>  
              </dt>
          </dl>
      </div>
      <div class="newsnr">
          <ul>
			  <!--学院新闻-->
		       <c:forEach var="news" items="${newses}" varStatus="status">
		       		<c:set var="color" value=""/>
					<c:choose>
						<c:when test="${news.color eq 1}">
							<c:set var="color" value="red"/>
						</c:when>
						<c:when test="${news.color eq 2}">
							<c:set var="color" value="green"/>
						</c:when>
						<c:when test="${news.color eq 3}">
							<c:set var="color" value="blue"/>
						</c:when>
					</c:choose>
					<c:if test="${status.index ne 0}">
						<li>
							<strong><fmt:formatDate value="${news.createDate}" pattern="MM-dd"/></strong>
							<a href="${ctx}/article/detail?nav=102&model=103&article=${news.id}" style="color: ${color}">${fn:substring(news.title,0,16)}...</a>
						</li>
					</c:if>
				</c:forEach>
          </ul>
      </div>
      <div class="newsmore"></div>
     <div class="tzlmbg"><strong>通知公告</strong><strong class="xsbg">学术报告</strong></div>
      <div class="tzggnr">
          <div class="tzgg fl_left">
              <ul>
				<!--通知公告-->
				  <li><a href="${ctx}/nav?navid=116&parent=102&deep=2" >学院办</a></li>
				  <li><a href="${ctx}/nav?navid=117&parent=102&deep=2" >教务科</a></li>
				  <li><a href="${ctx}/nav?navid=118&parent=102&deep=2" >学科建设与科研科</a></li>
				  <li><a href="${ctx}/nav?navid=119&parent=102&deep=2" >学生科</a></li>
				  <li><a href="${ctx}/nav?navid=120&parent=102&deep=2" >继续教育办公室</a></li>
				  <li><a href="${ctx}/nav?navid=121&parent=102&deep=2" >专业学位办公室</a></li>
              </ul>
              <p><span><a href="${ctx}/nav?navid=122&parent=102&deep=2" >其他</a></span></p>
          </div>
        <div class="tzgg fl_left">
              <ul>
				<!--学术报告-->
				<c:forEach var="report" items="${reports}">
				  <c:set var="color" value=""/>
				  <c:choose>
					<c:when test="${news.color eq 1}">
						<c:set var="color" value="red"/>
					</c:when>
					<c:when test="${news.color eq 2}">
						<c:set var="color" value="green"/>
					</c:when>
					<c:when test="${news.color eq 3}">
						<c:set var="color" value="blue"/>
					</c:when>
				</c:choose>
				  <li>
				 	<span><strong><fmt:formatDate value="${report.createDate}" pattern="MM-dd"/></strong></span>
				  	<a href="${ctx}/article/detail?nav=102&model=105&article=${report.id}" style='color:${color}'>${fn:substring(report.title,0,16)}...</a>
				  </li>
				</c:forEach>
            </ul>
            <p><span><a href="${ctx}/nav?navid=105&parent=102&deep=1">更多&gt;&gt;</a></span></p>
        </div>
      </div>
     <div><img src="${ctx}/template/images/tzggbottom.gif"/></div>
   </div>
   <div class="right fl_left">
       <div class="xydtlmbg">学院动态</div>
       <div class="xydtnr">
           <dl>
               <dd>
                   <ul>
                        <li><a href="${ctx}/nav?navid=81&parent=17&deep=2">院长专访</a></li>
                        <li><a href="${ctx}/nav?navid=82&parent=17&deep=2">开学典礼</a></li>
                        <li><a href="${ctx}/nav?navid=83&parent=17&deep=2">毕业典礼</a></li>
                        <li><a href="${ctx}/nav?navid=84&parent=17&deep=2">迎新晚会</a></li>
                        <li><a href="${ctx}/nav?navid=85&parent=17&deep=2">新生命</a></li>
                        <li><a href="${ctx}/nav?navid=86&parent=17&deep=2">生命的精彩</a></li>
                   </ul>
               </dd>
			   <!--建院10周年-->
               <dt><a href="${ctx}/nav?navid=101&parent=22&deep=2"><img src="${ctx}/template/images/jy10.jpg" width="121" height="166" /></a></dt>
           </dl>
       </div>
       <div><img src="${ctx}/template/images/loginbottom.gif" width="262" height="5" /></div>
       <div class="sxgdlmbg mar1"><strong>思想观点</strong><strong class="hdsq">互动社区</strong></div>
       <div class="sxgdnr">
           <dl>
               <dd>
                   <ul>
                        <li><a href="${ctx}/nav?navid=107&parent=102&deep=2">院长观点</a></li>
                        <li><a href="${ctx}/nav?navid=108&parent=102&deep=2">教授观点</a></li>
                        <li><a href="${ctx}/nav?navid=109&parent=102&deep=2">学生观点</a></li>
                        <li><a href="${ctx}/nav?navid=110&parent=102&deep=2">生命论坛</a></li>
                        <li><a href="${ctx}/nav?navid=59&parent=22&deep=1">创新创业讲坛</a></li>
                   </ul>
               </dd>
               <dt>
                   <ul>
                        <li><a href="${ctx}/nav?navid=67&parent=24&deep=1">学生交流</a></li>
                        <li><a href="${ctx}/nav?navid=73&parent=24&deep=1">家长交流</a></li>
                        <li><a href="${ctx}/nav?navid=60&parent=22&deep=1">生命阳光志愿者</a></li>
                   </ul>
               </dt>
           </dl>
       </div>
       <div><img src="${ctx}/template/images/loginbottom.gif" width="262" height="5" /></div>
       <div class="xydtlmbg mar1">学术小组</div>
       <div class="xsxznr">
       <div class="xsxzli fl_left">
       		<c:forEach var="group" items="${groups}">
              <dl>
                  <dd>${group.groupname}</dd>
                  <dt>
						<c:set var="items" value="${fn:split(group.groupitems,'|')}"/>
						<c:forEach var="item" items="${items}">
							<c:set var="p" value="${fn:split(item,',')}"/>
							<c:choose>
								<c:when test="${fn:length(p) eq 2}">
									<a href='${p[1]}'>${p[0]}</a>
								</c:when>
								<c:otherwise>
									<a href='#'>${p[0]}</a>
								</c:otherwise>
							</c:choose>
						</c:forEach>
                  </dt>
              </dl>
            </c:forEach>
           <p align='right'><span><a href="${ctx}/nav?navid=35&parent=18&deep=1">更多&gt;&gt;</a></span></p>
       </div>
       <div class="nextbtnbox fl_left">
           <div class="mar1"><a style="cursor: pointer;"><img src="${ctx}/template/images/shangbtn.gif"/></a></div>
           <div class="nextbtn"><a style="cursor: pointer;"><img src="${ctx}/template/images/nextbtn.gif"/></a></div>
       </div>
       </div>
       <div><img src="${ctx}/template/images/loginbottom.gif" width="262" height="5" /></div>
  </div>
</div>
<!--content_End-->
<%@include file="/upload/bottom.html"%>
</body>
</html>
