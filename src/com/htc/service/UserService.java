package com.htc.service;

import java.util.List;

import com.htc.model.UserTb;

public interface UserService {
	public List<UserTb> login(UserTb userTb);
	
	public String addInfo(UserTb userTb);
	
	public List<UserTb> getAll();
	
	public String delete(String userId);
	
	public UserTb findById(String userId);
	
	public String update(UserTb userTb);
}
