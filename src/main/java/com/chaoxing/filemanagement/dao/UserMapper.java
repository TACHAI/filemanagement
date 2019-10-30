package com.chaoxing.filemanagement.dao;

import com.chaoxing.filemanagement.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectByEmail(@Param("email")String email);

    User login(@Param("email")String email,@Param("password") String password);

    List<User> selectByDeptId (@Param("deptId")Integer deptId);

    // 查询所有的用户
    List<User> listUser();

}