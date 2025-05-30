package service;

import java.util.Scanner;

public class AdminService {
	private static Scanner scn = new Scanner(System.in);

	public static void AdminMenu() {
		boolean run = true;

		while (run) {
			System.out.println("""
					====================================
					        ✈ 관리자 메뉴
					====================================
					1.항공편 등록  2.항공편 조회  3.항공편 삭제
					4.공항 등록   5.공항 조회    6.공항 삭제
					7.종료 (메인메뉴)
					------------------------------------
					""");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 항공편 등록
				FlightService.dbFlyght();
				break;
			case 2:
				FlightService.dbFlyghtList();
				break;
			case 3:
				FlightService.deleteFlight();
				break;
			case 4:
				AirportService.dbAirport();
				break;
			case 5:
				AirportService.dbAirportList();
				break;
			case 6:
				AirportService.deleteAirpot();
				break;
			case 7:
				run = false;
				break;
			default:
				System.out.println("등록되어있지 않은 메뉴입니다.");
			}
		}
	}
}
