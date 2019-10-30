package com.chaoxing.filemanagement.dao;

import com.chaoxing.filemanagement.po.ForeUser;
import com.chaoxing.filemanagement.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ForeUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ForeUser record);

    int insertSelective(ForeUser record);

    ForeUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ForeUser record);

    int updateByPrimaryKey(ForeUser record);

    int selectByEmail(@Param("email")String email);


    ForeUser login(@Param("email")String email, @Param("password") String password);

    List<ForeUser> selectByDeptId (@Param("deptId")Integer deptId);

    List<ForeUser> listUser();

}