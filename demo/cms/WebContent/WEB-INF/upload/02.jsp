<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>学子留言</title>
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
<script src="${ctx}js/iepng.js" type="text/javascript"></script>
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
					alert("记录成功！");
					var str="";
					for(var i=0;i<o.length;i++){
						
						str+="<div class='xzlyboxbg'><dl>"+
                  "<dt><span>["+o[i].insertTime+"]</span>"+o[i].vistor+" ：</dt>"+
                  "<dd><p>"+o[i].content+"</p></dd>";
				  
				  <c:if test="${mest.replay}">
				  if(o[i].replayContent!=undefined){
                  str+="<dd class='glyhf'><strong>管理员回复：</strong>"+o[i].replayContent+"</dd>";
				  }
				  </c:if>
					str+="</dl></div>";
					if(i<o.length-1){
					str+="<div><img src='${ctx}/template/images/xzlyboxline.gif'/></div>";
					}else{
					str+="<div><img src='${ctx}/template/images/xzlyboxbottom.gif'/></div>";
					}
				}
				var tb=$('#liuyan');
				tb.empty();
				tb.append(str);
					}else{
					alert("记录失败！");
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
<%@include file="/upload/top.html"%>
<!--wrap-->
<div id="wrap">
  <jsp:include page="/upload/${navsec}.html"/>
    <div id="main">
      <div class="mainlmbg"><span>学子留言</span></div>
      <div><img src="${ctx}/template/images/xzlybanner.jpg"/></div>
      <div><img src="${ctx}/template/images/xzlybanner2.jpg"/></div>
      <div class="xzlybannerboxbg">
	  <div id="liuyan">
         <c:if test="${not empty mess.result}">
			<c:forEach var="mess" items="${mess.result}" varStatus="status">
				<div class="xzlyboxbg">
              <dl>
                  <dt><span>[<fmt:formatDate value="${mess.insertTime}" pattern="yyyy-MM-dd hh:mm:ss"/>]</span>${mess.vistor}:</dt>
                  <dd><p>${mess.content}</p></dd>
				  <c:if test="${mest.replay and mess.replayContent!=null}">
                  <dd class="glyhf"><strong>管理员回复：</strong>${mess.replayContent}</dd>
				  </c:if>
              </dl>
          </div>
		  <c:if test="${(status.index+1)<pagesize}">
		  <div><img src="${ctx}/template/images/xzlyboxline.gif"/></div>
		  </c:if>
		  <c:if test="${(status.index+1)==pagesize}">
			<div><img src="${ctx}/template/images/xzlyboxbottom.gif"/></div>
		  </c:if>
		  
			</c:forEach>
		 </c:if>
          </div>
          <div class="xzlyfybg page mar">
		  
		  
												<c:if test="${mess.result ne null}">
												<script>
													var pg = new showPages('pg');
													pg.pageCount = ${mess.maxPage};
													pg.argName = 'currentPage';
													pg.printHtml(); 
												</script>
												</c:if>
											
		  
		  </div>
		<form id="dataform" name="dataform" method="post">
          <div class="wylyboxbg mar">
              <div class="xingming">
			  <input type="hidden" value="${mest.id}" name="mess.tid"/>
			  <input type="hidden" value="${navid}" name="mess.navid"/>
                 
                  <div><span>留 言 人：</span><input name="mess.vistor" id="vistor" type="text" value="学生"/></div>
				  <div><span>邮　　箱：</span><input name="mess.email" id="title" type="text"/></div>

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
      </div>
    </div>
</div>
<!--wrap_End-->
<%@include file="/upload/bottom.html"%>
</body>
</html>
