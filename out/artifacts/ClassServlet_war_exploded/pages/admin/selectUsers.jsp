<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员查询</title>
</head>
<body>
	<center>
		<h1>管理员查询</h1>
		<hr>
		<table cellspacing="0px" cellpadding="0px" border="1px" width="600px">
			<thead>
				<tr>
					<th>用户名</th>
					<th>密码</th>
					<th>类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				 <c:forEach items="${list}" var="admin">
					<tr>
						<td>${admin.get("adminname")}</td>
						<td>${admin.get("adminpassword")}</td>
						<td>
							<c:choose>
							<c:when test="${admin.get('adminname').equals('imooc')}">
								超级管理员
							</c:when>
								<c:otherwise>
									普通管理员
								</c:otherwise>
							</c:choose>

						</td>
						<td><a href="<%=basePath%>/DeleteUser?username=${admin.get("adminname")}">删除</a></td>
					</tr>
				 </c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>