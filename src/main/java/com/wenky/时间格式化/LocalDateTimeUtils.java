package com.wenky.时间格式化;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-08-08 13:46
 */
public class LocalDateTimeUtils {
    public static void absoluteTimeDifference() {
        LocalDate localDate = LocalDate.now();
        LocalDate localDate1 = LocalDate.of(2019, 9, 1);
        LocalDate localDate2 = LocalDate.of(2019, 9, 23);
        Period period = Period.between(localDate, localDate1);
        Period period1 = Period.between(localDate, localDate2);
        System.out.println(period.getDays());
        System.out.println(period1.getDays());
        // 完整时间天数
        System.out.println(localDate.toEpochDay() - localDate1.toEpochDay());
    }

    public static void main(String[] args) {
        absoluteTimeDifference();
        //
        LocalDateTime.now();
        ChronoUnit.SECONDS.between(LocalDateTime.now(),LocalDateTime.now());
        // 可选参数信息
        // 1. LocalDate、LocalTime
        // 2. year、month、day、hour、minute、second、nanosecond
        // LocalDateTime.of();

        // 比较日期先后 参数 LocalDateTime
        //    LocalDateTime.now().isBefore(); // isAfter()、 isEqual()

        // Date转换为LocalDateTime
        LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault());

        // LocalDateTime转换为Date  先转化为instant
        Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());

        // 获取指定日期的毫秒 先转化为instant
        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

        // 获取指定日期的秒
        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();

        // 获取指定时间的指定格式
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        // 日期加上时间 long、TemporalUnit
        //    LocalDateTime.now().plus(); // plusDays、plusHours、plusMinutes...

        // 日期减去一个时间
        //    LocalDateTime.now().minus();

        // 两种方式获取两个日期的时间差
        Period period = Period.between(LocalDate.MIN, LocalDate.MAX);
        System.out.println(period.getYears());

        System.out.println(ChronoUnit.YEARS.between(LocalDate.MIN, LocalDate.MAX));

        // 一天开始时间
        LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);

        // 一天结束的时间
        LocalDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);

        String data1 = "1999-10-11";
        String data2 = "1999-10-12";
        String data3 = "1999-10-10";
        Period period1 =
                Period.between(
                        LocalDate.parse(data1, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now());
        Period period2 =
                Period.between(
                        LocalDate.parse(data2, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now());
        Period period3 =
                Period.between(
                        LocalDate.parse(data3, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now());
        System.out.println(period1.getYears());
        System.out.println(period2.getYears());
        System.out.println(period3.getYears());
    }
}
