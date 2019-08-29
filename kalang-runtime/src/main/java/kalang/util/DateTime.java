package kalang.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author KasonYang
 */
public class DateTime implements Comparable<DateTime> {

    private long timeInMillis;

    private Calendar calendar;

    public DateTime() {
        this(System.currentTimeMillis());
    }

    /**
     * constructor of DateTime
     * @param timeInMillis the number of milliseconds since January 1, 1970, 00:00:00 GMT
     */
    public DateTime(long timeInMillis) {
        this.timeInMillis = timeInMillis;
    }

    /**
     * constructor of DateTime
     * @param year the value of year
     * @param month the value of month.The value is 1-based. e.g. 1 for January
     * @param date the value of date
     * @param hour the value of hour
     * @param minute the value of minute
     * @param second the value of second
     */
    public DateTime(int year, int month, int date, int hour, int minute, int second, int millisecond) {
        Calendar d = Calendar.getInstance();
        d.set(year, month + 1, date, hour, minute, second);
        d.set(Calendar.MILLISECOND, millisecond);
        this.timeInMillis = d.getTimeInMillis();
    }

    /**
     * @see DateTime(int,int,int,int,int,int,int)
     */
    public DateTime(int year, int month, int date, int hour, int minute, int seconds) {
        this(year, month, date, hour, minute, seconds, 0);
    }

    /**
     * @see DateTime(int,int,int,int,int,int,int)
     */
    public DateTime(int year, int month, int date) {
        this(year, month, date, 0, 0, 0);
    }

    /**
     * Returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this DateTime object.
     * @return
     */
    public long getTime() {
        return timeInMillis;
    }

    public int getYear() {
        return getCalendar().get(Calendar.YEAR);
    }

    public int getMonth() {
        return getCalendar().get(Calendar.MONTH);
    }

    public int getDate() {
        return getCalendar().get(Calendar.DATE);
    }

    public int getHour() {
        return getCalendar().get(Calendar.HOUR);
    }

    public int getMinute() {
        return getCalendar().get(Calendar.MINUTE);
    }

    public int getSecond() {
        return getCalendar().get(Calendar.SECOND);
    }

    /**
     * Returns the day of week represented by this DateTime object.
     * @return the day of week.1-7 for SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, and SATURDAY.
     */
    public int getDayOfWeek() {
        return getCalendar().get(Calendar.DAY_OF_WEEK);
    }

    public int getMillisecond() {
        return getCalendar().get(Calendar.MILLISECOND);
    }

    public DateTime plusYear(int yearAmount) {
        return plus(Calendar.YEAR, yearAmount);
    }

    public DateTime plusMonth(int monthAmount) {
        return plus(Calendar.MONTH, monthAmount);
    }

    public DateTime plusDate(int dateAmount) {
        return plus(Calendar.DATE, dateAmount);
    }

    public DateTime plusHour(int hourAmount) {
        return plus(Calendar.HOUR, hourAmount);
    }

    public DateTime plusMinute(int minuteAmount) {
        return plus(Calendar.MINUTE, minuteAmount);
    }

    public DateTime plusSecond(int secondAmount) {
        return plus(Calendar.SECOND, secondAmount);
    }

    public DateTime plusMillisecond(int millis) {
        return plus(Calendar.MILLISECOND, millis);
    }

    public DateTime minusYear(int yearAmount) {
        return minus(Calendar.YEAR, yearAmount);
    }

    public DateTime minusMonth(int monthAmount) {
        return minus(Calendar.MONTH, monthAmount);
    }

    public DateTime minusDate(int dateAmount) {
        return minus(Calendar.DATE, dateAmount);
    }

    public DateTime minusHour(int hourAmount) {
        return minus(Calendar.HOUR, hourAmount);
    }

    public DateTime minusMinute(int minuteAmount) {
        return minus(Calendar.MINUTE, minuteAmount);
    }

    public DateTime minusSecond(int secondAmount) {
        return minus(Calendar.SECOND, secondAmount);
    }

    public DateTime minusMillisecond(int millis) {
        return minus(Calendar.MILLISECOND, millis);
    }

    public String toString(String pattern) {
        return new SimpleDateFormat(pattern).format(getCalendar().getTime());
    }

    public static DateTime parse(String date) throws ParseException {
        Date d = new SimpleDateFormat().parse(date);
        return new DateTime(d.getTime());
    }

    public static DateTime parse(String date, String pattern) throws ParseException {
        Date d = new SimpleDateFormat(pattern).parse(date);
        return new DateTime(d.getTime());
    }

    @Override
    public String toString() {
        return new SimpleDateFormat().format(getCalendar().getTime());
    }

    private DateTime plus(int field, int amount) {
        Calendar cd = createCalendar();
        cd.add(field, amount);
        return new DateTime(cd.getTimeInMillis());
    }

    private DateTime minus(int field, int amount) {
        return plus(field, -amount);
    }

    private Calendar createCalendar() {
        Calendar d = Calendar.getInstance();
        d.setTimeInMillis(timeInMillis);
        return d;
    }

    private Calendar getCalendar() {
        if (calendar == null) {
            synchronized (this) {
                if (calendar == null) {
                    calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(timeInMillis);
                }
            }
        }
        return calendar;
    }

    @Override
    public int compareTo(DateTime o) {
        return Long.compare(this.getTime(), o.getTime());
    }
}
