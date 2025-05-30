package dao;

import java.sql.*;

public class AdminDAO {
    private final String url = "jdbc:mysql://localhost:3306/airbooking";
    private final String user = "root";
    private final String password = "yourpassword";

    public void insertAdmin(String adminId, String password) {
        String sql = "INSERT INTO admin (admin_id, password) VALUES (?, ?)";

        try (
            Connection conn = DriverManager.getConnection(url, user, this.password);
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, adminId);
            pstmt.setString(2, password);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("✅ 관리자 등록 완료!");
            } else {
                System.out.println("❌ 관리자 등록 실패");
            }
        } catch (SQLException e) {
            System.out.println("DB 오류: " + e.getMessage());
        }
    }
}

