<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bf" uri="http://www.itany.com/bbs/functions" %>
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
<title>发表回帖</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>

<!--header开始 -->
<%@ include file="header.jsp"%>
<!--nav导航栏 -->
<div class="indexnav">
  <ul>
    <li><a href="index.do">论坛首页</a></li>
    <li>>>
      <p:out value="${sessionScope.secboard.boardName}"></p:out>
      </a></li>
    <li>>>
      <p:out value="${sessionScope.topic.title}"></p:out>
      </a></li>
  </ul>
</div>
<form action="post.do?topicId=${param.topicId}" method="POST">
  <table class="tab2">
    <thead>
      <tr>
        <th colspan="2">发表回帖</th>
      </tr>
    </thead>
    <tbody>
      <tr  class="h30">
        <td>标题</td>
        <td><input type="text" name="rtitle">
          </td>
      </tr>
      <tr class="text">
        <td>内容</td>
        <td><textarea rows="16" clos="30" name="rcontents"></textarea>
          <span>(不能大于：1000字)</span></td>
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
