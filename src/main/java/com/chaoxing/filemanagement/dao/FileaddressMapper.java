package com.chaoxing.filemanagement.dao;

import com.chaoxing.filemanagement.po.Fileaddress;

public interface FileaddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fileaddress record);

    int insertSelective(Fileaddress record);

    Fileaddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fileaddress record);

    int updateByPrimaryKey(Fileaddress record);
}