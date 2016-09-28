<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.tiandawu.com/UserTag" prefix="UserTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>我的网站</title>
	</head>
	<body>
		<div align="center">
			<h3>
				登录页面
			</h3>
			<hr />
			<font color="red">${msg}</font>
			<form
				action="${pageContext.request.contextPath}/servlet/LoginServlet"
				method="POST">
				<table border="1px" cellspacing="0">
					<tr>
						<td>
							用户名
						</td>
						<td>

							<input type="text" name="userName"
								value="<UserTag:URLDecoder content="${cookie.remberName.value}"/>" />
						</td>
					</tr>

					<tr>
						<td>
							密码
						</td>
						<td>
							<input type="password" name="password" />
						</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<input type="checkbox" value="ok" name="remberName"
								<c:if test="${cookie.remberName!=null }">
								checked="checked"
								</c:if>>
							记住用户名
							</input>
						</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<input type="submit" value="登录" />
						</td>
					</tr>
				</table>
			</form>
		</div>

	</body>
</html>
