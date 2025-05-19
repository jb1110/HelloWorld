package com.yedam.ref;

/*
 * 배열 + 기본타입: 정수, 실수
 * 배열 + 참조타입(클래스): 학생이름, 점수
 */
public class ArrayExe3 {

	static Student[] stdAry;

	public static void main(String[] args) {
		// 배열의 값을 출력.
		init();
		int sum = 0;
		double max = 0;
		Student maxStd = new Student();
		//String maxName = "";
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름:%s 점수:%d \n", stdAry[i].studentName, stdAry[i].score);
		} for (int i = 0; i < stdAry.length; i++) { // 점수 배열 반복
			sum += stdAry[i].score; // 전체 점수 합산
			if (max < stdAry[i].height) { // 큰키, 이름
				max = stdAry[i].height; // 최고점수 갱신
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "키큰학생: %s, 최고점수: %d, 키:%.1f, 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.score, maxStd.height, avg);
//	test();	
	}

	public static void init() {

		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = "남";
		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;
		s2.height = 165.7;
		s2.gender = "여";
		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 187.7;
		s3.gender = "남";
		stdAry = new Student[] { s1, s2, s3 }; // 배열에 값을 할당.
	}

	public static void test() {
		int num = 90;
		// 홍길동, 80
		Student s1 = new Student(); // 인스턴스 생성.
		s1.studentName = "홍길동";
		s1.score = 80;

		// 김민규, 85
		Student s2 = new Student();
		s2.studentName = "김민선";
		s2.score = 85;

		// 홍길동의 점수를 90 변경.
		s1.score = 90;

		// 학생정보를 배열에 저장.
		Student[] students = { s1, s2 };
		students[0].studentName = "홍길도";

		System.out.printf("이름: %s, 점수:%d\n", s1.studentName, s1.score);
	}
}
