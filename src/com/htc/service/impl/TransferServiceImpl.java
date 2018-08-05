package com.htc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.model.AccountTb;
import com.htc.model.TransferTb;
import com.htc.service.TransferService;

@Service("transferSercive")
public class TransferServiceImpl extends BaseService implements TransferService{
	
	@Override
	public List<TransferTb> findByAUserId(String aUserId, String transferFlag) {
		return transferTbMapper.selectByAUserId(aUserId, transferFlag);
	}
	@Override
	public List<TransferTb> findByOUserId(String oUserId, String transferFlag) {
		return transferTbMapper.selectByOUserId(oUserId, transferFlag);
	}
	@Override
	public String update(TransferTb transferTb) {
		if(transferTbMapper.updateByPrimaryKeySelective(transferTb) > 0){
			return sucMsg;
		}else{
			return failMsg;
		}
	}
	@Override
	public TransferTb findById(Integer id) {
		return transferTbMapper.selectByPrimaryKey(id);
	}
	@Override
	public String trans(TransferTb transferTb) {
		String oUserId = transferTb.getoUserId(); 
		String aUserId = transferTb.getaUserId(); 
		Double balance = transferTb.getBalance();
		AccountTb accountO = accountTbMapper.selectByAccountId(oUserId);
		Double limit = accountO.getLimitBalance();
		accountO.setAccountBalance(accountO.getAccountBalance()-balance);
		if(limit >= balance){
			AccountTb accountA = accountTbMapper.selectByAccountId(aUserId);
			accountA.setAccountBalance(accountA.getAccountBalance()+balance);
			if(accountTbMapper.updateByPrimaryKeySelective(accountO) > 0 && 
					accountTbMapper.updateByPrimaryKeySelective(accountA) > 0){
				return sucMsg;
			}else{
				return failMsg;
			}
		}else{
			transferTb.setTransferFlag(transferFlagUnRe);//未收取状态
			if(accountTbMapper.updateByPrimaryKeySelective(accountO) > 0 && 
					transferTbMapper.insert(transferTb) > 0){
				return sucMsg;
			}else{
				return failMsg;
			}
		}
	}
	
	
}
