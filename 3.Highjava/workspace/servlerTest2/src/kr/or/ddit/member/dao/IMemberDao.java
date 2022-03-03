package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberDao {
	public List<MemberVO> AllMemberList ();
	
	public MemberVO SelectMember (String id);
	
	public void InsertMember (MemberVO vo);
	
	public void UpdateMember (MemberVO vo);
}
