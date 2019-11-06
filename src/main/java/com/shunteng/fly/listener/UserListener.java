package com.shunteng.fly.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserListener implements ApplicationListener<UserEvent>{

	@Override
	public void onApplicationEvent(UserEvent event) {
		ApplicationContext app = event.getApplicationContext().getParent();
		if(app != null) {
			return;
		}
		// TODO Auto-generated method stub
		System.out.println(event.getName() + "---" + event.getSex() + "---" + event.getTimestamp());
	}


}
