package com.yedam.condition;

import java.util.Scanner;

public class IfExe {
    public static void main(String[] args) {
        int randomValue = (int) ((Math.random() * 1000) + 1); 
        int ese = 0;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("숫자를 입력하세요 (1 ~ 1000): ");
            int ses = scanner.nextInt();
            ese++;

            if (ses < randomValue) {
                System.out.println("입력값보다 큽니다.");
            } else if (ses > randomValue) {
                System.out.println("입력값보다 작습니다.");
            } else {
                System.out.println("정답입니다!");
                break;
            }
        } // end of while;
        
        System.out.println("총 시도한 횟수: " + ese);
        scanner.close();
    }


	public static void test() {

		int score = 70;

		// if
//		if (score >= 90) {
//			System.out.println("A학점");
//		} else if (score >= 80) {
//			System.out.println("B학점");
//		} else if (score >= 70) {
//			System.out.println("C학점");
//		} else {
//			System.out.println("F학점");
//		}

		score = score / 10;
		switch (score) {
		case 10:
		case 9:
			System.err.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("F학점");
		} // end of switch
	}
}