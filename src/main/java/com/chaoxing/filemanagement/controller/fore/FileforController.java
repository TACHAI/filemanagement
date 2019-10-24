package com.chaoxing.filemanagement.controller.fore;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.service.FileService;
import com.chaoxing.filemanagement.vo.FileVO;
import com.chaoxing.filemanagement.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create by tachai on 2019-10-23 13:44
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController("foreFileController")
@RequestMapping("/fore/file/")
@Api(value = "前台文件查询")
public class FileforController {

    @Autowired
    private FileService fileService;

    @GetMapping("selectList")
    public PageVO selectList(String id,@RequestParam(value = "pageSize",defaultValue = "25")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){
        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<FileVO> list =  fileService.selectByDeptId(Integer.parseInt(id.toString())).getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }

    @PostMapping("addFile")
    public ServerResponse<String> addFile(Fileaddress fileaddress){
        return fileService.addFile(fileaddress);
    }
}
