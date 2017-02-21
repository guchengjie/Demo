<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
<title>主题帖与回复</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<script type="text/javascript" src="js/jquery-1.7.min.js"></script>
<script>
	if (${empty topic}) {
		location.href = "topic.do?topicId=" + ${param.topicId};
	}

	function doPublish(id) {
		if (${empty sessionScope.users}) {
			alert("请登录后 在进行操作");
			window.location.href = "./login.jsp";
		} else {
			window.location.href = "publish.do?boardId=" + id;
		}
	}

	function doReply(id) {
		if (${empty sessionScope.users}) {
			alert("请登录后 在进行操作");
			window.location.href = "./login.jsp";
		} else {
			window.location.href = "post.jsp?topicId=" + id;
		}
	}

	//上一页
	function dopre(page) {
		if (page == 1) {
			return;
		}
		window.location.href = "replay.do?topicId=${requestScope.topic.topicId}&pageNo="
				+ (page - 1);
	}
	//下一页
	function donext(page, maxPage) {
		if (page == maxPage) {
			return;
		}
		window.location.href = "replay.do?topicId=${requestScope.topic.topicId}&pageNo="
				+ (page + 1);
	}
	/*function modify(id){
			window.location.href="remodify.do?topicId="+id; 
	}*/

	//是否删除主题帖
	var replyid = null;
	var userid = null;
	function del(ryid, usid) {

		/**if(confirm("确认删除？")){
			return true;
		}
		return false;*/
		$(".del").fadeIn(500);
		replyid = ryid;
		userid = usid;
	}

	function delCancel() {
		$(".del").fadeOut(500);
		replyid = null;
	}

	function delRight() {
		window.location.href = "delete.do?topicId=${requestScope.topic.topicId}&replyId="
				+ replyid + "&userid=" + userid;
	}
</script>
<!--header开始 -->
<%@ include file="header.jsp"%>

<!-- 删除框 -->
<div class="del">
	<h2>确认删除吗</h2>
	<div>
		<button onclick="delRight()">确认</button>
		<button onclick="delCancel()">取消</button>
	</div>
</div>
<!--nav导航栏 -->
<div class="indexnav">
	<ul>
		<li><a href="index.do">论坛首页</a></li>
		<li>>><a href="topic.do?boardId=${sessionScope.secboard.boardId}">
				<p:out value="${sessionScope.secboard.boardName}"></p:out>
		</a>
		<li>>> 帖子正文
	</ul>
</div>
<section class="post">
	<button onclick="doReply(${requestScope.topic.topicId})">
		<img src="imgs/reply.gif">
	</button>
	<button onclick="doPublish(${sessionScope.secboard.boardId})">
		<img src="imgs/post.gif">
	</button>
</section>
<div class="location">
	主题帖子的标题：
	<p:out value="${requestScope.topic.title }"></p:out>
</div>
<div class="cont">
	<table cellspacing="0" class="relaytable">
		<tbody>
			<tr>
				<td rowspan="2" align="center"><ul>
						<li><p:out
								value="${bf:findUserNameById(requestScope.topic.userid).loginname}"></p:out>
						</li>
						<li><img
							src="${bf:findUserNameById(requestScope.topic.userid).head}"></li>
						<li>注册时间： <fmt:formatDate
								value="${bf:findUserNameById(requestScope.topic.userid).regtime}"
								pattern="yyyy-MM-dd" />
						</li>
					</ul></td>
				<td><ul>

						<li>发帖内容：<p:out value="${requestScope.topic.tcontents}"></p:out>
						</li>
					</ul></td>
			</tr>
			<tr>
				<td>发表时间： [ <fmt:formatDate
						value="${requestScope.topic.postdate}" pattern="yyyy-MM-dd HH:mm:ss" /> ]
					<%-- 最后修改： [ <fmt:formatDate
						value="${requestScope.topic.modifydate}" pattern="yyyy-MM-dd HH:mm:ss" />
					] --%>
				</td>
			</tr>
			<p:forEach items="${requestScope.replys }" var="reply">
				<tr>
					<td rowspan="2" align="center"><ul>
							<li>${bf:findUserNameById(reply.userid).loginname}</li>
							<li><img src="${bf:findUserNameById(reply.userid).head}"></li>
							<li>注册时间： <fmt:formatDate
									value="${bf:findUserNameById(reply.userid).regtime}"
									pattern="yyyy-MM-dd" />
							</li>
						</ul></td>
					<td>回复标题：${reply.rtitle} <br> 回复内容：${reply.rcontents}
					</td>
				</tr>
				<tr>
					<td>回复时间： [ <fmt:formatDate value="${reply.postdate}"
							pattern="yyyy-MM-dd HH:mm:ss" /> ] &nbsp;最新修改： [ <fmt:formatDate
							value="${reply.modifydate }" pattern="yyyy-MM-dd HH:mm:ss" /> ]
						<!-- 登录用户和发帖用户是否一致 --> <p:choose>
							<p:when test="${sessionScope.users.userid == reply.userid}">
								<a href="javascript:void(0)"
									onclick="javascript:return del(${reply.replyId},${reply.userid})">
									【 删除 】 </a>
								<a
									href="remodify.do?replyId=${reply.replyId}&topicId=${requestScope.topic.topicId}">【
									修改 】</a>
							</p:when>
						</p:choose></td>
				</tr>
			</p:forEach>
		</tbody>
	</table>
</div>
<div class="page">
	<button class="pre" onclick="dopre(${requestScope.page.pageNo})">上一页</button>
	<button class="next" onclick="donext(${requestScope.page.pageNo},${requestScope.page.maxPageNo })">下一页</button>
</div>
<!--footer开始  -->
<%@ include file="footer.jsp"%>
</body>
</html>
