<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${model.navName}</title>
<meta name="keywords" content="生物技术系,生物医学工程"/>
<meta name="description" content="电子科技大学生命科学与技术学院"/>
<link href="${ctx}/template/css/all.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/index.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/style.css" type="text/css" rel="stylesheet" />
<script type=text/javascript src="${ctx}/template/js/jquery-1.3.2.min.js"></script>
<script type=text/javascript src="${ctx}/template/js/lmsf.js"></script>
<script type=text/javascript src="${ctx}/script/setHome.js"></script>
<script type="text/javascript" src="${ctx}/script/page.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("a.switch_thumb").toggle(function(){
	  $(this).addClass("swap"); 
	  $("ul.display").fadeOut("fast", function() {
	  	$(this).fadeIn("fast").addClass("thumb_view"); 
		 });
	  }, function () {
      $(this).removeClass("swap");
	  $("ul.display").fadeOut("fast", function() {
	  	$(this).fadeIn("fast").removeClass("thumb_view");
		});
	}); 
});
</script>
<!--[if lte IE 6]>
<script src="${ctx}/template/js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a ,span');
    </script>
<![endif]--> 
</head>
<body>
<%@include file="/upload/top.html"%>
<!--wrap-->
<div id="wrap">
    <jsp:include page="/upload/${navsec}.html"/>
    <div id="center">
      <div class="centerlmbg"><span>${model.navName}</span></div>
      <div class="newsxx">
          <div class="container">
          
          <a href="#" class="switch_thumb">Switch Thumb</a> 
          
          <ul class="display">
			<c:forEach var="article" items="${articles}">
              <li>
                  <div class="content_block">
                      <ul>${article.title}</ul>
                      <strong>${article.title}</strong>
                    <dl>
                          <dt>
                          	<a href="${ctx}/article/detail?nav=${navsec}&model=${model.id}&article=${article.id}">
                          		<c:choose>
              						<c:when test="${article.files ne null and fn:length(article.files) gt 0}">
              							<img src="${ctx}/article/${article.files[0].filePath}" width="215" height="120" alt="${article.title}" title="${article.title}"/>
              						</c:when>
              						<c:otherwise>
              							<img src="${ctx}/template/images/sample3.jpg" alt="${article.title}" title="${article.title}"/>
              						</c:otherwise>
              					</c:choose>	
                          	</a>
                             <h5><a href="${ctx}/article/detail?nav=${navsec}&model=${model.id}&article=${article.id}">${article.keywords}</a></h5>
                          </dt>
                          <dd>
                          <p>${fn:substring(fht:delHTMLTag(article.content),0,90)}......</p>
                          </dd>
                      </dl>
                      <b><img src="template/images/jslmbottom.gif" width="250" height="5" /></b>
                  </div>
                  <p><img src="template/images/xgnewsbottom.gif"/></p>
              </li>
			 </c:forEach>
          </ul>
          </div>
      </div>
		<div class="page mar">
		<script>
			var pg = new showPages('pg');
			pg.pageCount = ${maxPage};
			pg.argName = 'currentPage';
			pg.printHtml();  
		</script>
		</div>
    </div>
    <%@include file="/upload/right.html"%>
</div>
<!--wrap_End-->
<%@include file="/upload/bottom.html"%>
</body>
</html>
