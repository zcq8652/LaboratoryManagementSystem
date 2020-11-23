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
	<title>考勤情况</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/clock.css">
    <link rel="stylesheet" href="css/dateTime.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/clock.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/dateTime.min.js"></script>
   	<script type="text/javascript">
		function del(){
			if(confirm("确定删除这些记录吗？") == true){
				document.form.action="Attendance/delete";
				document.form.method="post";
				document.form.submit();
				return false;
			}else {
				return false;
			}
		}
		function sel(){
			document.form.action="Attendance/query";
			document.form.method="get";
			document.form.submit();
		}
    </script>
</head>
<body>
    <div class="all">
    	<div class="top">
    		<div class="topText">首页 > 考勤情况</div>
    	</div>
    	<div class="center">
    		<div class="centerText">考勤记录</div>
    		<form name="form">
	    		<div class="chaxun">
	    			<div class="t1">时间段查询：</div>
	    			<div class="time_chaxun">
	    			    <input type="text" placeholder="请选择日期和时间" name="start_time" class="datetime1">
	                    <div class="dateShow1">
	                    <script src="gg_bd_ad_720x90.js" type="text/javascript"></script>
	                    </div>  
	                    <div class="demo">~</div>
	                    <input type="text" placeholder="请选择日期和时间" name="end_time" class="datetime2">
	                    <div class="dateShow2">
	                        <script src="gg_bd_ad_720x90.js" type="text/javascript"></script>
	                    </div>  
	    			</div>
	    			<div class="t2">教师查询：</div>
	    			<div class="tea_chaxun">
	    				<input type="text" name="t_name" class="tea_text">
	    			</div>
	    			<input type="button" name="" class="chaxun_btn" value="查询" onclick="sel()">
	    		</div>
	            <div class="delete">
	                <div class="t3">请选择日期：</div>
	                <div class="delete_box">
	                    <input type="text" placeholder="请选择日期和时间" name="delete_time" class="datetime3">
	                    <div class="dateShow3">
	                        <script src="gg_bd_ad_720x90.js" type="text/javascript"></script>
	                    </div>  
	                </div>
	                <input type="button" class="delete_btn" value="删除" onclick="del()">
	    			<input type="hidden" name="_method" value="DELETE">
	            </div>
            </form>
    	    <div class="main">
    			<c:forEach items="${attendances }" var="attendance">
	    			<div class="item">
	    				${attendance.t_name }----${attendance.t_Id }----${attendance.at_at }----${attendance.at_time }<br/>
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