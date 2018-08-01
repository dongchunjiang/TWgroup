package com.htc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htc.model.UserTb;
import com.htc.service.UserService;

@Controller
@RequestMapping("/user")
public class UserContriller {
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	@RequestMapping("/login/{userId}/{loginPwd}")
	@ResponseBody
	public List<UserTb> login(@PathVariable("userId") String userId,
			@PathVariable("loginPwd") String loginPwd){
		UserTb user = new UserTb();
		user.setUserId(userId);
		user.setLoginPwd(loginPwd);
		return userService.login(user);
	}
}
