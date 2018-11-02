package com.decoration.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/10/30 17:36
 */
@Slf4j
public class DateUtil extends DateUtils {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    /**
     * 日期+时间的格式
     */
    final static public String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    final static public String DATE_TIME = "yyyy-MM-dd HH:mm";

    public final static String DATETIME_MILL_SECOND_FILE = "yyyyMMddHHmmssSSS";

    public final static String DATE_SHORT_PATTERN = "yyyyMMdd";

    /**
     * 日期的格式
     */
    final static public String yyyy_MM_dd = "yyyy-MM-dd";

    final static public String yyyyMMdd = "yyyyMMdd";
    final static public String DATETIME_FORMAT_SIMPLE = "yyyyMMdd HH:mm:ss";


    final static public String MONTH_FORMAT = "yyyy-MM";

    final static public String YYYY_DOT_MM = "yyyy.MM";

    /**
     * 中文日期的格式
     */
    final static public String DATE_CH_FORMAT = "yyyy年MM月dd日";

    final static public String FORMAT_MMDD = "MMdd";

    /**
     * 小时:分的格式
     */
    final static public String HHMM_FORMAT = "HH:mm";

    final static public String HHMMSS_FORMAT = "HH:mm:ss";

    final static public String HHMMSS_SIMPLE_FORMAT = "HHmmss";

    final static public String DATE_TIME_SSS_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";

    private static final String CRON_DATE_FORMAT = "ss mm HH dd MM ? yyyy";

