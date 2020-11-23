<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<%
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragrma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=basePath%>"> 
	<meta charset="utf-8">
	<title>主页</title>
	<link rel="stylesheet" type="text/css" href="css/mainPage.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/mainPage.js"></script>
</head>
<body style="overflow:-Scroll;overflow-x:hidden">
<%if(request.getSession().getAttribute("admin") == null){
	response.sendRedirect("/lab/Main/toLogin");
	return;
} %>  
    <div class="all">
    	<div class="allTop">
    		<div class="systemName">软件学院实验室管理系统</div>
            <div class="selectBox">
                <div class="selectBoxSon1">
                    <input type="text" name="" class="selectBoxSon11">
                    <img src="images/selected4.png" class="selected4Img">
                    <div class="inputText">查找功能...</div>
                </div>
                <div class="selectBoxSon2">
                    <img src="images/selected3.png" class="selected3Img">
                </div>
            </div>
            <div class="line1"></div>
    		<div class="userBox">
    			<div class="welcome">欢迎您，</div>
    			<div class="username">${sessionScope.admin.u_name }</div>
    			<img src="images/selectImg.png" class="selectImg">
    		</div>
            <div class="userSelectedBox">
                <a href="#" class="aLevel">
                    <div class="box1">
                        <img src="images/firstPage.png" class="firstPageImg">
                        <span class="text1">首页</span>
                    </div>
                </a>
                <a href="Main/toCancel">
                	<input type="button" name="" class="box2" value="注销">
                </a>
            </div>
    	</div>
    	<div class="allLeft">
    		<dl class="dl">
    			<dt class="dt1">
    				<a href="Main/toAttendance">
                    <img src="images/kaoqin.png" class="kaoqinImg">
                    考勤情况
                    </a>
                </dt>
    			<dt class="dt2">
    				<a href="Main/toSafe">
                    <img src="images/anquan.png" class="anquanImg">
                    安全记录
                    </a>
                </dt>
    			<dt class="dt3">
    				<a href="Main/toHealth">
                    <img src="images/weisheng.png" class="weishengImg">
                    卫生考察
                    </a>
                </dt>
    			<dt class="dt4">
    				<a href="Main/toFault">
                    <img src="images/shebei.png" class="shebeiImg">
                    设备故障
                    </a>
                </dt>
                <dt class="dt5">
                	<a href="Main/toSchedule">
                    <img src="images/class.png" class="classImg">
			课表上传
                    </a>
                </dt>
                <dt class="dt6">
                	<a href="Main/toNotice">
                    <img src="images/gonggao.png" class="gonggaoImg">
                    公告管理
                    </a>
                </dt>
                <dt class="dt6">
                	<a href="Main/toAdjust">
                    <img src="images/gonggao.png" class="gonggaoImg">
                   调停课管理
                    </a>
                </dt>
                <dt class="dt6">
                	<a href="Main/toLab?message=NULL">
                    <img src="images/gonggao.png" class="gonggaoImg">
                  注册实验室
                    </a>
                </dt>
                <dt class="dt6">
                	<a href="Main/toPassword?message=NULL">
                    <img src="images/gonggao.png" class="gonggaoImg">
                 密码重置
                    </a>
                </dt>
                <dt class="dt6">
                	<a href="Main/toLabShow?message=NULL">
                    <img src="images/gonggao.png" class="gonggaoImg">
                 实验室信息
                    </a>
                </dt>                
    		</dl>
    	</div>
    	<div class="allRight">
    	   <jsp:include page="${path }" flush="true"></jsp:include>  
    	</div>
    </div>
</body>
</html>