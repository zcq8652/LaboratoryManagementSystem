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
	<title>课表上传</title>
	<meta charset="utf-8">
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript">
	//导入excel文件
		function c(){
		  	var formData = new FormData();
		    var name = $("#articleImageFile").val();
		    formData.append("file",$("#articleImageFile")[0].files[0]);
		    formData.append("name",name);//这个地方可以传递多个参数
		    $.ajax({
		        url : "Schedule/upload",
		        type : 'POST',
		        async : false,
		        data : formData,
		        // 告诉jQuery不要去处理发送的数据
		        processData : false,
		        // 告诉jQuery不要去设置Content-Type请求头
		        contentType : false,
		        beforeSend:function(){
		            console.log("正在进行，请稍候");
		        },
		        success : function(responseStr) {

		        }
		    });
		}
    </script>
</head>
<body>	
	<div class="form-group" id="thumbnailUploadContainer" class="col-sm-10" style="float: left; margin-right: 50px;">
		<input id="articleImageFile" name="excelFile" type="file" class="form-control" style="width: 300px; display: inline;" />
		<input id="saveZipButton" type="button" style="width: 60px;height: 35px;" value="上传" onclick="c()" />
	</div>	
</body>
</html>