package app;

import service.AdminService;
import service.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("""
                =====================================
                         ✈ 항공권 예약 프로그램
                =====================================
                           1. 항공권 예약
                           2. 관리자 전용
                           3. 프로그램 종료
                ------------------------------------
                """);
            System.out.print("메뉴 선택: ");

            int mainmenu = 0;
            try {
            	mainmenu = Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력하세요!");
                continue;
            }

            switch (mainmenu) {
                case 1:
                	UserService.UserMenu();
                    break;
                case 2:
                    AdminService.AdminMenu(); // 관리자 메뉴 호출
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 선택하세요.");
            }
        }

        scn.close(); // Scanner 닫기
    }
}
