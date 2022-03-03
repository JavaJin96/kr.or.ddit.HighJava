package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 	문제) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 Lprod_id가 큰 자료를 출력하시오.
 */

public class JdbcTest02 {
		
	public static void main(String[] args) {
		Connection con = null;
		Statement ste = null;
		ResultSet rs = null;
		Scanner scan = new Scanner(System.in);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PSJ96", "java");
			
//			String sql = "select lprod_id from lprod where lprod_id > ?";
			String sql = "select lprod_id from lprod ";
			
			ste = con.createStatement();
			
			rs = ste.executeQuery(sql);
			
			System.out.println("LPROD_ID값을 입력해주세요>");
			int input = Integer.parseInt(scan.nextLine());
			
			System.out.println("==============================");
			
			System.out.println("입력한 LPROD_ID값보다 큰 ID들...");
				while(rs.next()) {
					
					if(rs.getInt(1) > input) {
					System.out.println("Lprod_id : " + rs.getInt(1));
					}
				}
				
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null)try {rs.close();}catch(SQLException e) {}
			if(ste != null)try {ste.close();}catch(SQLException e) {}
			if(con != null)try {con.close();}catch(SQLException e) {}
		}
		
	}

}
