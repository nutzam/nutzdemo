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
        <div class="xyjjbt"></div>
        <div class="newsxxnr">
                <c:if test="${cat.type1 ne null and cat.type1 ne ''}">
					${cat.type1}：${cat.name1}<br />
				</c:if>
				<c:if test="${cat.type2 ne null and cat.type2 ne ''}">
					${cat.type2}：${cat.name2}<br />
				</c:if>
				<c:if test="${cat.type3 ne null and cat.type3 ne ''}">
					${cat.type3}：${cat.name3}<br />
				</c:if>
				<c:if test="${cat.type4 ne null and cat.type4 ne ''}">
					${cat.type4}：${cat.name4}<br />
				</c:if>
				<c:if test="${cat.type5 ne null and cat.type5 ne ''}">
					${cat.type5}：${cat.name5}<br />
				</c:if>
				<c:if test="${cat.type6 ne null and cat.type6 ne ''}">
					${cat.type6}：${cat.name6}<br />
				</c:if>
				<c:if test="${cat.type7 ne null and cat.type7 ne ''}">
					${cat.type7}：${cat.name7}<br />
				</c:if>
				<c:if test="${cat.type8 ne null and cat.type8 ne ''}">
					${cat.type8}：${cat.name8}<br />
				</c:if>
				<c:if test="${cat.imgurl ne null and cat.imgurl ne ''}">
					<img src="${ctx}/contact/pic/${cat.imgurl}"/>
				</c:if>
              
        </div>
        </div>
    </div>
    <%@include file="/upload/right.html"%>
</div>
<!--wrap_End-->
<%@include file="/upload/bottom.html"%>
</body>
</html>
