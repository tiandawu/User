package com.tdw.dao;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.tdw.domain.User;
import com.tdw.utils.XmlDaoUtils;

public class XmlUserDao {

	/**
	 * �����û��������û�
	 * 
	 * @param userName
	 *            ���ҵ��û���
	 * @return ���ҵ��ͷ���user bean,���򷵻�null
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
	 * �����û�������������û�
	 * 
	 * @param userName
	 *            �û���
	 * @param password
	 *            ����
	 * @return ���ҵ��ͷ���user bean,���򷵻�null
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
	 * ����û�
	 * 
	 * @param user
	 *            ����û���user bean
	 */
	public void addUser(User user) {
		Document dom = XmlDaoUtils.getDom();
		Element root = dom.getRootElement();
		// 1��ƾ�մ���һ��<user/>Ԫ�أ�Ȼ����ݴ����user bean��<user/>Ԫ���������
		Element userNode = DocumentHelper.createElement("user");
		userNode.setAttributeValue("userName", user.getUserName());
		userNode.setAttributeValue("password", user.getPassword());
		userNode.setAttributeValue("nickName", user.getNickName());
		userNode.setAttributeValue("email", user.getEmail());
		// 2�����ص�<users/>�ڵ���
		root.add(userNode);
		// 3����д��xml�ļ���
		XmlDaoUtils.refXml();
	}

}
