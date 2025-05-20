package com.yedam;

/*
 * 라이브러리 클래스
 */
public class Student {
	// 필드(속성)
	private int studentNo;
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;

	// 생성자(객체: instance의 초기화)
	// 초기화를 하지 않으면 자동으로 만들어줌
	// 반드시 하는 편이 좋음
	public Student() {
//	  // 매개값이 없는 생성자 => 기본생성자
//	  // 컴파일러가 자동으로 생성
	}

	public Student(int studentNo, String studentName) {
		this.studentNo = studentNo; // 첫번째 매개값은 학생번호 할당
		this.studentName = studentName; // 두번째 매개값은 학생이름 할당
	}
	
	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	// 메소드(기능)
	void study() {
		System.out.println("공부를 합니다.");
	}

	void introduce() {
		System.out.printf("학번은 %d이고 이름은 %s\n", studentNo, studentName);
	}

	// 학번, 학생명 (Setter / Getter)
	
	  // Setter
	void setStudentNo(int studentNo) {
		this.studentNo=studentNo;
	}
	
      // Getter	
	  // 학번을 반환
	int getStudentNo() {
		return studentNo;
	}
	
	void setStudentName(String studentName) {
		this.studentName=studentName;
	}

	String getStudentName() {
		return studentName;
	}
	
	// 영어, 수학점수 (Setter / Getter)
	void setEngScore(int engScore) {
		if (engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore=engScore;
	}
	
	int getEngScore() {
		return engScore;
	}
	
	void setMathScore(int mathScore) {
		if (mathScore < 0 || mathScore > 100) {
			return;
		}
		this.mathScore=mathScore;
	}
	
	int getMathScore() {
		return mathScore;
	}
}
