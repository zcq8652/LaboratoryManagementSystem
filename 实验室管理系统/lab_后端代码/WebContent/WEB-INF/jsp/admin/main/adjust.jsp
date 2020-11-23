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
	<title>调停课申请</title>
	<meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/adjustClass.css">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/adjustClass.js"></script>
    <script type="text/javascript">
		function del(){
			if(confirm("确定删除这些记录吗？") == true){
				document.form.action="Adjust/delete";
				document.form.method="post";
				document.form.submit();
				return false;
			}else {
				return false;
			}
		}
		function sel1(){
			document.form.action="Adjust/select1";
			document.form.method="get";
			document.form.submit();
		}
		function sel2(){
			document.form.action="Adjust/select2";
			document.form.method="get";
			document.form.submit();
		}
    </script>
</head>
<body>
	<div class="all">
		<div class="top">
    		<div class="topText">首页 > 调停课管理</div>
    	</div>
    	<div class="center">
    		<form name="form">
	            <input type="button" value="待审核记录" class="wait_btn" onclick="sel1()">
	            <input type="button" value="已审核记录" class="complete_btn" onclick="sel2()">
	            <input type="button" class="delete_btn" value="删除" onclick="del()">
	            <input type="hidden" name="_method" value="DELETE">
	        </form>
    		<div class="centerText">审核记录</div>
            <div class="main2">
            	<c:forEach items="${adjusts }" var="adjust">
	                <div class="item2">
	                	${adjust.t_name }----${adjust.t_Id }----${adjust.ad_content }----${adjust.ad_date }----
	                	<c:if test="${adjust.ad_state eq 0 }">
	                		已通过
	                	</c:if>
	                	<c:if test="${adjust.ad_state eq 3 }">
	                		未通过
	                	</c:if>
	                	<c:if test="${adjust.ad_state eq 1 }">
	                		<a href="Adjust/${adjust.ad_Id }/agree"><input type="button" value="同意" class="agree"></a>
	                    	<a href="Adjust/${adjust.ad_Id }/disagree"><input type="button" value="不同意" class="disagree"></a>
	                	</c:if>	                	
	                	<c:if test="${adjust.ad_state eq 2 }">
	                		<a href="Adjust/${adjust.ad_Id }/agree"><input type="button" value="同意" class="agree"></a>
	                    	<a href="Adjust/${adjust.ad_Id }/disagree"><input type="button" value="不同意" class="disagree"></a>
	                	</c:if>
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