package kr.or.ddit.kjy.service;

import java.util.List;

import kr.or.ddit.dcum.vo.StudyApplyVO;
import kr.or.ddit.dcum.vo.StudyVO;

public interface IStudyService {
	
	//전체 리스트
	public List<StudyVO> getAllStudy();
	
	//선택 스터디
	public StudyVO selectStudy(String snum);
	
	//스터디 작성
	public int insertStudy(StudyVO svo);
	
	//스터디 수정
	public int updateStudy(StudyVO svo);
	
	//스터디 삭제
	public int deleteStudy(String snum);
	
	//스터디 예약 목록
	public List<StudyApplyVO> getStudyStudent(String smem);
	
	//스터디 예약
	public int insertApply(StudyApplyVO smem);

	//스터디 예약 취소
	public int deleteApply(String smem);
	
	//스터디 검색
	public List<StudyVO> searchStudy(String stitle);
	
	//말머리 검색
	public List<StudyVO> sortStudy(String sort);
	
	//스터디 현재인원 증가
	public int updateCcnt(int num);

}
