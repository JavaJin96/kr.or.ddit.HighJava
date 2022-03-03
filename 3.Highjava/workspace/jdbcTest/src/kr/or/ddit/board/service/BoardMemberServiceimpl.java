package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardMemberDaoimpl;
import kr.or.ddit.board.dao.IBoardMemberDao;
import kr.or.ddit.board.vo.BoardMemberVO;

public class BoardMemberServiceimpl implements IBoardMemberService {
	
	private static BoardMemberServiceimpl service;
	
	
	
	
	
	private IBoardMemberDao memDao;
	
	private BoardMemberServiceimpl() {
		memDao = BoardMemberDaoimpl.getInstance();
	}
	
	public static BoardMemberServiceimpl getInstance() {
		if(service == null) service = new BoardMemberServiceimpl();
		
		return service;
	}
	

	@Override
	public int insertBoard(BoardMemberVO mem) {
		
		return memDao.insertBoard(mem);
	}

	@Override
	public int deleteBoard(int no) {

		return memDao.deleteBoard(no);
	}

	@Override
	public int updateBoard(BoardMemberVO mem) {
		return memDao.updateBoard(mem);
	}

	@Override
	public int updateBoard2(Map<String, String> param) {
		return memDao.updateBoard2(param);
	}

	@Override
	public List<BoardMemberVO> selectBoard() {
		return memDao.selectBoard();
	}

	@Override
	public List<BoardMemberVO> selectBoardDetail(int no) {
		return memDao.selectBoardDetail(no);
	}
	
	public int cntup(int no) {
		return memDao.cntup(no);
	}

	@Override
	public List<BoardMemberVO> search(String title) {
		return memDao.search(title);
	}
	
	
	
	
}
