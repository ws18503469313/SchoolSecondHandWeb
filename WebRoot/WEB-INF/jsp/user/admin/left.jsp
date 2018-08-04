<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'left.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="${path }css/style.css" rel="stylesheet" type="text/css" />
	<script language="JavaScript" src="${path }js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript">
		$(function(){	
			//导航切换
			$(".menuson li").click(function(){
				$(".menuson li.active").removeClass("active");
				$(this).addClass("active");
			});
			
			$('.title').click(function(){
				var $ul = $(this).next('ul');
				$('dd').find('ul').slideUp();
				if($ul.is(':visible')){
					$(this).next('ul').slideUp();
				}else{
					$(this).next('ul').slideDown();
				}
			});
		});	
	</script>
  </head>
  
  <body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>管理信息
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="user/userManage" target="rightFrame">用户信息管理</a><i></i></li>
        <li><cite></cite><a href="god/godManage" target="rightFrame">商品信息管理</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">添加编辑</a><i></i></li>
        <li><cite></cite><a href="#" target="rightFrame">图片列表</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="images/leftico02.png" /></span>通知管理
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="user/publishNews" target="rightFrame">发布文章</a><i></i></li>
        <li><cite></cite><a href="user/publishNews" target="rightFrame">文件上传</a><i></i></li>
        <li><cite></cite><a href="user/newManage">新闻管理</a><i></i></li>
     </ul>     
    </dd> 
    
   <!--  <dd><div class="title"><span><img src="images/leftico03.png" /></span>编辑器</div>
    <ul class="menuson">
        <li><cite></cite><a href="#">自定义</a><i></i></li>
        <li><cite></cite><a href="#">常用资料</a><i></i></li>
        <li><cite></cite><a href="#">信息列表</a><i></i></li>
        <li><cite></cite><a href="#">其他</a><i></i></li>
    </ul>    
    </dd>  
    
    <dd><div class="title"><span><img src="images/leftico04.png" /></span>日期管理</div>
	    <ul class="menuson">
	        <li><cite></cite><a href="#">自定义</a><i></i></li>
	        <li><cite></cite><a href="#">常用资料</a><i></i></li>
	        <li><cite></cite><a href="#">信息列表</a><i></i></li>
	        <li><cite></cite><a href="#">其他</a><i></i></li>
	    </ul>
    </dd>   --> 
    </dl>
</body>
</html>
