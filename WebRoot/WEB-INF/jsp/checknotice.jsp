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
    
    <title>My JSP 'checknotice.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#btn").click(function(){
				var filename = $("#filename").text();
				$.ajax({
					url:'user/downloadfile', 	//后台处理程序php  
	      			type:'post',         //数据发送方式post  
	       			dataType:'text',     //接受数据格式json数据  
	       			data:{filename:filename},         //要传递的数据 序列化后的变量  
	       			success:function(message){//回传函数(这里是函数名)即成功后执行update_page函数，可以传参（data）,即服务器返回的数据作为参数  
			    	window.alert(message);
			     }	
				});
				
				
			});
		});
	</script>
	<style type="text/css">
		*{
			margin: 0;padding: 0;
		}
		.con{
			margin-left: 40%;margin-top: 5%;
		}
		.con div{
			margin-top: 15px;
		}
		textarea {
			width: 400px;height: 150px;
		}
	</style>
  </head>
  
  <body>
    <div class="con">
    	<div class="atri"><p>${notice.title }</p></div>
    	<div class="atri"><label style="margin-top: 60px;;">详情</label><textarea>${notice.content }</textarea> </div>
    	<div class="atri"><label>发布时间</label><a>${notice.date }</a> </div>
    	<div class="atri"><label>附件</label><c:if test="${notice.filename ne null }">
    							<a id="filename">${notice.filename }</a></c:if> </div>
    	<div class="atri"><a href="user/downloadfile?filename=${notice.filename }">下载到桌面</a> </div>
    </div>
  </body>
</html>
