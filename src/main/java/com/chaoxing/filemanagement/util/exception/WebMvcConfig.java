package com.chaoxing.filemanagement.util.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Create by tachai on 2019-10-31 10:10
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
// 视图控制器配置
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    // 统一异常处理
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("/index");// 设置默认跳转视图为/ index
        registry.addViewController("/error/500").setViewName("/error/500");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
}
