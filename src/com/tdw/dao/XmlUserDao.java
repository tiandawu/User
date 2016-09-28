package com.tdw.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.tdw.domain.User;
import com.tdw.utils.XmlDaoUtils;

public class XmlUserDao {

	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 *            查找的用户名
	 * @return 查找到就返回user bean,否则返回null
	 */
	public User findUserByUserName(String userName) {
		Document dom = XmlDaoUtils.getDom();
		Element root = dom.getRootElement();
		List<Element> list = root.selectNodes("//user[@username='" + userName
				+ "']");
		if (list.size() > 0) {
			Element userElement = list.get(0);
			User user = new User();
			user.setUserName(userElement.attributeValue("userName"));
			user.setPassword(userElement.attributeValue("password"));
			user.setNickName(userElement.attributeValue("nickName"));
			user.setEmail(userElement.attributeValue("email"));
			return user;
		} else {
			return null;
		}
	}

	/**
	 * 更加用户名和密码查找用户
	 * 
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 * @return 查找到就返回user bean,否则返回null
	 */
	public User findUserByNameAndPsw(String userName, String password) {
		Document dom = XmlDaoUtils.getDom();
		Element root = dom.getRootElement();
		List<Element> list = root.selectNodes("//user[@userName='" + userName
				+ "' and @password='" + password + "']");

		if (list.size() > 0) {
			Element userElement = list.get(0);
			User user = new User();
			user.setUserName(userElement.attributeValue("userName"));
			user.setPassword(userElement.attributeValue("password"));
			user.setNickName(userElement.attributeValue("nickName"));
			user.setEmail(userElement.attributeValue("email"));
			return user;
		} else {
			return null;
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            添加用户的user bean
	 */
	public void addUser(User user) {
		Document dom = XmlDaoUtils.getDom();
		Element root = dom.getRootElement();
		// 1、凭空创建一个<user/>元素，然后根据传入的user bean给<user/>元素添加属性
		Element userNode = DocumentHelper.createElement("user");
		userNode.setAttributeValue("userName", user.getUserName());
		userNode.setAttributeValue("password", user.getPassword());
		userNode.setAttributeValue("nickName", user.getNickName());
		userNode.setAttributeValue("email", user.getEmail());
		// 2、挂载到<users/>节点上
		root.add(userNode);
		// 3、回写到xml文件中
		XmlDaoUtils.refXml();
	}

}
