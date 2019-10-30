package com.chaoxing.filemanagement.controller.back;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.dao.UserMapper;
import com.chaoxing.filemanagement.po.Dept;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.po.User;
import com.chaoxing.filemanagement.service.DeptService;
import com.chaoxing.filemanagement.util.JWTUtil;
import com.chaoxing.filemanagement.vo.DeptVO;
import com.chaoxing.filemanagement.vo.FileVO;
import com.chaoxing.filemanagement.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Create by tachai on 2019-10-23 21:56
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
@RequestMapping("/back/dept/")
@Api(value = "后台部门")
public class DeptController {

    @Autowired
    private DeptService  deptService;
    @Autowired
    private UserMapper userDao;

    @RequiresAuthentication
    @PostMapping("addDept")
    public ServerResponse<String> addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequiresAuthentication
    @GetMapping("selectDeptByUser")
    public ServerResponse<DeptVO> select(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        int id = JWTUtil.getUserId(token);

        User user= userDao.selectByPrimaryKey(id);
        return deptService.slecetDeptVOByDeptId(user.getDeptId());
    }

    @RequiresAuthentication
    @GetMapping("selectDeptDeptId")
    public ServerResponse<List<Dept>> select(Integer deptId){

      return deptService.listDept(deptId);
    }

}
