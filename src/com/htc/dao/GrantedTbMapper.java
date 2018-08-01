package com.htc.dao;

import com.htc.model.GrantedTb;

public interface GrantedTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GrantedTb record);

    int insertSelective(GrantedTb record);

    GrantedTb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GrantedTb record);

    int updateByPrimaryKey(GrantedTb record);
}