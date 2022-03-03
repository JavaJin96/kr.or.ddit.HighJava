package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardMemberVO;

public interface IBoardMemberDao {
	
	public int insertBoard(BoardMemberVO mem);
	
	public int deleteBoard(int no);
	
	public int updateBoard(BoardMemberVO mem);
	
	public int updateBoard2(Map<String, String> param);
	
	// 전체 게시글을 조회하는 메서드
	public List<BoardMemberVO> selectBoard();
	
	// 게시글의 상세조회
	public List<BoardMemberVO> selectBoardDetail(int no);
	
	public int cntup(int no);
	
	public List<BoardMemberVO> search(String title);
	
	
}
