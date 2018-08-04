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
    
	
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		//取消订单
		function cancle_roder(order_id){
			$.ajax({
				url:'${pageContext.request.contextPath}/user/cancleOrder',
					type:'get',
					dataType:'text',
					data:{order_id:order_id},
					success:function(info){
						alert(info);
					}
			});
		}
		function confirm_order(order_id){
			if(window.confirm("请确认已收到商品!")){
				var comment = window.prompt("请给商品进行评价:");
				$.ajax({
					url:'${pageContext.request.contextPath}/user/confrimReceive',
						type:'get',
						dataType:'text',
						data:{order_id:order_id,comment:comment},
						success:function(info){
							alert(info);
							$('#order_state').text("已收货").css("color","green");
						}
				});
			}
		}
	</script>
  </head>
  
  <body>
  	<%-- <c:if test="${orders.size() eq 0 }"><h1 style="color: gray;">您还没在本站购买东西呢!快去逛逛吧~~</h1></c:if> --%>
  	<c:choose>
  	<c:when test="${orders.size() eq 0 }"><h1 style="color: gray;text-align: center;margin-top: 10%;">您还没在本站购买东西呢!快去逛逛吧~~</h1></c:when>
  	<c:otherwise>
    <div>
  		<table class="table table-bordered table-hover">
  			<thead>
  				<tr class="info">
  					<td>订单号</td>
  					<td>商品名称</td>
  					<td>商品价格</td>
  					<td>收货地址</td>
  					<td>订单状态</td>
  					<td>下单时间</td>
  					<td>最近操作</td>
  					<td>操作</td>
  					<td></td>
  				</tr>
  			</thead>
  			<tbody>
  				<c:forEach items="${orders }" var="g">
  				<tr>
  					<td>${g.odId }</td>
  					<td><p>${g.godname }</p></td>
  					<td>${g.price }</td>
  					<td>${g.address }</td>
  					<td class="${g.odId }" id="order_state">
  					<c:choose>
  						<c:when test="${g.state eq 0 }">
  							已受理
  						</c:when>
  						<c:when test="${g.state eq 1 }">
  							已发货&nbsp;<a style="cursor: pointer;" onclick="confirm_order(${g.odId})">确认收货</a>
  						</c:when>
  						<c:when test="${g.state eq 3 }">
  							已取消
  						</c:when>
  						<c:otherwise>
  							已收货
  						</c:otherwise>
  					</c:choose>
  					</td>
  					<td>${g.createTime }</td>
  					<td>${g.updateTime }</td>
  					<td>
  						<a href="god/godDetal?id=${g.godId }">查看详情</a>
  						<c:if test="${g.state eq 0 }">
  							<a class="cancleOrder" onclick="cancle_roder(${g.odId})" style="cursor: pointer;">取消订单</a>
  						</c:if>
  					</td>
  				</tr>
  				</c:forEach>
  			</tbody>
  		</table>
  	</div>
  	</c:otherwise>
  	</c:choose>
  </body>
</html>
