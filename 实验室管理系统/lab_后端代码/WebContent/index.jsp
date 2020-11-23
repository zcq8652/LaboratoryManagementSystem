<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>"> 
<meta charset="utf-8">
<title>实验室管理系统</title>
</head>
<body>
<a href="Index/toLogin">实验室管理系统</a>
</body>
</html>