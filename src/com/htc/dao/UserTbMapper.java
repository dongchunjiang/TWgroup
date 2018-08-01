package com.htc.dao;

import java.util.List;

import com.htc.model.UserTb;

public interface UserTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTb record);

    int insertSelective(UserTb record);

    List<UserTb> login(UserTb userLogin);
    
    UserTb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}