package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoimpl;
import kr.or.ddit.member.vo.MemberVO;

public class MemberServiceimpl implements IMemberService {
	
	private static IMemberService service;
	private IMemberDao dao;
	
	public MemberServiceimpl() {
		dao = MemberDaoimpl.getInstance();
	}
	
	public static IMemberService getInstanse() {
		if(service == null) service = new MemberServiceimpl();
		return service;
	}
	

	@Override
	public List<MemberVO> AllMemberList() {
		return dao.AllMemberList();
	}

	@Override
	public MemberVO SelectMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void InsertMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void UpdateMember(MemberVO vo) {
		// TODO Auto-generated method stub

	}

}
