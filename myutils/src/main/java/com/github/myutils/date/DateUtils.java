package com.github.myutils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @Author Dooby Kim
 * @Date 2023/4/12 7:56 下午
 * @Version 1.0
 * <p>
 * 日期工具类
 */
public class DateUtils {

    /**
     * 获取当前时间 年-月-日
     *
     * @return
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 获取当前时间 年-月-日 时:分:秒
     *
     * @return
     */
    public static String getDateTime() {
        return getDate("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前时间
     *
     * @param format
     * @return
     */
    public static String getDate(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(Calendar.getInstance(Locale.CHINA).getTime());
    }
}
