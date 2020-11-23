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
	<title>安全记录</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/safe.css">
	<script type="text/javascript">
		function del(){
			if(confirm("确定删除这些记录吗？") == true){
				document.form.action="Safe/delete";
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
    		<div class="topText"><a href="Login/Main">首页</a> > 安全记录</div>
    	</div>
    	<div class="center">
    		<div class="centerText">安全记录</div>
    		<form name="form" method="post">
	    		<input type="button" class="delete_btn" value="全部删除" onclick="del()">
	    		<input type="hidden" name="_method" value="DELETE">
    		</form>
    		<div class="main">
    			<div class="item">
		    		<c:forEach items="${safes }" var="safe">
		    			${safe.sf_u_name }----${safe.sf_u_Id }----${safe.sf_result }----${safe.sf_time }<br/>
		    		</c:forEach>
    			</div>
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