<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程后台管理系统</title>
</head>
	<frameset rows="20%,*">
		<frame src="<%=basePath%>/pages/admin/top.jsp"></frame>
		<frameset cols="15%,*">
			<frame src="<%=basePath%>/pages/admin/left.jsp"></frame>
			<frame name="main"></frame>
		</frameset>
	</frameset>
</html>