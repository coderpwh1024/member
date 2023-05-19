package com.coderpwh.member.domain.util;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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


    /**
     * 获取指定时间前/后天的23:59:59秒时间
     *
     * @param date 需要操作的时间
     * @param day  当前日期加减的值
     * @return
     */
    public static Date DateOperationByEndDay(Date date, Integer day) {
        Calendar calendar;
        try {
            calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DATE, day);
            return resetTimeEnd(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 将日期中的时间重置为23:59:59
     *
     * @param old
     * @return
     */
    public static Date resetTimeEnd(Date old) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = format.format(old);
        s = s.split(" ")[0] + " 23:59:59";

        Date parse = null;
        try {
            parse = format.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期转换错误");
        }
        return parse;
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            smdate = sdf.parse(sdf.format(smdate));
            bdate = sdf.parse(sdf.format(bdate));
            Calendar cal = Calendar.getInstance();
            cal.setTime(smdate);
            long time1 = cal.getTimeInMillis();
            cal.setTime(bdate);
            long time2 = cal.getTimeInMillis();
            long between_days = (time2 - time1) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 10000;
    }

}
