package com.ng.trainplan.sportplan.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelper {

	public static final long DAY_START = 0;
	public static final long DAY_END = 24 * 60 * 60 * 1000;

	public static String getLongAsString(long time) {
		Date date = new Date(time);
		return getDateAsString(date);
	}

	public static String getDateAsString(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy",
				Locale.GERMAN);
		return formatter.format(date);
	}

	public static String getCurrentDateAsString() {
		GregorianCalendar cal = new GregorianCalendar();
		return getDateAsString(cal.getTime());
	}

	public static int getCurrentYear() {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.get(GregorianCalendar.YEAR);
	}

	public static int getCurrentMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.get(GregorianCalendar.MONTH) + 1;
	}

	public static int getCurrentDayOfMonth() {
		GregorianCalendar cal = new GregorianCalendar();
		return cal.get(GregorianCalendar.DAY_OF_MONTH);
	}

	public static String getTimeAsString(long time) {
		long hours = time / (60 * 60 * 1000);
		long minutes = (time - (hours * 60 * 60 * 1000)) / (60 * 1000);

		StringBuilder sb = new StringBuilder();
		if (hours < 10) {
			sb.append("0");
		}
		sb.append(hours).append(":");
		if (minutes < 10) {
			sb.append("0");
		}
		sb.append(minutes);
		return sb.toString();
	}

	private static String getDayOfWeekAsString(int day) {
		switch (day) {
		case 2:
			return "Mon:";
		case 3:
			return "Tue:";
		case 4:
			return "Wed:";
		case 5:
			return "Thu:";
		case 6:
			return "Fri:";
		case 7:
			return "Sat:";
		default:
			return "Sun:";
		}
	}

	public static String getDateByWeekOfYearAsString(int dayOfWeek,
			int weekOfYear, int year) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(GregorianCalendar.YEAR, year);
		cal.set(GregorianCalendar.DAY_OF_WEEK, dayOfWeek);
		cal.set(GregorianCalendar.WEEK_OF_YEAR, weekOfYear);
		return getDateAsString(cal.getTime());
	}

	public static String getDayOfWeekByDateAsString(String date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(GregorianCalendar.DAY_OF_MONTH,
				Integer.parseInt(date.substring(0, 2)));
		cal.set(GregorianCalendar.MONTH,
				Integer.parseInt(date.substring(3, 5)) - 1);
		cal.set(GregorianCalendar.YEAR, Integer.parseInt(date.substring(6)));
		return getDayOfWeekAsString(cal.get(GregorianCalendar.DAY_OF_WEEK));
	}

	public static String getDateAsString(int day, int month, int year) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(year, month - 1, day);
		return getDateAsString(cal.getTime());
	}

	public static long convertDateStringToLong(int day, int month, int year) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(year, month - 1, day);
		return cal.getTimeInMillis();
	}

	public static long getHoursAsLong(String string) {
		if (string.contains(":")) {
			return getHoursAsLong(string.substring(0, 1))
					+ getMinutesAsLong(string.substring(3));
		}
		return Long.parseLong(string) * 60 * 60 * 1000;
	}

	public static long getMinutesAsLong(String string) {
		return Long.parseLong(string) * 60 * 1000;
	}

	public static int convertHoursLongToInt(long value) {
		return (int) (value / (1000 * 60 * 60));
	}

	public static Integer convertMinutesLongToInt(long value) {
		return (int) ((value / (1000 * 60)) % 60);
	}

	public static long convertDateStringToLong(String dateString) {
		return convertDateStringToLong(
				Integer.valueOf(dateString.substring(0, 2)),
				Integer.valueOf(dateString.substring(3, 5)),
				Integer.valueOf(dateString.substring(6)));
	}

	public static int convertHoursToLong(Integer currentHour) {
		return currentHour * 60 * 60 * 1000;
	}

	public static int convertMinutesToLong(Integer currentMinute) {
		return currentMinute * 60 * 1000;
	}

	public static long convertHoursAndMinutesToLong(int hours, int minutes) {
		return convertHoursToLong(hours) + convertMinutesToLong(minutes);
	}

	public static long getCurrentTime() {
		Calendar cal = new GregorianCalendar();
		return convertHoursAndMinutesToLong(cal.get(GregorianCalendar.HOUR),
				GregorianCalendar.MINUTE);
	}

}
