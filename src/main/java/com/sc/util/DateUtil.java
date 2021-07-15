package com.sc.util;



import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();



    public static String dateFormat(Date date, String pattern){
        simpleDateFormat.applyPattern(pattern);
        return simpleDateFormat.format(date);
    }

    /**
     *格式为yyyy-MM-dd
     */

    public static String dateFormat(Date date){
        return DateUtil.dateFormat(date,"yyyy-MM-dd");
    }


}
