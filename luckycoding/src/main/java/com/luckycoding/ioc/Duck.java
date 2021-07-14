package com.luckycoding.ioc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Duck {
	@Value(value = "")
	private String name;

	@Value(value = "")
	private String type;


}

