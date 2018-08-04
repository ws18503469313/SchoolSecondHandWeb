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
	<script type="text/javascript" src="${path }js/jquery-1.8.3.js"></script>
	
	
	<script type="text/javascript">
		$(function(){
			windowClose();
		});
		function check_detal(obj){
			var order_id = $(obj).attr("id");
			if(order_id == null){
				var info_id = $(obj).val();
				check_info_detal(info_id);
			}else{
				
				check_order_detal(order_id);
			}	
				
		};
		//查看订单详情
		function check_order_detal(order_id){
			$('.order_id').val(order_id);
				$.ajax({
					url:'${pageContext.request.contextPath}/user/orderDetal',
					type:'get',
					dataType:'text',
					data:{id:order_id},
					success:function(info){
						var d = eval("("+info+")");
						$('.god_name').text(d[0]);
						$('.god_price').text(d[1]);
						$('.purcher_name').text(d[2]);
						$('.purcher_phone').text(d[3]);
						$('.purcher_address').text(d[5]);
						$('.create_time').text(d[6]);
						if(d[7] == 0){
							$('.order_state').text("未发货!").css("color","red");
						}else if(d[7] == 1){
							$('.order_state').text("已发货").css("color","yellow");
						}else if(d[7] == 3){
							$('.order_state').text("已取消").css("color","blue");
						}else{
							$('.order_state').text("已收货").css("color","green");
						}
						$('.order_update_date').text(d[8]).css("color","green");
						$('.order_commnet').text(d[9]).css("color","green");
						$('#view').show();
						
					}
				
				});
		}
		//
		function check_info_detal(info_id){
			$.ajax({
				url:'${pageContext.request.contextPath}/user/Readed',
				type:'get',
				data:{info_id:info_id},
			});			
		}
		//关闭订单信息窗口
		function windowClose(){
			$('#view').hide();
		}
		//点击发货
		function sendGod(){
			var order_id = $('.order_id').val();
			var state = $('.order_state').text();
			if(state == "已取消"){
				return ;
			}else{
				if(window.confirm("请确认已经发货!")){
	 				$.ajax({
						url:'${pageContext.request.contextPath}/user/sendGod',
						type:'get',
						dataType:'text',
						data:{order_id:order_id},
						success:function(info){
							alert(info);
							$('.order_state').text("已发货").css("color","yellow");
						}
					});
	 			}
			}
 			
 		};
	</script>
  </head>
  
  <body>
  	<c:choose>
  	<c:when test="${infos.size() eq 0 }">
  		<h1 style="color: gray;text-align: center;font-family:'楷体'; margin-top: 10%;">
  			There's no message for u,plz enjoy the peace~~</h1></c:when>
  	<c:otherwise>>
    <div>
  		<table class="table table-bordered table-hover">
  			<thead>
  				<tr class="info">
  					<td>通知时间</td>
  					<td>通知内容</td>
  					<td>查看详情</td>
  				</tr>
  			</thead>
  			<tbody>
  				<c:forEach items="${infos }" var="g">
  				<tr>
  				<td >
  					<c:choose>
  							<c:when test="${g.state eq 0 && g.orderId ne 0}">
  								<img src="images/tip_unread.png" alt="未读"/>
  							</c:when>
  							<c:otherwise>
  								<img src="images/tip.png" alt="已查看"/>
  							</c:otherwise>
  						</c:choose>
  					${g.date }
  				</td>
  				<td>${g.content }</td>
  				<td><button onclick="check_detal(this)"   value="${g.infoId }" id="${g.orderId }"   ><img class="check"  src="images/ico06.png" title="查看订单"/></button>
  					<input type="hidden"  value="${g.infoId }" />
  				</td>
  				</tr>
  				</c:forEach>
  				
  			</tbody>
  		</table>
  	</div>
  	</c:otherwise>
  	</c:choose>
  	<!--订单详情窗口-->
    <div id="view" title="订单详情" class="easyui-window" style="width: 300px;height: 550px;
    				position:absolute;left: 40%;top: 5%; background: gray;">
		<form style="padding:10px 20px 10px 40px;">
			<table class="table">
				<tr><td>商品名称</td><td class="god_name"></td></tr>
				<tr><td>商品价格</td><td class="god_price"></td></tr>
				<tr><td>卖家姓名</td><td class="purcher_name"></td></tr>
				<tr><td>卖家联系方式</td><td class="purcher_phone"></td></tr>
				<tr><td>卖家地址</td><td class="purcher_address"></td></tr>
				<tr><td>下单时间</td><td class="create_time"></td></tr>
				<tr><td>订单状态</td><td class="order_state"></td></tr>
				<tr><td>订单评价</td><td class="order_commnet"></td></tr>
				<tr><td>最新操作</td><td class="order_update_date"></td></tr>
			</table><br/>
			<div style="padding:5px;text-align:center;">
				<a class="btn btn-info btn-ground" icon="icon-ok" onclick="sendGod()">发货</a>
				<a class="btn btn-info btn-ground" icon="icon-cancel" onclick="windowClose()" >OK</a>
				<input type="hidden" class="order_id" value=""/>
			</div>
		</form>`
	</div>
	<!--订单详情窗口结束-->
  </body>
</html>
