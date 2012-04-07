<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电子科技大学生命科学与技术学院-${model.navName}</title>
<meta name="keywords" content="生物技术系,生物医学工程"/>
<meta name="description" content="招生信息本科,硕士,博士,专业学位,继续教育,人才培养院士,长江学者,特聘教授,副教授"/>
<link href="${ctx}/template/css/all.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/index.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/style.css" type="text/css" rel="stylesheet" />
<script type=text/javascript src="${ctx}/template/js/jquery-1.3.2.min.js"></script>
<script type=text/javascript src="${ctx}/template/js/lmsf.js"></script>
<script type=text/javascript src="${ctx}/script/setHome.js"></script>
<script type="text/javascript" src="${ctx}/script/page.js"></script>
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
      <div class="newscolumn">
      	   <ul>
      	   	<c:forEach var="article" items="${articles}">
      	   		<li>
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
					<span><fmt:formatDate value="${article.createDate}" pattern="yyyy-MM-dd"/></span>
      	   			<a href="${ctx}/article/detail?nav=${navsec}&model=${model.id}&article=${article.id}" style='color:${color}'>${article.title}</a>
      	   		</li>
      	  	</c:forEach>
      	   </ul>
      </div>
        <div class="page">
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
