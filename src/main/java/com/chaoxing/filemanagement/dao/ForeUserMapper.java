package com.chaoxing.filemanagement.dao;

import com.chaoxing.filemanagement.po.ForeUser;

public interface ForeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ForeUser record);

    int insertSelective(ForeUser record);

    ForeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ForeUser record);

    int updateByPrimaryKey(ForeUser record);
}