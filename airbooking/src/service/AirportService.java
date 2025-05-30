package service;

import util.DBUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AirportService {

    // 공항 등록 메서드
    public static void dbAirport() {
        Scanner scn = new Scanner(System.in);

        System.out.print("공항명: ");
        String airportName = scn.nextLine();

        System.out.print("도시명: ");
        String cityName = scn.nextLine();

        System.out.print("국가명: ");
        String countryName = scn.nextLine();

        if (airportName.isEmpty() || cityName.isEmpty() || countryName.isEmpty()) {
            System.out.println("⚠ 모든 항목을 입력해주세요.");
            return;
        }

        DBUtil db = new DBUtil();
        db.connect();

        int newId = getNextAvailableAirportId(db); // 비어있는 ID 계산

        String sql = "INSERT INTO airport (airport_id, name, city, country) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement psmt = db.getPreparedStatement(sql);
            psmt.setInt(1, newId);
            psmt.setString(2, airportName);
            psmt.setString(3, cityName);
            psmt.setString(4, countryName);

            int result = psmt.executeUpdate();

            if (result > 0) {
                System.out.println("✅ 공항이 성공적으로 등록되었습니다.");
            } else {
                System.out.println("❌ 공항 등록에 실패했습니다.");
            }

        } catch (SQLException e) {
            System.out.println("🚫 DB 오류: " + e.getMessage());
        } finally {
            db.disConnect();
        }
    }

    // 비어 있는 가장 작은 ID 구하기
    private static int getNextAvailableAirportId(DBUtil db) {
        String sql = """
            SELECT MIN(id) AS next_id
            FROM (
                SELECT LEVEL AS id
                FROM dual
                CONNECT BY LEVEL <= (SELECT NVL(MAX(airport_id), 0) + 1 FROM airport)
                MINUS
                SELECT airport_id FROM airport
            )
            """;

        try {
            PreparedStatement psmt = db.getPreparedStatement(sql);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("next_id");
            }
        } catch (SQLException e) {
            System.err.println("🚫 ID 조회 실패: " + e.getMessage());
        }

        return 1; // 실패 시 기본값
    }

    // 공항 목록 조회 메서드
    public static void dbAirportList() {
        DBUtil db = new DBUtil();
        db.connect();

        String sql = "SELECT airport_id, name, city, country FROM airport ORDER BY airport_id";

        try {
            PreparedStatement psmt = db.getPreparedStatement(sql);
            ResultSet rs = psmt.executeQuery();

            System.out.println("========== 공항 목록 ==========");
            System.out.printf("%-10s %-20s %-20s %-20s\n", "ID", "공항명", "도시", "국가");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("airport_id");
                String name = rs.getString("name");
                String city = rs.getString("city");
                String country = rs.getString("country");

                System.out.printf("%-10d %-20s %-20s %-20s\n", id, name, city, country);
            }

        } catch (SQLException e) {
            System.out.println("🚫 공항 목록 조회 실패: " + e.getMessage());
        } finally {
            db.disConnect();
        }
    }

    // 공항 삭제 메서드
    public static void deleteAirpot() {
        Scanner scn = new Scanner(System.in);
        System.out.print("삭제할 공항 ID를 입력하세요: ");
        String airport_id = scn.nextLine();

        DBUtil db = new DBUtil();
        db.connect();

        String sql = "DELETE FROM airport WHERE airport_id = ?";

        try {
            PreparedStatement psmt = db.getPreparedStatement(sql);
            psmt.setString(1, airport_id);

            int rows = psmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ 공항이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("❌ 해당 공항번호를 찾을 수 없습니다.");
            }

        } catch (SQLException e) {
            System.out.println("🚫 공항 삭제 오류: " + e.getMessage());
        } finally {
            db.disConnect();
        }
    }
}
