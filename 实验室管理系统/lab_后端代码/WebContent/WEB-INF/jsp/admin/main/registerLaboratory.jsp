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
	<title>注册实验室</title>
	<link rel="stylesheet" type="text/css" href="css/registerLaboratory.css">
</head>
<body>
	<div class="all">
		<div class="top">
    		<div class="topText"> 首页 > 注册实验室</div>
    	</div>
    	<div class="center">
    	<form action="Lab/addLab" method="post">
    		<div class="centerText">实验室信息填写</div>
    		<div class="box">
    			<div class="laboratoryId">
    				<div class="laboratoryId_name">实验室ID</div>
    				<div class="laboratoryId_val">
    					<input type="text" name="l_Id" class="laboratoryId_textBox">
    				</div>
    			</div>
    			<div class="laboratoryName">
    				<div class="laboratoryName_name">实验室名称</div>
    				<div class="laboratoryName_val">
    					<input type="text" name="l_name" class="laboratoryName_textBox">
    				</div>
    			</div>
    			<div class="laboratoryLocation">
    				<div class="laboratoryLocation_name">实验室位置</div>
    				<div class="laboratoryLocation_val">
    					<input type="text" name="l_location" class="laboratoryLocation_textBox">
    				</div>
    			</div>
                <div class="laboratoryAdmin">
                    <div class="laboratoryAdmin_name">管理员工号</div>
                    <div class="laboratoryAdmin_val">
                        <input type="text" name="a_Id" class="laboratoryAdmin_textBox">
                    </div>
                </div>
    		</div>
    		<input type="submit" name="" value="提交" class="button1">
    	</form>	
    	</div>
	</div>
	<%
		if(request.getAttribute("message") != null){
			int message = (int)request.getAttribute("message"); 
			if(message == 1){
	%>
	<script type="text/javascript">
		alert("注册成功");
	</script>
	<%} else if(message == 0){%>
	<script type="text/javascript">
		alert("注册失败");
	</script>
	<%} }%>
</body>
</html>