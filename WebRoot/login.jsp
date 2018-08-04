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
	
	<link rel="stylesheet" href="css/style03.css" />
	<script type="text/javascript" src="${path }js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="${path }js/easyform.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#reg-form').easyform();
		});
	</script>
	
  </head>
  
  <body>
  <div class="form-div">
  	<sf:form id="reg-form"  modelAttribute="user" method="post">
   	 <table>
    	<tr>
    		<td style="font-size: 85px;font-weight:bold; font-family:'楷体';color:green; text-align: center;" colspan="2">欢迎登陆</td>
    	</tr>	
      <tr>
        <td>账号</td>
        <td><input name="username" type="text" id="uid" easyform="char-normal;real-time;" message="请输入账号" easytip="disappear:lost-focus;theme:red;" /></td>
      </tr>
       <tr>
        <td>密码</td>
        <td><input name="password" type="text" id="password" easyform="char-normal;real-time;" message="请输入密码" easytip="disappear:lost-focus;theme:red;" /></td>
      </tr>
      
    </table>
    <div class="buttons">
      <input value="登	录" type="submit" />
    </div>
    <br class="clear" />
  	</sf:form>
  </div>
  </body>
</html>
