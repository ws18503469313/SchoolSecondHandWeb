<%@ page language="java" import="java.util.*,com.ws.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="${path }css/style03.css" />
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="${path }js/easyform.js"></script>
  </head>
  
  <body>
  <div class="form-div">
  <sf:form id="reg-form" modelAttribute="user" method="post">
    <table>
    	<tr>
        <td><tr>
        <td><input name="address" type="hidden"   value="${loginUser.address }"/>
        	<input name="id" type="hidden"   value="${loginUser.id }"/>
        	<input name="username" type="hidden"   value="${loginUser.username }"/>
        	</td>
      </tr>
      <tr>
    		<td style="font-size: 65px;font-weight:bold; font-family:'楷体';color:green; text-align: center;" colspan="2">信息修改</td>
    	</tr>	
      <tr>
        <td style="font-size: 50px;font-weight:bold; font-family:'楷体';color:#232124; text-align: center;" colspan="2">${loginUser.username }</td>
        <td style="color: green;display: none;">√</td>
      </tr>
        <tr>
        <td>密码</td>
        <td><input name="password" type="password"  easyform="length:3-12;char-normal;real-time;" message="请输入新密码" easytip="disappear:lost-focus;theme:red;" /></td>
      </tr>
      <tr>
        <td>手机号</td>
        <td><input name="phone" type="text" value="${loginUser.phone }" easyform="length:11;char-normal;real-time;" message="请输入要更换的手机号" easytip="disappear:lost-focus;theme:red;" /></td>
      </tr>
      <tr>
        <td>email</td>
        <td><input name="email" type="text" id="email" value="${loginUser.email }" easyform="email;real-time;" message="请输入要更换的Email" easytip="disappear:lost-focus;theme:red;" ajax-message="这个Email地址已经被注册过，请换一个吧!" /></td>
      </tr>
    </table>
    <div class="buttons">
      <input value="提     交" type="submit" />
    </div>
    <br class="clear" />
  </sf:form>
</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$('#reg-form').easyform();
	});
	</script>
  </body>
</html>
<%-- 
 
      <tr>
        <td>账号</td>
        <td><a style="font-size: 32px;font-weight: bold;font-family: '楷体';text-align: center;">${loginUser.username }</a></td>
        <td style="color: green;display: none;">√</td>
      </tr>
      <tr>
        <td>密码</td>
        <td><input name="password" type="password" id="password"  placeholder="请输入新密码" value="${loginUser.password }"/></td>
        <td style="color: green;display: none;">√</td>
      </tr>
       <tr>
        <td>手机号</td>
        <td><input name="phone" type="text" id="phone"  placeholder="请输入要更换的手机号码" value="${loginUser.phone }" /></td>
        <td style="color: green;display: none;">√</td>
      </tr>
      <tr>
        <td>email</td>
        <td><input name="email" type="text" id="email"  placeholder="请输入要更换的邮箱" value="${loginUser.email }"/></td>
        <td style="color: green;display: none;">√</td>
      </tr>
      <tr>
        <td><tr>
        <td><input name="address" type="hidden"   value="${loginUser.address }"/>
        	<input name="id" type="hidden"   value="${loginUser.id }"/>
        	<input name="username" type="hidden"   value="${loginUser.username }"/>
        	</td>
      </tr>
 --%>
