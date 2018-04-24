package com.iancuio.flowerorder.utils.date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.format.ISODateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 * Created by vlad.iancu on 3/10/2016.
 */
public class DateUtils {

    public static final String FORMAT_DATE = "dd/MM/yyyy";
    public static final String FORMAT_DATE_TIME = "dd/MM/yyyy HH:mm:ss";
    public static final String FORMAT_DATE_TIME_SHORT = "dd/MM/yyyy HH:mm";
    public static final String FORMAT_TIME = "HH:mm:ss";
    public static final String FORMAT_TIME_SHORT = "HH:mm";

    public static String getFormattedDate(long milliSeconds, String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(milliSeconds);
    }

    public static String getTimeSinceExpiry(Long expiryDate) {
        long diffInMillisec = DateTime.now().getMillis() - expiryDate;
        long diffInHours = TimeUnit.MILLISECONDS.toHours(diffInMillisec);
        long diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillisec);

        if (diffInHours >= 24) {
            return "Expired " + diffInDays + " days ago";
        } else {
            return "Expired " + diffInHours + " hours ago";
        }
    }

    public static long getMillisFromIsoDate(String ISODate) {
        return ISODateTimeFormat.dateTime().parseDateTime(ISODate).getMillis();
    }

    public static String getIsoDateFromMillis(long millis) {
        return new DateTime(millis, DateTimeZone.UTC).toString();
    }

    public static boolean dateIsToday(Long timestamp) {
        if (timestamp != null) {
            Interval today = new Interval(DateTime.now().withTimeAtStartOfDay(), Days.ONE);
            return today.contains(timestamp);
        } else {
            return false;
        }
    }
}
