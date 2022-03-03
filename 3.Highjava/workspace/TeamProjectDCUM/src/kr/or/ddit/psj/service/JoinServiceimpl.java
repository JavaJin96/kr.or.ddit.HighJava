package kr.or.ddit.psj.service;


import java.util.List;

import kr.or.ddit.dcum.vo.EmployeeVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.ProfessorVO;
import kr.or.ddit.dcum.vo.StudentVO;
import kr.or.ddit.psj.dao.JoinDaoimpl;

public class JoinServiceimpl implements IJoinService {
	
	// 싱글톤 패턴 ----------------------------------------------------------
	private static JoinServiceimpl service; 
	private JoinDaoimpl dao;
	
	
	public JoinServiceimpl() {
		dao = JoinDaoimpl.getInstance();
	}
	
	public static JoinServiceimpl getInstance() {
		if(service == null) service = new JoinServiceimpl();
		return service;
	}
	
	// dao객체 호출 및 싱글톤 끝 -------------------------------------------------
	
	
	//회원 등록에 관련된 메서드 (맴버, 학생, 교수, 직원)
	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int insertStudent(StudentVO vo) {
		return dao.insertStudent(vo);
	}

	@Override
	public int insertProfessor(ProfessorVO vo) {
		return dao.insertProfessor(vo);
	}

	@Override
	public int insetEmployee(EmployeeVO vo) {
		return dao.insetEmployee(vo);
	}
	
	// 조회
	@Override
	public List<MemberVO> selectAllMember() {
		return dao.selectAllMember();
	}

	@Override
	public List<MemberVO> selectOneMember(int id) {
		return dao.selectOneMember(id);
	}
		
	
	
	
	


	
	
	
}

