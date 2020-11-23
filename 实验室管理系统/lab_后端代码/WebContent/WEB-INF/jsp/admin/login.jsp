<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>">
	<title>登录界面</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="all">
    	<div class="block">
    		<div class="blockTitle">欢迎登录实验室管理系统</div>
    		<div class="line"></div>
            <img src="images/login.png" class="loginImg">
            <div class="line2"></div>
    		<div class="login">
    			<form action="Login/toMain" method="post">
    				<input type="text" name="a_Id" id="uid" class="username"  placeholder="账号">
    				<input type="password" name="a_password" class="password" placeholder="密码">
                    <input type="submit" value="登录" class="teacherBtn">
                    <input type="reset" value="重置" class="reTeacherBtn">
                    <input type="checkbox" name="option" value="automatic" class="option">
                		<div class="option1">自动登录</div>
    			</form>
    		</div>
            <div class="forget">忘记密码？</div>
            <div class="line3"></div>
    	</div>
    </div>
    		<%
               if(request.getAttribute("error") != null){
            %>
               <script type="text/javascript">
					alert("${message}");
               </script>
            <%} %>
</body>
</html>