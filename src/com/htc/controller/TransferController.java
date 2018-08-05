package com.htc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htc.model.TransferTb;

@Controller
@RequestMapping("/transfer")
public class TransferController extends BaseController{
	
	@RequestMapping("/trans/{oUserId}/{aUserId}/{balance}")
	@ResponseBody
	public String add(@PathVariable("oUserId") String oUserId,
			@PathVariable("aUserId") String aUserId,
			@PathVariable("balance") Double balance){
		TransferTb transfer = new TransferTb();
		transfer.setaUserId(aUserId);
		transfer.setoUserId(oUserId);
		transfer.setBalance(balance);
		return transferService.trans(transfer);
	}
	
	@RequestMapping("/findo/{oUserId}/{transferFlag}")
	@ResponseBody
	public List<TransferTb> findo(@PathVariable("oUserId") String oUserId,
			@PathVariable("transferFlag") String transferFlag){
		return transferService.findByOUserId(oUserId, transferFlag);
	}
	@RequestMapping("/finda/{aUserId}/{transferFlag}")
	@ResponseBody
	public List<TransferTb> finda(@PathVariable("aUserId") String aUserId,
			@PathVariable("transferFlag") String transferFlag){
		return transferService.findByAUserId(aUserId, transferFlag);
	}
	@RequestMapping("/update/{id}/{transferFlag}")
	@ResponseBody
	public String update(@PathVariable("id") Integer id,
			@PathVariable("transferFlag") String transferFlag){
		TransferTb transfer = transferService.findById(id);
		transfer.setTransferFlag(transferFlag);
		return transferService.update(transfer);
	}
}
