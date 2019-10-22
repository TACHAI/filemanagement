package com.chaoxing.filemanagement.controller.back;

import com.chaoxing.filemanagement.po.Fileaddress;
import com.chaoxing.filemanagement.service.FileService;
import com.chaoxing.filemanagement.vo.PageVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create by tachai on 2019-10-22 14:14
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
@RequestMapping("/file/")
@Api(value = "文件模块")
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("selectList")
    public PageVO selectList(@RequestParam(value = "pageSize",defaultValue = "25")int pageSize, @RequestParam(value = "pageNumber",defaultValue = "1")int pageNumber){
        Page page = PageHelper.startPage(pageNumber,pageSize);
        List<Fileaddress> list =  fileService.selectList().getData();
        if(list !=null){
            Long total = page.getTotal();
            PageVO p =new PageVO();
            p.setTotal(total);
            p.setRows(list);
            return p;
        }
        return null;
    }


}
