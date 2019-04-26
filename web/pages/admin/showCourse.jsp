<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程查询</title>
<!-- 分页查看 -->
<link rel="stylesheet" type="text/css" href="resources/js/dataTable/jquery.dataTables.min.css">
<script type="text/javascript" src="resources/js/dataTable/jquery.js"></script>
<script type="text/javascript" src="resources/js/dataTable/jquery.dataTables.min.js"></script>
</head>
<body>
	<center>
		<h1>课程查询</h1>
		<hr>
		<table style="width: 100%;">
			<tr>
				<td></td>
				<td align="right">
					<form method="get">
					搜索<input type="text" name="name">
					<input type="submit" value="搜索">
				</form> </td>
			</tr>
		</table>
		<table cellspacing="0px" cellpadding="0px" border="1px" width="100%" class="tablelist" id="example">
			<thead>
				<tr>
					<th>课程ID</th>
					<th>课程名</th>
					<th>方向</th>
					<th>描述</th>
					<th>时长(小时)</th>
					<th>操作人</th>
				</tr>
			</thead>
			<tbody>
                    <c:forEach items="${list}" var="course">
					<tr>
						<td>${course.getCourseId()}</td>
						<td>${course.getCourseName()}</td>
						<td>${course.getCourseType()}</td>
						<td>${course.getDescription()}</td>
						<td>${course.getCourseTime()}</td>
						<td>${course.getOperator()}</td>
					</tr>
					</c:forEach>
				
			</tbody>

		</table>
		<c:if test="${totalPage>1}">
			<table style="width: 100%">
                  <tr>
					  <td align="left">从${(curPage*5)-4}到${totallast} 条记录/共${totalProducts}记录</td>
					  <td align="right">

							  <a href="<%=basePath%>/GetCourseServlet?page=1">首页</a>
							  <a href="<%=basePath%>/GetCourseServlet?page=${prePage}&name=${name}">上一页</a>
							  <buttom>${curPage}</buttom>
							  <a href="<%=basePath%>/GetCourseServlet?page=${nextPage}&name=${name}"> 下一页</a>
						      <a href="<%=basePath%>/GetCourseServlet?page=${totalPage}&name=${name}"> 尾页</a>
					  </td>


				  </tr>
			</table>
		</c:if>

	</center>
	
</body>
</html>