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
	<title>二维码生成</title>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-qrcode-0.14.0.min.js"></script>
		<style type="text/css">
			*{
				margin: 5;padding: 0;
			}
			.con{
				margin-left: 10%;margin-top: 10%;
			}	
			#qrcode{
				margin-left: 10%;margin-top: 10px;
			}
			img{
				position: absolute;top: 0;right: 10%;z-index: -1;width: 40%;height: 100%;
			}
		</style>
	</head>
	<body>
		<div class="con">
			<h2>笑笑专用二维码生成器:</h2>
			<input type="text" id="val" placholder="你想说啥涅?">
			<input type="button" value="别墨迹了,快生成吧!" onclick="generate()">
		</div>
		<div>
			<img alt="小可爱" src="img/bg02.jpg">
		</div>
		<div id="qrcode"></div>
		<script type="text/javascript">
			function generate(obj) {
				var val = $("#val").val();
				if(val == "" || val == null){
					alert("请输入内容!");
					return;
				}
				$('#qrcode').empty();
				$('#qrcode').qrcode({width: 64,height: 64,text: val});
			}
		</script>
	</body>
</html>