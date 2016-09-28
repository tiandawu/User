package com.tdw.test;

import org.junit.Test;

import com.tdw.dao.XmlUserDao;
import com.tdw.domain.User;

public class XmlUserDaoTest {

	@Test
	public void testFindUserByUserName() {
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUserName("tiandawu");
		if (user != null) {
			System.out.println("userName = " + user.getUserName());
			System.out.println("password = " + user.getPassword());
			System.out.println("nickName = " + user.getNickName());
			System.out.println("email = " + user.getEmail());
		} else {
			System.out.println("usert = " + user);
		}
	}
	
	@Test
	public void testFindUserByNmAndPsw(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByNameAndPsw("tiandawu", "tt12388");
		if (user != null) {
			System.out.println("userName = " + user.getUserName());
			System.out.println("password = " + user.getPassword());
			System.out.println("nickName = " + user.getNickName());
			System.out.println("email = " + user.getEmail());
		} else {
			System.out.println("usert = " + user);
		}
	}
	
	@Test
	public void tesAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUserName("ÃÔ¥ÛŒ‰");
		user.setPassword("devbird333");
		user.setNickName("–°ÃÔÃÔ");
		user.setEmail("tian@qq.com");
		dao.addUser(user);
	}
}