    private static final Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))?$");

    //判断“YYYY-MM-DD”类型 时间格式
    public static boolean isDate(String date) {
        return p.matcher(date).matches();
    }

    public static String getCron(final Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(CRON_DATE_FORMAT);
        String formatTimeStr = "";
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }


    public static Date min(Date... dates) {
        if (ArrayUtils.isEmpty(dates)) {
            return null;
        }
        Date minDate = dates[0];
        for (Date tmp : dates) {
            if (tmp.before(minDate)) {
                minDate = tmp;
            }
        }
        return minDate;
    }

    public static Date min(List<Date> dates) {
        if (CollectionUtils.isEmpty(dates)) {
            return null;
        }
        return min(dates.toArray(new Date[0]));
    }

    public static Date max(Date... dates) {
        if (ArrayUtils.isEmpty(dates)) {
            return null;
        }
        Date maxDate = dates[0];
        for (Date tmp : dates) {
            if (tmp.after(maxDate)) {
                maxDate = tmp;
            }
        }
        return maxDate;
    }

    public static Date max(List<Date> dates) {
        if (CollectionUtils.isEmpty(dates)) {
            return null;
        }
        return max(dates.toArray(new Date[0]));
    }

    /**
     * 判断日期是否为同一天
     *
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);

        return isSameDate;
    }

    /**
     * 将日期字符串解析成指定格式的Date对象
     *
     * @param dateTime 日期字符串
     * @param format   指定格式
     * @return （正确格式）日期对象
     * @throws ParseException
     */
    public static Date parse(String dateTime, String format) {
        if (StringUtils.isBlank(dateTime) || StringUtils.isBlank(format)) {
            return null;
        }
        String sDateTime = ((dateTime.indexOf('.') > 0)) ? dateTime.substring(
                0, dateTime.indexOf('.')) : dateTime;

        DateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(sDateTime);
        } catch (Exception e) {
            logger.error("parse date {} with {} exception: {}", dateTime, format, e.getMessage());
            return null;
        }
    }

    public static Date parseDate(String str) {
        return parse(str, yyyyMMdd);
    }

    /**
     * 将日期类解析成指定格式的日期字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return "";
        }
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }

    /**
     * 将日期字符串解析成"yyyy-MM-dd"格式的Date对象
     *
     * @param dateTime 日期字符串
     *                 指定格式
     * @return （正确格式）日期对象
     */
    public static Date parseDay(String dateTime) {
        return parse(dateTime, yyyy_MM_dd);
    }

    public static Date parseDay(String dateStr, String format) {
        return parse(dateStr, format);
    }

    /**
     * 将日期字符串解析成"yyyy年MM月dd日"格式的Date对象
     *
     * @param dateTime 日期字符串
     *                 指定格式
     * @return （正确格式）日期对象
     */
    public static Date parseChDay(String dateTime) {
        return parse(dateTime, DATE_CH_FORMAT);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatDay(Date date) {
        return format(date, yyyy_MM_dd);
    }

    /**
     * 将日期类解析成"yyyyMMdd"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatSimpleDay(Date date) {
        return format(date, yyyyMMdd);
    }

    /**
     * 将日期类解析成"yyyy年MM月dd日"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String formatChYYYYMMDD(Date date) {
        return format(date, DATE_CH_FORMAT);
    }

    /**
     * 将日期类解析成"yyyy-MM-dd HH:mm:ss"格式的日期字符串
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, DATE_TIME_FORMAT);
    }

    public static String formatMinute(Date date) {
        return format(date, DATE_TIME);
    }

    /**
     * 上一天
     *
     * @return
     */
    public static Date getPrevDay(Date date) {
        if (date == null) {
            return null;
        }
        return truncateDay(addDays(date, -1));
    }

    /**
     * 按天数获取日期，负数表示获取date之前的日期
     *
     * @param date
     * @param days
     * @return
     */
    public static Date getDays(Date date, Integer days) {
        if (date == null) {
            return null;
        }
        return truncateDay(addDays(date, days));
    }

    /**
     * 后一天
     *
     * @return
     */
    public static Date getNextDay(Date date) {
        if (date == null) {
            return null;
        }
        return truncateDay(addDays(date, 1));
    }

    /**
     * d0是否在[start,end]的日期区间中,闭区间
     *
     * @return
     */
    public static boolean between(Date d0, Date start, Date end) {
        if (d0 == null) {
            return false;
        }
        boolean after = start == null ? true : d0.compareTo(start) >= 0;
        boolean before = end == null ? true : d0.compareTo(end) <= 0;
        return after && before;
    }

    /**
     * 返回日期
     *
     * @param year  1900-...
     * @param month 0-11
     * @return
     * @throws RuntimeException
     */
    public static Date toDate(int year, int month, int day) {
        Calendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }

    public static Date fromSecond(Long second) {
        if (second == null || second <= 0L) {
            return null;
        }
        return new Date(second * 1000L);
    }

    /**
     * 返回四位年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回月数(0-11)
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 返回月几(1-31)
     *
     * @param date
     * @return
     */
    public static int getMonthDay(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回周几。周日为0，周一为1
     *
     * @param date
     * @return 0：周日；1：周一...
     */
    public static int getWeekDay(Date date) {
        if (date == null) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public static Date startOfHour(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        try {
            return sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            throw new RuntimeException("parse error", e);
        }
    }

    /**
     * 获取 GMT 格式时间戳
     * return String;
     */
    public static String formatGMTDate(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        formater.setTimeZone(TimeZone.getTimeZone("GMT"));
        return formater.format(date);
    }

    public static Date[] getDayStartEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Date[] dates = new Date[2];
        calendar = truncate(calendar, Calendar.DAY_OF_MONTH);
        dates[0] = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        dates[1] = calendar.getTime();
        return dates;
    }

    /**
     * 取得一个date对象对应的日期的0点0分0秒时刻的Date对象。
     *
     * @throws
     * @Title: getMinDateOfDay
     * @Description: 取得一个date对象对应的日期的0点0分0秒时刻的Date对象。
     * @param: @param date 给定的日期
     * @param: @return 操作后的日期
     * @return: Date
     * @author lc
     * @Date 2015-11-4 下午5:38:43
     */
    public static Date getMinDateOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MINUTE, calendar.getActualMinimum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMinimum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMinimum(Calendar.MILLISECOND));
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMinimum(Calendar.HOUR_OF_DAY));
        return calendar.getTime();
    }

    /**
     * 取得一个date对象对应的日期的23点59分59秒时刻的Date对象。
     *
     * @throws
     * @Title: getMaxDateOfDay
     * @Description: 取得一个date对象对应的日期的23点59分59秒时刻的Date对象。
     * @param: @param date 给定的日期
     * @param: @return 处理之后的日期
     * @return: Date
     * @author lc
     * @Date 2015-11-4 下午5:39:24
     */
    public static Date getMaxDateOfDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
        return calendar.getTime();
    }

    /**
     * 获取某月的所有天
     *
     * @param monthStr
     * @param fmt
     * @return
     */
    public static List<Date> allMonthDay(String monthStr, String fmt) {
        List<Date> days = new ArrayList<>(31);
        Date day = DateUtil.parse(monthStr, fmt);
        if (day == null) {
            return Collections.emptyList();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        int month = calendar.get(Calendar.MONTH);
        while (calendar.get(Calendar.MONDAY) == month) {
            days.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            ;
        }
        return days;
    }

    public static int diffDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return -1;
        }
        long time = date1.getTime() - date2.getTime();
        return (int) (time / (24 * 3600 * 1000L));
    }

    public static Date truncateDay(Date date) {
        if (date == null) {
            return null;
        }
        return truncate(date, Calendar.DAY_OF_MONTH);
    }

    public static int get(Date day, int field) {
        if (day == null || field < 0) {
            return -1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(day);
        return calendar.get(field);
    }


    public static String format(Long date) {
        Date date1 = new Date(date);
        return DateUtil.format(date1, yyyy_MM_dd);
    }

    /**
     * 往前推天数
     *
     * @param num
     * @return
     */
    public static Date frontManyDay(Date date, int num) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_MONTH, 0 - num);
        return cl.getTime();
    }

    /**
     * 往后推天数
     *
     * @param num
     * @return
     */
    public static Date afterManyDay(Date date, int num) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        cl.add(Calendar.DAY_OF_MONTH, num);
        return cl.getTime();
    }


    public static String formatSimpleHHmmss(Date date) {
        return format(date, HHMMSS_SIMPLE_FORMAT);
    }

    /**
     * 获取当前月份前几个月时间列表，包括当前月份
     *
     * @param num 月份数量
     * @return
     */
    public static List<String> getPassedMonths(int num) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        List<String> months = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.MONTH, i - num + 1);
            String month = df.format(calendar.getTime());
            months.add(month);
        }
        return months;
    }

    /**
     * 获取当前月份前几个月时间列表，包括当前月份
     *
     * @param base 基础时间
     * @param num  月份数量
     * @return
     */
    public static List<String> getPassedMonths(Date base, int num) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        List<String> months = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(base);
            calendar.add(Calendar.MONTH, i - num + 1);
            String month = df.format(calendar.getTime());
            months.add(month);
        }
        return months;
    }

    public static Date[] getRangeByMonthCount(int count) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1 - count);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date[] dates = new Date[2];
        try {
            dates[0] = df.parse(df.format(calendar.getTime()));
            calendar.setTime(new Date());
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            dates[1] = df.parse(df.format(calendar.getTime()));
            return dates;
        } catch (ParseException e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }


    /**
     * 获取下月第一天
     *
     * @param recentDate
     * @return
     */
    public static Date getFirstDayOfNextMonth(Date recentDate) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(recentDate);
        ca.add(Calendar.MONTH, 1);
        ca.set(Calendar.DAY_OF_MONTH, 1);
        return ca.getTime();
    }

    /**
     * 日期格式转换，由yy-mm-dd转换为mmdd
     *
     * @param dateStr:yy-mm-dd 格式
     * @return mmdd格式
     */
    public static String formatChangeToMMdd(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat(yyyy_MM_dd);
        try {
            Date date = dateFormat.parse(dateStr);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_MMDD);
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            logger.error("parse date {} with {} exception: {}", dateStr, yyyy_MM_dd, e.getMessage());
            return "0000";
        }
    }

    //得到两个日期之间所有月份(格式2018-08)
    public static List<String> getDateBetweenMonth(Date startDate, Date endDate) {
        List<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();
        min.setTime(startDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(endDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }
        return result;
    }

    public static int diffMinute(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return -1;
        }
        long time = date1.getTime() - date2.getTime();
        return (int) (time / (60 * 1000L));
    }
}
