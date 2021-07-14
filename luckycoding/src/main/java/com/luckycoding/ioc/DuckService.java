package com.luckycoding.ioc;

import com.luckycoding.ioc.aop.MetricTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuckService {
	@Autowired
	FlyService dfs;

	@MetricTime("doSomething")
	public void doSomething(Duck duck) {
		dfs.fly();
	}
}
