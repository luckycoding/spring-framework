package com.luckycoding.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcResourceTest {
	public static void main(String[] args) throws SQLException {
		String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
		String JDBC_USER = "root";
		String JDBC_PASSWORD = "123456";
		// 获取连接:
		Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		// 访问数据库...
		// 关闭连接:
		conn.close();
	}
}
