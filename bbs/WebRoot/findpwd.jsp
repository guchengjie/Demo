<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>通过邮箱找回密码</title>
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="indexnav">
		<ul>
			<li><a href="index.do">论坛首页</a></li>
			<li>&gt;&gt;找回密码</li>
		</ul>
	</div>
	<article>
		<section>
			<div class="login">
				<form action="findpwd.do" method="POST">
					<table>
						<tr>
							<td><label for="loginname">登录名：</label></td>
							<td><input type="text" name="loginname"></td>
						</tr>
						<tr>
							<td><label for="loginname">邮箱：</label></td>
							<td><input type="text" name="email"></td>
						</tr>
						<tr>
							<td colspan="2" class="btn"><input type="submit" value="提交"
								class="w50" /> <input type="reset" value="重置" class="w50" /></td>
						</tr>
					</table>
				</form>
			</div>
		</section>

	</article>
	<%@ include file="footer.jsp"%>



</body>
</html>

