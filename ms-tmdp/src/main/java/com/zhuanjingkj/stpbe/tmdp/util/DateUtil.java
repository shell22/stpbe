package com.zhuanjingkj.stpbe.tmdp.util;

import org.apache.tomcat.jni.Local;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateUtil {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private static DateTimeFormatter dtfMd = DateTimeFormatter.ofPattern("yyyyMMdd");
	
	private static DateTimeFormatter dtfMd2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	/**
	 * 获取当前时间字符串
	 */
	public static String getLocalDateTime(){
		return dtf.format(LocalDateTime.now()); 
	}
	
	/**
	 * 
	 * @Description: 判断时间有效期 
	 * @param @param vtime 有效时间
	 * @return boolean    返回类型 
	 */
	public static boolean isBefore(String date){
		return LocalDateTime.now().isBefore(LocalDateTime.parse(date, dtf));
	}
	
	public static boolean isTimeBefore(String time){
		return LocalTime.now().isBefore(LocalTime.parse(time));
	}
	
	public static boolean isTimeAfter(String time){
		return LocalTime.now().isAfter(LocalTime.parse(time));
	}
	
	public static String countDays(Integer num){
		LocalDate now = LocalDate.now();
		return now.plusDays(num).toString();
	}
	
	public static Integer getDay(){
		return LocalDate.now().getDayOfMonth();
	}
	
	public static String getDayOfMonth(LocalDate localDate){
		return localDate.format(dtfMd);
	}
	
	public static String getMonthOfYear(){
		return LocalDate.now().getYear() + "-" + (LocalDate.now().getMonthValue() > 9 ? LocalDate.now().getMonthValue() : "0" + LocalDate.now().getMonthValue());
	}
	
	public static String plusDays(String date, Integer num){
		LocalDateTime ldt = LocalDateTime.parse(date, dtf);
		return ldt.plusDays(num).format(dtf).toString();
	}
	
	public static String plusDaysForDate(String date, Integer num){
		LocalDate ldt = LocalDate.parse(date, dtfMd2);
		return ldt.plusDays(num).format(dtfMd2).toString();
	}
	
	public static String plusMonth(String date, Integer num){
		LocalDateTime localDateTime = LocalDateTime.parse(date, dtf);
		return localDateTime.plusMonths(num).format(dtf).toString();
	}
	
	public static String plusHours(String date, Integer num){
		return LocalDateTime.parse(date, dtf).plusHours(num).format(dtf);
	}
	
	public static String countMonth(Integer num){
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime.plusMonths(num).format(dtf).toString();
	}

	public static String plusDays(Integer num) {
		LocalDate localDate = LocalDate.now();
		return localDate.plusDays(num).format(dtfMd).toString();
	}

	public static String timeStamp2Date (String timeStamp) {
		Long l = Long.parseLong(timeStamp);
		LocalDateTime now = LocalDateTime.ofInstant(Instant.ofEpochMilli(l), TimeZone.getDefault().toZoneId());
		return dtf.format(now);
	}

	/**
	 * 连续30天的map
	 * @return
	 */
	public static Map<String, Integer> timeFor30Map() {
		String endTime = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		SortedMap<String, Integer> resMap = new TreeMap<>();
		for(int i =0; i < 30; i++) {
			resMap.put((plusDaysForDate(endTime, -i)), 0);
		}
		return resMap;
	}
	public static void main(String[] args) {
		System.out.println(getLocalDateTime());
		System.out.println(isBefore("2020-08-03 14:48:26"));
		System.out.println(getMonthOfYear());
		System.out.println(isTimeBefore("17:00"));
		System.out.println(isTimeAfter("05:00"));
		System.out.println(plusMonth("2020-09-27 10:19:22", 3));
		System.out.println(getDay());
		System.out.println(LocalDate.now().getMonthValue());
		System.out.println(getDayOfMonth(LocalDate.now().plusDays(3)));
		System.out.println(plusHours("2020-09-27 10:19:22", 72));
		System.out.println(countMonth(-1));
		System.out.println(plusDays("2020-08-27 10:19:22", -1));
		System.out.println(countDays(-1));
		System.out.println(plusDaysForDate("2021-01-04", -1));
		System.out.println(LocalDateTime.now().getHour());
		int hour = LocalDateTime.now().getHour();
		String date = "" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + (hour < 10 ? ("0" + hour) : hour) ;
		System.out.println(date);

		System.out.println(plusDays(-1));
		System.out.println(plusDays(0));
		System.out.println(timeStamp2Date("172214104"));

		System.out.println(plusDaysForDate("2021-01-25", -29));
		Map<String, Integer> map = timeFor30Map();
		for (String key : map.keySet()) {
			System.out.println("key:" + key +"value:" + map.get(key));
		}
	}

	
}
