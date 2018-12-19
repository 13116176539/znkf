package com.bjdv.znfk.utils;


import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 〈转化时间格式〉
 *
 * @author hanxulei
 * @create 2018/8/31
 * @since 1.0.0
 */
public class TimeUilt {

    /**
     * 日期转为字符串yyyy-MM-dd HH:mm:ss
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate(Date date) {
        //Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        String dateString = formatter.format( date );
        //ParsePosition pos = new ParsePosition(8);
        //Date currentTime_2 = formatter.parse( dateString, pos );
        return dateString;
    }

    /**
     * 日期转化为毫秒
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Long getTime(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        long time2 = formatter.parse( date ).getTime();
        return time2;
    }


    /**
     * 字符串转为字符串yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String getDate(String date) {
        Date strtoDate = getNowDate( date );
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMddHHmmss" );
        String dateString = formatter.format( strtoDate );
        return dateString;
    }

    /**
     * 日期转为字符串yyMMddHHmmss
     *
     * @param date
     * @return 返回字符类型 yyyyMMddHHmmss
     */
    public static String getDateString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyMMddHHmmss" );
        String dateString = formatter.format( date );
        return dateString;
    }

    /**
     * 日期转为字符串yyyyMMddHHmmss
     *
     * @param date
     * @return
     */
    public static String getDateTurnString(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMddHHmmss" );
        String dateString = formatter.format( date );
        return dateString;
    }

    /**
     * 字符串转为日期yyyyMMddHHmmss
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMddHHmmss" );
        ParsePosition pos = new ParsePosition( 0 );
        Date strtoDate = formatter.parse( strDate, pos );
        return strtoDate;
    }

    /**
     * 字符串日期转为日期格式的字符串yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getNowString(String date) {
        Date strtoDate = getNowDate( date );
        String dateString = getNowDate( strtoDate );
        return dateString;
    }


    /**
     * 字符串转为字符串yyyyMMdd
     *
     * @return 返回时间类型 yyyy-MM-dd
     */
    public static String conversionDate(String date) {
        SimpleDateFormat formatter = new SimpleDateFormat( "yyyyMMdd" );
        ParsePosition pos = new ParsePosition( 0 );
        Date strtoDate = formatter.parse( date, pos );
        SimpleDateFormat formatter2 = new SimpleDateFormat( "yyyy-MM-dd" );
        String dateString = formatter2.format( strtoDate );
        return dateString;
    }

    /**
     * 秒转时间格式
     *
     * @param ms
     * @return
     */
    public static String secondsTurnMinutes(long ms) {
        //初始化format格式
        SimpleDateFormat format = new SimpleDateFormat( "HH:mm:ss" );
        //设置时区，跳过此步骤会默认设置为"GMT+08:00" 得到的结果会多出来8个小时
        format.setTimeZone( TimeZone.getTimeZone( "GMT+00:00" ) );
        return format.format( ms * 1000 );
    }

}
