package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	private static int i;

	public static void main(String[] args) {
		friendApp();
	}

	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10]; // 친구 배열
		boolean run = true;

		while (run) {
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine()); // 메뉴선택

			switch (menu) {
			case 1: // 추가
	             System.out.print("이름입력>> ");
	             String name = scn.nextLine();
	             // 중복 이름 검사
	             boolean add = false;
	             for (String item : stringAry) {
	                 if (name.equals(item)) {
	                    add = true;
	                     break;
	                 }
	             }
	             //   추가 취소 결정
	             if (add) {
	                 System.out.println("동일한 이름이 존재합니다!");
	                 System.out.print("(1)추가 (2)취소 >> ");
	                 String input = scn.nextLine();
	                 int choice = Integer.parseInt(input);
	                 if (choice != 1) {
	                    System.out.println(">> 추가 취소");
	                    break;
	                 }
	             }
	             for (int i = 0; i < stringAry.length; i++) {
	                 if (stringAry[i] == null) {
	                     stringAry[i] = name;
	                     System.out.println("등록완료.");
	                     break;
	                 }
	             }
	             break; // case 1 종료

				
			case 2: // 목록
				System.out.println("친구목록>> ");
				for (int i = 0; i < stringAry.length; i++) {
					if (stringAry[i] != null) {
						System.out.printf("%d번째: %s\n", i + 1, stringAry[i]);
					}
				}
				break;

			case 3: // 삭제
				System.out.print("삭제할 이름입력>> ");
				String del = scn.nextLine();
				boolean deleted = false;
				for (int i = 0; i < stringAry.length; i++) {
					if (stringAry[i] != null && stringAry[i].equals(del)) {
						stringAry[i] = null;
						deleted = true;
						break;
					}
				}
				
				if (deleted) {
					System.out.println(del + " 삭제 완료.");
				} else {
					System.out.println("찾는 이름이 없습니다.");
				}
				break;

			case 4: // 종료
				System.out.println("end of prog.");
				run = false;
				break;

			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		}
	}

	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10]; // 배열선언
		stringAry[0] = "이정빈";
		stringAry[1] = "백준영";
		stringAry[2] = "차기훈";
		stringAry[3] = "박재훈";

		System.out.println("삭제할 친구 이름>>");
		String name = scn.nextLine();

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null; // 삭제.
			}
		}
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
	}

	// 문자열 배열.
	public static void strAry() {
		Scanner scn = new Scanner(System.in);
		// 배열선언
		String[] stringAry = new String[10];

		while (true) {
			System.out.print("이름을입력>>");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break; // while 문 종료
			}
			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null) 있는지 체크
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공.");
					break;
				}
			} // end of for

		} // end of while

		// 입력값 출력.
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {

				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}
		System.out.println("end of prog.");
	} // end of main.
} // end of class.
