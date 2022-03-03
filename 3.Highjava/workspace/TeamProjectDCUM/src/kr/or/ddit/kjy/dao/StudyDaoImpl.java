package kr.or.ddit.kjy.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.dcum.vo.StudyApplyVO;
import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class StudyDaoImpl implements IStudyDao{
	
	private SqlMapClient client;
	private static StudyDaoImpl dao;
	
	private StudyDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static StudyDaoImpl getInstance() {
		if(dao == null) dao = new StudyDaoImpl();
		return dao;
	}
	
	//전체 스터디
	@Override
	public List<StudyVO> getAllStudy() {
		List<StudyVO> studyList = null;
		
		try {
			studyList = client.queryForList("project.getAllStudy");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studyList;
	}

	//스터디 선택
	@Override
	public StudyVO selectStudy(String snum) {
		StudyVO svo = null;
		
		try {
			svo = (StudyVO)client.queryForObject("project.selectStudy", snum);
			
		} catch (SQLException e) {
			svo = null;
			e.printStackTrace();
		}
		
		return svo;
	}

	//스터디 작성
	@Override
	public int insertStudy(StudyVO svo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertStudy", svo);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	//스터디 수정
	@Override
	public int updateStudy(StudyVO svo) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.updateStudy", svo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//스터디 삭제
	@Override
	public int deleteStudy(String snum) {
		int cnt = 0;
		
		try {
			cnt = client.delete("project.deleteStudy", snum);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}
	
	//스터디 예약 목록
	@Override
	public List<StudyApplyVO> getStudyStudent(String smem) {
		List<StudyApplyVO> sivo = null;
		
		try {
			sivo = (List<StudyApplyVO>)client.queryForList("project.getStudyStudent", smem);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sivo;
	}
	
	//스터디 예약
	@Override
	public int insertApply(StudyApplyVO smem) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("project.insertApply", smem);
			if(obj == null) {
				cnt = 1;
			}
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	//스터디 예약 취소
	@Override
	public int deleteApply(String smem) {
		int cnt = 0;
		
		try {
			cnt = client.delete("project.deleteApply", smem);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//스터디 검색
	@Override
	public List<StudyVO> searchStudy(String stitle) {
		List<StudyVO> studyList = null;
		
		try {
			studyList = client.queryForList("project.searchStudy", stitle);

		} catch (SQLException e) {
			studyList = null;
			e.printStackTrace();
			
		} 
		
		return studyList;
	}

	//말머리 검색
	@Override
	public List<StudyVO> sortStudy(String sort) {
		List<StudyVO> studyList = null;
		
		try {
			studyList = client.queryForList("project.sortStudy", sort);
			
		} catch (SQLException e) {
			studyList = null;
			e.printStackTrace();
		}
		return studyList;
	}

	//스터디 현재인원 증가
	@Override
	public int updateCcnt(int num) {
		int cnt = 0;
		
		try {
			cnt = client.update("project.updateCcnt", num);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}


}
