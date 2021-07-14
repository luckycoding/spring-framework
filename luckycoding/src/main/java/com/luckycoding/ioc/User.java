package com.luckycoding.ioc;

public class User {
	private String name;
	private String password;
	private String email;
	private int id;


	public User(int id, String email, String password, String name) {
		this.email = email;
		this.id = id;
		this.password = password;
		this.name = name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}
}
