package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 	Lprod테이블에 새로운 데이터를 추가해보자.
 * 
 * 	Lprod_GU와 Lprod_Nm은 사용자로부터 직접 입력 받아서 처리하고,
 * 	Lprod_ID는 현재의 Lprod_Id값 중에서 제일 큰 값보다 1크게 지정한다.
 * 
 * 	입력 받은 Lprod_Gu가 이미 등록되어 있으면 다시 입력 받아서 처리한다.
 * 
 * 
 * 	Statement와 PreparedStatement의 차이점
 */

public class JdbcTest05 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Connection con = null;
		Statement ste = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		PreparedStatement pste = null;
		String inputgu = null;
		int inputid = 0;
		ArrayList<String> list = new ArrayList<>();
		
		main : while(true) {
			
			System.out.println("LPROD_GU의 값을 입력해주세요 : " );
			String gu = s.next();
			
			System.out.println("LPROD_NM의 값을 입력해주세요 : " );
			String nm = s.next();
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PSJ96", "java");
				
				
				// lprod_id의 최대값 구하기
				String sql = "select max(lprod_id) from lprod";
				ste = con.createStatement();
				rs = ste.executeQuery(sql);
				
				while(rs.next()) {
					inputid = rs.getInt(1) + 1;				
				}
				
				// lprod_gu의 중복검사
				String sql2 = "select lprod_gu from lprod";
				rs2 = ste.executeQuery(sql2);
				
				while(rs2.next()) {
					list.add(rs2.getString(1));
				}
				
				for(int i = 0; i < list.size(); i++) {
					if(list.get(i).equals(gu)) {
						System.out.println("LPROD_GU의 값이 중복됩니다.");
						inputgu = null;
						break;
					}else {
						inputgu = gu;
					}
				}
				
				
				if(inputgu != null) {
					String sql3 = "insert into lprod (lprod_id, lprod_gu, lprod_nm) values(?, ?, ?)";
					
					pste = con.prepareStatement(sql3);
					
					pste.setInt(1, inputid);
					pste.setString(2, inputgu);
					pste.setString(3, nm);
					
					//int result = 
					pste.executeUpdate();
					return;
					//System.out.println(result + "개의 정보가 업데이트 되었습니다.");
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		
			
			
		
	}

}
