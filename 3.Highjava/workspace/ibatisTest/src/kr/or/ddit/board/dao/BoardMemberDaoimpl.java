package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardMemberVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class BoardMemberDaoimpl implements IBoardMemberDao {
	
	private static BoardMemberDaoimpl Dao;
	private SqlMapClient smc;
	
	
	private BoardMemberDaoimpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static BoardMemberDaoimpl getInstance() {
		if(Dao == null) Dao = new BoardMemberDaoimpl();
		
		return Dao;
	}
	
	
	@Override
	public int insertBoard(BoardMemberVO mem) {
		int res = 0;
		try {
			
			Object obj = smc.insert("boardmember.insertBoard", mem);
			if(obj == null) {
				res = 1;
			}else {
				res = 0;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int deleteBoard(int no) {
		int res = 0;
		try {
		
			res = smc.delete("boardmember.deleteBoard", no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return res;
	}

	@Override
	public int updateBoard(BoardMemberVO mem) {
		int res = 0;
		try {
			
			res = smc.update("boardmember.updateBoard", mem);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int updateBoard2(Map<String, String> param) {
		int res = 0;
		
		try {

			res = smc.update("boardmember.updateBoard2", param);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<BoardMemberVO> selectBoard() {
		List<BoardMemberVO> list = new ArrayList<>();
		try {
			
			list = smc.queryForList("boardmember.selectBoard");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<BoardMemberVO> selectBoardDetail(int no) {
		List<BoardMemberVO> list = new ArrayList<>();
		try {
			
			list = smc.queryForList("boardmember.selectBoardDetail", no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int getcnt(int no) {
		int res = 0;
		
		try {
			
			res = (int) smc.queryForObject("boardmember.getcnt", no);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return res;
	}

	@Override
	public int setcnt(BoardMemberVO mem) {
		int res = 0;
		
		try {
			
			res = smc.update("boardmember.setcnt", mem);
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public List<BoardMemberVO> search(String title) {
		List<BoardMemberVO> list = new ArrayList<>();
		try {
			
			list = smc.queryForList("boardmember.search", title);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

}




















