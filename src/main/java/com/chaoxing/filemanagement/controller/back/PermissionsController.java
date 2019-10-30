package com.chaoxing.filemanagement.controller.back;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Permissions;
import com.chaoxing.filemanagement.service.PermissionService;
import com.chaoxing.filemanagement.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by tachai on 2019-10-25 11:42
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
@RequestMapping("/back/permission/")
@Api(value = "后台权限查询")
public class PermissionsController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("selectList")
    public PageVO selectList(int deptId,@RequestParam(value = "pageSize",defaultValue = "25")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){
        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<Permissions> list =  permissionService.selectListByDeptId(deptId).getData();
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
    @RequiresPermissions({"add"})
    @PostMapping("addPermission")
    public ServerResponse<String> addFile(Permissions permissions){
        return permissionService.addPermission(permissions);
    }

    @RequiresPermissions({"delete"})
    @PostMapping("deletePermission")
    public ServerResponse<String> deleteFile(Integer id){
        return permissionService.deleteById(id);
    }


}
