package com.htc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.dao.UserTbMapper;
import com.htc.model.UserTb;
import com.htc.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	private UserTbMapper userTbMapper;
	
	public UserTbMapper getAddUserTbMapper(){
		return userTbMapper;
	}
	@Autowired
	public void setUserTbMapper(UserTbMapper userTbMapper) {
		this.userTbMapper = userTbMapper;
	}
	@Override
	public List<UserTb> login(UserTb userTb) {
		UserTb userLogin = new UserTb();
		userLogin.setUserId(userTb.getUserId());
		userLogin.setLoginPwd(userTb.getLoginPwd());
		List<UserTb> list = userTbMapper.login(userLogin);
		if(list.size()>0){
			return list;
		}else{
			return null;
		}
	}

	@Override
	public String addInfo(UserTb userTb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserTb> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTb findById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(UserTb userTb) {
		// TODO Auto-generated method stub
		return null;
	}

}
