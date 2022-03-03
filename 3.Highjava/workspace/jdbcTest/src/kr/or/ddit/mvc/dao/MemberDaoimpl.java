package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoimpl implements IMemberDao {
	
	// 1. 자기 자신이 저장될 변수를 선언
	private static MemberDaoimpl dao;
	
	// 2.
	private MemberDaoimpl() {	}
	
	// 3.
	public static MemberDaoimpl getInstance() {
		if(dao == null) dao = new MemberDaoimpl();
		
		return dao;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		try {
			con = DBUtil3.getConnection();
			
			String sql = "insert into MYMEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR)"
					+ " values(?, ?, ?, ?, ?)";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memVo.getMem_id());
			pste.setString(2, memVo.getMem_pass());
			pste.setString(3, memVo.getMem_name());
			pste.setString(4, memVo.getMem_tel());
			pste.setString(5, memVo.getMem_addr());
			
			res = pste.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null)try {pste.close();} catch(SQLException e) {}
			if(con != null)try {con.close();} catch(SQLException e) {}
		}
		
		
		return res;
	}

	@Override
	public int deleteMember(String memId) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		
		try {
			con = DBUtil3.getConnection();
			
			String sql = "delete from MYMEMBER where MEM_ID=? ";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memId);
			
			res = pste.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null)try {pste.close();} catch(SQLException e ) {}
			if(con != null)try {con.close();} catch(SQLException e ) {}
		}
		
		
		return res;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		
		try {
			con = DBUtil3.getConnection();
			
			String sql = "update MYMEMBER set MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? where MEM_ID = ?";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memVo.getMem_pass());
			pste.setString(2, memVo.getMem_name());
			pste.setString(3, memVo.getMem_tel());
			pste.setString(4, memVo.getMem_addr());
			pste.setString(5, memVo.getMem_id());
			
			
			res = pste.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null)try { pste.close(); } catch(SQLException e) {}
			if(pste != null)try { pste.close(); } catch(SQLException e) {}
		} 
		
		
		return res;
	}

	@Override
	public List<MemberVO> selectMember() {
		Connection con = null;
		PreparedStatement pste = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<>(); 
		
		try {
			con = DBUtil3.getConnection();
			
			String sql = "select * from MYMEMBER";
			pste = con.prepareStatement(sql);
			rs = pste.executeQuery();
		
			
			while(rs.next()) {
				MemberVO mem = new MemberVO();
				
				mem.setMem_id(rs.getString(1));
				mem.setMem_pass(rs.getString(2));
				mem.setMem_name(rs.getString(3));
				mem.setMem_tel(rs.getString(4));
				mem.setMem_addr(rs.getString(5));
				
				list.add(mem);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null	) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();}catch (SQLException e) {}
			if(con != null) try {con.close();}catch (SQLException e) {}
		} 
		
		
		return list;
	}

	@Override
	public int getMemberCount(String memId) {
		Connection con = null;
		PreparedStatement pste = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			con = DBUtil3.getConnection();
			
			String sql = "select count(MEM_ID) FROM MYMEMBER where MEM_ID = ?";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memId);
			
			rs = pste.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null	) try {rs.close();} catch(SQLException e) {}
			if(pste != null	) try {pste.close();} catch(SQLException e) {}
			if(con != null	) try {con.close();} catch(SQLException e) {}
		}
		
		return count;
	}

	@Override
	public int updateMember2(Map<String, String> paramMap) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		
		try {
			con = DBUtil3.getConnection();
			
			String sql = "update MYMEMBER set " + paramMap.get("field") + " = ? where MEM_ID = ?";
			pste = con.prepareStatement(sql);
			pste.setString(1, paramMap.get("data"));
			pste.setString(2, paramMap.get("memid"));
			
			res = pste.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null)try {pste.close();} catch(SQLException e) {}
			if(con != null)try {con.close();} catch(SQLException e) {}
		}
		
		return res;
	}
	
}




















