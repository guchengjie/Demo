<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>成功页面</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>

<script type="text/javascript">
	setTimeout(function() {
		location.href = "./login.jsp";

	}, 3000);
</script>
</head>

<body>
	<!-- 头部 -->
	<%@ include file="header.jsp"%>
	<div class="regist">
		<div class="msg">
			欢迎您<span> ${requestScope.user.loginname } </span> 注册 <a
				href="./login.jsp">点击跳转</a> 或者 3s 跳转至登录界面
		</div>
	</div>
	<!-- 头部 -->
	<%@ include file="footer.jsp"%>
</body>

</html>
