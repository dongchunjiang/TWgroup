package com.htc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.htc.dao.AccountTbMapper;
import com.htc.dao.GrantedTbMapper;
import com.htc.dao.TransferTbMapper;
import com.htc.dao.UserTbMapper;

public class BaseService {
	protected AccountTbMapper accountTbMapper;
	protected GrantedTbMapper grantedTbMapper;
	protected TransferTbMapper transferTbMapper;
	protected UserTbMapper userTbMapper;
	//返回信息状态
	protected final String sucMsg = "SUCCESS";
	protected final String failMsg = "ERROR";
	//转账状态
	protected final String transferFlagUnRe = "unreceive";
	protected final String transferFlagRe = "received";
	
	public UserTbMapper getUserTbMapper(){
		return userTbMapper;
	}
	@Autowired
	public void setUserTbMapper(UserTbMapper userTbMapper) {
		this.userTbMapper = userTbMapper;
	}
	public TransferTbMapper getTransferTbMapper() {
		return transferTbMapper;
	}
	@Autowired
	public void setTransferTbMapper(TransferTbMapper transferTbMapper) {
		this.transferTbMapper = transferTbMapper;
	}
	public GrantedTbMapper getGrantedTbMapper() {
		return grantedTbMapper;
	}
	@Autowired
	public void setGrantedTbMapper(GrantedTbMapper grantedTbMapper) {
		this.grantedTbMapper = grantedTbMapper;
	}
	public AccountTbMapper getAccountTbMapper() {
		return accountTbMapper;
	}
	@Autowired
	public void setAccountTbMapper(AccountTbMapper accountTbMapper) {
		this.accountTbMapper = accountTbMapper;
	}
}
