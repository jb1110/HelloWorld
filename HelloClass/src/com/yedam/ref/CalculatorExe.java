package com.yedam.ref;

public class CalculatorExe {
	public static void main(String[] args) {
		int a = 20, b = 30;

		// sum 의 기능황룡.
		Calculator c1 = new Calculator();
		c1.sum(a, b); // 정적 메소드.

		Calculator.sum(a, b);

		printStar();
		
//		CalculatorExe ce = new CalculatorExe();
//		ce.printStar();
	}

	static void printStar() {
		System.out.println("★");

	}
}
