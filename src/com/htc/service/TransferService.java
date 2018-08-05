package com.htc.service;

import java.util.List;

import com.htc.model.TransferTb;

public interface TransferService {
	/**
	 * 转账记录
	 * @param transferTb
	 * @return
	 */
	String trans(TransferTb transferTb);
	
	String update(TransferTb transferTb);
	TransferTb findById(Integer id);
	List<TransferTb> findByAUserId(String aUserId, String transferFlag);
	List<TransferTb> findByOUserId(String oUserId, String transferFlag);
}
