<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>家长互动</title>
<meta name="keywords" content="生物技术系,生物医学工程"/>
<meta name="description" content="电子科技大学生命科学与技术学院"/>
<link href="${ctx}/template/css/all.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/index.css" type="text/css" rel="stylesheet" />
<link href="${ctx}/template/css/style.css" type="text/css" rel="stylesheet" />
<script type=text/javascript src="${ctx}/template/js/jquery-1.3.2.min.js"></script>
<script type=text/javascript src="${ctx}/script/jquery.form.js"></script>
<script type=text/javascript src="${ctx}/template/js/lmsf.js"></script>
<script type=text/javascript src="${ctx}/script/setHome.js"></script>
<script type="text/javascript" src="${ctx}/script/page.js"></script>
<!--[if lte IE 6]>
<script src="js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        DD_belatedPNG.fix('div, ul, img, li, input , a ,span');
    </script>
<![endif]--> 

<script type="text/javascript">
		$(document).ready(function(){	
	 	$("#dataform").submit(function(){
			$(this).ajaxSubmit({
				beforeSubmit:function(){
				if($('#title').val()==""){
					alert("请填写标题");
					return false;
				}
				if($("#vistor").val()==""){
					alert("请填写留言人");
					return false;
				}
				if($("#content").val()==""){
					alert("请填写内容");
					return false;
				}
				},
				success:function(data){
				var o = eval("("+eval("("+data+")")+")");
					if(o!=""){
					var str="";
					for(var i=0;i<o.length;i++){
	
				  str+="<div class='jzhdnr mar'>"+
					"<div class='jzhdlmbg'><span>留言时间："+o[i].insertTime+"</span><strong>家长："+o[i].vistor+"</strong></div><dl>"+
                  "<dt><p>"+o[i].content+"</p></dt>";
				  <c:if test="${mest.replay}">
				  if(o[i].replayContent!=undefined){
                  str+="<dd class='glyhf'><strong>管理员回复：</strong>"+o[i].replayContent+"</dd>";
				  }
				  </c:if>
					str+="</dl></div>";
					
				}
				var tb=$('#liuyan');
				tb.empty();
				tb.append(str);
					}else{
					alert("留言失败！");
					}
				},
				url:"${ctx}/message/add",
				type:'post'
			});
			return false;
		})
		});
		</script>
</head>
<body>
<!--wrap-->
<div id="wrap">
<%@include file="/upload/top.html"%>
   <jsp:include page="/upload/${navsec}.html"/>
    <div id="main">
      <div class="mainlmbg"><span>家长互动</span></div>
	  <div id="liuyan">
		         <c:if test="${not empty mess.result}">
			<c:forEach var="mess" items="${mess.result}">
				<div class="jzhdnr mar">
				<div class="jzhdlmbg"><span>留言时间：<fmt:formatDate value="${mess.insertTime}" pattern="yyyy-MM-dd hh:mm:ss"/></span><strong>家长：${mess.vistor}</strong></div>
              <dl>
                  <dt><p>${mess.content}</p></dts>
				  <c:if test="${mest.replay}">
				<c:if test="${mest.replay and mess.replayContent!=null}">
                  <dd class="glyhf"><strong>管理员回复：</strong>${mess.replayContent}</dd>
				  </c:if>
				  </c:if>
              </dl>
          </div>
			</c:forEach>
		 </c:if>
	</div>
      <div class="page mar2">
	  <c:if test="${pm.result ne null}">
												<script>
													var pg = new showPages('pg');
													pg.pageCount = ${pm.maxPage};
													pg.argName = 'currentPage';
													pg.printHtml(); 
												</script>
												</c:if>
	  </div>
      <div class="mar2" align="center"><img src="${ctx}/template/images/jzlytop.gif"/></div>
 	  <form name="dataform" id="dataform" method="post">

      <div class="jzlybg">
              <div class="xingming">
			  	  			  <input type="hidden" value="${mest.id}" name="mess.tid"/>
							<input type="hidden" value="${navid}" name="mess.navid"/>
							<div><span>留 言 人：</span><input name="mess.vistor" id="vistor" type="text" /></div>
							<div><span>邮    箱：</span><input name="mess.email" id="title" type="text" /></div>
                  
              </div>
              <div class="lynr fl_left">
                <div><span>内    容：</span><textarea name="mess.content" id="content" cols="" rows=""></textarea></div>
              </div>
              <div class="wylybtn fl_left">
                  <div><input name="" type="submit" value="提交" /></div>
                  <div><input name="" type="reset" value="重置" /></div>
              </div>
      </div>
	  </form>
      <div align="center"><img src="${ctx}/template/images/jzlybottom.gif"/></div>
    </div>
</div>
<!--wrap_End-->
<%@include file="/upload/bottom.html"%>
</body>
</html>
