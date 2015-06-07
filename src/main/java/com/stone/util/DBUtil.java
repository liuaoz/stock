package com.stone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ���ݿ�������߰�
 * 
 * @author matrix
 * @since 2015-05-14
 */
public class DBUtil {
	private static String DBNAME = "sample";
	private static String URL = "127.0.0.1";
	private static String USER = "administrator";
	private static String PASSWORD = "111111";
	private static String PORT = "60000";
	private Connection conn;

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return conn ���ݿ�����
	 */
	public Connection getConn() {

		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			conn = DriverManager.getConnection("jdbc:db2://" + URL + ":" + PORT
					+ "/" + DBNAME, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;

	}

	/**
	 * �����ݿ�
	 */
	public void openConn() {
	}

	/**
	 * �ر����ݿ�����
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
