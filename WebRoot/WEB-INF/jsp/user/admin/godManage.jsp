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
    
    <title>My JSP 'godManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<style type="text/css">
		img{
			height: 100px;width: 100px; img-rounded;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			
			$(".punk").click(function(){
				//获取要下架商品的ID
				var id = $(this).val();
				//获取商品现在的状态,更具状态来进行操作
				var state = $(this).next().val();
				if(state == 0){
					if(window.confirm("确认要下架?")){
						//提示输入下架理由
						$('.view').show();
						var reason;
						//点击Ok
						$('.post').click(function(){
							reason = $('.reason').val();
							if(reason.length == 0){
								alert("请输入理由!");
							}else{
								$.ajax({
									url:'god/changestate', 	 
									type:'post',
							      	dataType:'text',     
							      	data:{id:id,state:2,reason:reason},  
							      	success:function(message){
							    	   window.alert(message);
							    	   $('.view').hide();
							    	   $(this).text("下架");

							        }	
								}); 
							}
						});
						//点击cancle取消操作
						$('.cancle').click(function(){
							$('.view').hide();
							return;
						});
					 	
					}
				}
				if(state == 2){
					if(window.confirm("确认商品符合要求?")){
					 	$.ajax({
							url:'god/changestate', 	 
							type:'post',
					      	dataType:'text',     
					      	data:{id:id,state:0},  
					      	success:function(message){
					    	   window.alert(message);
					    	   $(this).text("上架");
					        }	
						}); 
					}
				}
				if(state == 1){
					return null;
				}
			});
		
		});
	</script>
  </head>
  
  <body>
  	<div>
  		<table class="table table-bordered table-hover">
  			<thead>
  				<tr class="info">
  					<td>商品主题</td>
  					<td>商品描述</td>
  					<td>价格</td>
  					<td>所属种类</td>
  					<td>发布时间</td>
  					<td>访问次数</td>
  					<td>商品图片</td>
  					<td>商品图片</td>
  					<td>商品图片</td>
  					<td>商品图片</td>
  					<td>商品状态</td>
  					<td></td>
  				</tr>
  			</thead>
  			<tbody>
  				<c:forEach items="${gods.datas }" var="g">
  				<tr>
  					<td>${g.godname }</td>
  					<td style="width: 160px;"><p>${g.disc }</p></td>
  					<td>${g.price }</td>
  					<td>${g.type }</td>
  					<td>${g.date }</td>
  					<td>${g.clickTime }</td>
  					<td><img class="img-rounded" src="fileupload/${g.username }/${g.img1 }"></td>
  					<td><img class="img-rounded" src="fileupload/${g.username }/${g.img2 }"></td>
  					<td><img class="img-rounded" src="fileupload/${g.username }/${g.img3 }"></td>
  					<td><img class="img-rounded" src="fileupload/${g.username }/${g.img4 }"></td>
  					<td><button class="btn punk" value="${g.id }" >
  						<c:choose>
  							<c:when test="${g.state eq 0 }">正常</c:when>
  							<c:when test="${g.state eq 1 }">售出</c:when>
  							<c:otherwise>下架</c:otherwise>
  						</c:choose>
  					</button><input type="hidden" value="${g.state }"/>
  					<td><a href="god/checkcomment?id=${g.id }">查看评论</a></td>
  				</tr>
  				</c:forEach>
  			</tbody>
  		</table>
  	</div>
  	<div class="view"
  		 style="display: none; position: absolute;top: 10%;left: 35%; background: gray;
  		 		width: 400px;height: 300px;" >
  		<input class="reason" placeholder="请输入下架商品理由!" style="width: 350px; margin: 25px;margin-top:50px; height: 50px;" value="" />
  		<div class="action" style="margin-right: 0px; margin-left: 100px;">
  			<button class="post btn btn-info" style="width: 150px;">OK</button><br/>
  			<button class="cancle btn btn-info" style="width: 150px;margin-top: 25px;">cancle</button>
  		</div>
  	</div>
  	<div class="pagination .pager" style="margin-left:40%;">
  		<c:if test="${gods ne null }">
			<li><a href="god/godManage?pageIndex=1">首页</a></li>
			<c:if test="${gods.pageIndex ne 1 }">
			   <li><a href="god/godManage?pageIndex=${gods.pageIndex-1 }">上一页</a></li>
			</c:if>
			<c:forEach  begin="0" end="${gods.totalPage-1 }" varStatus="i">
				<c:if test="${gods.pageIndex eq i.index+1 }">
				   	<li class="active"><a>${gods.pageIndex}</a></li>
				</c:if>
			<c:if test="${gods.pageIndex ne i.index+1 }">
				 <li><a href="god/godManage?pageIndex=${i.index+1 }">[${i.index+1}]</a></li>
			</c:if>	
			</c:forEach>
			 <c:if test="${gods.pageIndex ne gods.totalPage }">
			  <li><a href="god/godManage?pageIndex=${gods.pageIndex+1 }">下一页</a></li>
			</c:if>
			<li><a href="god/godManage?pageIndex=${gods.totalPage }">尾页</a></li> 	 	
		</c:if>
  	</div>
  </body>
</html>
