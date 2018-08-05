package com.htc.service;

import java.util.List;

import com.htc.model.UserTb;

public interface UserService {
	public UserTb login(UserTb userTb);
	
	public UserTb addInfo(UserTb userTb);
	
	public List<UserTb> getAll();
	
	public String delete(String userId);
	
	public UserTb findById(String userId);
	
	public UserTb findByUserId(String userId);
	
	public String update(UserTb userTb);
}
