package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.BambooReplyVO;
import kr.or.ddit.kjy.dao.reBambooDaoImpl;
import kr.or.ddit.kjy.dao.IreBambooDao;

public class reBambooServiceImpl implements IreBambooService{
	
	private IreBambooDao dao;
	
	private reBambooServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = reBambooDaoImpl.getInstance();
	}
	
	private static reBambooServiceImpl service;
	
	public static reBambooServiceImpl getInstance() {
		if(service == null) service = new reBambooServiceImpl();
		return service;
	}
	
	//댓글 리스트
	@Override
	public List<BambooReplyVO> getAllReBamboo(String rnum) {
		return dao.getAllReBamboo(rnum);
	}
	
	//댓글 선택
	@Override
	public BambooReplyVO selectReBamboo(String rnum) {
		return dao.selectReBamboo(rnum);
	}
	
	//댓글 작성
	@Override
	public int insertReBamboo(BambooReplyVO rvo) {
		return dao.insertReBamboo(rvo);
	}
	
	//댓글 수정
	@Override
	public int updateReBamboo(BambooReplyVO rvo) {
		return dao.updateReBamboo(rvo);
	}
	
	//댓글 삭제
	@Override
	public int deleteReBamboo(String rnum) {
		return dao.deleteReBamboo(rnum);
	}


}
