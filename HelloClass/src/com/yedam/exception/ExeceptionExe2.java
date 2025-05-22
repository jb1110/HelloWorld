package com.yedam.exception;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExeceptionExe2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.메뉴 2.종료");
			System.out.print("선택>> ");
			int menu = 0;
			
			while (true) {
				try {
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException | NoSuchElementException e) {
					System.out.println("1.메뉴 2.종료");
					System.out.println("메뉴다시선택해");
					
					continue;
				}
				break;
			}

			switch (menu) {
			case 1:
				백업();
				break;
			case 2:
				run = false;
			default:
				System.out.println("없는 메뉴를 선택해서 종료합니다.");
				run = false;
			}
		}
		System.out.println("end of prog");
	}

	public static void 백업() {
		// NullPointerException
		// NumberFormatException
		// ClassCastException
		// ArrayIndexOutOfBoundsException
		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine();
		try {
			System.out.print(str.toString());
			int num = Integer.parseInt("a");
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("Null 값을 참조.");
//		} catch (NumberFormatException e) {
//			System.out.println("포맷이 비정상.");
		} finally {
			// 정상실행, 예외발생 반드시 실행해야할 코드 .
			scanner.close(); // 사용한 리소스를 반환.
		}

		System.out.println("end of prog");
	}
}
