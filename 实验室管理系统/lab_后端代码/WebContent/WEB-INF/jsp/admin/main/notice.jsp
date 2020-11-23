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
	<title>公告管理</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/safe.css">
	<script type="text/javascript" src="js/jquery.js"></script>
    <style type="text/css">
        .addNotice_btn{
            position: absolute;
            top: 40px;
            right: 100px;
            width: 80px;
            height: 25px;
            border-radius: 6px;
            border: 1px solid orange;
            background-color: orange;
            color: #fff;
            cursor: pointer;
        }
        .add{
            position: absolute;
            top: 200px;
            left: 20%;
            width: 60%;
            height: 300px;
            border: 1px solid #ccc;
            display: none; 
 			z-index: 2;
        }
        .addtxt{
            font-size: 30px;
            color: #0081b8;
            background-color: #f2f2f2;
        }
        .content_title{
            position: absolute;
            top: 50px;
            left: 20px;
        }
        .content_box{
            position: absolute;
            top: 80px;
            left: 20px;
            width: 94.5%;
            height: 150px;
            border: 1px solid #ccc;
        }
        .add_btn{
            position: absolute;
            top: 250px;
            left: 46%;
            width: 60px;
            height: 25px;
            background-color: #0081b8;
            color: #fff;
            border: 1px solid #0081b8;
            border-radius: 6px;
            cursor: pointer;
        }
    </style>
    <script type="text/javascript">
		function del(){
			if(confirm("确定删除这些记录吗？") == true){
				document.form.action="Notice/delete";
				document.form.method="post";
				document.form.submit();
				return false;
			}else {
				return false;
			}
		}
		function add(){
			if(confirm("确定发布该公告吗？") == true){
				document.form1.action="Notice/add";
				document.form1.method="post";
				document.form1.submit();
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
    		<div class="topText">首页 > 公告管理</div>
    	</div>
    	<div class="center">
    		<div class="centerText">公告记录</div>
    		<form name="form" method="post">
				<input type="button" value="新增公告" class="addNotice_btn">
	    		<input type="button" value="全部删除" class="delete_btn" onclick="del()">
	    		<input type="hidden" name="_method" value="DELETE">
	    	</form>
    		<div class="main">
    		    <c:forEach items="${notices }" var="notice">
    				<div class="item">
		    			${notice.a_name }----${notice.n_content }----${notice.n_date }<br/>
    				</div>
    			</c:forEach>
    		</div> 
    		<div class="count">
    			<button class="count_btn1"><</button>
    			<input type="text" name="" class="page" value="1">
    			<button class="count_btn2">></button>
    		</div>
    	</div>
    	<form name="form1" method="post">
    			<div class="add">
		            <div class="addtxt">新增公告</div>
		            <div class="content_title">发布内容：</div>
		            <textarea class="content_box" name="n_content"></textarea>
		            <input type="button" value="发布公告" class="add_btn" onclick="add()">
		        </div>
    	</form>
	</div>
    <script type="text/javascript">
        $(".addNotice_btn").toggle(function(){
            $(".add").css('display','block');
        }, function(){
            $(".add").css('display','none');
        })
    </script>
</body>
</html>