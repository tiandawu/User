package com.tdw.dao;

import com.tdw.domain.User;

public interface UserDao {
	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 *            查找的用户名
	 * @return 查找到就返回user bean,否则返回null
	 */
	public User findUserByUserName(String userName);

	/**
	 * 更加用户名和密码查找用户
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 查找到就返回user bean,否则返回null
	 */
	public User findUserByNameAndPsw(String userName, String password);

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            添加用户的user bean
	 */
	public void addUser(User user);
}
