package com.wenky.时间格式化;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @program: design-patterns
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2018-10-29 09:37
 */
public class OwnDateUtils {
    private static void RFC3339Time() throws ParseException {
        ZonedDateTime dateTime1 = ZonedDateTime.parse("2018-10-27T11:32:26.553955473Z");
        System.out.println(dateTime1.toString());

        ZonedDateTime dateTime2 = ZonedDateTime.parse("2018-10-27T11:32:26.123445+08:00");
        System.out.println(dateTime2.toString());

        // RFC3339 格式, 例如: 2006-01-02T15:04:05+08:00
        String dateString = DateFormatUtils.format(new Date(), "yyyy-MM-dd'T'HH:mm:ssZZ");
        System.out.println(dateString);

        // RFC3339 格式, 例如: 2006-01-02T15:04:05+08:00
        Date date = DateUtils.parseDate(dateString, "yyyy-MM-dd'T'HH:mm:ssZZ");
        System.out.println(date);
    }

    // RFC3339 格式, 例如: 2006-01-02T15:04:05+08:00
    public static String RFC3339Time(Date date) {
        String rfc3339 = "yyyy-MM-dd'T'HH:mm:ss";
        String TIMEZONE = "ZZ";
        String s =
                new StringBuilder()
                        .append(new SimpleDateFormat(rfc3339).format(date))
                        .append(DateFormatUtils.format(date, TIMEZONE))
                        .toString();
        return s;
    }

    public static void main(String[] args) throws ParseException {
        RFC3339Time();

        System.out.println(RFC3339Time(new Date()));
    }
}
