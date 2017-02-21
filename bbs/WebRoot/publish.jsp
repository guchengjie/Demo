<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>发表帖子页面</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>

<!--header开始 -->
<%@ include file="header.jsp"%>
<!--nav导航栏 -->
<div class="indexnav">
  <ul>
    <li><a href="index.do">论坛首页</a></li>
    <li>>> <a href="topic.do?boardId=${param.boardId}">
      <p:out value="${sessionScope.secboard.boardName}"></p:out>
      </a>
  </ul>
</div>
<form action="publish.do?boardId=${param.boardId}" method="POST">
  <table class="tab2">
    <thead>
      <tr class="h30">
        <th colspan="2">发表新帖</th>
      </tr>
    </thead>
    <tbody>
      <tr  class="h30">
        <td>标题</td>
        <td><input type="text" name="title" placeholder="标题"></td>
      </tr>
      <tr class="text">
        <td>内容</td>
        <td><textarea rows="16" clos="50" name="contents" placeholder="(不能大于：1000字)"></textarea>
        </td>
      </tr>
    </tbody>
  </table>
  <div class="tijiao">
    <input type="submit" value="提交" class="w50" />
    <input type="reset" value="重置" class="w50" />
  </div>
</form>
<!--footer开始  -->
<%@ include file="footer.jsp"%>
</body></html>
