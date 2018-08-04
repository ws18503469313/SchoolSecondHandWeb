<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'publishnews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<style type="text/css">
		._from{
			margin-left: 5%;
			margin-top:5%
			width: 800px;
		}
		input[name="title"]{
			width: 400px;
		}
		textarea{
			width: 400px;height: 300px;font-size: 32px;
		}
		button{
			width: 200px;
		}	
	</style>
	<script type="text/javascript">
		function judgement(){
			var title = $("#title").val();
			if(title == "" || title == "请输入新闻标题"){
				alert("请输入新闻标题");
				return false;
			}
			
			var content = $("#content").val();
			if(content == "" || content == "请输入新闻内容"){
				alert("请输入新闻内容");
				
				return false;
			}
			return true;
		}
		
	</script>
  </head>
  
  <body>
  <div class="con">
  	<div>
  		<h1>新闻发布中心 </h1>
  	</div>
  	<div class="_from">
  	<sf:form modelAttribute="notice" class="form-inline" method="post" enctype="multipart/form-data" onsubmit="return judgement()">
		<div class="from-group">
			<label for="" class="control-lable">标题</label>
			<input type="text" name="title" placeholder="请输入新闻标题" id="title" class="from-control">
		</div>
		<div class="from-group">
			<label for="" class="control-lable">内容</label>
			<textarea name="content"  placeholder="请输入新闻内容" id="content" class="from-control" ></textarea>
		</div>

		<div class="from-group">
			<input type="file" class="btn btn-info" name="file"  id="choosefile"  class="from-control"  />
		</div>
		<div class="from-group">
			<button type="submit" class="btn btn-info" id="btn">发布</button>
		</div> 
	</sf:form>
	</div>
	</div>   
  </body>
</html>
