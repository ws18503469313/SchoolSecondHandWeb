<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>校园二手网站信息管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <frameset rows="88,*" cols="*" frameBorder="no" border="0" frameSpacing="0">
  	<frame src="SchoolSecondHandWeb/admintop" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
	    <frame src="SchoolSecondHandWeb/adminleft" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
	    <frame src="SchoolSecondHandWeb/adminindex" name="rightFrame" id="rightFrame" title="rightFrame" />
	 </frameset>  
</frameset>	
  
</html>
