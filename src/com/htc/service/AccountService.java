package com.htc.service;

import java.util.List;

import com.htc.model.AccountTb;

public interface AccountService {
	public AccountTb add(AccountTb accountTb);
	public String update(AccountTb accountTb);
	public String delete(int id);
	public List<AccountTb> getListByUserId(String userId);
	public AccountTb getByAccountId(String accountId);
	public List<AccountTb> getAll();
}
