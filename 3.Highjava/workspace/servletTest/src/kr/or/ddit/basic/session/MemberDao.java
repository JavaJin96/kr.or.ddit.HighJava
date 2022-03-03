package kr.or.ddit.basic.session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.util.DBUtil3;

public class MemberDao {
	
	private static MemberDao dao;
	
	Connection con;
	ResultSet rs;
	PreparedStatement pste;
	
	public MemberDao() {
	}
	
	public static MemberDao getInstance() {
		if(dao == null) dao = new MemberDao();
		return dao;
	}
	
	public MemberVO loginInfo(MemberVO paravo) {
		con = DBUtil3.getConnection();
		String sql = "select * from MYMEMBER where mem_id = ? and mem_pass = ?";
		MemberVO vo = new MemberVO();
		
		
		try {
			pste = con.prepareStatement(sql);
			pste.setString(1, paravo.getMem_id());
			pste.setString(2, paravo.getMem_pass());
			
			
			rs = pste.executeQuery();
			
			while(rs.next()) {
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pass(rs.getString("mem_pass"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_tel(rs.getString("mem_tel"));
				vo.setMem_addr(rs.getString("mem_addr"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return vo;
	}
	
}
