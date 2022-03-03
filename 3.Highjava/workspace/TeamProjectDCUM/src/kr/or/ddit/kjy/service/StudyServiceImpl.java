package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.StudyApplyVO;
import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.kjy.dao.IStudyDao;
import kr.or.ddit.kjy.dao.StudyDaoImpl;

public class StudyServiceImpl implements IStudyService{
	
	private IStudyDao dao;
	
	private StudyServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = StudyDaoImpl.getInstance();
	}
	
	private static StudyServiceImpl service;
	
	public static StudyServiceImpl getInstance() {
		if(service == null) service = new StudyServiceImpl();
		return service;
	}

	//전체 스터디
	@Override
	public List<StudyVO> getAllStudy() {
		return dao.getAllStudy();
	}

	//스터디 선택
	@Override
	public StudyVO selectStudy(String snum) {
		return dao.selectStudy(snum);
	}

	//스터디 작성
	@Override
	public int insertStudy(StudyVO svo) {
		return dao.insertStudy(svo);
	}

	//스터디 수정
	@Override
	public int updateStudy(StudyVO svo) {
		return dao.updateStudy(svo);
	}

	//스터디 삭제
	@Override
	public int deleteStudy(String snum) {
		return dao.deleteStudy(snum);
	}
	
	//스터디 예약 목록
	@Override
	public List<StudyApplyVO> getStudyStudent(String smem) {
		return dao.getStudyStudent(smem);
	}
	
	//스터디 예약
	@Override
	public int insertApply(StudyApplyVO smem) {
		return dao.insertApply(smem);
	}
	
	//스터디 예약 취소
	@Override
	public int deleteApply(String smem) {
		return dao.deleteApply(smem);
	}
	
	//게시글 검색
	@Override
	public List<StudyVO> searchStudy(String stitle) {
		return dao.searchStudy(stitle);
	}

	//말머리 검색
	@Override
	public List<StudyVO> sortStudy(String sort) {
		return dao.sortStudy(sort);
	}

	//스터디 예약 현재인원 증가
	@Override
	public int updateCcnt(int num) {
		return dao.updateCcnt(num);
	}

	


	
	

}
