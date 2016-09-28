<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>我的网站</title>
	</head>
	<body>
		<div align="center">
			<h3>
				用户主页
			</h3>

			<c:if test="${sessionScope.user==null}">
		欢迎光临!游客!
		<a href="${pageContext.request.contextPath }/regist.jsp">注册</a>
				<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
		欢迎回来!${sessionScope.user.userName }!
		<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
			</c:if>
		</div>
	</body>
</html>
