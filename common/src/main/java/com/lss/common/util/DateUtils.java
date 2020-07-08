package com.lss.common.util;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能描述
 *
 * @author HuWenhai
 * @title: DateUtils
 * @projectName lssplatform
 * @description: TODO
 * @date 2019/5/6 10:30
 * @version: v1.0
 */
public class DateUtils {

    /**
     * @param year  指定年份
     * @param month 指定月份
     * @return
     * @throws
     * @description: 根据年月获取当月的天数
     * @author HuWenhai
     * @date
     */
    public static int getMonthDateNumber(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * @param year  指定年份
     * @param month 指定月份
     * @param date  指定日期
     * @return
     * @throws
     * @description: 根据年月日返回当天零点
     * @author HuWenhai
     * @date
     */
    public static Date getDate(int year, int month, int date) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, date);
        a.set(Calendar.HOUR_OF_DAY, 0);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.SECOND, 0);
        return a.getTime();
    }

    /**
     * @param year  指定年份
     * @param month 指定月份
     * @return
     * @throws
     * @description: 根据年月返回当月第一天零点
     * @author HuWenhai
     * @date
     */
    public static Date getFirstTimeMon(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        a.set(Calendar.DATE, 1);
        a.set(Calendar.HOUR_OF_DAY, 0);
        a.set(Calendar.MINUTE, 0);
        a.set(Calendar.SECOND, 0);
        return a.getTime();
    }

    /**
     * @param year  指定年份
     * @param month 指定月份
     * @return
     * @throws
     * @description: 根据年月返回当月最后一天23点59分59秒
     * @author HuWenhai
     * @date
     */
    public static Date getLastTimeMon(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month);
        a.set(Calendar.DATE, 0);
        a.set(Calendar.HOUR_OF_DAY, 23);
        a.set(Calendar.MINUTE, 59);
        a.set(Calendar.SECOND, 59);
        return a.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期的零点
     * @author HuWenhai
     * @date
     */
    public static Date getDateStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期的23点59分59秒
     * @author HuWenhai
     * @date
     */
    public static Date getDateEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * @param days 根据传输的正负数值获取指定日期（提前或延后）的23点59分59秒
     * @return
     * @throws
     * @description: 获取指定日期的23点59分59秒
     * @author HuWenhai
     * @date
     */
    public static Date getSpecifiedDateEnd(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE, days);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期当周周一
     * @author HuWenhai
     * @date
     */
    public static Date getWeekStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - calendar.get(Calendar.DAY_OF_WEEK) + 1);
        return calendar.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期当周週日
     * @author HuWenhai
     * @date
     */
    public static Date getWeekEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            return date;
        }
        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.add(Calendar.DATE, 7 - calendar.get(Calendar.DAY_OF_WEEK) + 1);
        return calendar.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期当月第一天
     * @author HuWenhai
     * @date
     */
    public static Date getFirstMonthDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期当月最后一天
     * @author HuWenhai
     * @date
     */
    public static Date getLastMonthDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期在当月第几天
     * @author HuWenhai
     * @date
     */
    public static int getDateNumber(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int dateNumber = calendar.get(Calendar.DAY_OF_MONTH);
        return dateNumber;
    }

    /**
     * @param date 指定日期
     * @return
     * @throws
     * @description: 获取指定日期当月的天数
     * @author HuWenhai
     * @date
     */
    public static int getMonthDays(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * @param year  指定年份
     * @param month 指定月份
     * @return
     * @throws
     * @description: 根据年月获取指定月份的天数
     * @author HuWenhai
     * @date
     */
    public static int getDaysByYearMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int maxDate = calendar.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * mongo 日期查询isodate
     *
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(String dateStr) throws Exception {
        //T代表后面跟着时间，Z代表UTC统一时间
        dateStr += " 00:00:00";
        Date date = formatD(dateStr);
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
        String isoDate = format.format(date);
        try {
            return format.parse(isoDate);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 时间格式(yyyy-MM-dd HH:mm:ss)
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static Date formatD(String dateStr) throws Exception {
        return formatD(dateStr, DATE_TIME_PATTERN);
    }

    public static Date formatD(String dateStr, String format) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date ret = null;
        try {
            ret = simpleDateFormat.parse(dateStr);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return ret;
    }

    /**
     * @param
     * @return
     * @description: 给一段时间，判断该段时间是否小于24小时
     */
    public static Boolean judgeDateLessThanOneDay(Date startDate, Date endDate) {

        long cha = endDate.getTime() - startDate.getTime();

        if (cha < 0) {
            return false;
        }

        double result = cha * 1.0 / (1000 * 60 * 60);

        if (result <= 24) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param
     * @return
     * @description: 拼接一天中小时的集合
     */
    public static List<String> covertDayToHourStrings() {
        List<String> hourStrs = new ArrayList<>();
        for (int i = 1; i <= 24; i++) {
            String hourStr = i + "点";
            hourStrs.add(hourStr);
        }
        return hourStrs;
    }

    /**
     * @param
     * @return
     * @description: 给一段时间，按日升序展示该时间段内时间，时间间隔最长不能超过31天
     */
    public static List<String> convertDateToStrings(Date startDate, Date endDate) {
        //返回值
        List<String> dateStrs = new ArrayList<>();

        //获取起始月日
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.setTime(startDate);
        Integer startMonth = startCalendar.get(Calendar.MONTH) + 1;
        Integer startDay = startCalendar.get(Calendar.DAY_OF_MONTH);

        //获取终止月日
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        Integer endMonth = endCalendar.get(Calendar.MONTH) + 1;
        Integer endDay = endCalendar.get(Calendar.DAY_OF_MONTH);

        if (startMonth == endMonth) {//同月
            for (int i = startDay; i <= endDay; i++) {
                String dateStr = startMonth + "月" + i + "日";
                dateStrs.add(dateStr);
            }
        } else {//不同月
            int num = getMonthDays(startDate);//获取指定日期当月的天数
            for (int j = startDay; j <= num; j++) {
                String dateStr = startMonth + "月" + j + "日";
                dateStrs.add(dateStr);
            }
            for (int k = 1; k <= endDay; k++) {
                String dateStr = endMonth + "月" + k + "日";
                dateStrs.add(dateStr);
            }
        }
        return dateStrs;
    }

    /**
     * @param date    需要转换的时间
     * @param pattern 需要转换的字符串格式，例如yyyyMMdd将会返回20191125
     * @return String 转换后的时间字符串
     * @throws
     * @description: 根据入参时间和字符转格式进行字符串转换
     * @author HuWenhai
     * @date 2019/11/21 15:00
     */
    public static String dateParseString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

}
