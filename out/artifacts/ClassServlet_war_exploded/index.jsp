<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<%
   String flag=request.getParameter("flag");
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
	<script>
		var flag="<%=flag%>";
		if(flag=='1')
		{
			alert("用户名和密码错误！");
		}if(flag=='2'){
				alert("验证码错误!");
		}if(flag=='3'){
			alert("用户未登陆，登陆后操作！");
		}

	</script>
<style type="text/css">
	.code 
	{
	 background:url(<%=basePath%>/code.jsp);
	 font-family:Arial;
	 font-style:italic;
	 color:blue;
	 font-size:20px;
	 border:0;
	 padding:2px 3px;
	 letter-spacing:3px;
	 font-weight:bolder;
	 float:left;
	 cursor:pointer;
	 width:70px;
	 height:18px;
	 line-height:20px;
	 text-align:center;
	 vertical-align:middle;
	}
	a 
	{
	 text-decoration:none;
	 font-size:12px;
	 color:#288bc4;
	}
	a:hover 
	{
	 text-decoration:underline;
	}
</style>

</head>
<body>
	<center>
		<h1>用户登录</h1>
		<form action="<%=basePath%>/LoginServlet" method="post" onsubmit="return validateCode()">
			<table width="300px" cellspacing="0px" cellpadding="0px" border="1px">
				<tr>
					<td>用户名</td>
					<td colspan="2"><input type="text" name="username" placeholder="用户名为3-12位字母数字或下划线组合"></td>
				</tr>
				<tr>
					<td>密&nbsp;码</td>
					<td  colspan="2"><input type="password" name="password" placeholder="长度为5-12位字母数字或下划线组合" ></td>
				</tr>
				<tr>
					<td>验证码</td>
					<td style="border-right-style:none;">
						<input type="text" name="checkCode" placeholder="请输入验证码" id="inputCode">
					</td>
					<td style="border-left-style:none;"><div class="code" id="checkCode" onclick="changeCode()" ></div></td>

				</tr>
				<tr>
					<td colspan="3" style="text-align:center">
						<input type="submit" value="登录">
						<input type="reset" value="取消">
					</td>
				</tr>
			</table>
		</form>
	</center>
<script>

	function changeCode() {
		document.getElementById("checkCode").style.background = "url(<%=basePath%>/code.jsp?d="+new Date().getTime()+")";
	}

</script>
</body>
</html>