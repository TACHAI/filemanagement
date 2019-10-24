package com.chaoxing.filemanagement.util;



import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName MD5Util
 * @Author https://github.com/TACHAI
 * @Email tc1206966083@gmail.com
 * @Date 2019-06-06 13:28
 **/
@Slf4j
public class MD5Util {
    public static String MD5(String str)  {
        String res =null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(str.getBytes("utf-8"));
            res = toHex(bytes);
        }catch (NoSuchAlgorithmException noException){
            log.error("/com.chaoxing/util/MD5Util.java:"+noException.getMessage());
        }catch (UnsupportedEncodingException unException){
            log.error("/com.chaoxing/util/MD5Util.java:"+unException.getMessage());
        }finally {
            return res;
        }
    }

    private static String toHex(byte[] bytes) {

        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i=0; i<bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        //5EA422EF28B79988EE640D4CF9E3286E
        //85ADA72802DE970FDD43E68D29A85A80
        //密码38C3350484E7431798AB8657C6B0A280
        String pwd = "chaoxing";
        //AB2385DD1F310B9C2995687B10162B73
        String pwd2 = MD5Util.MD5(pwd);

        System.out.println(pwd2);
    }
}
