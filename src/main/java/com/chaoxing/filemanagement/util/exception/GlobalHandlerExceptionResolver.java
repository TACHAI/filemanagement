package com.chaoxing.filemanagement.util.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by tachai on 2019-10-31 10:15
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
// 统一异常处理方式二  实现HandlerExceptionResolver的resolveException 方法
@Component
public class GlobalHandlerExceptionResolver implements HandlerExceptionResolver {
    private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        Exception e = new Exception();
        //处理 UndeclaredThrowableException
        if (ex instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
        } else {
            e = ex;
        }
        e.printStackTrace();
        //这里可以根据不同异常引起的类做不同处理方式
        String exceptionName = ClassUtils.getShortName(e.getClass());
        if(exceptionName.equals("ArrayIndexOutOfBoundsException")) {
            log.error("GlobalHandlerExceptionResolver resolveException ===>" + exceptionName);
            ModelAndView mav = new ModelAndView();
            mav.addObject("stackTrace", e.getStackTrace());
            mav.addObject("exceptionName", exceptionName);
            mav.addObject("errorMessage", e.getMessage());
            mav.addObject("url", request.getRequestURL());
            mav.setViewName("forward:/error/500");
            return mav;
        }
        return null;

    }
}
