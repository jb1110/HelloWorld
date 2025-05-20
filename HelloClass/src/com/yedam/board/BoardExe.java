package com.yedam.board;

import java.util.Scanner;

/*
 * 추가/수정/삭제/목록
 */
public class BoardExe {
	// 필드
	private Board[] boards; // 데이터 저장.
	private Scanner scn = new Scanner(System.in);
	private int bno = 2;  // 배열 인덱스를

	// 생성자.
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다", "오늘기온이 34도입니다","홍길동"); // 샘플데이터
		boards[1] = new Board(11, "자바는 어려워", "진짜 너무어려워","이정빈"); // 샘플데이터
	}

	// 메소드.
	void execute() {
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------");
			System.out.println("1.추가 2.수정 3.삭제 4.목록보기 5.종료");
			System.out.println("-------------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;
			case 2: // 수정
				break;
			case 3: // 삭제
				break;
			case 4: // 목록
				boardList();
				break;
			case 5: // 종료.
				break;
			default:
				System.out.println("메뉴룰 다시 선택하세요.");
			} // end of switch
		} // end of while
	} // end of execute.

	// 기능
	// "글번호를 입력하세요>> " 1눌리고
	// "제목을 입력하세요>> " 오늘은 덥네요.
	// "내용을 입력하세요>> " 오늘은 기온이 30도가 넘습니다.
	// "작성자를 입력하세요>> " 홍길동 다적었으면
	// "추가성공" 추가실패하면
	// "추가실패" 메세지출력

	void addBoard() {
		System.out.print("글번호를 입력하세요>> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("제목을 입력하세요>> ");
		String title = scn.nextLine();
		System.out.print("내용을 입력하세요>> ");
		String content = scn.nextLine();
		System.out.print("작성자를 입력하세요>> ");
		String writer = scn.nextLine();
		// Board인스턴스 선언하고 값을 지정.
		Board board = new Board(no, title, content, writer);
		// 배열에 저장.
		boards[bno++] = board;
		System.out.println("추가성공");
	} // end of addBoard

	// 기능
	// 글번호 제목 작성자
	// ===========================
	// 1 날씨가 좋아요 홍길동
	// 2 클래스 멋지다 김민규
	// 3 자바는 어려워 박석민
	// 4 그래도 열심히 김민규
	// ---------------------------
	// 상세보기: 글번호입력, 메뉴로 이동(q)
	// ---------------------------

	// ** 등록된 글이 없습니다. **

	void boardList() {
		if (bno == 0) {
			System.out.println("    **등록된 글이 없습니다.**  ");
			return;
		}
		System.out.println("  글번호  제목          작성자");
		System.out.println("===========================");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				boards[i].showInfo();
			}
		}
		// 상세보기.
		System.out.println("---------------------------");
		System.out.println("상세보기: 글번호입력, 메뉴로 이동(q)");
		System.out.println("---------------------------");
		String str = scn.nextLine();
		if (str.equals("q")) {
			return;
		} else {
			int no = Integer.parseInt(str); // no = 글번호
			// 배열에서 조회.
			for (int i = 0; i < boards.length; i++) {
				if (boards[i] != null && boards[i].getBoardNo() == no) {
					boards[i].showAllInfo();
				}
			}
		}
		System.out.println();
	}
}
