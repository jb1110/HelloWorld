package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {

		long now = System.currentTimeMillis(); // 현재시간을 1/1000단위로
		System.out.println(now);
		// 1747965344320 => "초" => 몇일, 몇시간, 몇분, 몇초 계싼
		// 60 * 60 * 24 => 1일
		// 60 * 60 => 한시간
		// 60 => 1분
		// 나머지가 초.
		long Seconds = now / 1000; 
		long days = Seconds / (60 * 60 * 24); 
		long hours = (Seconds % (60 * 60 * 24)) / (60 * 60); 
		long minutes = (Seconds % (60 * 60)) / 60; 
		long second = Seconds % 60;
		long years = days / 365 + 1970; 
		System.out.printf("year %d, day %d, hour %d, min %d, sec %d", years, days, hours, minutes, second);
	}

	public static void exe() {
		//
		long start = System.nanoTime();
		int sum = 0;
		for (int i = 0; i < 10000000; i++) {
			sum += i;
		}
		long end = System.nanoTime();
		System.out.printf("합계 %d, 걸린시간 %d\n", sum, (end - start));
	}
}
