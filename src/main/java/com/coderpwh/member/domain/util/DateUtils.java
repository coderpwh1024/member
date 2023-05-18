package com.coderpwh.member.domain.util;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author coderpwh
 * @date 2023/5/18 14:40
 */
public class DateUtils {


    /***
     * 时间格式转换(string转换date)
     * @param date
     * @return
     */
    public static Date getDateByString(String date) {
        DateFormat dateForma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = dateForma.parse(date);
            return date1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /***
     * 时间格式转换(date转换string)
     * @param date
     * @return
     */
    public static String getStringByDate(Date date) {
        DateFormat dateForma = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            String time = dateForma.format(date);
            return time;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
