package com.htc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htc.model.UserTb;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@RequestMapping("/login/{userId}/{loginPwd}")
	@ResponseBody
	public UserTb login(@PathVariable("userId") String userId,
			@PathVariable("loginPwd") String loginPwd,
			HttpSession session){
		UserTb user = new UserTb();
		user.setUserId(userId);
		user.setLoginPwd(loginPwd);
		session.setAttribute("user", user);
		return userService.login(user);
	}
	
	@RequestMapping("/regist/{userName}/{idType}/{userId}/"
			+ "{addr}/{phone}/{rank}/{loginPwd}/{payPwd}")
	@ResponseBody
	public UserTb regist(@PathVariable("userName") String userName,
			@PathVariable("idType") String idType,
			@PathVariable("userId") String userId,
			@PathVariable("addr") String addr,
			@PathVariable("phone") String phone,
			@PathVariable("rank") String rank,
			@PathVariable("loginPwd") String loginPwd,
			@PathVariable("payPwd") String payPwd,
			HttpSession session){
		UserTb user = new UserTb();
		user.setUserName(userName);
		user.setIdType(idType);
		user.setUserId(userId);
		user.setAddr(addr);
		user.setPhone(phone);
		user.setRank(rank);
		user.setLoginPwd(loginPwd);
		user.setPayPwd(payPwd);
		session.setAttribute("user",user);
		return userService.addInfo(user);
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public List<UserTb> getUserList(HttpSession session){
		if(getLoginUser(session) != null){
			return userService.getAll();
		}else{
			return null;
		}
	}
	
	@RequestMapping("/update/{userName}/{idType}/{userId}/"
			+ "{addr}/{phone}/{rank}/{loginPwd}/{payPwd}")
	@ResponseBody
	public String update(@PathVariable("userName") String userName,
			@PathVariable("idType") String idType,
			@PathVariable("userId") String userId,
			@PathVariable("addr") String addr,
			@PathVariable("phone") String phone,
			@PathVariable("rank") String rank,
			@PathVariable("loginPwd") String loginPwd,
			@PathVariable("payPwd") String payPwd,
			HttpSession session){
		UserTb user = new UserTb();
		user.setUserName(userName);
		user.setIdType(idType);
		user.setUserId(userId);
		user.setAddr(addr);
		user.setPhone(phone);
		user.setRank(rank);
		user.setLoginPwd(loginPwd);
		user.setPayPwd(payPwd);
		String res = userService.update(user);
		if(res.equals("SUCCESS")){
			session.setAttribute("user",user);//更新session用户信息
		}
		return res;
	}
	
	@RequestMapping("getByUserId/{userId}")
	@ResponseBody
	public UserTb getByUserId(@PathVariable("userId") String userId,
			HttpSession session){
		if(getLoginUser(session) != null){
			return userService.findByUserId(userId);
		}else{
			return null;
		}
	}
	/**
	 * 获取已经登录的用户的用户信息
	 * @param session
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public UserTb getUser(HttpSession session){
		if(getLoginUser(session) != null){
			return getLoginUser(session);
		}else{
			return null;
		}
	}
}
