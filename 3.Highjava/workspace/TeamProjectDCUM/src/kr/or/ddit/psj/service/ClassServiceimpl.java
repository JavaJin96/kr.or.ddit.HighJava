package kr.or.ddit.psj.service;

import java.util.List;
import java.util.Map;

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
import kr.or.ddit.psj.dao.ClassDaoimpl;

public class ClassServiceimpl implements IClassService {
	
	private static ClassServiceimpl service;
	private ClassDaoimpl dao;
	
	public ClassServiceimpl() {
		dao = ClassDaoimpl.getInstance();
	}
	
	public static ClassServiceimpl getInstance() {
		if(service == null) service = new ClassServiceimpl();
		return service;
	}

	@Override
	public List<SubjectVO> selectAllMySubject(String id) {
		return dao.selectAllMySubject(id);
	}

	@Override
	public List<ClassVO> selectClass(String subnum) {
		return dao.selectClass(subnum);
	}

	@Override
	public SubjectVO selectAllMySubjectVO(String id) {
		return dao.selectAllMySubjectVO(id);
	}

	@Override
	public List<GongjiVO> selectNotice() {
		return dao.selectNotice();
	}

	@Override
	public SubjectVO selectOneSubjectForName(String subname) {
		return dao.selectOneSubjectForName(subname);
	}

	@Override
	public ClassVO selectClassByName(String classname) {
		return dao.selectClassByName(classname);
	}

	@Override
	public List<SubjectVO> selectSubjectListPro(String memid) {
		return dao.selectSubjectListPro(memid);
	}

	@Override
	public int insertClass(ClassVO vo) {
		return dao.insertClass(vo);
	}

	@Override
	public List<BoardVO> selectClassNotice() {
		return dao.selectClassNotice();
	}

	@Override
	public List<TempBoardVO> selectAllMyClassNotice(String mem_id) {
		return dao.selectAllMyClassNotice(mem_id);
	}

	@Override
	public List<BoardVO> selectAllClassNoticeBysn(String subname) {
		return dao.selectAllClassNoticeBysn(subname);
	}

	@Override
	public List<BoardVO> selectAllQna() {
		return dao.selectAllQna();
	}

	@Override
	public List<SubjectVO> selectAllMySubject2(String id) {
		return dao.selectAllMySubject2(id);
	}

	@Override
	public int insertQna(BoardVO vo) {
		return dao.insertQna(vo);
	}

	@Override
	public int insertQnaRe(Board_ReplyVO vo) {
		return dao.insertQnaRe(vo);
	}

	@Override
	public List<Board_ReplyVO> selectBoardReply(String boardnum) {
		return dao.selectBoardReply(boardnum);
	}

	@Override
	public List<BoardVO> selectInclassBoard(String classnum) {
		return dao.selectInclassBoard(classnum);
	}

	@Override
	public int deleteQna(String boardnum) {
		return dao.deleteQna(boardnum);
	}

	@Override
	public List<TempBoardVO> selectAllMyNotice(String memid) {
		return dao.selectAllMyNotice(memid);
	}

	@Override
	public int modifyQna(BoardVO vo) {
		return dao.modifyQna(vo);
	}

	@Override
	public List<SubjectVO> selectClaComent(Map<String, String> map) {
		return dao.selectClaComent(map);
	}

	@Override
	public void submitComent(Map<String, String> map) {
		 dao.submitComent(map);
		
	}

	@Override
	public List<TempTaskVO> selectAllMyTask(TempTaskVO vo) {
		return dao.selectAllMyTask(vo);
	}

	@Override
	public void submitTask(Task_submitVO vo) {
		dao.submitTask(vo);
		
	}

	@Override
	public List<ClassStudentVO> selectAllMyStudent(String subnum) {
		return dao.selectAllMyStudent(subnum);
	}

	@Override
	public void insertTaskp(TaskVO vo) {
		dao.insertTaskp(vo);
		
	}

	@Override
	public void insertTasks(Task_submitVO vo) {
		dao.insertTasks(vo);
		
	}

	@Override
	public List<BoardVO> selectAllClassNoticeBysn2(String classnum) {
		return dao.selectAllClassNoticeBysn2(classnum);
	}

	@Override
	public void insertNotice(BoardVO vo) {
		dao.insertNotice(vo);
	}

	@Override
	public void modifyPQna(BoardVO vo) {
		dao.modifyPQna(vo);
	}

	@Override
	public void deletePQna(String bnum) {
		dao.deletePQna(bnum);
	}

	@Override
	public void insertSubject(SubjectVO vo) {
		dao.insertSubject(vo);
	}

	@Override
	public List<SubjectVO> selectInSubject(String status) {
		return dao.selectInSubject(status);
	}

	@Override
	public void deleteSubject(SubjectVO vo) {
		dao.deleteSubject(vo);
	}

	@Override
	public List<MemberVO> selectManageStudents(String subname) {
		return dao.selectManageStudents(subname);
	}

	@Override
	public void insertClassChk(Class_chkVO vo) {
		dao.insertClassChk(vo);
	}

	@Override
	public List<TempClass_chkVO> selectClaChk(TempClass_chkVO vo) {
		return dao.selectClaChk(vo);
	}

	@Override
	public List<TempTask_submitVO> selectTasks(String subnum) {
		return dao.selectTasks(subnum);
	}

	@Override
	public void TaskScore(Task_submitVO vo) {
		dao.TaskScore(vo);
	}

	@Override
	public List<TempClassStudentVO> needScoreStudent(String subnum) {
		return dao.needScoreStudent(subnum);
	}

	@Override
	public void insertScore(ClassStudentVO vo) {
		dao.insertScore(vo);
	}

	@Override
	public void insertTest(TestVO vo) {
		dao.insertTest(vo);
	}

	@Override
	public List<TempTestVO> selectTest(String subname) {
		return dao.selectTest(subname);
	}

	@Override
	public List<TestVO> selectTestMenu() {
		return dao.selectTestMenu();
	}

	@Override
	public List<TestVO> MyTest(String memid) {
		return dao.MyTest(memid);
	}

	@Override
	public List<TestVO> MyTestDetail(TestVO vo) {
		return dao.MyTestDetail(vo);
	}

	@Override
	public void updateTest(TestVO vo) {
		dao.updateTest(vo);
	}

	@Override
	public void chkIn(Class_chkVO vo) {
		dao.chkIn(vo);
	}

	@Override
	public List<TempNoticeClassVO> NoticeClass(String memid) {
		return dao.NoticeClass(memid);
	}

	@Override
	public List<TempNoticeTaskVO> NoticeTask(String memid) {
		return dao.NoticeTask(memid);
	}

	@Override
	public List<TestVO> NoticeTest(String memid) {
		return dao.NoticeTest(memid);
	}

	@Override
	public List<TempCSVO> cistu(String subnum) {
		return dao.cistu(subnum);
	}

	@Override
	public void confirmStu(String subnum) {
		dao.confirmStu(subnum);
	}



}
