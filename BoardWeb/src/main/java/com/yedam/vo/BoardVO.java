package com.yedam.vo;

import java.util.Date;

import lombok.Data;

/*
 * 필드, 생성자, 메소드(getter/setter)
 * lombok 라이브러리 사용(설치 및 필요한 라이브러리 가져와야함)
 */
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class BoardVO {
  private int boardNo;
  private String title;
  private String content;
  private String writer;
  private Date writeDate;
  private int readCnt;
  
  
  
}
