<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="${path }css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	
	<script language="javascript">
		$(function(){
	    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
		$(window).resize(function(){  
	    $('.error').css({'position':'absolute','left':($(window).width()-490)/2});
	    });  
	});  
	</script>
  </head>
  

  <body style="background:#edf6fa;">
    
    <div class="error">
    
    <h2>${msg}</h2>
    <p>看到这个提示，就自认倒霉吧!</p>
    <div class="reindex"><a onclick="history.back()">返回上一级</a></div>
    
    </div>


	</body>
</html>
