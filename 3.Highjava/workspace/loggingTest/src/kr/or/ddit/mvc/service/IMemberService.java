package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 실행하고 
 * 실행된 결과를 받아와서 받아온 결과를 Controller에게 보내주는 역할을 수행한다.
 * 
 * @author PC-14
 * @version 1.0.0
 */

public interface IMemberService {
	
	/**
	 * MemberVO객체에 담겨진 자료를 DB에 insert하는 메서드
	 * 
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO객체
	 * @return 작업 성공 : 1이상의 정수, 작업실패 : 0
	 */
	
	public int insertMember(MemberVO memVo);
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param memId 삭제할 회원ID(String)
	 * @return 작업 성공 : 1, 작업실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * DB에 저장된  회원들의 정보를 수정하는 메서드
	 * 
	 * @param memVo 변경할 내용을 담은 memVo 객체
	 * @return 작업 성공 : 1, 작업실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * DB에 저장된 모든 회원들의 정보를 조회하는 메서드
	 * 
	 * @return MemberVO를 담고있는 List객체
	 */
	public List<MemberVO> selectMember();
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원의 수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원의 ID
	 * @return 검색된 회원의 수
	 */
	public int getMemberCount(String memId);
	
	/**
	 * 변경할 내용들(field, pass, name ...)을 저장한 Map을 매개변수로 받아 부분적으로 자료를 수정
	 * key값 정보 : 회원ID(memId), 수정할 컬럼(field), 수정할데이터(data)
	 * 
	 * @param paramMap 변경될 내용들
	 * @return
	 */
	public int updateMember2(Map<String, String> paramMap);
	
	
}
