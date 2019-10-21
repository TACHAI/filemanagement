package com.chaoxing.filemanagement;

import com.github.pagehelper.PageHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@SpringBootApplication
public class FilemanagementApplication extends SpringBootServletInitializer {

    //配置mybatis 分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");// 配置mysql 方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    public static void main(String[] args) {
        SpringApplication.run(FilemanagementApplication.class, args);
    }


    //打成war包使用
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        // 此处Application.class 替换为springboot默认启动类
        return builder.sources(FilemanagementApplication.class);
    }

}
