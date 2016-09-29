package com.tdw.dao;

import com.tdw.domain.User;

public interface UserDao {
	/**
	 * �����û��������û�
	 * 
	 * @param userName
	 *            ���ҵ��û���
	 * @return ���ҵ��ͷ���user bean,���򷵻�null
	 */
	public User findUserByUserName(String userName);

	/**
	 * �����û�������������û�
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @return ���ҵ��ͷ���user bean,���򷵻�null
	 */
	public User findUserByNameAndPsw(String userName, String password);

	/**
	 * ����û�
	 * 
	 * @param user
	 *            ����û���user bean
	 */
	public void addUser(User user);
}
