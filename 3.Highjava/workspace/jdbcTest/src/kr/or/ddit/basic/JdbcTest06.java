package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * 회원을 관리하는 프로그램을 작성하시오.
 * (MYMEMBER 테이블 이용)
 * 
 * 아래 메뉴의 기능을 모두 구현하시오.(CRUD기능 구현하기)
 * 메뉴 예시)
 *   == 작업 선택 ==
 *   1. 자료 추가
 *   2. 자료 삭제
 *   3. 자료 수정
 *   4. 전체 자료 출력
 *   0. 작업 끝.
 *   
 *   처리조건) 
 *   1) 자료 추가에서 '회원ID'는 중복되지 않는다.(중복되면 다시 입력 받는다.)
 *   2) 삭제는 '회원ID'를 입력 받아서 처리한다.
 *   3) 자료 수정에서 '회원ID'는 변경되지 않는다.
 * 
 */

public class JdbcTest06 {

	static Scanner sc = new Scanner(System.in);
	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt2 = null;
	ResultSet rs = null;
	
	
	public static void main(String[] args) {
		
         new JdbcTest06().start();
		
	}
	
	public void start(){
		while(true){
			
			System.out.println("==작업선택==");
			System.out.println("1.자료추가 2.자료삭제 3.자료수정4.전체자료출력0.작업끝");
			System.out.print("선택>");
			
			int input = sc.nextInt();
			switch(input){
			 
			case 1 : 
				add(); break; //자료 추가
			case 2:
				delete(); break; //자료 삭제
			case 3:
				update(); break; // 자료 수정
			case 4:
				displayAll(); break; // 전체 자료 출력
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default : 
				System.out.println("작업 번호를 잘못 입력했습니다.");
					System.out.println("다시 선택하세요.");
			  }
			}
	}
	
	private void add(){
		try {
			
			conn = DBUtil.getConnection();
			System.out.println();
			System.out.println("새롭게 추가할 자료를 입력하세요");
			
			String MEMID = null;
			int cnt = 0;
			do{
				System.out.println("MEM_ID : ");
				MEMID = sc.next();
				String sql = "select count(*) cnt from mymember"
						+" where MEM_ID = ?";
				pstmt2 = conn.prepareStatement(sql);
				pstmt2.setString(1, MEMID);
				rs = pstmt2.executeQuery();
				
				if(rs.next()){
					cnt = rs.getInt("cnt");
				}
				if(cnt>0){
					System.out.println("이미 있어용");
					System.out.println("다시 입력 하세영");
				}
				System.out.println(cnt);	
			
			}while(cnt>0);
			
			System.out.println("MEM_NAME : ");
			String MEMNAME = sc.next();
			
			System.out.println("MEM_PASS : ");
			String MEMPASS = sc.next();
			
			System.out.println("MEM_TEL : ");
			String MEMTEL = sc.next();
			
			System.out.println("MEM_ADDR : ");
			String MEMADDR = sc.next();
			
			String sql = "insert into mymember values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, MEMID);
			pstmt.setString(2, MEMNAME);
			pstmt.setString(3, MEMPASS);
			pstmt.setString(4, MEMTEL);
			pstmt.setString(5, MEMADDR);
			
			int result = pstmt.executeUpdate();
			
			if(result>0){
				System.out.println("저장완료!!!");
			}else{
				System.out.println("저장안됨");
			}
			
//			pstmt2 = conn.prepareStatement(sql);
//			pstmt2.setString(1, MEMID);
//			rs = pstmt2.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void delete(){
		try {
			conn = DBUtil.getConnection();
			System.out.println();
			System.out.println("삭제할 아이디를 입력하세요");
			String id = sc.next();
			
			String sql = "DELETE FROM MYMEMBER WHERE MEM_ID = ?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int result = pstmt.executeUpdate();
			
			if(result > 0){
				System.out.println("삭제완료!!");
			}else{
				System.out.println("아이디가 없어용");
				System.out.println("삭제 안됨 ㅜ ㅜ");
			}
			
		} catch (Exception e) {
			
		}
	}
	
	private void update(){
		try {
			conn = DBUtil.getConnection();
			int cnt = 0;
			do{
			System.out.println("수정할 id를 입력하세용");
		    String id = sc.next();
		    String sql1 = "select count(*) cnt from mymember where mem_id = ?";
		    pstmt = conn.prepareStatement(sql1);
		    pstmt.setString(1, id);
		    rs = pstmt.executeQuery();
		    
		    if(rs.next()){
		    	cnt = rs.getInt("cnt");
		    }
		    if(cnt<1){
		    	 System.out.println("아이디가 없어요 ㅠㅠ");
		    }
		   
			}while(cnt <= 0);
			
			System.out.println("변경할 이름을 입력하세요");
			System.out.print("MEMNAME : " );
			String name = sc.next();
			System.out.println("변경할 비밀번호를 입력하세요");
			System.out.print("MEMPASS : " );
			String pass = sc.next();
			System.out.println("변경할 전화번호를 입력하세요");
			System.out.print("MEMTEL : " );
			String tel = sc.next();
			System.out.println("변경할 주소를 입력하세요");
			System.out.print("MEMADDR : " );
			String addr = sc.next();
			
			String sql2 = "update mymember set mem_name=? ,mem_pass=?, mem_tel=?, mem_addr=?  ";
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, name);
			pstmt2.setString(2, pass);
			pstmt2.setString(3, tel);
			pstmt2.setString(4, addr);
			
			int result = pstmt2.executeUpdate();
			
			if(result>0){
				System.out.println("수정완료 !!");
			}else{
				System.out.println("안됨 ㅠ");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	private void displayAll(){
		try {
		conn = DBUtil.getConnection();
		
		System.out.println();
		System.out.println("========전체 자료 출력========");
		String sql = "select * from mymember"; 
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()){
			System.out.println("MEMID : " + rs.getString(1));
			System.out.println("MEMNAME :" + rs.getString(2));
			System.out.println("MEMPASS : " + rs.getString(3));
			System.out.println("MEMTEL : " + rs.getString(4));
			System.out.println("MEMADDR : " + rs.getString(5));
			System.out.println("--------------------------------");
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}