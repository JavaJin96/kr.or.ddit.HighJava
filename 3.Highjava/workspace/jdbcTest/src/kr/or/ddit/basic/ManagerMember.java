package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil2;
import kr.or.ddit.util.DBUtil3;

public class ManagerMember {
	Connection con = null;
	PreparedStatement pste = null;
	ResultSet rs = null;
	Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {

		ManagerMember mm = new ManagerMember();
		mm.main();
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void main() {
		while(true) {
			System.out.println("===============================================");
			System.out.println("맴버관리 프로그램");
			System.out.println("===============================================");
			System.out.println("1. 자료추가 2. 자료삭제 3. 자료수정 4. 전체자료출력 5. 부분자료수정 0. 프로그램 종료");
			System.out.println("===============================================");			
			System.out.println("행동을 입력해주세요>>>>");
			int input = Integer.parseInt(s.nextLine());
			switch(input) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			case 1:
				insert();
				break;
			case 2:
				delete();
				break;
			case 3:
				update();
				break;
			case 4:
				select();
				break;
			}
		}
	}
	
	
	
	public void insert() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PSJ96", "java");
			
			System.out.println("회원ID를 입력해주세요");
			String inputID = s.nextLine(); 
			
			String sql2 = "select MEM_ID from MYMEMBER";
			pste = con.prepareStatement(sql2);
			
			rs = pste.executeQuery();
			ArrayList<String> ids = new ArrayList<>();
			while(rs.next()) {
				ids.add(rs.getString(1));
			}
			
			for(int i = 0; i < ids.size(); i++) {
				if(ids.get(i).equals(inputID)) {
					System.out.println("이미 중복된 아이디가 존재합니다.");
					System.out.println("중복여부를 확인해주세요.");
					return;
				}
			}
			
			System.out.println("비밀번호를 입력해주세요");
			String inputPW = s.nextLine();
			
			System.out.println("이름을 입력해주세요");
			String inputName = s.nextLine();
			
			System.out.println("전화번호를 입력해주세요");
			String inputTel = s.nextLine();
			
			System.out.println("주소를 입력해주세요");
			String inputAddr = s.nextLine();
			
			String sql1 = "insert into MYMEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR) values(?,?,?,?,?)";
			
			pste = con.prepareStatement(sql1);
			pste.setString(1, inputID);
			pste.setString(2, inputPW);
			pste.setString(3, inputName);
			pste.setString(4, inputTel);
			pste.setString(5, inputAddr);
			
			int result = pste.executeUpdate();
			System.out.println(result + "개의 정보가 등록되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
	}
	
	public void delete() {
		System.out.println("삭제할 회원의 ID를 입력하세요.");
		String deleteID = s.nextLine();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "PSJ96", "java");
			
			String sql1 = "delete from MYMEMBER where MEM_ID = ?";
			pste = con.prepareStatement(sql1);
			
			pste.setString(1, deleteID);
			int result = pste.executeUpdate();
			
			if(result == 1) {
				System.out.println("성공적으로 삭제되었습니다.");
			}else {
				System.out.println("삭제할 ID가 일치하지 않습니다.");
				System.out.println("다시 시도해주세요.");
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		
		
	}
	
	public void update() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PSJ96", "java");
			
			System.out.println("수정할 회원의 ID를 입력하세요.");
			String updateID = s.nextLine();
			
			String sql1 = "select * from MYMEMBER where MEM_ID = ?";
			pste = con.prepareStatement(sql1);
			pste.setString(1, updateID);
			
			rs = pste.executeQuery();
			
			ArrayList<String> info = new ArrayList<>();
			
			if(rs.next() == false) {
				System.out.println("해당 ID가 존재하지 않습니다.");
				return;
			}else {
				
				while(rs.next()) {
					info.add(rs.getString(1));
					info.add(rs.getString(2));
					info.add(rs.getString(3));
					info.add(rs.getString(4));
					info.add(rs.getString(5));				
				}
			}
			
			String sql2 = "update MYMEMBER set ";
			//String sql2 = "update MYMEMBER set MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
			
