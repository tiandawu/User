<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
	<head>
		<title>我的网站</title>
		<script type="text/javascript">
			function changeImg(img){
				img.src = img.src+"?time="+new Date().getTime();
			}
		</script>
	</head>
	<body>
		<div align="center">
			<h3>
				注册页面
			</h3>

			<hr />
			<font color="red">${msg }</font>
			<form
				action="${pageContext.request.contextPath}/servlet/RegistServlet"
				method="POST">

				<table cellspacing="0" border="1px" cellpadding="0">
					<tr>
						<td>
							用户名
						</td>
						<td>
							<input type="text" name="userName" value="${param.userName}" />
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

					<tr>
						<td>
							确认密码
						</td>
						<td>
							<input type="password" name="repeatPassword" />
						</td>
					</tr>

					<tr>
						<td>
							昵称
						</td>
						<td>
							<input type="text" name="nickName" value="${param.nickName}" />
						</td>
					</tr>

					<tr>
						<td>
							邮箱
						</td>
						<td>
							<input type="text" name="email" value="${param.email}" />
						</td>
					</tr>

					<tr>
						<td colspan="2" align="center">
							<img src="${pageContext.request.contextPath}/servlet/ValiImg"
								style="cursor: pointer;" onclick="changeImg(this)" />
						</td>
					</tr>
					<tr>
						<td>
							验证码
						</td>
						<td>
							<input type="text" name="valistr" />
						</td>
					</tr>

					<tr>
						<td colspan="2" align="center">
							<input type="submit" name="注册" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
