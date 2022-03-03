package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.kjy.dao.BambooDaoImpl;
import kr.or.ddit.kjy.dao.IBambooDao;

public class BambooServiceImpl implements IBambooService{

	private IBambooDao dao;
	
	private BambooServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = BambooDaoImpl.getInstance();
	}
	
	private static BambooServiceImpl service;
	
	public static BambooServiceImpl getInstance() {
		if(service == null) service = new BambooServiceImpl();
		return service;
	}

	//전체 리스트
	@Override
	public List<BambooVO> getAllBamboo() {
		return dao.getAllBamboo();
	}
	
	//게시글 선택
	@Override
	public BambooVO selectBamboo(String bnum) {
		return dao.selectBamboo(bnum);
	}

	//게시글 추가
	@Override
	public int insertBamboo(BambooVO bvo) {
		return dao.insertBamboo(bvo);
	}

	//게시글 수정
	@Override
	public int updateBamboo(BambooVO bvo) {
		return dao.updateBamboo(bvo);
	}

	//게시글 삭제
	@Override
	public int deleteBamboo(String bnum) {
		return dao.deleteBamboo(bnum);
	}

	//게시글 검색
	@Override
	public List<BambooVO> searchBamboo(String bnum) {
		return dao.searchBamboo(bnum);
	}

}
