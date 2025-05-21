package com.yedam.board;

//Board class// 글번호, 제목, 내용, 작성자.
//getter, setter 작성 :메소드.
//기본생성자, 전체매개값을 갖는 생성자 하나만들기.
// 필드는 private으로.
public class Board {
	private int boardNo; // 글번호
	private String title; // 제목
	private String content; // 내용
	private String writer; // 작성자

	public Board() {
	}

	public Board(int boardNo, String title, String content, String writer) {
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	// 글번호, 제목, 작성자 => 간략출력메소드.
	public void showInfo() {
		System.out.printf("%3d %-12s %-4s\n", boardNo, title, writer);
	}
	// 상세보기.
	public void showAllInfo() {
		// 글번호: 5    작성: 홍길동
		// 제목: 날씨가 좋아요
		// 내용: 오늘 30도가 넘는데도 좋아요.
		String strFormat = " 글번호: %d    작성: %s\n";
		strFormat += " 제목: %s\n";
		strFormat += " 내용: %s";
		System.out.printf(strFormat, boardNo, writer, title, content);
	}
	
	

}
