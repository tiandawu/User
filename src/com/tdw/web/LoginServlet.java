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

		// 1����ȡ�ͷ����ύ�������û���������

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		// 2������service�еķ���У���û���������
		UserService service = new UserService();
		User user = service.checkUser(userName, password);

		if (user == null) {
			// 3���������ȷ����ʾ
			request.setAttribute("msg", "�û��������벻��ȷ");
			request.getRequestDispatcher("/login.jsp").forward(request,
					response);
			return;
		} else {
			// 4����ȷ���¼�û����ض�����ҳ
			request.getSession().setAttribute("user", user);

			// 5������û���ѡ�˼�ס�û�������ʵ�ּ�ס�û����Ĳ���
			if ("ok".equals(request.getParameter("remberName"))) {
				Cookie remeberNameC = new Cookie("remberName", URLEncoder
						.encode(user.getUserName(), "utf-8"));
				remeberNameC.setPath(request.getContextPath());
				remeberNameC.setMaxAge(3600 * 24 * 30);
				response.addCookie(remeberNameC);
			} else {
				// û�й�ѡ��ס�û�����ɾ��cookie
				Cookie remeberNameC = new Cookie("remberName", "");
				remeberNameC.setPath(request.getContextPath());
				remeberNameC.setMaxAge(0);
				response.addCookie(remeberNameC);
			}
			// �ض���
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
