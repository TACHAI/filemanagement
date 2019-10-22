package com.chaoxing.filemanagement.controller;

import com.chaoxing.filemanagement.common.ServerResponse;
import com.chaoxing.filemanagement.common.cons.FileType;
import com.chaoxing.filemanagement.util.FileUtil;
import io.swagger.annotations.Api;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName UploadController
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-11 10:46
 **/
@RestController
@RequestMapping("/back/upload/")
@Api(value = "UploadController|上传模块")
public class UploadController {

    @PostMapping(value = "uploadImage", produces = { "application/json;charset=UTF-8" })
    public ServerResponse<String> uploadImage(@RequestParam("file") MultipartFile file, String name) throws IOException {
        System.out.println(name);
        return FileUtil.uploadFile(file, FileType.Image,"");
    }

    @PostMapping(value = "uploadImageByFormDate")
    public ServerResponse<Map> uploadImageByFormDate(HttpServletRequest request, HttpRequest request1)throws IOException{
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
        Iterator iter = multipartHttpServletRequest.getFileNames();
        Map map = new HashMap<String,String>();
        while (iter.hasNext()){
            MultipartFile multipartFile = multipartHttpServletRequest.getFile(iter.next().toString());
            String imgUrl = FileUtil.uploadFile(multipartFile,FileType.Image,"").getData();
            map.put(iter.next().toString(),imgUrl);
        }
        return ServerResponse.createBySuccess(map);
    }
    @PostMapping(value = "uploadBook", produces = { "application/json;charset=UTF-8" })
    public ServerResponse<String> uploadBook(@RequestParam("file") MultipartFile file) throws IOException {
        return FileUtil.uploadFile(file, FileType.Book,"");
    }

    @PostMapping(value = "uploadVideo", produces = { "application/json;charset=UTF-8" })
    public ServerResponse<String> uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        return FileUtil.uploadFile(file, FileType.Video,"");
    }

    @PostMapping(value = "uploadFile", produces = { "application/json;charset=UTF-8" })
    public ServerResponse<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        return FileUtil.uploadFile(file, FileType.File,"");
    }

    // fastdfs 上传文件
   /* @PostMapping(value = "fastDFSUploadFile",produces = { "application/json;charset=UTF-8" })
    public String fastDFSUploadFile(@RequestParam("file") MultipartFile file)throws IOException{
        return FastDFSClient.uploadFile(file);
    }*/
}
