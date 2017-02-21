<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>登录界面</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
</head>

<body>
<%@ include file="header.jsp" %>
<!--nav导航栏 -->
<div class="indexnav">>><a href="index.do">论坛首页</a></div>
<div class="login">
  <form action="./login.do" method="post">
    <h2>${requestScope.loginrr }</h2>
    <table>
      <tr>
        <td><label for="loginname">用户名：</label></td>
        <td><input type="text" name="loginname" value=""></td>
      </tr>
      <tr>
        <td><label for="loginpwd">密码：</label></td>
        <td class="pass"><input type="password" name="loginpwd" value=""></td>
      </tr>
      <tr>
        <td>验证码</td>
        <td><input type="text" name="vcode" class="vcode">
          <img  src="validate.jpg" id="vcode" title="看不清，请点击刷新"></td>
      </tr>
      <tr>
        <td colspan="2" class="btn">
          <input type="submit" value="提交" class="w50" />
          <input type="reset" value="重置"  class="w50"/>
          <a href="findpwd.jsp">忘记密码</a>
          </td>
      </tr>
    </table>
  </form>
</div>
<script>
    	$("#vcode").click(function(){
    		this.src="validate.jpg?"+new Date().getTime();
    	
    	})
    	
    </script>
<%@ include file="footer.jsp" %>
</body>
</html>
