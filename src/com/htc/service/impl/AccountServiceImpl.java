package com.htc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.model.AccountTb;
import com.htc.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseService implements AccountService{
	
	@Override
	public AccountTb add(AccountTb accountTb) {
		if(accountTbMapper.insert(accountTb) > 0){
			return accountTb;
		}else{
			return null;
		}
	}
	@Override
	public String update(AccountTb accountTb) {
		if(accountTbMapper.updateByPrimaryKeySelective(accountTb) > 0){
			return sucMsg;
		}else{
			return failMsg;
		}
	}
	@Override
	public String delete(int id) {
		if(accountTbMapper.deleteByPrimaryKey(id) > 0){
			return sucMsg;
		}else{
			return failMsg;
		}
	}
	@Override
	public List<AccountTb> getListByUserId(String userId) {
		return accountTbMapper.selectByUserId(userId);
	}
	@Override
	public AccountTb getByAccountId(String accountId) {
		return accountTbMapper.selectByAccountId(accountId);
	}
	@Override
	public List<AccountTb> getAll() {
		return accountTbMapper.getAll();
	}
}