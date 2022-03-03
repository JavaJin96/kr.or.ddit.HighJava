package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		Connection con = null;
		Statement ste = null;
		PreparedStatement pste = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PSJ96", "java");
			
			System.out.println("계좌 번호 정보 추가하기");
			
			System.out.println();
			System.out.print("계좌번호 >> ");
			String bankNo = s.next();
			
			System.out.print("은행이름 >> ");
			String bankName = s.next();
			
			System.out.print("예금주명 >> ");
			String bankUserName = s.next();
			
			/*
			// statement 객체를 이용한 데이터 추가작업
			
			String sql = "insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date)"
						 + "values ('" + bankNo + "','" + bankName + "','" + bankUserName + "', sysdate)";
			
			// System.out.println(sql);
			
			ste = con.createStatement();
			
			// SQL문 실행하기
			// select문을 실행할 때는 stmt.excuteQuery()메서드를 사용하고,
			// DML명령어를 사용할 때는 stmt.excuteUpdate()메서드를 사용한다. (반환값은 update된 행의 수)
			int cnt = ste.executeUpdate(sql); 
			 */
			
			// PreparedStatement객체를 이용하여 처리하기
			
			// SQL문장 중에서 데이터가 들어갈 자리를 물음표(?)로 표시하여 작성한다.
			String sql = "insert into bankinfo (bank_no, bank_name, bank_user_name, bank_date) values (?, ?, ?, sysdate)";
			
			// PreparedStatement객체를 생성한다. 
			// 이 때 처리할 SQL문장을 인수값으로 넣어준다.
			pste = con.prepareStatement(sql);
			
			// SQL문장의 물음표(?)자리에 들어갈 데이터를 셋팅한다.
			// 형식) pste.set자료형이름(물음표번호, 데이터값)
			pste.setString(1, bankNo);
			pste.setString(2, bankName);
			pste.setString(3, bankUserName);
			
			// 데이터의 셋팅이 완료되면 쿼리문을 실행한다.
			// 실행할 SQL문이 select문이면 excuteQuery() , DML명령어면 excuteUpdate() 이다. 
			int cnt = pste.executeUpdate();
			
			System.out.println("반환값 : " + cnt);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(ste != null) try {ste.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
	}

}
