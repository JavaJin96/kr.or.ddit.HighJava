package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.CommuReplyVO;
import kr.or.ddit.kjy.dao.IreCommunityDao;
import kr.or.ddit.kjy.dao.reCommunityDaoImpl;

public class reCommunityServiceImpl implements IreCommunityService{
	
	private IreCommunityDao dao;
	
	private reCommunityServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = reCommunityDaoImpl.getInstance();
	}
	
	private static reCommunityServiceImpl service;
	
	public static reCommunityServiceImpl getInstance() {
		if(service == null) service = new reCommunityServiceImpl();
		return service;
	}

	@Override
	public List<CommuReplyVO> getAllReCommu(String rnum) {
		return dao.getAllReCommu(rnum);
	}

	@Override
	public CommuReplyVO selectReCommu(String rnum) {
		return dao.selectReCommu(rnum);
	}

	@Override
	public int insertReCommu(CommuReplyVO rvo) {
		return dao.insertReCommu(rvo);
	}

	@Override
	public int updateReCommu(CommuReplyVO rvo) {
		return dao.updateReCommu(rvo);
	}

	@Override
	public int deleteReCommu(String rnum) {
		return dao.deleteReCommu(rnum);
	}

}
