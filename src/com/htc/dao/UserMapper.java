package com.htc.dao;

import java.util.List;

import com.htc.model.User;

public interface UserMapper {
    
    List<User> login(User user);
    
    int deleteByPrimaryKey(String id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
    
    List<User> getAll();
}