package com.chaoxing.filemanagement.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @ClassName PropertiesUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-26
 */
@Slf4j
public class PropertiesUtil {
    private static Properties props;

    static {
        String fileName="arm.properties";
        props = new Properties();
        InputStreamReader inputStreamReader=null;
        try {
            inputStreamReader = new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),"utf-8");
            props.load(inputStreamReader);
        }catch (IOException e){
            log.error("PropertiesUtil:{}",e.getMessage());
        }finally {
            if(inputStreamReader!=null){
                try{
                    inputStreamReader.close();
                }catch (IOException e){
                    log.error("PropertiesUtil:{}",e.getMessage());
                }
            }
        }
    }

    public static String getProperty(String key){
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultValue){
        String value = props.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return defaultValue;
        }
        return value.trim();
    }
}
