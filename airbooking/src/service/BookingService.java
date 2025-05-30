package service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

import util.DBUtil;

public class BookingService {

    // 항공권 예약
    public static void bookTicket() {
        Scanner scn = new Scanner(System.in);

        System.out.print("예약할 항공편 번호: ");
        String flightNumber = scn.nextLine();

        System.out.print("승객 이름: ");
        String name = scn.nextLine();

        System.out.print("국가: ");
        String country = scn.nextLine();

        System.out.print("예약할 좌석 번호 (예: S1): ");
        String seatNumber = scn.nextLine();

        DBUtil db = new DBUtil();
        db.connect();

        try {
            // 1. flight_id, 좌석 수 조회
            String flightSql = "SELECT flight_id, seat_capacity FROM flight WHERE flight_number = ?";
            PreparedStatement flightStmt = db.getPreparedStatement(flightSql);
            flightStmt.setString(1, flightNumber);
            ResultSet flightRs = flightStmt.executeQuery();

            if (!flightRs.next()) {
                System.out.println("❌ 해당 항공편 번호를 찾을 수 없습니다.");
                return;
            }

            int flightId = flightRs.getInt("flight_id");
            int seatCapacity = flightRs.getInt("seat_capacity");

            flightRs.close();
            flightStmt.close();

            // 2. 해당 좌석이 이미 예약되었는지 확인
            String seatCheckSql = "SELECT COUNT(*) FROM reservation WHERE flight_id = ? AND seat_number = ?";
            PreparedStatement seatCheckStmt = db.getPreparedStatement(seatCheckSql);
            seatCheckStmt.setInt(1, flightId);
            seatCheckStmt.setString(2, seatNumber);
            ResultSet seatCheckRs = seatCheckStmt.executeQuery();
            if (seatCheckRs.next() && seatCheckRs.getInt(1) > 0) {
                System.out.println("❌ 이미 예약된 좌석 번호입니다.");
                return;
            }
            seatCheckRs.close();
            seatCheckStmt.close();

            // 3. 승객이 이미 예약한 내역이 있는지 확인 (이름 기준)
            String passengerCheckSql = """
                SELECT COUNT(*)
                FROM reservation r
                JOIN passenger p ON r.passenger_id = p.passenger_id
                WHERE p.name = ? AND r.flight_id = ?
            """;
            PreparedStatement passengerCheckStmt = db.getPreparedStatement(passengerCheckSql);
            passengerCheckStmt.setString(1, name);
            passengerCheckStmt.setInt(2, flightId);
            ResultSet passengerCheckRs = passengerCheckStmt.executeQuery();
            if (passengerCheckRs.next() && passengerCheckRs.getInt(1) > 0) {
                System.out.println("❌ 동일한 승객 이름으로 이미 예약된 좌석이 있습니다.");
                return;
            }
            passengerCheckRs.close();
            passengerCheckStmt.close();

            // 4. passenger_seq 시퀀스 NEXTVAL 조회
            String seqSql = "SELECT passenger_seq.NEXTVAL FROM dual";
            PreparedStatement seqStmt = db.getPreparedStatement(seqSql);
            ResultSet seqRs = seqStmt.executeQuery();

            int passengerId = 0;
            if (seqRs.next()) {
                passengerId = seqRs.getInt(1);
            } else {
                System.out.println("❌ 시퀀스 조회 실패.");
                return;
            }
            seqRs.close();
            seqStmt.close();

            // 5. passenger 등록
            String insertPassengerSql = "INSERT INTO passenger (passenger_id, name, country) VALUES (?, ?, ?)";
            PreparedStatement passengerStmt = db.getPreparedStatement(insertPassengerSql);
            passengerStmt.setInt(1, passengerId);
            passengerStmt.setString(2, name);
            passengerStmt.setString(3, country);
            int passengerResult = passengerStmt.executeUpdate();

            if (passengerResult == 0) {
                System.out.println("❌ 승객 등록 실패.");
                return;
            }
            passengerStmt.close();

            // 6. 예약 생성
            String reservationSql = "INSERT INTO reservation (reservation_id, passenger_id, flight_id, seat_number) "
                    + "VALUES (reservation_seq.NEXTVAL, ?, ?, ?)";
            PreparedStatement reservationStmt = db.getPreparedStatement(reservationSql);
            reservationStmt.setInt(1, passengerId);
            reservationStmt.setInt(2, flightId);
            reservationStmt.setString(3, seatNumber);
            reservationStmt.executeUpdate();
            reservationStmt.close();

            System.out.println("✅ 예약이 완료되었습니다.");

        } catch (SQLException e) {
            System.out.println("🚫 예약 오류: " + e.getMessage());
        } finally {
            db.disConnect();
        }
    }

    // 예약 확인
    public static void checkbooking() {
        Scanner scn = new Scanner(System.in);

        System.out.print("승객 이름으로 예약 조회: ");
        String name = scn.nextLine();

        DBUtil db = new DBUtil();
        db.connect();

        String sql = """
                SELECT r.reservation_id, f.flight_number, p.name, r.seat_number, r.reservation_time
                FROM reservation r
                JOIN passenger p ON r.passenger_id = p.passenger_id
                JOIN flight f ON r.flight_id = f.flight_id
                WHERE p.name = ?
                ORDER BY r.reservation_time
                """;

        try {
            PreparedStatement psmt = db.getPreparedStatement(sql);
            psmt.setString(1, name);
            ResultSet rs = psmt.executeQuery();

            System.out.println("========== 예약 목록 ==========");
            System.out.printf("%-10s %-15s %-15s %-10s %-20s\n", "예약ID", "항공편", "승객명", "좌석", "예약일시");

            while (rs.next()) {
                int id = rs.getInt("reservation_id");
                String flight = rs.getString("flight_number");
                String passenger = rs.getString("name");
                String seat = rs.getString("seat_number");
                Timestamp time = rs.getTimestamp("reservation_time");

                System.out.printf("%-10d %-15s %-15s %-10s %-20s\n", id, flight, passenger, seat,
                        time.toLocalDateTime());
            }

        } catch (SQLException e) {
            System.out.println("🚫 예약 조회 오류: " + e.getMessage());
        } finally {
            db.disConnect();
        }
    }

    // 예약 취소
    public static void cancelbooking() {
        Scanner scn = new Scanner(System.in);

        System.out.print("취소할 예약 ID: ");
        int id = Integer.parseInt(scn.nextLine());

        DBUtil db = new DBUtil();
        db.connect();

        String sql = "DELETE FROM reservation WHERE reservation_id = ?";

        try {
            PreparedStatement psmt = db.getPreparedStatement(sql);
            psmt.setInt(1, id);

            int result = psmt.executeUpdate();

            if (result > 0) {
                System.out.println("✅ 예약이 취소되었습니다.");
            } else {
                System.out.println("❌ 예약 ID를 찾을 수 없습니다.");
            }

        } catch (SQLException e) {
            System.out.println("🚫 예약 취소 오류: " + e.getMessage());
        } finally {
            db.disConnect();
        }
    }
}
