package com.chaoxing.filemanagement.controller;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.User;
import com.chaoxing.filemanagement.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by tachai on 2019-10-22 13:45
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
@RequestMapping("/login/")
@Api(value = "用户模块")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ServerResponse<User> login(String email, String password){
        return userService.login(email,password);
    }

    @PostMapping("addUser")
    public ServerResponse<String> addUser(User user){
        return userService.addUser(user);
    }

    @PostMapping("deleteUserById")
    public ServerResponse<String> deleteUser(Integer id){
        return userService.deleteById(id);
    }

    @PostMapping("updateUser")
    public ServerResponse<String> update(User user){
        return userService.updateUser(user);
    }
    // todo 用户的数量
    @GetMapping
    public ServerResponse<List<User>> list(){
        return null;
    }
}
