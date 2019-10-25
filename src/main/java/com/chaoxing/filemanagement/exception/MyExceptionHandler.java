package com.chaoxing.filemanagement.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by tachai on 2019-10-25 14:16
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */

// 自定义异常处理

@ControllerAdvice
public class MyExceptionHandler {

    @ResponseBody
    @ExceptionHandler(RuntimeException.class)
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map =new HashMap<>();
        map.put("status",1);
        map.put("msg",e.getMessage());
        return map;
    }
}
