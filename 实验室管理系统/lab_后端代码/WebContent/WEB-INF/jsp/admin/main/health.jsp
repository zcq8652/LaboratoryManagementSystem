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
	<title>卫生考察</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/hygiene.css">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
		function del(){
			if(confirm("确定删除这些记录吗？") == true){
				document.form.action="Health/delete";
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
    		<div class="topText">首页 > 卫生考察</div>
    	</div>
    	<div class="center">
    		<div class="centerText">卫生记录</div>
    		<form name="form" method="post">
	    		<input type="button" class="delete_btn" value="全部删除" onclick="del()">
	    		<input type="hidden" name="_method" value="DELETE">
    		</form>
    		<div class="main">
    			<div class="main1">
    				<c:forEach items="${healths }" var="health">
	                    <div class="item">
	                    	${health.h_u_name }----${health.h_u_Id }----${health.h_content }----${health.h_time }<br/>
	                    </div>
	                    <div class="img_box">
	                    <c:forEach items="${health.imgsPath }" var="imgsPath">	         
		                        <div class="img_sonbox">
		                        	<img src="${imgsPath }" width="170" height="170" style="display: inline-block;"/>
		                        </div>
		                </c:forEach>
		                </div>		                
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