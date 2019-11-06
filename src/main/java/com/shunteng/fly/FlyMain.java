package com.shunteng.fly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shunteng"})
public class FlyMain {

	public static void main(String[] args) throws Exception{
		SpringApplication.run(FlyMain.class, args);
//		SpringApplication app = new SpringApplication(FlyMain.class);
//		app.addListeners(new UserListener());
////		app.setBannerMode(Banner.Mode.OFF);
//		app.run(args);
	}
}
