<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>"> 
	<meta charset="utf-8">
	<title>重置密码</title>
	<link rel="stylesheet" type="text/css" href="css/resetPassword.css">
</head>
<body>
	<div class="all">
		<div class="top">
    		<div class="topText"> 首页 > 重置密码</div>
    	</div>
    	<div class="center">
    		<div class="centerText">重置密码</div>
    		<div class="box">
    			<div class="resetPass">
    				<div class="resetPass_name">学号/工号</div>
    				<div class="resetPass_val">
    					<input type="text" name="id" class="resetPass_textBox"> 
    				</div>
    				<div class="demo">重置后的密码为：123456</div>
    			</div>
    		</div>
    		<input type="submit" name="" value="提交" class="button1">
    	</div>
	</div>
	<%
		if(request.getAttribute("message") != null){
			int message = (int)request.getAttribute("message"); 
			if(message == 1){
	%>
	<script type="text/javascript">
		alert("重置成功");
	</script>
	<%} else if(message == 0){%>
	<script type="text/javascript">
		alert("重置失败");
	</script>
	<%} }%>
</body>
</html>