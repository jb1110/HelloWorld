package service;

import domain.Flight;
import util.DBUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FlightService {

	// DB에 항공편 등록
	public static boolean registerFlight(Flight flight) {
		DBUtil db = new DBUtil(); // DBUtil 인스턴스 생성
		db.connect(); // 연결

		String sql = "INSERT INTO flight (flight_id, flight_number, departure_id, arrival_id, departure_time, arrival_time, seat_capacity) "
				+ "VALUES (flight_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement ptmt = db.getPreparedStatement(sql);

			ptmt.setString(1, flight.getFlightNumber());
			ptmt.setInt(2, flight.getDepartureId());
			ptmt.setInt(3, flight.getArrivalId());
			ptmt.setTimestamp(4, new java.sql.Timestamp(flight.getDepartureTime().getTime()));
			ptmt.setTimestamp(5, new java.sql.Timestamp(flight.getArrivalTime().getTime()));
			ptmt.setInt(6, flight.getSeatCapacity());

			int rows = ptmt.executeUpdate();
			return rows > 0;

		} catch (SQLException e) {
			System.err.println("🚫 항공편 등록 오류: " + e.getMessage());
			return false;

		} finally {
			db.disConnect(); // 자원 해제
		}
	}

	public static void dbFlyght() {
		Scanner scn = new Scanner(System.in);

		try {
			Flight flight = new Flight();

			System.out.print("항공편 번호: ");
			flight.setFlightNumber(scn.nextLine());

			System.out.print("출발 공항 ID: ");
			flight.setDepartureId(Integer.parseInt(scn.nextLine()));

			System.out.print("도착 공항 ID: ");
			flight.setArrivalId(Integer.parseInt(scn.nextLine()));

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			System.out.print("출발 시간 (yyyy-MM-dd HH:mm): ");
			Date departureTime = sdf.parse(scn.nextLine());
			flight.setDepartureTime(departureTime);

			System.out.print("도착 시간 (yyyy-MM-dd HH:mm): ");
			Date arrivalTime = sdf.parse(scn.nextLine());
			flight.setArrivalTime(arrivalTime);

			System.out.print("좌석 수: ");
			flight.setSeatCapacity(Integer.parseInt(scn.nextLine()));

			boolean success = registerFlight(flight);
			if (success) {
				System.out.println("✅ 항공편이 성공적으로 등록되었습니다.");
			} else {
				System.out.println("❌ 항공편 등록에 실패했습니다.");
			}

		} catch (ParseException e) {
			System.out.println("⚠ 날짜 형식이 올바르지 않습니다. 다시 시도하세요.");
		} catch (NumberFormatException e) {
			System.out.println("⚠ 숫자를 올바르게 입력하세요.");
		}
	}

	public static void dbFlyghtList() {
		DBUtil db = new DBUtil();
		db.connect();

		String sql = """
				    SELECT
				        f.flight_number,
				        a1.name AS departure_name,
				        a2.name AS arrival_name,
				        f.departure_time,
				        f.arrival_time,
				        f.seat_capacity
				    FROM flight f
				    JOIN airport a1 ON f.departure_id = a1.airport_id
				    JOIN airport a2 ON f.arrival_id = a2.airport_id
				    ORDER BY f.flight_number
				""";

		try {
			PreparedStatement psmt = db.getPreparedStatement(sql);
			ResultSet rs = psmt.executeQuery();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			System.out.println("========== 항공편 목록 ==========");
			System.out.printf("%-15s %-20s %-20s %-20s %-20s %-10s\n", "항공편번호", "출발공항", "도착공항", "출발시간", "도착시간", "좌석수");
			System.out.println(
					"------------------------------------------------------------------------------------------------------");

			while (rs.next()) {
				String flightNumber = rs.getString("flight_number");
				String departureName = rs.getString("departure_name");
				String arrivalName = rs.getString("arrival_name");

				String departureTime = sdf.format(rs.getTimestamp("departure_time"));
				String arrivalTime = sdf.format(rs.getTimestamp("arrival_time"));

				int seatCapacity = rs.getInt("seat_capacity");

				System.out.printf("%-15s %-20s %-20s %-20s %-20s %-20d\n", flightNumber, departureName, arrivalName,
						departureTime, arrivalTime, seatCapacity);
			}

		} catch (SQLException e) {
			System.out.println("🚫 항공편 목록 조회 실패: " + e.getMessage());
		} finally {
			db.disConnect();
		}
	}

	public static void deleteFlight() {
		Scanner scn = new Scanner(System.in);
		System.out.print("삭제할 항공편 번호를 입력하세요: ");
		String flightNumber = scn.nextLine();

		DBUtil db = new DBUtil();
		db.connect();

		String sql = "DELETE FROM flight WHERE flight_number = ?";

		try {
			PreparedStatement psmt = db.getPreparedStatement(sql);
			psmt.setString(1, flightNumber);

			int rows = psmt.executeUpdate();
			if (rows > 0) {
				System.out.println("✅ 항공편이 성공적으로 삭제되었습니다.");
			} else {
				System.out.println("❌ 해당 항공편 번호를 찾을 수 없습니다.");
			}

		} catch (SQLException e) {
			System.out.println("🚫 항공편 삭제 오류: " + e.getMessage());
		} finally {
			db.disConnect();
		}
	}

}
