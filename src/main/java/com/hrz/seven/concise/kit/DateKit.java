package com.hrz.seven.concise.kit;

import com.sun.xml.internal.ws.util.UtilException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;

/**
 * Created by paul on 2017/6/10.
 */
public class DateKit extends com.jfinal.ext.kit.DateKit {

    /** 标准日期格式 */
    public final static String NORM_DATE_PATTERN = "yyyy-MM-dd";
    /** 标准时间格式 */
    public final static String NORM_TIME_PATTERN = "HH:mm:ss";
    /** 标准日期时间格式，精确到秒 */
    public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /** 标准日期（不含时间）格式化器 */
    private static ThreadLocal<SimpleDateFormat> NORM_DATE_FORMAT = new ThreadLocal<SimpleDateFormat>(){
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATE_PATTERN);
        };
    };
    /** 标准时间格式化器 */
    private static ThreadLocal<SimpleDateFormat> NORM_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_TIME_PATTERN);
        };
    };
    /** 标准日期时间格式化器 */
    private static ThreadLocal<SimpleDateFormat> NORM_DATETIME_FORMAT = new ThreadLocal<SimpleDateFormat>(){
        synchronized protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(NORM_DATETIME_PATTERN);
        };
    };

    public static String now(){
        return formatDateTime(new Date());
    }

    /**
     * 格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDateTime(Date date) {
        return NORM_DATETIME_FORMAT.get().format(date);
    }
    /**
     * 格式 yyyy-MM-dd
     *
     * @param date 被格式化的日期
     * @return 格式化后的日期
     */
    public static String formatDate(Date date) {
        return NORM_DATE_FORMAT.get().format(date);
    }
    /**
     * 格式 yyyy-MM-dd HH:mm:ss
     *
     * @param date 被格式化的时间
     * @return 格式化后的时间
     */
    public static String formatTime(Date date) {
        return NORM_TIME_FORMAT.get().format(date);
    }

}
