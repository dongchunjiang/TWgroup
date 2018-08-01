package com.htc.dao;

import com.htc.model.TransferTb;

public interface TransferTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransferTb record);

    int insertSelective(TransferTb record);

    TransferTb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransferTb record);

    int updateByPrimaryKey(TransferTb record);
}