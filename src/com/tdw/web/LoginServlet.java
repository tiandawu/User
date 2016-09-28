package com.tdw.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tdw.domain.User;
import com.tdw.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1、获取客服端提交过来的用户名和密码

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		// 2、调用service中的方法校验用户名和密码
		UserService service = new UserService();
		User user = service.checkUser(userName, password);

		if (user == null) {
			// 3、如果不正确则提示
			request.setAttribute("msg", "用户名或密码不正确");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		} else {
			// 4、正确则登录用户后重定向到主页
			request.getSession().setAttribute("user", user);

			// 5、如果用户勾选了记住用户名，则实现记住用户名的操作
			if ("ok".equals(request.getParameter("remberName"))) {
				Cookie remeberNameC = new Cookie("remberName", URLEncoder
						.encode(user.getUserName(), "utf-8"));
				remeberNameC.setPath(request.getContextPath());
				remeberNameC.setMaxAge(3600 * 24 * 30);
				response.addCookie(remeberNameC);
			} else {
				// 没有勾选记住用户名，删除cookie
				Cookie remeberNameC = new Cookie("remberName", "");
				remeberNameC.setPath(request.getContextPath());
				remeberNameC.setMaxAge(0);
				response.addCookie(remeberNameC);
			}
			// 重定向
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
