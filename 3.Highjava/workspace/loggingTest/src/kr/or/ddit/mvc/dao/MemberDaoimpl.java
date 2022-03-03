package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.mvc.vo.MemberVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoimpl implements IMemberDao {
	
	// Logger 객체 변수 생성
	private static Logger logger = Logger.getLogger(MemberDaoimpl.class);
	
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
			logger.info("Connection SUCCESS");
			
			String sql = "insert into MYMEMBER (MEM_ID, MEM_PASS, MEM_NAME, MEM_TEL, MEM_ADDR)"
					+ " values(?, ?, ?, ?, ?)";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memVo.getMem_id());
			pste.setString(2, memVo.getMem_pass());
			pste.setString(3, memVo.getMem_name());
			pste.setString(4, memVo.getMem_tel());
			pste.setString(5, memVo.getMem_addr());
			
			logger.debug("PreparedStatement객체 생성완료..");
			logger.debug("질의시작.. : " + sql);
			logger.debug("사용 데이터  [" + memVo.getMem_id() + "," 
					+ memVo.getMem_pass() + ","
					+ memVo.getMem_name() + ","
					+ memVo.getMem_tel() + ","
					+ memVo.getMem_addr() + "]");
			
			
			res = pste.executeUpdate();
			
			logger.info("질의성공..[insertMember]");
			
		} catch (SQLException e) {
			logger.error("질의실패..");
			e.printStackTrace();
		} finally {
			if(pste != null)try {pste.close(); logger.info("Preparedstatement 객체 CLOSE 완료..");} catch(SQLException e) {}
			if(con != null)try {con.close(); logger.info("Connection 객체 CLOSE 완료..");} catch(SQLException e) {}
			
			
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
			logger.info("Connection SUCCESS");
			
			String sql = "delete from MYMEMBER where MEM_ID=? ";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memId);
			logger.debug("PreparedStatement객체 생성완료..");
			logger.debug("질의시작.. : " + sql);
			logger.debug("사용 데이터 [" + memId + "]");
			
			res = pste.executeUpdate();
			logger.info("질의성공..[insertMember]");
			
		} catch (SQLException e) {
			logger.error("질의실패..");
			e.printStackTrace();
		} finally {
			if(pste != null)try {pste.close(); logger.info("Preparedstatement 객체 CLOSE 완료..");} catch(SQLException e ) {}
			if(con != null)try {con.close(); logger.info("Connection 객체 CLOSE 완료..");} catch(SQLException e ) {}
			
			
			
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
			logger.info("Connection SUCCESS");
			
			String sql = "update MYMEMBER set MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ? where MEM_ID = ?";
			pste = con.prepareStatement(sql);
			
			pste.setString(1, memVo.getMem_pass());
			pste.setString(2, memVo.getMem_name());
			pste.setString(3, memVo.getMem_tel());
			pste.setString(4, memVo.getMem_addr());
			pste.setString(5, memVo.getMem_id());
			logger.debug("PreparedStatement객체 생성완료..");
			logger.debug("질의시작.. : " + sql);
			logger.debug("사용 데이터  [" + memVo.getMem_pass() + "," 
					+ memVo.getMem_name() + ","
					+ memVo.getMem_tel() + ","
					+ memVo.getMem_addr() + ","
					+ memVo.getMem_id() + "]");
			
			
			res = pste.executeUpdate();
			logger.info("질의성공..[insertMember]");
			
			
		} catch (SQLException e) {
			logger.error("질의실패..");
			e.printStackTrace();
		} finally {
			if(pste != null)try { pste.close(); logger.info("Preparedstatement 객체 CLOSE 완료..");} catch(SQLException e) {}
			if(con != null)try { con.close(); logger.info("Connection 객체 CLOSE 완료..");} catch(SQLException e) {}
			
			
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
			logger.info("Connection SUCCESS");

			
			String sql = "select * from MYMEMBER";
			pste = con.prepareStatement(sql);
			logger.debug("PreparedStatement객체 생성완료..");
			logger.debug("질의시작.. : " + sql);
			rs = pste.executeQuery();
			logger.info("질의성공..[insertMember]");
			
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
			logger.error("질의실패..");
			e.printStackTrace();
		} finally {
			if(rs != null	) try {rs.close(); 	logger.info("ResultSet 객체 CLOSE 완료..");} catch(SQLException e) {}
			if(pste != null) try {pste.close(); logger.info("Preparedstatement 객체 CLOSE 완료..");}catch (SQLException e) {}
			if(con != null) try {con.close(); logger.info("Connection 객체 CLOSE 완료..");}catch (SQLException e) {}
			
		
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
			logger.info("Connection SUCCESS");
			
			String sql = "select count(MEM_ID) FROM MYMEMBER where MEM_ID = ?";
			pste = con.prepareStatement(sql);
			logger.debug("PreparedStatement객체 생성완료..");
			logger.debug("질의시작.. : " + sql);
			pste.setString(1, memId);
			logger.info("사용 데이터 [" + memId + "]");
			
			
			rs = pste.executeQuery();
			logger.info("질의성공..[insertMember]");
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
			
			
			
		} catch (SQLException e) {
			logger.error("질의실패..");
			e.printStackTrace();
		} finally {
			if(rs != null	) try {rs.close(); 	logger.info("ResultSet 객체 CLOSE 완료..");} catch(SQLException e) {}
			if(pste != null) try {pste.close(); logger.info("Preparedstatement 객체 CLOSE 완료..");}catch (SQLException e) {}
			if(con != null) try {con.close(); logger.info("Connection 객체 CLOSE 완료..");}catch (SQLException e) {}
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
			logger.info("Connection SUCCESS");
			
			String sql = "update MYMEMBER set " + paramMap.get("field") + " = ? where MEM_ID = ?";
			pste = con.prepareStatement(sql);
			logger.debug("PreparedStatement객체 생성완료..");
			logger.debug("질의시작.. : " + sql);
			
			pste.setString(1, paramMap.get("data"));
			pste.setString(2, paramMap.get("memid"));
			logger.info("사용 데이터 [" + paramMap + "]");
			
			
			res = pste.executeUpdate();
			logger.info("질의성공..[insertMember]");
			
		} catch (SQLException e) {
			logger.error("질의실패..");
			e.printStackTrace();
		} finally {
			if(pste != null) try {pste.close(); logger.info("Preparedstatement 객체 CLOSE 완료..");}catch (SQLException e) {}
			if(con != null) try {con.close(); logger.info("Connection 객체 CLOSE 완료..");}catch (SQLException e) {}
		}
		
		return res;
	}
	
}




















