<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="bf" uri="http://www.itany.com/bbs/functions"%>
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
<title>论坛 话题版块</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script src="js/jquery-1.7.min.js"></script>
<script>
	/**if(${empty secboard}){
	 alert("${requestScope.secboard.boardId}");
	 location.href="topic.do?boardId=${param.boardId}";
	 }
	 */

	//上一页
	function dopre(page) {
		if (page == 1) {
			return;
		}
		window.location.href = "topic.do?boardId=${requestScope.board.boardId}&pageNo="
				+ (page - 1);
	}
	//下一页
	function donext(page, maxPage) {
		if (page == maxPage) {
			return;
		}
		window.location.href = "topic.do?boardId=${requestScope.board.boardId}&pageNo="
				+ (page + 1);
	}

	$(
			function() {
				$("#post")
						.click(
								function() {
									if (${empty sessionScope.users}) {
										alert("请登录后 在进行操作");
										window.location.href = "./login.jsp";
									} else {
										window.location.href = "publish.do?boardId=${requestScope.board.boardId}";
									}
								});
			})
</script>
<!--header开始 -->
<%@ include file="header.jsp"%>
<!--nav导航栏 -->
<div class="indexnav">
	<ul>
		<li><a href="index.do"> 论坛首页 </a></li>
		<li>&gt加精帖</li>
	</ul>
</div>
<!-- 内容开始 -->
<table class="t1" cellspacing="0">
	<thead>
		<tr class="blue">
			<th colspan="2">文章</th>
			<th>内容</th>
			<th>修改时间</th>
		</tr>
	</thead>
	<tbody>
		<p:forEach items="${requestScope.top}" var="one">
			<tr>
				<td style="width:15%;font-size:20px;"><img style="width:80px;" src="imgs/top.png"></td>
				<td style="width:25%;font-size:20px;">${one.title}</td>
				<td style="width:40%;font-size:20px;">${one.tcontents}</td>
				<td style="width:20%;font-size:20px;">${one.modifydate}</td>
			</tr>
		</p:forEach>
	</tbody>
</table>
<div class="page">
	<button class="pre" onclick="dopre(${requestScope.page.pageNo})">上一页</button>
	<button class="next"
		onclick="donext(${requestScope.page.pageNo},${requestScope.page.maxPageNo })">下一页</button>
</div>
<%@ include file="footer.jsp"%>
</body>
</html>
