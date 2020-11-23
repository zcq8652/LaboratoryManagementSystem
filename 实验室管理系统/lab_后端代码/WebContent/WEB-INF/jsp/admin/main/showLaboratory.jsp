<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<meta charset="utf-8">
	<title>实验室信息</title>
	<link rel="stylesheet" type="text/css" href="css/showLaboratory.css">
	<script type="text/javascript" src="jquery.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".updateBtn").click(function(){
				prompt("请输入该实验室的管理员工号：","");
			})
			$(".deleteBtn").click(function(){
				confirm("你确定删除这条实验室信息吗？");
			})
		})
	</script>
</head>
<body>
	<div class="all">
		<div class="top">
    		<div class="topText"> 首页 > 实验室信息</div>
    	</div>
    	<div class="center">
    		<div class="centerText">实验室信息</div>
    		<div class="main">
    			<c:forEach items="${labs }" var="lab">
	    			<div class="item">
	    				${lab.l_Id }----${lab.l_name }----${lab.l_location }----${lab.a_Id }
	    				<button class="updateBtn">修改管理员</button>
	    				<button class="deleteBtn">删除</button>
	    			</div>
	    		 </c:forEach>
    		</div>
    	</div>
	</div>
	<%
		if(request.getAttribute("message") != null){
			int message = (int)request.getAttribute("message"); 
			if(message == 1){
	%>
	<script type="text/javascript">
		alert("修改成功");
	</script>
	<%} else if(message == 0){%>
	<script type="text/javascript">
		alert("修改失败");
	</script>
	<%} }%>
</body>
</html>