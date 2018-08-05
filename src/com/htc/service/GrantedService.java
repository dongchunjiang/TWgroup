package com.htc.service;

import java.util.List;

import com.htc.model.GrantedTb;

public interface GrantedService {
	public GrantedTb add(GrantedTb grantedTb);
	public String update(GrantedTb grantedTb);
	public String delete(int id);
	public List<GrantedTb> getByOUserId(String oUserId);
	public GrantedTb getById(int id);
}
