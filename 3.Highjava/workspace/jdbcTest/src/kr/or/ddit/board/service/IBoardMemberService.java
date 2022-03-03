package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardMemberVO;

public interface IBoardMemberService {
	public int insertBoard(BoardMemberVO mem);
	
	public int deleteBoard(int no);
	
	public int updateBoard(BoardMemberVO mem);
	
	public int updateBoard2(Map<String, String> param);
	
	public List<BoardMemberVO> selectBoard();

	public List<BoardMemberVO> selectBoardDetail(int no);
	
	public List<BoardMemberVO> search(String title);
	
}