package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberService {
	
	// 전체 회원의 리스트를 출력하는 메서드
	public List<MemberVO> AllMemberList ();
	
	public MemberVO SelectMember (String id);
	
	public void InsertMember (MemberVO vo);
	
	public void UpdateMember (MemberVO vo);
	
}


