package com.chaoxing.filemanagement.util;

import org.joda.time.DateTime;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @class: DateUtils
 * @Author: darren
 * @CreateDate: 2019-06-13 9:53
 * @Version 1.0
 */
public class DateUtils {

    public static final String DATENAME_FORMAT="yyyyMMddHHmmsss";
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getNowDate() {

        Date currentTime = new Date();

        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }


    public static String dateToStr(Date date,String formStr){
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formStr);
    }



}
