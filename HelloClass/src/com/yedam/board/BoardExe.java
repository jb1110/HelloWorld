package com.yedam.board;

import java.util.Scanner;

/*
 * 추가: addBoard
 * 수정: modifyBoard - 글번호, 바뀔내용, 바뀔제목
 * 삭제: removeBoard - 글번호, 
 * 목록: boardList - 상세화면 조회
 * 순번부여방법: nextSequence - 현재 글 번호 + 1
 * 조회기능 (글번호입력시 글반환.) getBoard
 */
public class BoardExe {
	// 필드
	private Board[] boards; // 데이터 저장.
	private Scanner scn = new Scanner(System.in);
	private int bno = 2; // 배열 인덱스를

	// 생성자.
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "날씨가 좋습니다", "오늘기온이 34도입니다", "홍길동"); // 샘플데이터
		boards[1] = new Board(11, "자바는[11] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[2] = new Board(12, "자바는[12] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[3] = new Board(13, "자바는[13] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[4] = new Board(14, "자바는[14] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[5] = new Board(15, "자바는[15] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[6] = new Board(16, "자바는[16] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[7] = new Board(17, "자바는[17] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[8] = new Board(18, "자바는[18] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[9] = new Board(19, "자바는[19] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터
		boards[10] = new Board(20, "자바는[20] 어려워", "진짜 너무어려워", "이정빈"); // 샘플데이터

	}

	// 메소드.
	void execute() {
		boolean run = true;
		// 아이디 입력.
		// 비밀번호 입력.

		UserExe.login(null, null);
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
				modifyBoard();
				break;
			case 3: // 삭제
				removeBoard();
				break;
			case 4: // 목록
				boardList();
				break;
			case 5: // 종료.
				run = false;
				System.err.println("시스템 종료");
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
		int no = nextSequence();// Integer.parseInt(userMessage("글번호를 입력하세요 "));
		String title = userMessage("제목을 입력하세요 ");
		String content = userMessage("내용을 입력하세요 ");
		String writer = userMessage("작성자를 입력하세요 ");
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
//		sort();
		int page = 1;
		// while 반복.
		while (true) {
			int start = (page - 1) * 5;
			int end = page * 5;
			if (bno == 0) {
				System.out.println("    **등록된 글이 없습니다.**  ");
				return;
			}
			System.out.println("  글번호  제목          작성자");
			System.out.println("===========================");
			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
				}
			}
			// 상세보기.
			System.out.println("---------------------------");
			System.out.println("상세보기: 글번호입력,(다음:n) (이전:p) 메뉴로 이동(q)");
			System.out.println("---------------------------");
			String str = scn.nextLine();
			if (str.equals("q")) {
				break;
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("p")) {
				page--;
			} else {
				int no = Integer.parseInt(str); // no = 글번호
				// 배열에서 조회.
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회결과 없음.");
					return;
				}
				sboard.showAllInfo();
			}
		} // end of while
		System.out.println();
	} // end of boardList

	// 수정
	void modifyBoard() {
		int bno = userMenu("수정할 글 번호 입력");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}
		String title = userMessage("수정할 제목을 입력");
		String content = userMessage("수정할 내용을 입력");
		// 제목과 내용 변경.
		result.setContent(content);
		result.setTitle(title);
		System.out.println("수정 완료.");
	} // end of modifyBoard

	void removeBoard() {
		int delNo = userMenu("삭제할 글 번호 입력");
		Board result = getBoard(delNo);
		if (result == null) {
			System.out.println("삭제할 내용이 없습니다.");
			return;
		}

		for (int i = 0; i < bno; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == delNo) {
				for (int d = i; d < bno - 1; d++) {
					boards[d] = boards[d + 1];
				}
				boards[--bno] = null;
				System.out.println("삭제 완료.");
				return;
			}
		}
	}

	// 단건조회(getBoard)
	// 글번호를 활용하여 배열에서 조회하고 Board타입 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}
		return null; // 조건에 맞는 글번호 없으면 null값 반환.
	} // end of getBoard

	// 사용자의 입력값을 반환해주는 메소드.
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	} // userMessage 문자열 반환

	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	} // 정수값 반환 // end of userMenu

	// 순번생성
	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;

	}// end of nextSequence

	void sort() {
		Board temp = null;
		for (int j = 0; j < boards.length - 1; j++) {
			for (int i = 0; i < boards.length - 1; i++) {
				if (boards[i + 1] == null) {
					continue;
				}
				if (boards[i] == null) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
					continue;
				}
				if (boards[i].getBoardNo() < boards[i + 1].getBoardNo()) {
					temp = boards[i];
					boards[i] = boards[i + 1];
					boards[i + 1] = temp;
				}
			}
		}
	} // end of sort.
	
} // end of class
