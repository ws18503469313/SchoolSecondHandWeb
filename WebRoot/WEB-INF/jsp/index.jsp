<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>校园二手交易网</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="校园二手网站 ,太原工业学院,王帅毕业设计,二手物品">
	<meta http-equiv="description" content="王帅个人毕业设计">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <FRAMESET border=0 frameSpacing=0 rows="135, *" frameBorder="no">
		
				
			<FRAME name=menu src="SchoolSecondHandWeb/top" frameBorder=0 noResize>
			
			<FRAME name=nav src="SchoolSecondHandWeb/nav" frameBorder=0 noResize scrolling=yes>
	
	</FRAMESET>
</html>
