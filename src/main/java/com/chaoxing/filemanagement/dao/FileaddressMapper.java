package com.chaoxing.filemanagement.dao;

import com.chaoxing.filemanagement.po.Fileaddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FileaddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Fileaddress record);

    int insertSelective(Fileaddress record);

    Fileaddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Fileaddress record);

    int updateByPrimaryKey(Fileaddress record);

    List<Fileaddress> selectByDeptId(Integer id);

    List<Fileaddress> selectList();
}