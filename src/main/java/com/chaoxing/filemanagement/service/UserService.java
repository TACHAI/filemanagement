package com.chaoxing.filemanagement.service;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.User;
import com.chaoxing.filemanagement.vo.UserVO;

import java.util.List;

/**
 * Create by tachai on 2019-10-22 08:39
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface UserService {
    // 添加用户
    ServerResponse<String> addUser(User user);
    // 删除用户
    ServerResponse<String> deleteById(Integer  id);
    // 修改用户
    ServerResponse<String> updateUser(User user);
    // 查询用户
    ServerResponse<User> selectById(Integer id);
    // 登录
    ServerResponse<UserVO> login(String email, String password);
    // 组织查询
    ServerResponse<List<User>> listUserByDeptId(Integer deptId);
}
