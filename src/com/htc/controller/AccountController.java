package com.htc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htc.model.AccountTb;

@Controller
@RequestMapping("/account")
public class AccountController extends BaseController{
	@RequestMapping("/getList")
	@ResponseBody
	public List<AccountTb> getList(HttpSession session){
		return accountService.getAll();
	}
	@RequestMapping("/getByUserId/{userId}")
	@ResponseBody
	public List<AccountTb> getByUserId(@PathVariable("userId") String userId,
			HttpSession session){
		return accountService.getListByUserId(userId);
	}
	@RequestMapping("/getById/{accountId}")
	@ResponseBody
	public AccountTb getById(@PathVariable("accountId") String accountId,
			HttpSession session){
		return accountService.getByAccountId(accountId);
	}
	@RequestMapping("/add/{accountId}/{accountType}/{accountPwd}/"
			+ "{accountBalance}/{limitBalance}/{userId}/{others}")
	@ResponseBody
	public AccountTb addAccount(HttpSession session,
			@PathVariable("accountId") String accountId,
			@PathVariable("accountType") String accountType,
			@PathVariable("accountPwd") String accountPwd,
			@PathVariable("accountBalance") Double accountBalance,
			@PathVariable("limitBalance") Double limitBalance,
			@PathVariable("userId") String userId,
			@PathVariable("others") String others){
		AccountTb account = new AccountTb();
		account.setAccountBalance(accountBalance);
		account.setAccountId(accountId);
		account.setAccountPwd(accountPwd);
		account.setAccountType(accountType);
		account.setLimitBalance(limitBalance);
		account.setOthers(others);
		account.setUserId(userId);
		return accountService.add(account);
	}
	@RequestMapping("/update/{accountId}/{accountBalance}/{accountPwd}"
			+ "/{limitBalance}/{others}")
	@ResponseBody
	public String update(HttpSession session,
			@PathVariable("accountId") String accountId,
			@PathVariable("accountPwd") String accountPwd,
			@PathVariable("accountBalance") Double accountBalance,
			@PathVariable("limitBalance") Double limitBalance,
			@PathVariable("others") String others){
		AccountTb account = accountService.getByAccountId(accountId);
		account.setAccountBalance(accountBalance);
		account.setAccountPwd(accountPwd);
		account.setLimitBalance(limitBalance);
		account.setOthers(others);
		return accountService.update(account);
	}
}
