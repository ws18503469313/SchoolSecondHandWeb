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
    
    <title>发布商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<link rel="stylesheet" href="${path }css/style03.css" />
	<script type="text/javascript" src="${path }js/jquery-3.3.1.min.js"></script>
	<style type="text/css">
		#reg-form{
			margin-left: 40%;
			margin-top: 20px;
			border: 5px dotted green;
			width: 18%;
		}
		#title{
			font-family: "楷体";font-weight: bold;text-align: center;font-size: 34px;margin-top: 25px;color: olive;
		}
	</style>
	<script type="text/javascript">
		function judge() {
			var name = $('#uid').val();
			if(name == "请输入商品名称" || name == null || name == ""){
				alert("请输入商品名称")
				return false;
			}
			var disc = $('#disc').val();
			if(disc == "请输入商品描述" || disc == null || disc == ""){
				alert("请输入商品描述")
				return false;
			}
			var price = $('#price').val();
			if(price == "请输入商品价格" || price == null || price == ""){
				alert("请输入商品价格")
				return false;
			}
			var reg = /^[0-9]{1,10}$/;
			if(!price.match(reg)){
				alert("价格只能为数字!");
				return false;
			}
			
			
			
		}
	</script>
  </head>
  
  <body>
  <h1 id="title">商品发布</h1>
  <sf:form id="reg-form" onsubmit="return judge()" modelAttribute="god" enctype="multipart/form-data" method="post"  >
    <table>
      <tr>
        <td>名称</td>
        <td><input name="name" placeholder="请输入商品名称" type="text" id="uid"  /></td>
      </tr>
      <tr>
        <td>描述</td>
        <td ><input name="disc"  type="text" id="disc" placeholder="请输入商品描述"/></td>
        <td></td>
      </tr>
      <tr>
        <td>价格</td>
        <td><input name="price" type="text" id="price" placeholder="请输入商品价格"  /></td>
      </tr>
      <tr>
        <td>选择种类</td>
        <td>
        	<select name="type" style="width: 225px;height: 30px;">
        		<option></option>
        		<option>生活用品</option>
        		<option>数码电子</option>
        		<option>服装装饰</option>
        		<option>文体用品</option>
        		<option>其他</option>
        	</select>
        </td>
      </tr>
      <tr>
        <td>上传图片</td>
        <td><input name="files" class="file" type="file"  /></td>
      </tr>
       <tr>
        <td>上传图片</td>
        <td><input name="files" type="file" class="file"   /></td>
      </tr>
       <tr>
        <td>上传图片</td>
        <td><input name="files" type="file" class="file"  /></td>
      </tr>
       <tr>
        <td>上传图片</td>
        <td><input name="files" type="file" class="file"  /></td>
      </tr>
       
    </table>
    <div class="buttons">
      <input value="发	布" type="submit" />
    </div>
    <br class="clear" />
  </sf:form>
	
  </body>
</html>
