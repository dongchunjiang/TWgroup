<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<title>登录页面</title>
</head>
<body class="login_body">
	<form action="<%=request.getContextPath()%>/login.do" method="post">
		<div class="login_div">
			<h1>欢迎登录</h1>
			<ul class="list-unstyled">
				<li style="height: 40px;">
					用户名： <input type="text" name="login_name" />
				</li>
				<li style="height: 40px;">
					密&nbsp;&nbsp;&nbsp;码： <input type="text" name="login_password" />
				</li>
				<li style="height: 40px;">
					<ul class="list-inline">
						<li><input type="submit" value="登录" class="btn btn-primary" /></li>
						<li><input type="button" value="注册" class="btn btn-primary" onclick="goRegister()"/></li>
					</ul>
				</li>
			</ul>
		</div>
	</form>
	<!-- js -->
	<script type="text/javascript">
		function goRegister(){
			window.location.href="add.jsp";
		}
	</script>
	<!-- 导入js -->
	<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>