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
	<title>首页</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/firstPage.css">
</head>
<body>
	<div class="all">
		<div class="top">
			<img src="images/firstPage.png" class="topImg">
    		<div class="topText">首页</div>
    	</div>
    	<div class="teacher">
    		<div class="top">
    			<div class="teacherText">教师调停课申请</div>
    			<div class="gang"></div>
    			<div class="f_img">
    				<a href="#"><img src="images/table.png" class="tableImg"></a>
    				<a href="#"><img src="images/new.png" class="newImg"></a>
    			</div>
    		</div>
    		<c:forEach items="${adjusts }" var="adjust">
    			${adjust.t_name }----${adjust.ad_content }----${adjust.ad_date }<br/>
    		</c:forEach>
    	</div>
    	<div class="shebei">
    		<div class="top">
    			<div class="shebeiText">公告</div>
    			<div class="gang"></div>
    			<div class="f_img">
    				<a href="#"><img src="images/table.png" class="tableImg"></a>
    				<a href="#"><img src="images/new.png" class="newImg"></a>
    			</div>
    		</div>
    	    <c:forEach items="${notices }" var="notice">
    			${notice.n_content }----${notice.n_date }<br/>
    		</c:forEach>
    	</div>
    	<div class="student">
    		<div class="top">
    			<div class="studentText">设备故障信息</div>
    			<div class="gang"></div>
    			<div class="f_img">
    				<a href="#"><img src="images/table.png" class="tableImg"></a>
    				<a href="#"><img src="images/new.png" class="newImg"></a>
    			</div>
    		</div>
    		<c:forEach items="${faults }" var="fault">
    			${fault.f_content }----${fault.f_date }<br/>
    		</c:forEach>
    	</div>
	</div>
</body>
</html>