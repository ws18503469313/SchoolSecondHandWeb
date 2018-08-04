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
    
    <title>My JSP 'top.jsp' starting page</title>
    
	
	<link rel="stylesheet" type="text/css" href="${path }css/main.css">
	<link rel="stylesheet" type="text/css" href="${path }css/gods.css">
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
  </head>
  
  <body>
   	<div class="type ">
   		<ul class="nav nav-tabs" >
   			<li><a href="god/selectByType?type=生活用品">生活用品</a></li>
   			<li><a href="god/selectByType?type=数码电子">数码电子</a></li>
   			<li><a href="god/selectByType?type=服装装饰">服装装饰</a></li>
   			<li><a href="god/selectByType?type=文体用品">文体用品</a></li>
   		</ul>
   		<div class="search">
   			<form action="god/selectByIn" method="get" >
	   			<input name="in" type="text" placeholder="请输入想要搜索的商品" />
	   			<button type="submit" class="btn btn-info btn-lg" >搜索</button>
   			</form>
   		</div>
   	</div>
   	<div class="message" >
   		<table class="table table-bodered table-hover">
   			<tr><td colspan="2" class="title">管理员通知</td></tr>
	   		<c:forEach items="${notices.datas }" var="n" varStatus="j">
	   			<tr>
	   				<td><a href="user/checknotice?id=${n.id }">${n.title }</a></td>
	   			</tr>
	   		</c:forEach>
   		</table>
   	</div>
   	<div class="con">
   		<table>
   			<tr>
   				<c:forEach items="${pages.datas }" var="i" varStatus="status">
   				<td>
			    	<table>
			    		<tr>
			    			<td>${i.godname }</td>
			    			<td><a href="god/userpublish">用户:${i.username }</a></td>
			    		</tr>
			    		<tr>
			    			<td colspan="2"><a href="god/godDetal?id=${i.id }" > <img  src="fileupload/${i.username }/${i.img1}" /></a></td>
			    		</tr>
			    		<tr>
			    			<td class="price">¥${i.price }</td>
			    			<td class="address">${i.address }</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2" style="height: 80px;">${i.disc }</td>
			    		</tr>
			    		<tr>
			    			<td>发布时间</td>
			    			<td>${i.date }</td>
			    		</tr>
			    	</table>
	    		</td>
		    		<c:if test="${(status.count)%4 eq 0 }">
	    				</tr>
	    				<tr>
	    			</c:if>
	    		</c:forEach>
    		<tr>
    	</table>
   	</div>
   	<div class="pagination .pager" style="margin-left:40%;">
   		<c:if test="${pages.totalPage gt 1  }">
			<li><a href="SchoolSecondHandWeb/nav?pageIndex=1">首页</a></li>
			<c:if test="${pages.pageIndex ne 1 }">
			   <li><a href="SchoolSecondHandWeb/nav?pageIndex=${pages.pageIndex-1 }">上一页</a></li>
			</c:if>
			<c:forEach  begin="0" end="${pages.totalPage-1 }" varStatus="i">
				<c:if test="${pages.pageIndex eq i.index+1 }">
				   	<li class="active"><a>${pages.pageIndex}</a></li>
				</c:if>
			<c:if test="${pages.pageIndex ne i.index+1 }">
				 <li><a href="SchoolSecondHandWeb/nav?pageIndex=${i.index+1 }">[${i.index+1}]</a></li>
			</c:if>	
			</c:forEach>
			 <c:if test="${pages.pageIndex ne pages.totalPage }">
			  <li><a href="SchoolSecondHandWeb/nav?pageIndex=${pages.pageIndex+1 }">下一页</a></li>
			</c:if>
			<li><a href="SchoolSecondHandWeb/nav?pageIndex=${pages.totalPage }">尾页</a></li> 	 	
		</c:if>
   	</div>
  </body>
</html>
