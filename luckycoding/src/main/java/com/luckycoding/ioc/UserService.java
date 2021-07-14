package com.luckycoding.ioc;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	private MailService mailService;

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}

	private List<User> users = new ArrayList<User>() {
		private static final long serialVersionUID = 123456789L;

		{
			add(new User(1, "bob@example.com", "password", "Bob"));
		}
	};


	public User login(String email, String password) {
		for (User user : users) {
			if (user.getEmail().equalsIgnoreCase(email) && user.getPassword().equals(password)) {
				mailService.sendLoginMail(user);
				return user;
			}
		}
		throw new RuntimeException("login failed.");
	}

	public User getUser(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User register(String email, String password, String name) {
		users.forEach((user) -> {
			if (user.getEmail().equalsIgnoreCase(email)) {
				throw new RuntimeException("email exist.");
			}
		});
		User user = new User(users.size() + 1, email, password, name);
		users.add(user);
		mailService.sendRegistrationMail(user);
		return user;
	}
}
