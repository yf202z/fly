package com.shunteng.fly.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shunteng.fly.listener.UserEvent;
import com.shunteng.fly.model.User;
import com.shunteng.fly.service.UserService;

@RestController
public class WelcomeController {

	@Autowired
	private UserService userService;
	
	private Logger sysLog = LoggerFactory.getLogger("sysLog");
	
	@Value("${spring.application.name}")
	private String applicationName;
	
	@Value("${my.secret}")
	private String secret;
	
	@Value("${env}")
	private String env;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@RequestMapping("/")
	public String welcomePage() {
		User user = userService.findById(1l);
		UserEvent event = new UserEvent(applicationContext);
		event.setName(user.getName());
		event.setSex(user.getSex());
		applicationContext.publishEvent(event);
		sysLog.error("hello world, welcome to springboot");
		return "hello world, welcome to " + applicationName + ",login user[" + user.getName() + "]----" + secret;
	}
}