			System.out.println("수정할 정보를 선택하세요.");
			System.out.println("1. 비밀번호 2. 이름 3. 전화번호 4. 주소 0. 모든항목");
			int seinput = Integer.parseInt(s.nextLine());
			switch(seinput) {
			case 1 : 
				System.out.println("변경할 비밀번호를 입력하세요.");
				String upPW = s.nextLine();
				
				sql2 += "MEM_PASS = ? WHERE MEM_ID = ?";
				pste = con.prepareCall(sql2);
				pste.setString(1, upPW);
				pste.setString(2, updateID);
				
				/*pste.setString(1, upPW);
				pste.setString(2, info.get(2));
				pste.setString(3, info.get(3));
				pste.setString(4, info.get(4));
				pste.setString(5, info.get(0));*/
				
				pste.executeUpdate();
				break;
			case 2 :
				System.out.println("변경할 이름을 입력하세요.");
				String upName = s.nextLine();
				
				sql2 += "MEM_NAME = ? WHERE MEM_ID = ?";
				pste = con.prepareCall(sql2);
				pste.setString(1, upName);
				pste.setString(2, updateID);
				
/*				pste.setString(1, info.get(1));
				pste.setString(2, upName);
				pste.setString(3, info.get(3));
				pste.setString(4, info.get(4));
				pste.setString(5, info.get(0));*/
				
				pste.executeUpdate();
				break;
			case 3 :
				System.out.println("변경할 전화번호를 입력하세요.");
				String upTel = s.nextLine();
				
				sql2 += "MEM_TEL = ? WHERE MEM_ID = ?";
				pste = con.prepareCall(sql2);
				pste.setString(1, upTel);
				pste.setString(2, updateID);
				
				/*pste.setString(1, info.get(1));
				pste.setString(2, info.get(2));
				pste.setString(3, upTel);
				pste.setString(4, info.get(4));
				pste.setString(5, info.get(0));*/
				
				pste.executeUpdate();
				break;
			case 4 :
				System.out.println("변경할 주소를 입력하세요.");
				String upAddr = s.nextLine();
				
				sql2 += "MEM_ADDR = ? WHERE MEM_ID = ?";
				pste = con.prepareCall(sql2);
				pste.setString(1, upAddr);
				pste.setString(2, updateID);
				
				/*pste.setString(1, info.get(1));
				pste.setString(2, info.get(2));
				pste.setString(3, info.get(3));
				pste.setString(4, upAddr);
				pste.setString(5, info.get(0));*/
				
				pste.executeUpdate();
				break;
			case 0 :
				System.out.println("변경할 비밀번호를 입력하세요.");
				String upPW0 = s.nextLine();
				System.out.println("변경할 이름을 입력하세요.");
				String upName0 = s.nextLine();
				System.out.println("변경할 전화번호를 입력하세요.");
				String upTel0 = s.nextLine();
				System.out.println("변경할 주소를 입력하세요.");
				String upAddr0 = s.nextLine();
				
				sql2 += "MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? WHERE MEM_ID = ?";
				pste = con.prepareCall(sql2);
				pste.setString(1, upPW0);
				pste.setString(2, upName0);
				pste.setString(3, upTel0);
				pste.setString(4, upAddr0);
				pste.setString(5, updateID);
				
				/*pste.setString(1, upPW0);
				pste.setString(2, upName0);
				pste.setString(3, upTel0);
				pste.setString(4, upAddr0);
				pste.setString(5, info.get(0));*/
				
				pste.executeUpdate();
				break;
			}
			
			
			
			System.out.println("변경되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
	}
	
	public void select() {
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PSJ96", "java");*/
			
//			con = DBUtil2.getConnection();
			con = DBUtil3.getConnection();
			
			String sql = "select * from MYMEMBER";
			pste = con.prepareStatement(sql);
			rs = pste.executeQuery();
			
			System.out.println("==========================================================");
			System.out.println("전체자료열람");
			System.out.println("==========================================================");
			while(rs.next()) {
				System.out.println("회원ID : " + rs.getString(1));
				System.out.println("비밀번호 : " + rs.getString(2));
				System.out.println("회원이름 : " + rs.getString(3));
				System.out.println("전화번호 : " + rs.getString(4));
				System.out.println("회원주소 : " + rs.getString(5));
				System.out.println("-----------------------------------------------------------");
			}
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
	}
	
	
	

}




