package service;

import java.util.Scanner;

public class UserService {

	public static void UserMenu() {
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("""
					==========================================
					      ✈ 항공권 예약, 조회
					==========================================
					  1. 항공권 예약    2. 예약 확인    3. 예약 취소
					  4. 항공편 목록    5. 메인 메뉴     6. 종료
					------------------------------------------
					""");

			System.out.print("선택>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("⚠ 숫자를 올바르게 입력하세요.");
				continue;
			}

			switch (menu) {
			case 1: // 예약
				BookingService.bookTicket();
				break;
			case 2: // 예약확인
				BookingService.checkbooking();
				break;
			case 3: // 예약취소
				BookingService.cancelbooking();
				break;
			case 4: // 항공편목록
				FlightService.dbFlyghtList();
				break;
			case 5: // 메인메뉴
				run = false; 
				break;
			case 6:
				System.out.println("👋 프로그램을 종료합니다.");
				break;
			default:
				System.out.println("⚠ 등록되어 있지 않은 메뉴입니다.");
			}
		}
	}
}
