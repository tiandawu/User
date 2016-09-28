package com.tdw.service;

import com.tdw.dao.XmlUserDao;
import com.tdw.domain.User;
import com.tdw.exception.MsgException;

public class UserService {

	private XmlUserDao dao = new XmlUserDao();

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @throws MsgException
	 */
	public void registUser(User user) throws MsgException {
		// 1、检查用户名是否存在，如果已经存在则提示

		if (dao.findUserByUserName(user.getUserName()) != null) {
			throw new MsgException("用户名已经存在");
		}

		// 2、如果不存在则调用dao中的添加用户方法
		dao.addUser(user);
	}

	/**
	 * 检查用户名和密码是否正确
	 * 
	 * @param userName
	 * @param password
	 */
	public User checkUser(String userName, String password) {
		return dao.findUserByNameAndPsw(userName, password);
	}
}
