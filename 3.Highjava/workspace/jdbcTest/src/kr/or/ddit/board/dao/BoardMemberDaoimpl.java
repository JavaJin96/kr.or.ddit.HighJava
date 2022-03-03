package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardMemberVO;
import kr.or.ddit.util.DBUtil3;

public class BoardMemberDaoimpl implements IBoardMemberDao {
	
	private static BoardMemberDaoimpl Dao;
	
	private BoardMemberDaoimpl() {
		
	}
	
	public static BoardMemberDaoimpl getInstance() {
		if(Dao == null) Dao = new BoardMemberDaoimpl();
		
		return Dao;
	}

	@Override
	public int insertBoard(BoardMemberVO mem) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "insert into JDBC_BOARD (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CNT, BOARD_CONTENT) "
					+ " values(board_seq.NEXTVAL, ?, ?, sysdate, 0, ?)";
			
			pste = con.prepareStatement(sql);
			pste.setString(1, mem.getBoard_title());
			pste.setString(2, mem.getBoard_writer());
			
			pste.setString(3, mem.getBoard_content());
			
			res = pste.executeUpdate();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return res;
		
	}

	@Override
	public int deleteBoard(int no) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "delete from JDBC_BOARD where BOARD_NO = ?";
			
			pste = con.prepareStatement(sql);
			pste.setInt(1, no);
			
			res = pste.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return res;
	}

	@Override
	public int updateBoard(BoardMemberVO mem) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "update JDBC_BOARD set BOARD_TITLE = ? , BOARD_CONTENT = ? where BOARD_NO = ?";
			
			pste = con.prepareStatement(sql);
			pste.setString(1, mem.getBoard_title());
			pste.setString(2, mem.getBoard_content());
			pste.setInt(3, mem.getBoard_no());
			
			res = pste.executeUpdate();

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return res;
	}

	@Override
	public int updateBoard2(Map<String, String> param) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	//전체 게시글을 출력하는 메서드
	@Override
	public List<BoardMemberVO> selectBoard() {
		Connection con = null;
		PreparedStatement pste = null;
		ResultSet rs = null;
		ArrayList<BoardMemberVO> list = new ArrayList<>();
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "select BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT from JDBC_BOARD";
			
			pste = con.prepareStatement(sql);
			
			rs = pste.executeQuery();
			
			while(rs.next()) {
				BoardMemberVO mem = new BoardMemberVO();
				mem.setBoard_no(rs.getInt(1));
				mem.setBoard_title(rs.getString(2));
				mem.setBoard_writer(rs.getString(3));
				mem.setBoard_cnt(rs.getInt(4));
				
				list.add(mem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return list;
	}
	
	public int cntup(int no) {
		Connection con = null;
		PreparedStatement pste = null;
		int res = 0;
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "update JDBC_BOARD set BOARD_CNT = (SELECT BOARD_CNT FROM JDBC_BOARD WHERE BOARD_NO = ?)+1 "
					+ " where BOARD_NO = ? ";
			
			pste = con.prepareStatement(sql);
			pste.setInt(1, no);
			pste.setInt(2, no);
			
			res = pste.executeUpdate();
			
			
			
		} catch (SQLException e) {
		
		} finally {
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return res;
	}
	
	@Override
	public List<BoardMemberVO> selectBoardDetail(int no) {
		Connection con = null;
		PreparedStatement pste = null;
		ResultSet rs = null;
		ArrayList<BoardMemberVO> list = new ArrayList<>();
		
		
/*		try {
			con2 = DBUtil3.getConnection();
			String sql2 = "update JDBC_BOARD set BOARD_CNT = BOARD_CNT+1 where BOARD_NO = ?";
			pste2 = con2.prepareStatement(sql2);
			pste2.setInt(1, no);
			int res = pste2.executeUpdate();
			
			System.out.println(res);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pste2 != null) try {pste2.close();} catch(SQLException e) {}
			if(con2 != null) try {con2.close();} catch(SQLException e) {}
		}*/
		
		
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "select * from JDBC_BOARD where BOARD_NO = ?";
			
			
			
			
			pste = con.prepareStatement(sql);
			
			pste.setInt(1, no);
			
			rs = pste.executeQuery();
			
			while(rs.next()) {
				BoardMemberVO mem = new BoardMemberVO();
				mem.setBoard_no(rs.getInt(1));
				mem.setBoard_title(rs.getString(2));
				mem.setBoard_writer(rs.getString(3));
				mem.setBoard_date(rs.getDate(4));
				mem.setBoard_cnt(rs.getInt(5));
				mem.setBoard_content(rs.getString(6));
				
				list.add(mem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
		
		return list;
	}

	@Override
	public List<BoardMemberVO> search(String title) {
		Connection con = null;
		PreparedStatement pste = null;
		ResultSet rs = null;
		List<BoardMemberVO> list = new ArrayList<>();
		
		try {
			
			con = DBUtil3.getConnection();
			
			String sql = "select BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_CNT from JDBC_BOARD where BOARD_TITLE LIKE ?";
			
			pste = con.prepareStatement(sql);
			
			pste.setString(1, "%"+title+"%");
			
			rs = pste.executeQuery();
			
			while(rs.next()) {
				BoardMemberVO member = new BoardMemberVO();
				member.setBoard_no(rs.getInt(1));
				member.setBoard_title(rs.getString(2));
				member.setBoard_writer(rs.getString(3));
				member.setBoard_cnt(rs.getInt(4));
				
				list.add(member);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
			if(pste != null) try {pste.close();} catch(SQLException e) {}
			if(con != null) try {con.close();} catch(SQLException e) {}
		}
				
		return list;
	}


	

}
