package com.htc.service;

import java.util.List;
import com.htc.model.User;

public interface BaseService {
    
    String login(User user);
	
	String addInfo(User user);
	
	List<User> getAll();
	
	String delete(String id);
	
	User findById(String id);
	
	String update(User user);

}
