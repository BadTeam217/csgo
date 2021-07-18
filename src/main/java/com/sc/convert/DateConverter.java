package com.sc.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    /**
    * 将前端时间字符串转换为Date格式
    */
    @Override
    public Date convert(String time) {
        try {
            if (time.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$")){
                return date.parse(time);
            }else if(time.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{2}:\\d{2}$")){
                return dateTime.parse(time);
            }
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
