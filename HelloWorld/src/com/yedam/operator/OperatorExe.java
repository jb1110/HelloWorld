package com.yedam.operator;

public class OperatorExe {

	public static void main(String[] args) {
		test5();
	}

	// 연습 7
	public static void test5() {
		String pass = "";
		int score = (int) (Math.random() * 100);
//		if (score > 60) {
//			pass = "합격";
//		} else {
//			pass = "불합격";
//		}
		pass = (score > 80) ? "우수" : ((score > 60) ? "합격" : "불합격");
		System.out.printf("%d점은 %s\n", score, pass);
	} // end of test5

	// 연습 6
	// "월" 정보를 입력하면 "공란" 반환하는 메소드. getSpace()
	public static int getSpace(int month) {
		int space = 0;
		if (month == 3) {
			space = 6;
		} else if (month == 4) { // 4월
			space = 2;
		} else if (month == 5) { // 5월
			space = 4;
		} else if (month == 7) { // 6월
			space = 2;
		}
		return space;
	} // end of getSpace.

	// 연습 7.
	// "월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	} // end of LastDate

	// 연습 5. 달력
	public static void test4() {
		int mon = 7; // 월정보 입력...
		System.out.println(mon);
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);

		// 빈공간.
		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}
		// 날짜출력
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day); // 4개의 ___ 안에다 숫자나열.
			if ((day + space) % 7 == 0) {
				System.out.println();
			}
		}
	} // end of test4

	// 연습 4. 토글기능 알아보기.
	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글기능. (on -> off, off -> on)
		}
	} // end of test3

	// 연습 3.
	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++; // 연산자를 앞에붙이냐 뒤에붙이냐의 차이 알아보기.
		System.out.printf("num1 => %d, num2 => %d, result => %d", num1, num2, result);

		boolean isTrue = true;
		// 논리,부정 연산자 ! 알아보기.
		if (!isTrue) {
			System.out.println(" 참입니다.");
		}
		// 같다라는 (==) 값의 논리부정은 !=, > 부정은 <=, >= 부정은 <.
		result = 30;
		if (!(result != 30)) {
			System.out.println("\nresult 는 30보다 작거나 같다.");
		}

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 => %d", num1);
		}
	} // end of test2

	// 연습 2.
	// byte, short, int, long, char 정수형 데이터타입.
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2); // 정수연산의 기본타입은 int.
		System.out.println(sum);

		long num3 = 10000000000L; // L을 붙여야 long 으로 인식
		long num4 = 100L;
		System.out.println(Integer.MAX_VALUE); // int의 최대값: 2147483647
	} // end of test1

	// 연습1.
	public static void test() {
		// 증가, 감소 연산자 (++, --)
		byte num1 = -128; // byte 1바이트 , short 2바이트, int 4바이트, long 8바이트
		num1 = 127; // 128이상은 오류
		num1++;
		System.out.println(num1);

		char ch1 = 'A'; // 65
		ch1 = 66; // B
		ch1 = '가'; // 유니코드.
		ch1 = 'a';
		ch1 = 'A';
		ch1 = 0x29D7;
		for (int i = 1; i <= 26; i++) {
			System.out.println(ch1++);
		} // end of test
	}
} // end of main
