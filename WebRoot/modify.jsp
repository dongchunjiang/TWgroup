<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
    <form action="<%=request.getContextPath() %>/update.do" method="post">

    	用户名：<input type="text" name="login_name" value="${add.loginName}"><br>
		密码：<input type="password" name="login_password" value="${add.loginPassword}"><br>
		昵称：<input type="text" name="nick_name" value="${add.nickName}"><br>
		备注：<input type="text" name="remark" value="${add.remark}">
		<input type="hidden" name="uuid" value="${add.uuid}">
    <input type="submit" value="提交数据">

      </form>
  </body>
</html>
