package com.chaoxing.filemanagement.dao;

import com.chaoxing.filemanagement.po.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    List<Dept> selectList(Integer id);
}