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
    
    <title>My JSP 'checkComment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
  	<div>
  		<table class="table table-bordered table-hover">
  			<tr>
  				<td>${god.godname }</td>
  			</tr>
  			<tr>
  				<td>评论</td>
  				<td>评论的人</td>
  				<td>评论时间</td>
  				<td>主人回复</td>
  				<td>回复时间</td>
  			</tr>
  			<c:forEach items="${comments }" var="c">
  			 <tr>
  				<td>${c.cmtcontent }</td>
  				<td>${c.cmtusername }</td>
  				<td>${c.cmtdate }</td>
  				<td>${c.reply }</td>
  				<td>${c.rpldate }</td>
  				<%-- <c:forEach items="${c.replies }" var="r">
  					<td>${r.content }</td>
  					<td>${r.date }</td>
  				</c:forEach> --%>
  			 </tr>		
  			</c:forEach>
  		</table>
  	</div>
    
  </body>
</html>
