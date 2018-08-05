package com.htc.dao;

import java.util.List;

import com.htc.model.TransferTb;

public interface TransferTbMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TransferTb record);

    int insertSelective(TransferTb record);

    TransferTb selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TransferTb record);

    int updateByPrimaryKey(TransferTb record);
    
    List<TransferTb> selectByOUserId(String oUserId, String transferFlag);
    List<TransferTb> selectByAUserId(String aUserId, String transferFlag);
}