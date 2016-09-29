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
	 * 校验数据
	 * 
	 * @throws MsgException
	 */
	public void checkValue() throws MsgException {
		if (userName == null || "".equals(userName)) {
			throw new MsgException("用户名不能为空");
		}

		if (password == null || "".equals(password)) {
			throw new MsgException("密码不能为空");
		}

		if (repeatPassword == null || "".equals(repeatPassword)) {
			throw new MsgException("确认密码不能为空");
		}

		if (!password.equals(repeatPassword)) {
			throw new MsgException("两次密码不一致");
		}

		if (nickName == null || "".equals(nickName)) {
			throw new MsgException("昵称不能为空");
		}

		if (email == null || "".equals(email)) {
			throw new MsgException("邮箱不能为空");
		}

		if (!email.matches("^\\w+@\\w+(\\.\\w+)+$")) {
			throw new MsgException("邮箱格式不正确");
		}

	}

}
