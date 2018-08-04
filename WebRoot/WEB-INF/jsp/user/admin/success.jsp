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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body{
			text-align: center;background-color: #88ABE7;
		}
		h2{ 
			font-family: "楷体";font-weight: bold; color: green; margin-top: 200px;
		}
		#a1{
			color: black;
		}
	</style>
  </head>
  
  <body>
  		
    	<h2 >提示信息:<a id=a1>${str}</a></h2>
    	<h3><a id=a2 href="#" onclick="javascript:window.location.replace(SchoolSecondHandWeb/adminindex)" >返回主页</a></h3>
  </body>
</html>
