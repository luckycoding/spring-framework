package com.luckycoding.sfjdbc;

public class User {
	public String getName() {
		return name;
	}

	private String name;
	private String password;
	private String email;
	private Long id;


	public User(Long id, String email, String password, String name) {
		this.email = email;
		this.id = id;
		this.password = password;
		this.name = name;
	}
}
