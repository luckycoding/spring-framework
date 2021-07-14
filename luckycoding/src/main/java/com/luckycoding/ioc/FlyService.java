package com.luckycoding.ioc;

import com.luckycoding.ioc.aop.MetricTime;
import org.springframework.stereotype.Component;

@Component
public class FlyService {
	@MetricTime("fly")
	public void fly() {
		System.out.println("duck flying...");
	}
}
