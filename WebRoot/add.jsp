<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>添加数据</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<form action="<%=request.getContextPath()%>/addInfo.do" method="post">

		用户名：<input type="text" name="login_name"><br> 
		密码：<input type="password" name="login_password"><br> 
		昵称：<input type="text" name="nick_name"><br> 
		备注：<input type="text" name="remark">
		<input type="submit" value="添加用户">
	</form>
</body>
</html>
