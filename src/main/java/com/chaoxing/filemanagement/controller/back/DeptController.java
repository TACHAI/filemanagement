package com.chaoxing.filemanagement.controller.back;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Dept;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.service.DeptService;
import com.chaoxing.filemanagement.vo.FileVO;
import com.chaoxing.filemanagement.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by tachai on 2019-10-23 21:56
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
@RequestMapping("/back/dept/")
@Api(value = "后台文件查询")
public class DeptController {

    @Autowired
    private DeptService  deptService;

    @RequiresAuthentication
    @PostMapping("addDept")
    public ServerResponse<String> addDept(Dept dept){
        return deptService.addDept(dept);
    }

}
