package com.tdw.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.tdw.domain.User;
import com.tdw.exception.MsgException;
import com.tdw.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			// 1��У����֤��
			String valistr = request.getParameter("valistr");
			String valiPre = (String) request.getSession().getAttribute(
					"valistr");
			if (valistr == null || valiPre == null || !valistr.equals(valiPre)) {
				request.setAttribute("msg", "��֤�벻��ȷ");
				request.getRequestDispatcher("/regist.jsp").forward(request,
						response);
				return;
			}
			// 2����װ����У������

			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			// user.setUserName((String) request.getParameter("userName"));
			// user.setPassword((String) request.getParameter("password"));
			// user.setRepeatPassword((String)
			// request.getParameter("repeatPassword"));
			// user.setNickName((String) request.getParameter("nickName"));
			// user.setEmail((String) request.getParameter("email"));

			// System.out.println("username = " + user.getUserName());
			// System.out.println("password = " + user.getPassword());
			// System.out.println("reaptPassword = " +
			// user.getRepeatPassword());
			// System.out.println("nickname = " + user.getNickName());
			// System.out.println("email = " + user.getEmail());

			user.checkValue();
			// 3������service�еķ�������û�
			UserService service = new UserService();
			service.registUser(user);
			// 4����¼�û�
			request.getSession().setAttribute("user", user);
			// 5����ʾע��ɹ�3��ص���ҳ
			response.getWriter().write("ע��ɹ���3���ص���ҳ��");
			response.setHeader("refresh", "3,url=" + request.getContextPath()
					+ "/index.jsp");
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/regist.jsp").forward(request,
					response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
