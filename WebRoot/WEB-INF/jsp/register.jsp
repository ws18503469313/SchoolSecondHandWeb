<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>"> 
    
    <title>用户注册</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	
	<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	
	<script type="text/javascript">
		$(function(){
			var  address;
			$.get("Area.xml",function(data){
				address = data;
				init();
			});
				
		function init(){
				$(address).find("province").each(function(n){
					$("#province").append("<option value="+$(this).attr("name")+">"+$(this).attr("name")+"</option>");
				});
				//province 绑定 change()函数 只用于select 当select改变时引发该函数 
				$("#province").change(function(){
				//此时的this是之前选择的对象
					$("#city option").remove();
					$("#city").append("<option>选择县</option>");
					$("#country option").remove();
					$("#country").append("<option>选择市</option>");
					$(address).find("province[name="+$(this).val()+"] city").each(function(i){
						$("#city").append("<option value="+$(this).attr("name")+">"+$(this).attr("name")+"</option>");
					
					});
					
				});
				$("#city").change(function(){
					$("#country option").remove();
					$("#country").append("<option>选择市</option>");
					$(address).find("city[name="+$(this).val()+"] country").each(function(q){
						$("#country").append("<option value="+$(this).attr("name")+">"+$(this).attr("name")+"</option>");
					});
				});
		}
	});	
	</script>
	<script type="text/javascript">
		function judgement() {
			var username = $("#uid").val();
			if(username == null || username == "" ||username == "请输入账号"){
				alert("请输入账号");
				return false;
			}
			var password = $("#password").val(); //得到,密码框的值
			if(password == null || password ==""){
					alert("请输入密码!");
					return false;
			}
			var reg = /^[A-Za-z0-9]{6,16}$/;
			if(!password.match(reg)){
				alert("请输入由数字、26个英文字母组成的 6-16个长度的密码");
				return false;
			}
			var confirm = $("#confirm").val();
			if(password != confirm){
				alert("两次输入密码不一致!");
				return false;
			}
			var phone = $("#phone").val(); //得到手机号框的值
			if(phone.length != 11){
				alert("请输入11位手机号!");
				return false;
			}
			var email = $("#email").val(); //得到邮箱框的值
			if(email == "请输入邮箱,以便通知您" || email == ""){
				alert("请输入邮箱账号!");
				return false;
			}else{
				var reg = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$";
				if(!email.match(reg)){
					alert("请输入正确格式的邮箱!");
					return false;
				}
			}
						
	}
	</script>
	<style type="text/css">
		tabel{
			width: 500px;
		}
		input{
			width: 350px;
		}
		.content{
			margin-left: 40%;margin-top: 20px;
		}
	</style>
  </head>
  
  <body>
  <div  class="content"><h1>欢迎注册校园二手网站用户</h1></div>
  <div  class="content">
  	<sf:form class="from-group" modelAttribute="user" onsubmit="return judgement()" method="post">
    <table class="tabel table-condensed table-bordered table-hover">
      <tr>
        <td>账号</td>
        <td><input name="username" type="text" id="uid"   placeholder="请输入账号" /></td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input name="password" type="password" id="password"   /></td>
      </tr>
      <tr>
        <td>确认密码</td>
        <td><input  type="password" id="confirm"   /></td>
      </tr>
       <tr>
        <td>手机号</td>
        <td><input name="phone" type="text" id="phone"  placeholder="请输入11位手机号码"  /></td>
      </tr>
      <tr>
        <td>email</td>
        <td><input name="email" type="text" id="email"  placeholder="请输入邮箱,以便通知您" /></td>
      </tr>
      <tr>
        <td>地址</td>
        <td><select id="province" name="province">
		    	<option >请选择省</option>
		    </select>
		    <select id="city" name="city">
		    	<option >请选择市</option>
		    </select>
		    <select id="country" name="country">
		    	<option >请选择县</option>
		    </select>
		  </td>
      </tr>
    </table>
    <div >
      <button  id="btn" type="submit" style=" font-size: 22px;margin-left: 15%;" 
      	class="btn btn-info">立&nbsp;&nbsp;即&nbsp;&nbsp;注&nbsp;&nbsp;册</button>
    </div>
    <br class="clear" />
  </sf:form>
</div>

</body>
</html>
