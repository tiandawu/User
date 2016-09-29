package com.tdw.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import com.tdw.utils.JDBCUtils;

public class JDBCTest {
	@Test
	public void add() {
		Connection conn = null;
		Statement stat = null;
		try {
			// 1.注册数据库驱动
			// 2.获取连接
			conn = JDBCUtils.getConn();
			// 3.获取传输器对象
			stat = conn.createStatement();
			// 4.执行sql语句
			int count = stat
					.executeUpdate("insert into user values(null,'devbird','男','devbird@qq.com',26)");
			// 5.处理结果
			if (count > 0) {
				System.out.println("插入数据成功，影响到的行数为：" + count);
			} else {
				System.out.println("插入数据失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}

	}

	@Test
	public void update() {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			int count = stat
					.executeUpdate("update user set age=20 where name='devbird'");
			if (count > 0) {
				System.out.println("修改成功，影响到的行数为：" + count);
			} else {
				System.out.println("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}
	}

	@Test
	public void find() {
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery("select * from user where name='devbird'");
			while (rs.next()) {
				String name = rs.getString("name");
				String sex = rs.getString("sex");
				String email = rs.getString("email");
				short age = rs.getShort("age");

				System.out.println("name = " + age);
				System.out.println("sex = " + sex);
				System.out.println("email = " + email);
				System.out.println("age = " + age);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, stat, conn);
		}
	}

	@Test
	public void delete() {
		Connection conn = null;
		Statement stat = null;
		try {
			conn = JDBCUtils.getConn();
			stat = conn.createStatement();
			int count = stat
					.executeUpdate("delete from user where name='devbird'");
			if (count > 0) {
				System.out.println("删除成功，影响到的行数为：" + count);
			} else {
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}
	}
}
