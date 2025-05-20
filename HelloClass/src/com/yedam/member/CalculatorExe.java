package com.yedam.member;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
      Calculator cal = new Calculator();  //  인스턴스생성
      int num1 = 10;
      String str = "✨";
      String result = cal.printStar(num1, str);  // 매개값
      System.out.println(result);
      
      
      double sum = cal.add(num1, 10.5);
      
      int[] numAry = { 10, 20, 30 };
      sum = cal.add(numAry);
      
      // Member[] 중에서 point가 큰 회원을 반환
      Member[] members = {new Member("user01", "홍길동", "1111", 1000), 
      		new Member("user02", "김민규", "2222", 2200), 
      		new Member("user03", "황선흥", "3333", 2700), 
      		new Member("user04", "홍명보", "4444", 1900)};
      
      // 반환유형(Member), 매개변수(Member[]) => 포인트가 많은 사람을 반환
      Member member = cal.getMaxPoint(members);
      System.out.println(member);
      member.showInfo();

      System.out.println("10");
      System.out.println(10);
      System.out.println(true);
	}
}