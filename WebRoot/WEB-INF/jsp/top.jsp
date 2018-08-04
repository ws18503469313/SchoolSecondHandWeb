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
    
    <title>My JSP 'nav.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	
	<style type="text/css">
		*{margin: 0;padding: 0;}
		a:HOVER{color: #99cc99; text-decoration: none;}
		a:VISITED {color: blue;}
		a:LINK{color: purple;text-decoration: none;}
		.menu{position: absolute; right: 0px;}
		.menu ul{list-style: none;clear: both;}
		.menu ul .bigLi{float: right;font-size: 18px;line-height: 35px;margin-right: 10px;color: #3399FF;}
		.menu ul .smalLi{font-size: 14px;color: #3399FF;text-align: center;}
		.top{  height: 135px;background: green;}
		.top a{font-size: 46px;font-weight: bold;color:black; font-family: "楷体"; margin-bottom:0; margin-left: 2%; }
		
	</style>
	<script type="text/javascript">
		$(function(){
			$('#pc').mouseover(function(){
				$('#pc table').show();
			});
			$('#pc').mouseout(function(){
				$('#pc table').hide();
			});
			
		});
	</script>
  </head>
  
  <body>
  	<div class="menu">
  		<ul class="nav nav-tabs">
  			<li><a class="bigLi" href="SchoolSecondHandWeb/nav" target="nav">首页</a></li>
  			
  			<li id="pc">
  				<a  class="bigLi">个人中心</a>
  				<table style="margin: 5px;display: none;">
  					<tr>
  						<td><li><a class="smalLi" href="god/myCollection" target=nav>我的收藏</a></li></td>
  						<td><li><a class="smalLi" href="god/myOrder" target=nav>我的订单</a></li></td>
  					<tr>
  					<tr>
  						<td><li><a class="smalLi" href="god/myGods" target=nav>我的发布</a></li></td>
  						<td><li><a class="smalLi" href="god/publish" target=nav>发布商品</a></li></td>
  					</tr>
  					<tr>
  						<td><li><a class="smalLi" href="user/update" target=nav>修改信息</a></li></td>
  						<td><li><a class="smalLi" href="user/myInfo" target=nav>我的消息</a></td>
  					</tr>
  				</table>
  			</li>
  			<li><a class="bigLi" href="SchoolSecondHandWeb/logout">退出登录</a></li>
  			
  			<c:choose >
  				<c:when test="${loginUser eq null }">
  					<li><a  class="bigLi" href="SchoolSecondHandWeb/login" target=_blank>用户登录</a></li>
  					<li><a class="bigLi" href="SchoolSecondHandWeb/adminlogin" target=_blank>管理员登录</a></li>
  					<li><a  class="bigLi" href="forget.jsp"  target=_blank>忘记密码</a></li>
  					<li><a  class="bigLi" href="SchoolSecondHandWeb/register"  target=_blank>用户注册</a></li>
  				</c:when>
  				<c:otherwise>
  							
  							 <li><a  class="bigLi" class="active">[${loginUser.username }]登录</a></li>
  				</c:otherwise>
  							
  			</c:choose>
  		</ul>
  		
  	</div>
    <div class="top">
    	<a >欢迎进入校园二手交易网站</a>
    </div>
  </body>
</html>