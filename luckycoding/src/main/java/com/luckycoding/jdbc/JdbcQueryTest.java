package com.luckycoding.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcQueryTest {
	public static void main(String[] args) {
		String JDBC_URL = "jdbc:mysql://localhost:3306/learnjdbc";
		String JDBC_USER = "root";
		String JDBC_PASSWORD = "123456";

		try (
				Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
			//使用Java对数据库进行操作时，必须使用PreparedStatement，严禁任何通过参数拼字符串的代码！避免sql注入
			try (Statement stmt = conn.createStatement()) {
				try (ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
					while (rs.next()) {
						long id = rs.getLong(1); // 注意：索引从1开始
						long grade = rs.getLong(2);
						String name = rs.getString(3);
						int gender = rs.getInt(4);
						System.out.println(id + gender + name + grade);
					}
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}


		try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
			try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
				ps.setObject(1, "M"); // 注意：索引从1开始
				ps.setObject(2, 3);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						long id = rs.getLong("id");
						long grade = rs.getLong("grade");
						String name = rs.getString("name");
						String gender = rs.getString("gender");
						System.out.println(id + gender + name + grade);
					}
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}


}
