<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${path }css/style.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>

  </head>
  
  <body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    	<li><a href="#">首页</a></li>
	    </ul>
    </div>
    
    <div class="mainindex">
    
    
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>[${loginUser.username }]你好，欢迎使用校园二手物品交易信息管理系统</b>
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间：${loginUser.date }</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
    
    <div class="xline"></div>
    
    <ul class="iconlist">
    
    <li><img src="images/ico02.png" /><p><a href="user/publishNews">发布文章</a></p></li>
    <li><img src="images/ico04.png" /><p><a href="user/publishNews">文件上传</a></p></li>
    <li><img src="images/ico06.png" /><p><a href="#">查询</a></p></li> 
<!--     <li><img src="images/ico01.png" /><p><a href="#">管理设置</a></p></li>
    <li><img src="images/ico03.png" /><p><a href="#">数据统计</a></p></li>
    <li><img src="images/ico05.png" /><p><a href="#">目录管理</a></p></li>
 -->            
    </ul>
    
    
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>信息管理系统使用指南</b>
    </div>
    
    <ul class="infolist">
    <li><span>您可以快速进行文章发布管理操作</span><a class="ibtn">发布或管理文章</a></li>
    <li><span>您可以快速发布产品</span><a class="ibtn">发布或管理产品</a></li>
    <li><span>您可以进行密码修改、账户设置等操作</span><a class="ibtn">账户管理</a></li>
    </ul>
    
    <div class="xline"></div>
    
    <div class="uimakerinfo"><b></b></div>
    
    <ul class="umlist">
    <li><a >发布文章</a></li>
    <li><a >访问网站</a></li>
    <li><a >管理广告</a></li>
    <li><a >后台用户设置(权限)</a></li>
    <li><a >系统设置</a></li>
    </ul>
    
    
    </div>
  </body>
</html>
