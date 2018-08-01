package com.htc.dao;

import com.htc.model.AccountTb;

public interface AccountTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountTb record);

    int insertSelective(AccountTb record);

    AccountTb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountTb record);

    int updateByPrimaryKey(AccountTb record);
}