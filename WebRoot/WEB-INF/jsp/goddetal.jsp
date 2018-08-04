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
    
    <title>商品详情-[${god.godname }]</title>
    
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path }js/godDetal.js" ></script>
	<link rel="stylesheet" type="text/css" href="${path }css/detal.css">
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript">
		$(function(){
			$('#buynow').click(function(){
				var user_id = $('#purcher_id').text();
				var purcher_id = $('.publisher_id').val();
				if(user_id.length == 0){
					alert("请先登录!");
					return;
				}
				if(user_id == purcher_id){
					alert("傻瓜!这是你自己发布的商品!");
					return;
				}
				if(confirm("请确认购买!")){
					var address = window.prompt("请输入收货地址!");
					confirm_address(address);
				};
				
			});
			
		});
		function confirm_address(address){
			if(window.confirm("确认收货地址:"+address)){
				$.ajax({
					url:'god/addOrder',
					type:'post',
					dataType:'text',
					data:{
						address:address,
						god_id:$('#god_id').text(),
						purcher_id:$('#purcher_id').text()
					},
					success:function(data){
						alert(data);
						window.location.href = "god/myOrder";
					}
				});
			}else{
				address = window.prompt("请输入收货地址!");
				confirm_address(address);
			}
		}
	</script>
  </head>
  <jsp:include page="common.jsp"></jsp:include>
  <body>
      	<div class="con">
    	<table class="tabblee">
    		<tr> 	
    			<td>
				    <div class="left">
				    	<div class="main"> 
				    		<a style="display: none;" id="god_id">${god.id }</a>
				    		<a style="display: none;" id="purcher_id">${loginUser.id}</a>
				    		<input type="hidden" class="publisher_id" value="${god.id }">
						    <a class="username">用户:${god.username }</a>&nbsp;&nbsp;
						    
						    <a class="date">发布时间:${god.date }</a>
					    </div>
				    	<img class="big" src="fileupload/${god.username }/${god.img1}"/>
				    	<table>
				    		<tr>
				    			<td><img class="small img-rounded" src="fileupload/${god.username }/${god.img1}"></td>
				    			<td><img class="small img-rounded" src="fileupload/${god.username }/${god.img2}"></td>
				    			<td><img class="small img-rounded" src="fileupload/${god.username }/${god.img3}"></td>
				    			<td><img class="small img-rounded" src="fileupload/${god.username }/${god.img4}"></td>
							</tr>
				    	</table>	
				    </div>
				</td>
				<td>
				    <div class="right">
				    	<table class="table table-bodered  table-condensed">
				    		<tr><td>商品名称:${god.godname }</td></tr>
				    		<tr><td>访问次数:${god.clickTime }</td></tr>
				    		<tr><td class="price">¥${god.price }</td></tr>
				    		<tr><td>地址:${god.address }</td></tr>
				    		<tr><td>联系方式:${god.phone }</td></tr>
				    		<tr><td><button class="btn btn-info " id="buynow">立即购买</button></td></tr>
				    		<tr><td><button value="${god.id }" class="btn btn-info " id="aic">加入收藏</button></td></tr>
				    	</table>
				    </div>
				</td>
			</tr> 	
	    </table>
	    <div class="add">
	    	<div class="btn"><input id="discrip" type="button" value="描述" /><input id="comment" type="button" value="评论" style="margin-left: 5px;"/></div>
	    	<div class="disc" id="disc">${god.disc }</div>
	    	<div  id="comments" style="display: none;" >
	    		<c:forEach items="${cr }" var="c">
	    			<table>
	    				<tr>
	    					<td>[${c.cmtusername}]:${c.cmtcontent }</td>
	    					<td>评论时间:${c.cmtdate }</td>
	    				</tr>
	    				<c:if test="${c.reply ne null }">
	    					<tr>
	    					<td>[卖家回复]:${c.reply }</td>
	    					<td>回复时间:${c.rpldate }</td>
	    				</tr>
	    				</c:if>
	    				
	    				<c:if test="${c.commentId ne loginUser.id && loginUser.id eq c.publisherId}">
	    					<tr>
	    						<td><a>回复</a></td>
	    					<td>
	    						<input type="text" class="reply">
	    						<input type="hidden"  class="comment_id" value="${c.commentId }">
	    					</td>
	    					<td ><a class="submitreply btn btn-info btn-small btn-round">提交</a></td>
	    					</tr>
	    					<hr/>
	    				</c:if>
	    			</table><br/>
	    		</c:forEach>
	   		</div>
	   	</div>
	   	<div class="addcomment">
	   		<div>
	   			<form action="god/addComment"  method="get">
	   				<input type="hidden" name="id" value="${god.id }">
	   				<input name="comment" style="width: 100%;height: 68px;font-size: 24px;" type="text" />
 		   			<input value="添加评论" type="submit" style="border:none;  font-size: 32px;font-weight: bold;font-family: '楷体';"/>
	   			</form>
	   		</div>
		</div>
	</div>
	
  </body>
</html>
