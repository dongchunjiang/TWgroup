package com.htc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.htc.model.UserTb;
import com.htc.service.AccountService;
import com.htc.service.GrantedService;
import com.htc.service.TransferService;
import com.htc.service.UserService;

public class BaseController {
	protected AccountService accountService;
	protected GrantedService grantedService;
	protected TransferService transferService;
	protected UserService userService;

	public UserTb getLoginUser(HttpSession session){
		if(session.getAttribute("user") != null){
			return (UserTb)session.getAttribute("user");
		}else{
			return null;
		}
	}
	
	public UserService getUserService() {
		return userService;
	}
	@Autowired
	public void setUserService(UserService userService){
		this.userService = userService;
	}
	public TransferService getTransferService() {
		return transferService;
	}
	@Autowired
	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}
	public GrantedService getGrantedService() {
		return grantedService;
	}
	@Autowired
	public void setGrantedService(GrantedService grantedService) {
		this.grantedService = grantedService;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	@Autowired
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
}
