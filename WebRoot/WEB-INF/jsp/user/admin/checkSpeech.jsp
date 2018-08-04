<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${path }css/bootstrap.min.css">
<script type="text/javascript" src="${path }js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function delete_comment(obj,comment_id) {
		 $.ajax({
			url:'user/deleteComment', 	 
			type:'post',
			async: false,
	      	dataType:'text',     
	      	data:{comment_id:comment_id},  
	      	success:function(message){
	      		 $(obj).parent().parent("tr").remove();
	    	   	 window.alert(message);
	      	}
		}); 
	}

</script>
</head>
<body>
	<div>
		<p style="color:green;font-style:楷体;  font-weight: bold;font-size: 22px;">${msg }</p>
	</div>
	<div>
		<table class="table table-bordered table-hover">
			<tr>
				<td>言论</td>
				<td>发布时间</td>
				<td>品论商品</td>
				<td>卖家回复</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${speech }" var="i">
				<tr class="${i.comment }">
					
					<td>${i.comment }</td>
					<td>${i.date }</td>
					<td>${i.god.name }</td>
					<td><p>
							<c:forEach items="${i.replies }" var="r">
								${r.content },${r.date }<br/>
							</c:forEach>
						</p>
					</td>
					<td><button type="button" value="delete" onclick="delete_comment(this,${i.id})">删除</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>