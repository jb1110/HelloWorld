package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * 인덱스를 사용하여 객체를 관리
 * 순서를 가지고 중복된 값 가능.
 */

class Student {
	private int studentNo; // 1001, 1002, 1003...1010;
	private int score;
	public Student (int studentNo, int score) {
		this.studentNo = studentNo;
		this.score = score;
	}
	public int getScore () {
		return score;
	}
	
}




public class ListExe {
	public static void main(String[] args) {
        // 10 ~ 100 점 점수를 임의의 값으로 생성. 정수10개 생성.
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int score = random.nextInt(91) + 10; 
            numbers.add(score);
        }

    
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        int avg = sum / numbers.size();

        System.out.println("점수들: " + numbers);
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
    }


	
	    
	
	
		
		public static void exe() {
		// 인터페이스 = 구현클래스
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add(new String("Hello"));

		// 위치지정 ㄱㄴ
		list.add(1, "2340320");

		// 삭제
		list.remove(0);
		// 변경
		list.set(1, "World");
		
		
		

		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
		for (Object item : list) {
//			String result = (String) item;
			System.out.println(item);
		}
	}
}
