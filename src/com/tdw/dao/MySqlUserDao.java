package com.tdw.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.tdw.domain.User;
import com.tdw.utils.JDBCUtils;

public class MySqlUserDao implements UserDao {

	public User findUserByUserName(String userName) {
		String sql = "select * from users where userName='" + userName + "'";

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setNickName(rs.getString("nickName"));
				user.setEmail(rs.getString("email"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JDBCUtils.close(rs, stat, conn);
		}
	}

	public User findUserByNameAndPsw(String userName, String password) {

		String sql = "select * from users where userName='" + userName
				+ "' and password='" + password + "'";

		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				user.setNickName(rs.getString("nickName"));
				user.setEmail(rs.getString("email"));
				return user;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JDBCUtils.close(rs, stat, conn);
		}
	}

	public void addUser(User user) {
		String sql = "insert into users values(null,'" + user.getUserName()
				+ "','" + user.getPassword() + "','" + user.getNickName()
				+ "','" + user.getEmail() + "')";

		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}
	}

}
