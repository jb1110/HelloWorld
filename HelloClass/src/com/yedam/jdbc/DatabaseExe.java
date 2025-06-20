package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 */
public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pw = "tiger";
		// 세션.
		Connection conn = null;

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pw);
			conn.setAutoCommit(false);
			System.out.println("연결성공.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Statement 객체.
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "update  product\r\n"
				+ "set     p_name = '갑자집1',\r\n"
				+ "        p_price = 1700\r\n"
				+ "where   p_code = 200";
		
		
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert,update,delete = executeUpdate 구문써야함.
			if (r > 0) {
				conn.commit();
				System.out.println(r + "건 등록완료.");
			} else {
				conn.rollback();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			rs = stmt.executeQuery("select * from product");
			System.out.println("상품코드   상품이름       가격");
			System.out.println("-----------------------");
			while (rs.next()) {
				System.out.println(rs.getInt("p_code") + "  " + rs.getString("p_name") + " " + rs.getInt("p_price"));
			}
			System.out.println("-------end of rows-------");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
