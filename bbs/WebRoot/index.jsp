<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="bf" uri="http://www.itany.com/bbs/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>BBS 论坛首页</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="header.jsp"%>
	<!-- 内容部分 开始 -->
	<div class="cont">
		<table cellspacing="0" class="table">
			<thead>
				<tr>
					<th colspan="2">论坛</th>
					<th>主题</th>
					<th>最后发表</th>
				</tr>
			</thead>
			<tbody>
				<!-- 循环遍历 items的集合 var 定义一个新的变量来接收集合中的对象-->
				<p:forEach items="${sessionScope.boards }" var="one">
					<p:if test="${one.key==0 }">
						<!-- 赋值变量名 将value的值 存储到varname：first 中-->
						<p:set var="first" value="${one.value }"></p:set>
					</p:if>
				</p:forEach>
				<!-- 一级版块 -->
				<p:forEach items="${first }" var="mb">
					<tr>
						<td colspan="4" class="title">${mb.boardName}</td>
					</tr>
					<p:forEach items="${sessionScope.boards }" var="one">
						<p:if test="${one.key==mb.boardId }">
							<p:set var="second" value="${one.value }"></p:set>
						</p:if>
					</p:forEach>
					<p:forEach items="${second }" var="sec">
						<tr>
							<td></td>
							<td><img src="imgs/board.gif"><a
								href="topic.do?boardId=${sec.boardId }">${sec.boardName }</a></td>
							<td>${bf:getTopicCount(sec.boardId)}</td>
							<p:choose>
								<p:when
									test="${bf:findLastTopicByBoard(sec.boardId).postdate!=null}">
									<td><p>
											<a
												href="replay.do?topicId=${bf:findLastTopicByBoard(sec.boardId).topicId }">${bf:findLastTopicByBoard(sec.boardId).title }</a>
										</p> <a
										href="replay.do?topicId=${bf:findLastTopicByBoard(sec.boardId).topicId }">
											${bf:findUser(bf:findLastTopicByBoard(sec.boardId).userid).loginname}</a><span>
											[ <fmt:formatDate
												value="${bf:findLastTopicByBoard(sec.boardId).postdate}"
												pattern="yyyy-MM-dd HH:mm" /> ]
									</span></td>
								</p:when>
								<p:otherwise>
									<td>暂未发布相关帖子</td>
								</p:otherwise>
							</p:choose>
						</tr>
						</tr>

					</p:forEach>
				</p:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
