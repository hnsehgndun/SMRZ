package com.crm.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * 日期转换器
 */
public class DateConverter implements Converter<String,Date> {
    @Override
    public Date convert(String s) {
       if(StringUtils.isNotEmpty(s)){
           String [] str={"yyyy-MM", "yyyyMMddHHmmss", "yyyyMMdd",
                   "yyyyMM", "yyyy/MM", "yyyy-MM-dd HH:mm:ss",
                   "yyyy-MM-dd'T'HH:mm", "yyyy-MM-dd'T'HH:mm:ss",
                   "yyyy/MM/dd HH:mm:ss", "yyyy-MM-dd",
                   "yyyy/MM/dd", "yyyy年MM月dd日 HH时mm分ss秒",
                   "yyyy年MM月dd日"};

           try {
               return DateUtils.parseDate(s, str);
           } catch (ParseException e) {
               e.printStackTrace();
           }
       }
       return null;
    }
}
