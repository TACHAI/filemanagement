package com.chaoxing.filemanagement.controller.back;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.service.FileService;
import com.chaoxing.filemanagement.vo.FileVO;
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
 * Create by tachai on 2019-10-22 14:14
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController("backFileController")
@RequestMapping("/back/file/")
@Api(value = "后台文件查询")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("selectList")
    public PageVO selectList(@RequestParam(value = "pageSize",defaultValue = "25")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){
        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<FileVO> list =  fileService.selectList().getData();
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
    @RequiresPermissions({"file:addFile"})
    @PostMapping("addFile")
    public ServerResponse<String> addFile(Fileaddress fileaddress){
        return fileService.addFile(fileaddress);
    }

    @RequiresPermissions({"file:deleteFile"})
    @PostMapping("deleteFile")
    public ServerResponse<String> deleteFile(Integer id){
        return fileService.deleteById(id);
    }


    @PostMapping("updateFile")
    public ServerResponse<String> updatefile(Fileaddress fileaddress){
        return fileService.updateFile(fileaddress);
    }
}
