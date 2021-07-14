package com.luckycoding.sfjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class UserService {
	@Autowired
	JdbcTemplate jdbcTemplate;

//	public void insertUser(Long id, String email, String password, String name) {
//		String sql = "INSERT INTO users (id, email, password, name) VALUES (?,?,?,?)";
//		jdbcTemplate.execute((Connection conn) -> {
//			// TODO 不能在相应的 try 语句的正文中引用可自动结束的资源rs
//			try (PreparedStatement ps = conn.prepareStatement(sql)) {
//				ps.setObject(1, id);
//				try (ResultSet rs = ps.executeQuery()) {
//					throw new RuntimeException("user insert failed");
//				}
//			}
//		});
//
//	}


	public User getUserById(long id) {
		// 注意传入的是ConnectionCallback:
		return jdbcTemplate.execute((Connection conn) -> {
			// 可以直接使用conn实例，不要释放它，回调结束后JdbcTemplate自动释放:
			// 在内部手动创建的PreparedStatement、ResultSet必须用try(...)释放:
			try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM students WHERE id = ?")) {
				ps.setObject(1, id);
				try (ResultSet rs = ps.executeQuery()) {
					if (rs.next()) {
						return new User( // new User object:
								rs.getLong("id"), // id
								rs.getString("gender"), // email
								rs.getString("grade"), // password
								rs.getString("score")); // name
					}
					throw new RuntimeException("user not found by id.");
				}
			}
		});
	}
}
