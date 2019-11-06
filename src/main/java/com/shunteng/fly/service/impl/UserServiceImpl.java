package com.shunteng.fly.service.impl;

import org.springframework.stereotype.Service;

import com.shunteng.fly.model.User;
import com.shunteng.fly.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(1l);
		user.setName("方正");
		user.setSex("男");
		return user;
	}

	
}
