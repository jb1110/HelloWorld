package com.yedam.exception;

/*
 * 1) 일반예외 - 컴파일러가 에러부분을 파악하여알려줌.
 * 2) 실행예외 - 실행시점에 에러가 발생하는경우.
 */
public class ExceptionExe {
	public static void main(String[] args) {
		String numStr = "a";
		int num = 0;
		try {
		num = Integer.parseInt(numStr);
		} catch(NumberFormatException e) {
			// catch구문은 에러가 발생하면 대체할 코드.
			System.out.println("예외발생");
		}
		System.out.println(num);
		
		
		try {
		Class.forName("java.util.Scanner");
		} catch(ClassNotFoundException e) {
			System.out.println("일반예외발생.");
		}
		System.out.println("end of prog.");
	}
}
