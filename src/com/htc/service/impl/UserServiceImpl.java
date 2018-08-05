package com.htc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.htc.model.UserTb;
import com.htc.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseService implements UserService{

	@Override
	public UserTb login(UserTb userTb) {
		UserTb userLogin = new UserTb();
		userLogin.setUserId(userTb.getUserId());
		userLogin.setLoginPwd(userTb.getLoginPwd());
		return userTbMapper.login(userLogin);
	}

	@Override
	public UserTb addInfo(UserTb userTb) {
		if(userTbMapper.insert(userTb) > 0){
			return userTb;
		}else{
			return null;
		}
	}

	@Override
	public List<UserTb> getAll() {
		return userTbMapper.getAll();
	}

	@Override
	public String delete(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTb findByUserId(String userId) {
		return userTbMapper.selectByUserId(userId);
	}

	@Override
	public String update(UserTb userTb) {
		return userTbMapper.updateByPrimaryKeySelective(userTb) > 0 ? sucMsg : failMsg;
	}
	@Override
	public UserTb findById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
