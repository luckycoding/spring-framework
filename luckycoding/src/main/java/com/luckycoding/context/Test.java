package com.luckycoding.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(UserDao.class);
		context.refresh();

		UserDao userDao = (UserDao) context.getBean("userDao");
		userDao.query();
	}
}
