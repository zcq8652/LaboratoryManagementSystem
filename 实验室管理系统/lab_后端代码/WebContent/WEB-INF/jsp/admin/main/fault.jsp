<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>设备故障</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/safe.css">
	<script type="text/javascript">
		function del(){
			if(confirm("确定删除这些记录吗？") == true){
				document.form.action="Fault/delete";
				document.form.method="post";
				document.form.submit();
				return false;
			}else {
				return false;
			}
		}
    </script>
</head>
<body>
	<div class="all">
		<div class="top">
    		<div class="topText">首页 > 设备故障</div>
    	</div>
    	<div class="center">
    		<div class="centerText">申报记录</div>
    		<form name="form" method="post">
	    		<input type="button" class="delete_btn" value="全部删除" onclick="del()">
	    		<input type="hidden" name="_method" value="DELETE">
    		</form>
    		<div class="main">
    			<c:forEach items="${faults }" var="fault">
	    			<div class="item">
	    				${fault.f_u_name }----${fault.f_u_Id }----${fault.f_content }----${fault.f_date }<br/>
	    			</div>
	    		</c:forEach>
    		</div> 
    		<div class="count">
    			<button class="count_btn1"><</button>
    			<input type="text" name="" class="page" value="1">
    			<button class="count_btn2">></button>
    		</div>
    	</div>
	</div>
</body>
</html>