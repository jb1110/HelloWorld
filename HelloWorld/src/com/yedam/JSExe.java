package com.yedam;

import java.util.Scanner;

public class JSExe {
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
		System.out.println(num1 == num2); // 값 비교 (기본형이므로 값 비교)

		String str1 = new String("Hello");
		String str2 = new String("Hello");

		System.out.println(str1); // str1의 문자열 출력
		System.out.println(str2); // str2의 문자열 출력

		System.out.println(str1.equals(str2)); // 문자열 내용 비교는 equals 사용해야 함

//		testrandom(); // testrandom 출력
//		test2(); // test2 출력
//		test(); // test 출력
//		test3();
//		testn();
//		test4();
//		testname();
		test5();
	}

	// 메서드로 따로 정의
	public static void testrandom() {
		int sum = 0;

		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 10) + 1; // 1 ~ 10 임의 값
			sum += result;
		}
		System.out.println("결과: " + sum); // 최종 결과 출력
	} // end of testrandom
	
	public static void test5() {
		// printf ("형식문자열", 값1, 값2...)
//		System.out.printf("%s %.2f\t", "문자", 30.3);
		System.out.printf("%s %d %.1f\t \n", "홍길동", 100, 23.9); //%s 문자, %d 정수 %f 실수
		System.out.printf("안녕하세요.\n %s입니다.\n나이는 %d세입니다.\n몸무게는 %.1f입니다.", "이정빈", 27, 70.5);  
		// "홍길동", 100, 23.9
	} // end of test5
	
//	public static void testn() {
//        String str1 = "hello";
//        String str2 = "hello";
//		String str3 = "30";
//		int num3 = 30;
//		
//		System.out.println(str3.equals("" + num3));
//		int num4 = Integer.parseInt(str3);
//		System.out.println(num3 == num4);
//		System.out.println(str1.equals(str2));
//	} //end of testn.

//	public static void test4() {
//
//		Scanner scn = new Scanner(System.in);
//		while (true) {
//			System.out.println("메세지 입력. 종료하려면 quit>>");
//			String msg = scn.nextLine();
//			// equals로 비교
//			if (msg.equals("quit")) {
//				break;
//			}
//			System.out.println("입력한 값은 " + msg);
//		}
//		System.out.println("end of prog.");
//	} // end of test4

	public static void testname() {

		Scanner scn = new Scanner(System.in);
		String str = "친구목록은 ";
		while (true) {
			System.out.println("친구이름 입력 하시오. 종료하려면 quit>>");
			String msg = scn.nextLine();
			// equals로 비교
			if (msg.equals("quit")) {
				if (str.endsWith(", ")) {
					str = str.substring(0, str.length() - 2);
				}
				str += " 입니다";
				break;
			}
			str += msg + ", ";
		}
		// 홍길동, 김민규, 최석영
		// 친구목록은 홍길동, 김민규, 최석영 입니다.
		System.out.println(str);
	} // end of testname

	public static void test3() {
		// 사용자의 입력값을 읽어들이기.
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine(); // 입력값을 문자열형태로 반환.
//		System.out.println("입력값은 " + value);
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계: " + sum);
		System.out.println("평균: " + avg);
	}

	public static void test2() {
		int sum = 0;

		for (int i = 1; i <= 3; i++) {
			int result = (int) (Math.random() * 71) + 1;
			sum += result;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계: " + sum);
		System.out.println("평균: " + avg);
//		System.out.println(Math.round(23.678 * 100) / 100.0);
	} // end of test2.

	public static void test() {
		int sum = 0;
		// 1 ~ 10까지의 누적하는 반복문.
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) { // 홀수일 경우
				sum += 1; // 1 더함 → 실제로는 홀수의 합이 됨
			}
		}
		System.out.println("결과: " + sum); // 출력: 25 (1 + 3 + 5 + 7 + 9)
	} // end of test.
}
