package kr.or.ddit.kjy.service;

import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.kjy.dao.CommunityDaoImpl;
import kr.or.ddit.kjy.dao.ICommunityDao;
import kr.or.ddit.util.SqlMapClientFactory;

public class CommunityServiceImpl implements ICommunityService{
	
	private ICommunityDao dao;
	
	private CommunityServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = CommunityDaoImpl.getInstance();
	}
	
	private static CommunityServiceImpl service;
	
	public static CommunityServiceImpl getInstance() {
		if(service == null) service = new CommunityServiceImpl();
		return service;
	}
	
	//전체 리스트
	@Override
	public List<CommunityVO> getAllCommu() {
		return dao.getAllCommu();
	}

	//게시글 선택
	@Override
	public CommunityVO selectCommu(String cnum) {
		return dao.selectCommu(cnum);
	}

	//게시글 추가
	@Override
	public int insertCommu(CommunityVO cvo) {
		return dao.insertCommu(cvo);
	}

	//게시글 수정
	@Override
	public int updateCommu(CommunityVO cvo) {
		return dao.updateCommu(cvo);
	}

	//게시글 삭제
	@Override
	public int deleteCommu(String cnum) {
		return dao.deleteCommu(cnum);
	}

	//게시글 검색
	@Override
	public List<CommunityVO> searchCommu(String ccont) {
		return dao.searchCommu(ccont);
	}
	
	//말머리 검색
	@Override
	public List<CommunityVO> sortCommu(String sort) {
		return dao.sortCommu(sort);
	}

}
