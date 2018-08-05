package com.htc.dao;

import java.util.List;

import com.htc.model.UserTb;

public interface UserTbMapper {
	/**
	 * 根据id删除
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
    /**
     * 插入
     * @param record
     * @return
     */
    int insert(UserTb record);

    int insertSelective(UserTb record);

    UserTb login(UserTb userLogin);
    /**
     * 获取用户列表
     * @return
     */
    List<UserTb> getAll();
    /**
     * 根据id查找
     * @param id
     * @return
     */
    UserTb selectByPrimaryKey(Integer id);
    /**
     * 根据身份证号查找
     * @param userId
     * @return
     */
    UserTb selectByUserId(String userId);

    int updateByPrimaryKeySelective(UserTb record);

    int updateByPrimaryKey(UserTb record);
}