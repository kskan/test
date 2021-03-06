<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<style type="text/css">
	.c1{
		width:300px;
		cursor:pointer;
	}
	.c2{
		width:300px;
		padding-left: 30px;
	}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${flag==1 }">
			<div class="c1">
				<h3 onclick="show1()">用户管理</h3>
				<div class="c2" id="menu1" style="display:none;">
					<p><a href="<%=basePath%>/pages/admin/addUser.jsp" target="main">添加管理员</a></p>
					<p><a href="<%=basePath%>/SelectUserServlet" target="main">查询管理员</a></p>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<h3>用户管理</h3>
		</c:otherwise>
	</c:choose>
	<div class="c1">
		<h3 onclick="show2()">课程管理</h3>
		<div class="c2" id="menu2" style="display:none;">
			<p><a href="<%=basePath%>/pages/admin/addCourse.jsp" target="main">课程添加</a></p>
			<p><a href="<%=basePath%>/pages/admin/courseImport.jsp" target="main">课程批量导入(Excel)</a></p>
			<p><a href="<%=basePath%>/ExportCourseServlet" target="main">课程导出</a></p>
			<p><a href="<%=basePath%>/GetCourseServlet" target="main">课程查询</a></p>
		</div>
	</div>
	<script type="text/javascript">
		function show1(){
			var menu = document.getElementById("menu1");
			var displayStyle = menu.style.display;
			if(displayStyle=="none"){
				menu.style.display="block";
			}else{
				menu.style.display="none";
			}
		}
		function show2(){
			var menu = document.getElementById("menu2");
			var displayStyle = menu.style.display;
			if(displayStyle=="none"){
				menu.style.display="block";
			}else{
				menu.style.display="none";
			}
		}
	</script>
</body>
</html>