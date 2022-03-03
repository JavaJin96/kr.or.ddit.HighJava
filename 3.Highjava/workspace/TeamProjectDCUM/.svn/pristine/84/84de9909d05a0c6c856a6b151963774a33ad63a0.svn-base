package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.kjy.dao.GongjiDaoImpl;
import kr.or.ddit.kjy.dao.IGongjiDao;

public class GongjiServiceImpl implements IGongjiService{
	
	private IGongjiDao dao;
	
	private GongjiServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = GongjiDaoImpl.getInstance();
	}
	
	private static GongjiServiceImpl service;
	
	public static GongjiServiceImpl getInstance() {
		if(service == null) service = new GongjiServiceImpl();
		return service;
	}
	
	//공지 리스트
	@Override
	public List<GongjiVO> getAllGongji() {
		return dao.getAllGongji();
	}

	//선택 공지
	@Override
	public GongjiVO selectGongji(String gnum) {
		return dao.selectGongji(gnum);
	}

	//공지 작성
	@Override
	public int insertGongji(GongjiVO gvo) {
		return dao.insertGongji(gvo);
	}

	//공지 수정
	@Override
	public int updateGongji(GongjiVO gvo) {
		return dao.updateGongji(gvo);
	}

	//공지 삭제
	@Override
	public int deleteGongji(String gnum) {
		return dao.deleteGongji(gnum);
	}

	//공지 검색
	@Override
	public List<GongjiVO> searchGongji(String gtitle) {
		return dao.searchGongji(gtitle);
	}

}
