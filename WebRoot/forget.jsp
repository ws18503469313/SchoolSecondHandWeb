<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${path }js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${path }js/jquery.form.js"></script>
<title>忘记密码</title>

<script type="text/javascript">
	$(function(){
		$("#aaaa").click(function () {
			$('#check_div').hide();
    		$('#update_div').show();
		});
		$('#btn_confirm').click(function(){
			var username = $("#username").val();
			if(username == null || username == "" ||username == "请输入账号"){
				alert("请输入账号");
				return false;
			}
			var email = $("#email").val(); //得到邮箱框的值
			var reg = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$";
			if(!email.match(reg)){
				alert("请输入正确格式的邮箱!");
				return false;
			}
			$.ajax({
				url:'user/emailConfirm', 	 
				type:'post',
				async: false,
		      	dataType:'json',     
		      	data:{'username':username,'email':email},  
		      	success: function (json) {
			    	if(json.result){
			    		alert(json.msg);
			    		$('#check_div').hide();
			    		$('#user_id').val(json.user.id);
			    		$('#update_div').show();
			    		
			    	}else{
			    		alert(json.msg);
			    	}
			    } 
			}); 
			
		});
	});
	function submitInfo(){
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
		var id = $("#user_id").val();
		$.ajax({//ajax方式提交表单  
		    url: 'user/updateUserPasswrod',  
		    type: 'post',  
		    data:{'id':id,'password':password},
		    dataType: 'text',  
		    beforeSubmit: function () {alert("表单已提交,系统正在处理,请稍后!")},  
		    success: function (msg) {  
		    	alert(msg);
		    },  
		    clearForm: true, //禁止清楚表单  
		    resetForm: true//禁止重置表单  
		});
	}
</script>
<style type="text/css">
	*{
		margin: 0;padding: 0;
	}
	h1{
		text-align: center;
	}
	.con{
		text-align: center;
	}
	.con div{
		margin-top: 20px;
	}
	.con label{
		width: 200px;
	}
	.con input{
		width: 200px;
	}
	.con button{
		width: 120px;height: 42px;border-radius: 8px; 
	}
</style>
</head>
<body>
	<div style="margin-top: 15%;">
		<h1>校园二手-方便你我</h1>
	</div>
	<div id="check_div" class="con">
		<form id="check_form" >
			<div><p>请先通过邮箱校验本人操作,方可进行密码修改!</p></div>
			<div>
				<label>请输入账号</label><input id="username" type="text" name="username"/>
			</div>
			<div>
				<label>请输入注册邮箱</label><input id="email" type="text" name="email"/>
			</div>
			<div><button type="button"  class="btn btn-info" id="btn_confirm">点击验证</button></div>
		</form>
	</div>
	<div id="update_div" style="display: none;" class="con">
		<form id="update_form">
			<input type="hidden" id="user_id" name="id" />
			<div>
				<label>密码</label><input id="password" type="password" name="password"/>
			</div>
			<div>
				<label>确认密码</label><input id="confirm" type="password" />
			</div>
		</form>
		<div><button type="button" id="btn" onclick="submitInfo()">立即修改</button></div>
	</div>
</body>
</html>