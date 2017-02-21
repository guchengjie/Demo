<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
	<div>
		<img src="${pageContext.request.contextPath }/imgs/logo.jpg"
			class="img-responsive">
	</div>
</div>
<div class="container">
	<ul class="nav nav-pills">
		<p:choose>
			<p:when test="${sessionScope.users !=null}">
				<li class="disabled"><a href="javascript:void(0)">欢迎您： <span>
							<p:out value="${sessionScope.users.loginname }"></p:out>
					</span></a></li>
				<p:if test="${sessionScope.users.level==1}"><li><a href="http://127.0.0.1:8080/BBS1/houtai.html">后台管理系统</a></li></p:if>
				<li><a href="./addtop.do">加精帖</a></li>
				<li><a href="./addgood.do">置顶帖</a></li>
				<li><a href="./exit.do">退出</a></li>

			</p:when>
			<p:otherwise>
				<li class="disabled"><a href="javascript:void(0)">您尚未</a></li>
				<li><a href="./login.jsp">登录</a></li>
				<li><a href="./regist.jsp">注册</a></li>
			</p:otherwise>
		</p:choose>
	</ul>
</div>

