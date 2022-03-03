package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest002 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Lprod_id값 입력>>");
		int num = scan.nextInt();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PSJ96","java");
			
			String sql = "select * from lprod where lprod_id > " + num;
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("lprod_id : " + rs.getInt(1));
				System.out.println("lprod_gu : " + rs.getString(2));
				System.out.println("lprod_nm : " + rs.getString(3));
				System.out.println("========================================");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();}catch(SQLException e){}
			if(stmt != null) try {stmt.close();}catch(SQLException e){}
			if(conn != null) try {conn.close();}catch(SQLException e){}
		}
		
		
		
	}

}
