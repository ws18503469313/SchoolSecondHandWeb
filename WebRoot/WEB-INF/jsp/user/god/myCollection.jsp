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
    
    <title>My JSP 'myCollection.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" type="text/css" href="${path }css/gods.css">
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".dc").click(function(){
				if(window.confirm("确认移除收藏?")){
					var id = $(this).val();
					$.ajax({
						url:'god/removeCollection',
						type:'get',
						dataType:'text',
						data:{id:id},
						success:function(message){
							alert(message);
							window.location.reload();
						}
					});
				}
			});
		});
	</script>
  </head>
  
  <body>
  	<c:choose>
  	<c:when test="${pages.datas.size() eq 0 }"><h1 style="color: gray;text-align: center;margin-top: 10%;">您还没在本站购买东西呢!快去逛逛吧~~</h1></c:when>
  	<c:otherwise>>
    <div class="con">
    	<a style="color: orange;font-size: 22px;text-align: center;">${msg }</a>
   		<table>
   			<tr>
   				<c:forEach items="${pages.datas }" var="i" varStatus="status">
   				<td>
			    	<table class="">
			    		<tr>
			    			<td>${i.god.name }</td>
			    			<td><a href="god/userpublish">用户:${i.god.publisher.username }</a></td>
			    		</tr>
			    		<tr>
			    			<td colspan="2"><a href="god/godDetal?id=${i.god.id }"> <img  src="fileupload/${i.god.publisher.username }/${i.god.img1}" /></a></td>
			    		</tr>
			    		<tr>
			    			<td class="price">¥${i.god.price }</td>
			    			<td class="address">${i.god.publisher.address }</td>
			    		</tr>
			    		<tr>
			    			<td colspan="2" style="height: 80px;">${i.god.disc }</td>
			    		</tr>
			    		<tr>
			    			<td>发布时间</td>
			    			<td>${i.god.date }</td>
			    		</tr>
			    		<tr><td colspan="2"><button  value="${i.id }" class="dc btn btn-info btn-lg">移出收藏</button></td></tr>
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
   	<div class="pagination .pager">
   		<c:if test="${pages.totalPage gt 1  }">
			<li><a href="admin/checkstudent?pageIndex=1">首页</a></li>
			<c:if test="${pages.pageIndex ne 1 }">
			   <li><a href="admin/checkstudent?pageIndex=${pages.pageIndex-1 }">上一页</a></li>
			</c:if>
			<c:forEach  begin="0" end="${pages.totalPage-1 }" varStatus="i">
				<c:if test="${pages.pageIndex eq i.index+1 }">
				   	<li><a class="active">[${pages.pageIndex}]</a></li>
				</c:if>
			<c:if test="${pages.pageIndex ne i.index+1 }">
				 <li><a href="admin/checkstudent?pageIndex=${i.index+1 }">[${i.index+1}]</a></li>
			</c:if>	
			</c:forEach>
			 <c:if test="${pages.pageIndex ne pages.totalPage }">
			  <li><a href="admin/checkstudent?pageIndex=${pages.pageIndex+1 }">下一页</a></li>
			</c:if>
			<li><a href="admin/checkstudent?pageIndex=${pages.totalPage }">尾页</a></li> 	 	
		</c:if>
   	</div>
   	</c:otherwise>
   	</c:choose>
  </body>
</html>
