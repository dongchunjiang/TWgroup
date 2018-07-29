package com.htc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htc.dao.UserMapper;
import com.htc.model.User;
import com.htc.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	private UserMapper userMapper;

	public UserMapper getAddMapper() {
		return userMapper;
	}
	@Autowired
	public void setAddMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}


    @Override
    public String login(User user) {
        User condition = new User();
        condition.setLoginName(user.getLoginName());
        condition.setLoginPassword(user.getLoginPassword());
        List<User> list = userMapper.login(condition);
        if(list.size() > 0){
            return "success";
        }else{
            return "error";
        }
    }
    
	@Override
	public String addInfo(User user) {
		if (userMapper.insertSelective(user) == 1) {
			return "添加成功";
		}else{
			return "添加失败";
		}
	}
	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}
	@Override
	public String delete(String id) {
		int result = userMapper.deleteByPrimaryKey(id);
		System.out.println("no:"+result);
		if (result == 1) {
			return "删除成功";
		}else{
			return "删除失败";
		}
	}
	@Override
	public User findById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}
	@Override    
	public String update(User user) {
		if (userMapper.updateByPrimaryKeySelective(user) == 1) {
			return "更新成功";
		}else{
			return "更新失败";
		}
	}

}
