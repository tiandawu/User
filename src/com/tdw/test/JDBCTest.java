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
			// 1.ע�����ݿ�����
			// 2.��ȡ����
			conn = JDBCUtils.getConn();
			// 3.��ȡ����������
			stat = conn.createStatement();
			// 4.ִ��sql���
			int count = stat
					.executeUpdate("insert into user values(null,'devbird','��','devbird@qq.com',26)");
			// 5.������
			if (count > 0) {
				System.out.println("�������ݳɹ���Ӱ�쵽������Ϊ��" + count);
			} else {
				System.out.println("��������ʧ��");
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
				System.out.println("�޸ĳɹ���Ӱ�쵽������Ϊ��" + count);
			} else {
				System.out.println("�޸�ʧ��");
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
				System.out.println("ɾ���ɹ���Ӱ�쵽������Ϊ��" + count);
			} else {
				System.out.println("ɾ��ʧ��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, stat, conn);
		}
	}
}
