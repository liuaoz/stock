package com.stone.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库操作工具包
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
	 * 获取数据库连接
	 * 
	 * @return conn 数据库连接
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
	 * 打开数据库
	 */
	public void openConn() {
	}

	/**
	 * 关闭数据库连接
	 */
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
