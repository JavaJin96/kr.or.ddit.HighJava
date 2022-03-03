package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * 	문제) Lprod_id값을 2개 입력 받아서 두 값 중 작은값부터 큰값 사이의 자료를 출력하시오.
 * 
 */

public class JdbcTest03 {

	public static void main(String[] args) {
		Connection con = null;
		Statement ste = null;
		ResultSet rs = null;
		Scanner s = new Scanner(System.in);
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
					,"PSJ96", "java");
			
			ste = con.createStatement();
			
			System.out.println("LPROD_ID값을 입력해주세요. >");
			int input = Integer.parseInt(s.nextLine());
			
			System.out.println("두번째 LPROD_ID값을 입력해주세요. >");
			int input2 = Integer.parseInt(s.nextLine());
			
			int temp;
			if(input > input2) {
				temp = input;
				input = input2;
				input2 = temp;
			}
			
			// 방법2) Math의 메서드를 사용해서 값 지정하기
			// int max = Math.max(num1,num2);
			// int min = Math.min(num1,num2);
			
			String sql = "select * from lprod where lprod_id >=" + input + "and lprod_id <= " + input2;
			
			rs = ste.executeQuery(sql);
			
			System.out.println("====================================");
			while(rs.next()) {
				System.out.println("LPROD_ID : " + rs.getInt(1));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString(3));
				System.out.println("-------------------------------------");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
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
