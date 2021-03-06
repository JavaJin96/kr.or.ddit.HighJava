package kr.or.ddit.psj.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.BAD_INV_ORDER;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.dcum.vo.Board_ReplyVO;
import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.Class_chkVO;
import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.dcum.vo.TaskVO;
import kr.or.ddit.dcum.vo.Task_submitVO;
import kr.or.ddit.dcum.vo.TempBoardVO;
import kr.or.ddit.dcum.vo.TempCSVO;
import kr.or.ddit.dcum.vo.TempClassStudentVO;
import kr.or.ddit.dcum.vo.TempClass_chkVO;
import kr.or.ddit.dcum.vo.TempNoticeClassVO;
import kr.or.ddit.dcum.vo.TempNoticeTaskVO;
import kr.or.ddit.dcum.vo.TempTaskVO;
import kr.or.ddit.dcum.vo.TempTask_submitVO;
import kr.or.ddit.dcum.vo.TempTestVO;
import kr.or.ddit.dcum.vo.TestVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class ClassDaoimpl implements IClassdao {
	
	private static ClassDaoimpl dao;
	private SqlMapClient smc;
	
	public ClassDaoimpl() {
		smc = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static ClassDaoimpl getInstance() {
		if(dao == null) dao = new ClassDaoimpl();
		return dao;
	}
	
	@Override
	public List<SubjectVO> selectAllMySubject(String id) {
		List<SubjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMySubject", id);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}
	
	@Override
	public List<SubjectVO> selectAllMySubject2(String id) {
		List<SubjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMySubject2", id);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	
	@Override
	public List<ClassVO> selectClass(String subnum) {
		List<ClassVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectClass", subnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public SubjectVO selectAllMySubjectVO(String id) {
		SubjectVO vo = new SubjectVO();
		try {
			vo = (SubjectVO) smc.queryForObject("dum.selectAllMySubject", id);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return vo;
	}

	@Override
	public List<GongjiVO> selectNotice() {
		List<GongjiVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectNotice");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public SubjectVO selectOneSubjectForName(String subname) {
		SubjectVO vo = new SubjectVO();
		try {
			vo = (SubjectVO)smc.queryForObject("dum.selectOneSubjectForName", subname);
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return vo;
	}

	@Override
	public ClassVO selectClassByName(String classname) {
		ClassVO vo = new ClassVO();
		try {
			vo = (ClassVO) smc.queryForObject("dum.selectClassByName", classname);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return vo;
	}

	@Override
	public List<SubjectVO> selectSubjectListPro(String memid) {
		List<SubjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectSubjectListPro", memid);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int insertClass(ClassVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertClass", vo) == null) {
				result = 1;
			}else {
				result = 0;
			}
			 
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public List<BoardVO> selectClassNotice() {
		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectClassNotice");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TempBoardVO> selectAllMyClassNotice(String mem_id) {
		List<TempBoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMyClassNotice", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<BoardVO> selectAllClassNoticeBysn(String subname) {
		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllClassNoticeBysn", subname);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<BoardVO> selectAllQna() {
		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllQna");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int insertQna(BoardVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertQna", vo) == null) {
				result = 1;
			}else {
				result = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public int insertQnaRe(Board_ReplyVO vo) {
		int result = 0;
		try {
			if(smc.insert("dum.insertQnaRe", vo) == null) {
				result = 1;
			}else {
				result = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return result;
	}

	@Override
	public List<Board_ReplyVO> selectBoardReply(String boardnum) {
		List<Board_ReplyVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectBoardReply", boardnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<BoardVO> selectInclassBoard(String classnum) {
		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectInclassBoard", classnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int deleteQna(String boardnum) {
		try {
			smc.delete("dum.deleteQna", boardnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<TempBoardVO> selectAllMyNotice(String memid) {
		List<TempBoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMyNotice", memid);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public int modifyQna(BoardVO vo) {
		try {
			smc.update("dum.modifyQna", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<SubjectVO> selectClaComent(Map<String, String> map) {
		List<SubjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectClaComent", map);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void submitComent(Map<String, String> map) {
		try {
			smc.update("dum.submitComent", map);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<TempTaskVO> selectAllMyTask(TempTaskVO vo) {
		List<TempTaskVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMyTask", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void submitTask(Task_submitVO vo) {
		try {
			smc.update("dum.submitTask", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<ClassStudentVO> selectAllMyStudent(String subnum) {
		List<ClassStudentVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllMyStudent", subnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void insertTaskp(TaskVO vo) {
		try {
			smc.insert("dum.insertTaskp", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public void insertTasks(Task_submitVO vo) {
		try {
			smc.insert("dum.insertTasks", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<BoardVO> selectAllClassNoticeBysn2(String classnum) {
		List<BoardVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectAllClassNoticeBysn2", classnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void insertNotice(BoardVO vo) {
		try {
			smc.insert("dum.insertNotice", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public void modifyPQna(BoardVO vo) {
		try {
			smc.update("dum.modifyPQna", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public void deletePQna(String bnum) {
		try {
			smc.delete("dum.deletePQna", bnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public void insertSubject(SubjectVO vo) {
		try {
			smc.insert("dum.insertSubject", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public List<SubjectVO> selectInSubject(String status) {
		List<SubjectVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectInSubject", status);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void deleteSubject(SubjectVO vo) {
		try {
			smc.delete("dum.deleteSubject", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<MemberVO> selectManageStudents(String subname) {
		List<MemberVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectManageStudents", subname);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void insertClassChk(Class_chkVO vo) {
		try {
			smc.insert("dum.insertClaChk", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<TempClass_chkVO> selectClaChk(TempClass_chkVO vo) {
		List<TempClass_chkVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectClaChk", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TempTask_submitVO> selectTasks(String subnum) {
		List<TempTask_submitVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectTasks", subnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void TaskScore(Task_submitVO vo) {
		try {
			smc.update("dum.TaskScore", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public List<TempClassStudentVO> needScoreStudent(String subnum) {
		List<TempClassStudentVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.needScoreStudent", subnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void insertScore(ClassStudentVO vo) {
		try {
			smc.update("dum.insertScore", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public void insertTest(TestVO vo) {
		try {
			smc.insert("dum.insertTest", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}

	@Override
	public List<TempTestVO> selectTest(String subname) {
		List<TempTestVO> list = new ArrayList<>();
				try {
					list = smc.queryForList("dum.selectTest", subname);
				} catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
		return list;
	}

	@Override
	public List<TestVO> selectTestMenu() {
		List<TestVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.selectTestMenu");
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TestVO> MyTest(String memid) {
		List<TestVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.MyTest", memid);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TestVO> MyTestDetail(TestVO vo) {
		List<TestVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.MyTestDetail", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void updateTest(TestVO vo) {
		try {
			smc.update("dum.updateTest", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public void chkIn(Class_chkVO vo) {
		try {
			smc.update("dum.chkIn", vo);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public List<TempNoticeClassVO> NoticeClass(String memid) {
		List<TempNoticeClassVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.NoticeClass", memid);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TempNoticeTaskVO> NoticeTask(String memid) {
		List<TempNoticeTaskVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.NoticeTask", memid);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TestVO> NoticeTest(String memid) {
		List<TestVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.NoticeTest", memid);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public List<TempCSVO> cistu(String subnum) {
		List<TempCSVO> list = new ArrayList<>();
		try {
			list = smc.queryForList("dum.cistu", subnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public void confirmStu(String subnum) {
		try {
			smc.update("dum.confirmStu", subnum);
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}


}
