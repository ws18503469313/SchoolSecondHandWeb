<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
	<title>欢迎</title>
	<script type="text/javascript" src="${path }js/jquery.js"></script>
	<style type="text/css">
		*{
			margin: 0;padding: 0;
		}
		.con{
			text-align: center;margin-top: 12%;
		}
		.con div{
			margin-top: 22px;	
		}
		img{
			position: absolute;top: 0;left: 0;z-index: -1;width: 40%;height: 100%;
		}	
	</style>
	<script type="text/javascript">
		$("#btn").click(function () {
			
		});
		function login() {
			var username = $("#username").val();
			var password = $("#password").val();
			if(username == "xiaoxiao" && password == "0620"){
				window.location.href = "generate.html";
			}else{
				alert("错误凭证!");
			}
		}
	</script>
	</head>
	<body>
		<div class="con">
			<div>
				<label>用户名</label><input type="text" id="username"/>
			</div>
			<div>
				<label>密码</label><input type="password" id="password">
			</div>
			<div>
				<input type="button" value="提交" onclick="login()">
			</div>
		</div>
		<div>
			<img alt="小侠女" src="img/bg01.jpg">
		</div>
	</body>
</html>