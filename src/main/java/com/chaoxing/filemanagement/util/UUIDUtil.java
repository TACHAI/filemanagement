package com.chaoxing.filemanagement.util;

import java.util.UUID;

/**
 * @ClassName UUIDUtil
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-06 17:16
 **/
public class UUIDUtil {

    /**
     * 使用java自带jdk生成UUID
     * 长度为32字符
     * @return uuid
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
