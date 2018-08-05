package com.htc.model;

import java.util.Date;

public class TransferTb {
    private Integer id;

    private String oUserId;

    private String aUserId;

    private String transferFlag;

    private Date transferDate;

    private Double balance;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getoUserId() {
        return oUserId;
    }

    public void setoUserId(String oUserId) {
        this.oUserId = oUserId == null ? null : oUserId.trim();
    }

    public String getaUserId() {
        return aUserId;
    }

    public void setaUserId(String aUserId) {
        this.aUserId = aUserId == null ? null : aUserId.trim();
    }

    public String getTransferFlag() {
        return transferFlag;
    }

    public void setTransferFlag(String transferFlag) {
        this.transferFlag = transferFlag == null ? null : transferFlag.trim();
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}