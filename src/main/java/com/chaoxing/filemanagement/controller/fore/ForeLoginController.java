package com.chaoxing.filemanagement.controller.fore;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.ForeUser;
import com.chaoxing.filemanagement.po.User;
import com.chaoxing.filemanagement.service.ForeUserService;
import com.chaoxing.filemanagement.service.UserService;
import com.chaoxing.filemanagement.vo.FileVO;
import com.chaoxing.filemanagement.vo.PageVO;
import com.chaoxing.filemanagement.vo.UserVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create by tachai on 2019-10-30 16:32
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
@RequestMapping("/foreuser/")
@Api(value = "前端用户模块")
public class ForeLoginController {

    @Autowired
    private ForeUserService userService;


    @GetMapping("selectList")
    public PageVO selectList(String id, @RequestParam(value = "pageSize",defaultValue = "25")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){
        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<UserVO> list =  userService.listUser().getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }


    @RequiresAuthentication
    @PostMapping("checkToken")
    public ServerResponse<String> checkToken(){
        return ServerResponse.createBySuccess();
    }



    @PostMapping("login")
    public ServerResponse<UserVO> login(String email, String password){
        return userService.login(email,password);
    }

    @RequiresAuthentication
    @PostMapping("addUser")
    public ServerResponse<String> addUser(ForeUser user){
        return userService.addUser(user);
    }

    @RequiresAuthentication
    @PostMapping("deleteUserById")
    public ServerResponse<String> deleteUser(Integer id){
        return userService.deleteById(id);
    }

    @RequiresAuthentication
    @PostMapping("updateUser")
    public ServerResponse<String> update(ForeUser user){
        return userService.updateUser(user);
    }
    // todo 用户的数量
    @GetMapping
    public ServerResponse<List<ForeUser>> list(){
        return null;
    }

    @RequiresAuthentication
    @GetMapping("exit")
    public ServerResponse<String> exit(HttpServletRequest request){
        /*String token = request.getHeader("Authorization");
        if(token!=null){
            String userName = JWTUtil.getUsername(token);
        }*/
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ServerResponse.createBySuccessMessage("退出成功");
    }
}
