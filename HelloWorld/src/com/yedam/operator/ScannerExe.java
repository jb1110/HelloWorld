package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌의 금액.
		while (true) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			int menu = Integer.parseInt(scn.nextLine()); // Integer.parseInt("30");
			if (menu == 1) {
				System.out.print("입금액을 입력>> ");
				int mem = Integer.parseInt(scn.nextLine());
				if (mem > 0) {
					balance += mem;
					System.out.println(mem + "원이 입금되었습니다.");
				} else {
					System.out.println("입금액은 0보다 커야 합니다.");
				}
			} else if (menu == 2) {
				System.out.print("출금액을 입력>> ");
				int mem = Integer.parseInt(scn.nextLine());
				if (mem > balance) {
					System.out.println("잔액이 부족합니다. 현재잔액: " + balance + "원");
				} else if (mem <= 0) {
					System.out.println("출금액은 0보다 커야 합니다.");
				} else {
					balance -= mem;
					System.out.println(mem + "원이 출금되었습니다.");
				}
				// 출금기능구현
			} else if (menu == 3) {
				System.out.println("현재잔액>> " + balance + "원");
			
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1 ~ 4번중에 선택하세요.");
			}
		} // end of while
		System.out.println("end of prog.");
	} // end of main

}
