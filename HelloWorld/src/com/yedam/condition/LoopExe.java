package com.yedam.condition; // 패키지 선언

import java.util.Scanner; // Scanner 클래스를 사용하기 위한 import

public class LoopExe { // LoopExe 클래스 정의 시작

	// main 메서드: 프로그램 시작점
	public static void main(String[] args) {
		game2(); // game2() 메서드 호출
	}

	// 각 경우(가위, 바위, 보)에 따라 승패를 판별하는 메서드
	public static void game1() {
		Scanner scn = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성
		while (true) { // 무한 반복
			int systemValue = (int) (Math.random() * 3) + 1; // 컴퓨터가 1~3 중 랜덤한 숫자 선택 (가위, 바위, 보)
			System.out.println("\n가위(1), 바위(2), 보(3) 입력. 종료는 4"); // 안내 메시지 출력
			System.out.print("선택>> "); // 사용자 입력 유도 메시지 출력
			int myValue = Integer.parseInt(scn.nextLine()); // 사용자 입력을 정수로 변환해서 저장

			if (myValue == 4) { // 입력값이 4이면 종료
				System.out.println("종료합니다."); // 종료 메시지 출력
				break; // 반복문 종료
			}

			if (systemValue == myValue) { // 컴퓨터와 내가 같은 값을 냈다면
				System.out.println("You Same."); // 비겼다는 메시지 출력
				continue; // 다음 반복으로 넘어감
			}

			// 컴퓨터가 가위인 경우
			if (systemValue == 1) {
				if (myValue == 2) { // 내가 바위면 이김
					System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
				} else { // 그 외는 짐
					System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
				}
			} else if (systemValue == 2) { // 컴퓨터가 바위인 경우
				if (myValue == 3) { // 내가 보면 이김
					System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
				} else { // 그 외는 짐
					System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
				}
			} else if (systemValue == 3) { // 컴퓨터가 보인 경우
				if (myValue == 1) { // 내가 가위면 이김
					System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
				} else { // 그 외는 짐
					System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
				}
			}
		} // while문 끝

		System.out.println("end of prog."); // 프로그램 종료 메시지 출력
	} // game1 메서드 끝

	// 가위, 바위, 보의 값 차이(diff)를 이용한 간단한 승패 판별 로직
	public static void game2() {
		Scanner scn = new Scanner(System.in); // 사용자 입력을 위한 Scanner 객체 생성
		while (true) { // 무한 반복
			int systemValue = (int) (Math.random() * 3) + 1; // 컴퓨터가 낼 값(1~3 중 무작위)
			System.out.println("\n가위(1), 바위(2), 보(3) 입력. 종료는 4"); // 안내 메시지
			System.out.print("선택>> "); // 사용자 입력 유도 메시지
			int myValue = Integer.parseInt(scn.nextLine()); // 사용자 입력값 저장

			if (myValue == 4) { // 입력값이 4이면
				System.out.println("종료합니다."); // 종료 메시지 출력
				break; // 반복문 종료
			}

			int diff = systemValue - myValue; // 컴퓨터 값과 사용자 값의 차이를 계산

			if (diff == 0) { // 같으면 비김
				System.out.println("You Same.");
				continue; // 다음 반복으로 넘어감
			}

			// 승리 조건: 차이가 -1 또는 2
			if (diff == -1 || diff == 2) {
				System.out.printf("%s : Computer: %d, You: %d\n", "You win.", systemValue, myValue);
			} else { // 그 외는 패배
				System.out.printf("%s : Computer: %d, You: %d\n", "You lost.", systemValue, myValue);
			}
		} // while문 끝

		System.out.println("end of prog."); // 프로그램 종료 메시지
	} // game2 메서드 끝

	// while과 do-while의 차이점을 보여주는 테스트 메서드
	public static void test() {
		boolean run = false; // 실행 여부를 제어하는 변수

		// 아래 주석처리된 while문은 조건이 false이므로 실행되지 않음
		// while (run) {
		// System.out.println("while문");
		// run = !run;
		// }

		// do-while문은 조건과 상관없이 최소 1회는 실행됨
		do {
			System.out.println("while문"); // 실행 메시지 출력
			run = !run; // run 값을 반대로 변경(true로)
		} while (run); // 조건 검사: run이 true면 반복

		System.out.println("end of prog."); // 종료 메시지 출력
	}
} // LoopExe 클래스 끝