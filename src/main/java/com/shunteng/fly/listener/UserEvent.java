package com.shunteng.fly.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;

public class UserEvent extends ApplicationContextEvent{
	
	public UserEvent(ApplicationContext source) {
		super(source);
	}

	public UserEvent(ApplicationContext source, String name, String sex) {
		super(source);
		this.name = name;
		this.sex = sex;
	}

	private String name;
	
	private String sex;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7003185166925058031L;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
