package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.BambooVO;

public interface IBambooService {
	
	//전체 리스트
	public List<BambooVO> getAllBamboo();
	
	//게시글 선택
	public BambooVO selectBamboo(String bnum);
	
	//게시글 작성
	public int insertBamboo(BambooVO bvo);
	
	//게시글 수정
	public int updateBamboo(BambooVO bvo);
	
	//게시글 삭제
	public int deleteBamboo(String bnum);
	
	//게시글 검색
	public List<BambooVO> searchBamboo(String bnum);
}
