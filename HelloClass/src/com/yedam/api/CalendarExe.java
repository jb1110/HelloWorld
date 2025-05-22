package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Calendar: 날짜, 시간 관련.
 * Date: 날짜, 시간,
 */
public class CalendarExe {
	public static void main(String[] args) {

	}
	
	// 달력
	public static void makeCalendar(int year, int month) {
		
		
		System.out.println("=============================");
		System.out.printf("        %d년 %02d월 \n", year, month);
		System.out.println("=============================");
		
	}
	
	
	

	public static void date() {
		Date today = new Date();
		System.out.println(today.toString()); ////// "YYYY년MM월dd HH시mm분ss초"
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // 생성자의 매개값으로 포맷 지정.
		String timeStr = sdf.format(today);
		System.out.println(timeStr);

		try {
			today = sdf.parse("2025-08-01 09:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static void cal() {
		// Calendar 클래스.
		Calendar now = Calendar.getInstance();

		// 시간변경.
		now.set(2025, 0, 1);
		now.set(Calendar.YEAR, 2024);

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;

		}

		System.out.printf("%d년도, %d월, %d일, %d요일, %d말일", now.get(Calendar.YEAR), now.get(Calendar.MONTH),
				now.get(Calendar.DATE), now.get(Calendar.DAY_OF_WEEK), now.getActualMaximum(Calendar.DATE));

	}
}
