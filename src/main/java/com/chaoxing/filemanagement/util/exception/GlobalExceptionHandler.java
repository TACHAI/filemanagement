package com.chaoxing.filemanagement.util.exception;

import com.fasterxml.jackson.databind.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Create by tachai on 2019-10-31 09:54
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
// 定义统一异常处理类  方式一 使用@ControllerAdvice+@ExceptionHandler 注解
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e){
        log.error("ExceptionHandler ====>"+ e.getMessage());
        e.printStackTrace();
        // 这里可根据不同异常引起的类做不通处理方式
        String exceptionName = ClassUtil.getPackageName(e.getClass());
        log.error("ExceptionHandler ====>"+exceptionName);
        ModelAndView mav = new ModelAndView();
        mav.addObject("stackTrace",e.getStackTrace());
        mav.addObject("errorMessage",e.getMessage());
        mav.addObject("url",req.getRequestURL());
        mav.setViewName("forward:/error/500");
        return mav;
    }
}
