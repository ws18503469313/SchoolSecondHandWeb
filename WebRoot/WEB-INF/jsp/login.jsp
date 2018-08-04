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
    
    <title>欢迎登陆</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
	var code;//声明一个变量用于存储生成的验证码  
	$(function () {
		changeImg();
		 	
		document.getElementById("code").onclick=changeImg;  
		     
	});
	 function changeImg(){  
		 
	        var arrays=new Array(  
	            '1','2','3','4','5','6','7','8','9','0',  
	            'a','b','c','d','e','f','g','h','i','j',  
	            'k','l','m','n','o','p','q','r','s','t',  
	            'u','v','w','x','y','z',  
	            'A','B','C','D','E','F','G','H','I','J',  
	            'K','L','M','N','O','P','Q','R','S','T',  
	            'U','V','W','X','Y','Z'               
	        );  
	        code='';//重新初始化验证码  
	        //alert(arrays.length);  
	        //随机从数组中获取四个元素组成验证码  
	        for(var i=0;i<4;i++){  
	        //随机获取一个数组的下标  
	            var r=parseInt(Math.random()*arrays.length);  
	            code+=arrays[r];  
	            //alert(arrays[r]);  
	        }  
	        //alert(code);  
	        document.getElementById('code').innerHTML=code;//将验证码写入指定区域  
	}       
	//效验验证码(表单被提交时触发)  
	 function check(){  
		 	var username = $("#username").val();
			if(username == null || username == "" ||username == "请输入账号"){
				alert("请输入账号");
				return false;
			}
			var password = $("#password").val(); //得到,密码框的值
			if(password == null || password ==""){
					alert("请输入密码!");
					return false;
			}
	        //获取用户输入的验证码  
	        /* var input_code=document.getElementById('vcode').value;#vcode')  ; */
	        var input_code = $('#vcode').val();
// 	        alert(code);
//	        alert(input_code+"----"+code);  
	        if(input_code.toLowerCase()==code.toLowerCase())  
	        {  
	            //验证码正确(表单提交)  
	            return true;  
	        }  
	        alert("请输入正确的验证码!");  
	        //验证码不正确,表单不允许提交  
	        return false;  
	    }  	
	</script>
	<style type="text/css">
		#form{
			margin-left: 44%;
			margin-top: 10%;
		}
		div{
			margin-top: 15px;
		}
		#title{
			font-size: 85px;font-weight: bold;font-family: "楷体";color: green;
		}
		.con{
			margin-left: 8%; 
		}
	</style>
  </head>
  
  <body>
  
  <div >
  	
  	<sf:form  modelAttribute="user" id="form" onsubmit="return check()" method="post"  >
  		<div id="title"><a >欢迎登陆</a></div>
  		<div class="con">
  			<label>账号</label>
  			<input name="username" type="text" id="username"  placeholder="请输入账号" />
  		</div>
  		<div class="con">
  			<label>密码</label>
  			<input name="password" type="password" id="password"  placeholder="请输入密码" />
  		</div>
  		<div class="con" >
				<input type="text"  id="vcode" placeholder="请输入验证码..."/>
				<span id="code" style="cursor: pointer;" title="看不清，换一张"></span>
		</div>
	    <div class="con" class="buttons">
	      <input value="登	录" type="submit" />
	    </div>
	    <br class="clear" />
  	</sf:form>
  </div>
  </body>
</html>
