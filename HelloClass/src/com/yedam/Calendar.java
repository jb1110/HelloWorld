package com.yedam;


		// Sun Mon Tue Wed Thd Fri Sat
		// ===========================
		// 1 2 3
		// 4 5 6 7 8 9 10


	public class Calendar {
		static void showMonth() {
			int startDay = 3; // 수요일 (0: Sun, 1: Mon, ..., 6: Sat)
			int daysInMonth = 31;

			System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
			System.out.println("================================");


			for (int i = 0; i < startDay; i++) {
				System.out.print("    ");
			}


			for (int day = 1; day <= daysInMonth; day++) {
				System.out.printf("%4d", day);
				if ((startDay + day) % 7 == 0) {
					System.out.println();
				}
			}

			System.out.println(); // 줄바꿈

		}
	}

