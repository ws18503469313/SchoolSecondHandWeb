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
    
    <title>我的商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    


	<link rel="stylesheet" type="text/css" href="${path }css/gods.css">
 	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		function update_price(obj) {
			var newprice = window.prompt("请输入新的价格:");
			var god_id = $(obj).val();
			if(window.confirm("确认价格为:"+newprice)){
				$.ajax({
					url:'god/updatePrice', 	 
					type:'post',
			      	dataType:'text',     
			      	data:{price:newprice,god_id:god_id},  
			      	success:function(message){
			      		$(obj).parent().parent().prev().children().eq(0).text("¥"+newprice);
			    	   	 window.alert(message);
			      	}
				});  
			}else{
				return;
			}
		}
	</script>
  </head>
  <body>
   	<div class="con">
   		<div>
   			<h1>${msg}</h1>
   		</div>
   		<table id="2321">
   			<tr>
   				<c:forEach items="${pages.datas }" var="i" varStatus="status">
   				<td>
			    	<table id="111">
			    		<tr>
			    			<td>${i.name }</td>
			    			<td><a >用户:${i.publisher.username }</a></td><!-- href="god/userpublish" -->
			    		</tr>
			    		<tr>
			    			<td colspan="2"><a href="god/godDetal?id=${i.id }"> <img  src="fileupload/${i.publisher.username }/${i.img1}" /></a></td>
			    		</tr>
			    		<tr id="222_22">
			    			<td class="price">¥${i.price }</td>
			    			<td class="address">${i.publisher.address }</td>
			    		</tr>
			    		<tr id="22">
			    			<td style="height: 80px;">${i.disc }</td>
			    			<td id="dada"><button value="${i.id }" onclick="update_price(this)" class=" btn btn-info btn-small">修改价格</button>
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
   	<div class="number">
   		<c:if test="${pages.totalPage gt 1 }">
			<a href="god/myGods?pageIndex=1">首页</a>
			<c:if test="${pages.pageIndex ne 1 }">
			   <a href="god/myGods?pageIndex=${pages.pageIndex-1 }">上一页</a>
			</c:if>
			<c:forEach  begin="0" end="${pages.totalPage-1 }" varStatus="i">
				<c:if test="${pages.pageIndex eq i.index+1 }">
				   	<a>[${pages.pageIndex}]</a>
				</c:if>
			<c:if test="${pages.pageIndex ne i.index+1 }">
				 <a href="god/myGods?pageIndex=${i.index+1 }">[${i.index+1}]</a>
			</c:if>	
			</c:forEach>
			 <c:if test="${pages.pageIndex ne pages.totalPage }">
			  <a href="god/myGods?pageIndex=${pages.pageIndex+1 }">下一页</a>
			</c:if>
			<a href="god/myGods?pageIndex=${pages.totalPage }">尾页</a>  	 	
		</c:if>
   	</div>
  </body>
</html>
