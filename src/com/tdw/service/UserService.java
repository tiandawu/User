package com.tdw.service;

import com.tdw.dao.XmlUserDao;
import com.tdw.domain.User;
import com.tdw.exception.MsgException;

public class UserService {

	private XmlUserDao dao = new XmlUserDao();

	/**
	 * ע���û�
	 * 
	 * @param user
	 * @throws MsgException
	 */
	public void registUser(User user) throws MsgException {
		// 1������û����Ƿ���ڣ�����Ѿ���������ʾ

		if (dao.findUserByUserName(user.getUserName()) != null) {
			throw new MsgException("�û����Ѿ�����");
		}

		// 2����������������dao�е�����û�����
		dao.addUser(user);
	}

	/**
	 * ����û����������Ƿ���ȷ
	 * 
	 * @param userName
	 * @param password
	 */
	public User checkUser(String userName, String password) {
		return dao.findUserByNameAndPsw(userName, password);
	}
}
