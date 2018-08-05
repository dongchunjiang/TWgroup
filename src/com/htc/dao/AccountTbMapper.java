package com.htc.dao;

import java.util.List;

import com.htc.model.AccountTb;

public interface AccountTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountTb record);

    int insertSelective(AccountTb record);

    AccountTb selectByPrimaryKey(Integer id);
    
    List<AccountTb> selectByUserId(String userId);
    
    List<AccountTb> getAll();
    
    AccountTb selectByAccountId(String accountId);

    int updateByPrimaryKeySelective(AccountTb record);

    int updateByPrimaryKey(AccountTb record);
}