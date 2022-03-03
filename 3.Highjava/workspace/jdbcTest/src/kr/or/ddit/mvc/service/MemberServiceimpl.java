package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemberDao;
import kr.or.ddit.mvc.dao.MemberDaoimpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceimpl implements IMemberService {
	
	private static MemberServiceimpl service;
	
	
	
	
	private IMemberDao memDao;	// DAO객체가 저장될 변수 선언
	
	// 생성자
	private MemberServiceimpl() {
		//memDao = new MemberDaoimpl();	// DAO객체 생성
		memDao = MemberDaoimpl.getInstance();
	}
	
	public static MemberServiceimpl getInstance() {
		if(service == null) service = new MemberServiceimpl();
		
		return service;
	}
	
	
	@Override
	public int insertMember(MemberVO memVo) {
		
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {

		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> selectMember() {

		return memDao.selectMember();
	}

	@Override
	public int getMemberCount(String memId) {

		return memDao.getMemberCount(memId);
	}


	@Override
	public int updateMember2(Map<String, String> paramMap) {

		return memDao.updateMember2(paramMap);
	}

}
