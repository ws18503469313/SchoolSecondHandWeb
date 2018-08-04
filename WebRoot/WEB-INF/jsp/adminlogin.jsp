<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员登录界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${path }css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script src="${path }js/cloud.js" type="text/javascript"></script>
	
	<script language="javascript">
		$(function(){
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			$(window).resize(function(){  
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    });  
		}); 
		function judgement(){
			var username = $(".loginuser").val();
			if(username == null || username == "请输入用户名" || username == ""){
				alert("请输入用户名");
				return  false;
			}
			var password = $(".loginpwd").val();
			if(password == null || password == ""){
				alert("请输入密码");
				return false;
			}
			return true;
		} 
	</script> 

  </head>
  
	<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


	<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox">
    <sf:form modelAttribute="admin" method="post" onsubmit="return judgement()">
	    <ul>
		    <li><input name="username" type="text" class="loginuser" placeholder="请输入用户名"  /></li>
		    <li><input name="password" type="password" class="loginpwd"  /></li>
		    <li><input name="" type="submit" class="loginbtn" value="登录"    />
		    	<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label>
		    	<label><a href="#">忘记密码？</a></label>
		    </li>
	    </ul>
    </sf:form>
    
    </div>
    
    </div>
    
    
    
    <div class="loginbm">版权所有 @王帅  <a href="http://www.aspku.com">源码之家</a> </div>
	
    
</body>
</html>
