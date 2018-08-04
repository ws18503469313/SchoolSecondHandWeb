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
    
    <title>My JSP 'userManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
  </head>
  
  <body>
  	<div>
  		<table class="table table-border table-hover">
  			<thead>
  				<tr class="info">
  					<td>用户名</td>
  					<td>地址</td>
  					<td>手机号</td>
  					<td>Email</td>
  					<td>注册时间</td>
  					<td>操作</td>
  				</tr>
  			</thead>
  			<tbody>
  			<c:forEach items="${users.datas }" var="u" varStatus="i">
  				<tr>
  					<td>${u.username }</td>
  					<td>${u.address }</td>
  					<td>${u.phone }</td>
  					<td>${u.email }</td>
  					<td>${u.date }</td>
  					<td><a href="user/checkSpeech?id=${u.id }">查看言论</a></td>
  				</tr>
  			</c:forEach>
  			</tbody>
  		</table>
  	</div>
    <div class="number">
   		<c:if test="${pages ne null }">
			<a href="admin/checkstudent?pageIndex=1">首页</a>
			<c:if test="${pages.pageIndex ne 1 }">
			   <a href="admin/checkstudent?pageIndex=${pages.pageIndex-1 }">上一页</a>
			</c:if>
			<c:forEach  begin="0" end="${pages.totalPage-1 }" varStatus="i">
				<c:if test="${pages.pageIndex eq i.index+1 }">
				   	<a>[${pages.pageIndex}]</a>
				</c:if>
			<c:if test="${pages.pageIndex ne i.index+1 }">
				 <a href="admin/checkstudent?pageIndex=${i.index+1 }">[${i.index+1}]</a>
			</c:if>	
			</c:forEach>
			 <c:if test="${pages.pageIndex ne pages.totalPage }">
			  <a href="admin/checkstudent?pageIndex=${pages.pageIndex+1 }">下一页</a>
			</c:if>
			<a href="admin/checkstudent?pageIndex=${pages.totalPage }">尾页</a>  	 	
		</c:if>
   	</div>
  </body>
</html>
