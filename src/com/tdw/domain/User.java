package com.tdw.domain;

import java.io.Serializable;

import com.tdw.exception.MsgException;

public class User implements Serializable {

	private int id;
	private String userName;
	private String password;
	private String repeatPassword;
	private String nickName;
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * У������
	 * 
	 * @throws MsgException
	 */
	public void checkValue() throws MsgException {
		if (userName == null || "".equals(userName)) {
			throw new MsgException("�û�������Ϊ��");
		}

		if (password == null || "".equals(password)) {
			throw new MsgException("���벻��Ϊ��");
		}

		if (repeatPassword == null || "".equals(repeatPassword)) {
			throw new MsgException("ȷ�����벻��Ϊ��");
		}

		if (!password.equals(repeatPassword)) {
			throw new MsgException("�������벻һ��");
		}

		if (nickName == null || "".equals(nickName)) {
			throw new MsgException("�ǳƲ���Ϊ��");
		}

		if (email == null || "".equals(email)) {
			throw new MsgException("���䲻��Ϊ��");
		}

		if (!email.matches("^\\w+@\\w+(\\.\\w+)+$")) {
			throw new MsgException("�����ʽ����ȷ");
		}

	}

}
