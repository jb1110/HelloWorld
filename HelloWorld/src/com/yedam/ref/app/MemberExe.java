package com.yedam.ref.app;

import java.util.Scanner;

/*
 * 회원 추가, 수정, 삭제, 조회 기능.
 * 1) 추가
 * 	  - 아이디, 이름, 전화번호, 포인트
 * 2) 수정
 *    - 아이디 검색후
 *    - 전화번호 (바뀔항복)
 * 3) 삭제
 *    - 아이디 
 *    아이디가없을시에는 "삭제할 아이디가 올바르지않습니다."
 * 4) 조회
 *    - 이름 (조회)
 */
public class MemberExe {
	static Member[] link = null;

	public static void main(String[] args) {
		boolean run = true;
		int member = 0;
		Scanner scanner = new Scanner(System.in);
		int selectNo = Integer.parseInt(scanner.nextLine());
		while (run) {
			System.out.println("----------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.조회 5.종료");
			System.out.println("----------------------------");
			System.out.print("선택>> ");
		}
		if (selectNo == 1) {
			System.out.print("추가>> ");
			member = Integer.parseInt(scanner.nextLine());
			link = new Member[member];
			System.out.println("아이디를 적어주세요");
			String uid = scanner.nextLine();
			System.out.println("이름을 적어주세요");
			System.out.println("전화번호를 적어주세요.");
			System.out.println("포인트 입력.");
			
		} else if (selectNo == 2) {
			
		} else if (selectNo == 3) {
			
		} else if (selectNo == 4) {
			
		}
	}
}