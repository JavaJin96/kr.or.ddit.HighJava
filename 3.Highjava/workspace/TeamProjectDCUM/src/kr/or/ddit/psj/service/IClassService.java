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

public interface IClassService {
	
	// 학생부분-----------------------------------------------------------------
	// 강의실과 관련된 메서드
	
	// 학생의 id값을 받아 수강중인 과목의 이름과 과목코드를 리턴하는 메서드
	public List<SubjectVO> selectAllMySubject (String id);
	
	// 학생의 id값을 받아 수강중인 과목의 이름과 과목코드를 리턴하는 메서드
	public List<SubjectVO> selectAllMySubject2 (String id);
	
	// 수강중인 과목의 강의에 관련된 정보들을 리턴하는 메서드
	public List<ClassVO> selectClass (String subnum);
	
	public ClassVO selectClassByName (String classname);
	
	// 세션에 담기 위한 모든 정보 메서드
	public SubjectVO selectAllMySubjectVO (String id);
	
	// 모든 공지사항을 불러오는 메서드
	public List<GongjiVO> selectNotice ();
	
	// 모든 강의공지사항을 불러오는 메서드
	public List<BoardVO> selectClassNotice ();
	
	// 학생이 듣고 있는 모든 강의공지사항을 불러오는 메서드
	public List<TempBoardVO> selectAllMyClassNotice (String mem_id);
	
	// 과목명으로 해당 과목의 모든 공지사항을 불러오는 메서드
	public List<BoardVO> selectAllClassNoticeBysn(String subname);
	
	// 위의 메서드 수정본
	public List<BoardVO> selectAllClassNoticeBysn2(String classnum);
	
	// 모든 질의응답 게판을 조회하는 메서드
	public List<BoardVO> selectAllQna();
	
	// subjectVO 이름으로 한개 찾기
	public SubjectVO selectOneSubjectForName (String subname);
	
	// qna 게시판에 글 등록하기
	public int insertQna (BoardVO vo );
	
	// qna 게시판 글 삭제하기
	public int deleteQna (String boardnum);
	
	// qna 게시판 답글(댓글) 달기
	public int insertQnaRe (Board_ReplyVO vo);
	
	// qna 게시판 글 수정하기
	public int modifyQna (BoardVO vo );
	
	// qna 게시글에 해당하는 댓글 조회하기
	public List<Board_ReplyVO> selectBoardReply (String boardnum);
	
	// 강의실 내부에서 질의응답 조회하기
	public List<BoardVO> selectInclassBoard (String classnum);
	
	// 수강평가 미 등록 과목 조회하기
	public List<SubjectVO> selectClaComent (Map<String, String> map);
	
	// 수강평가 등록하기
	public void submitComent (Map<String, String> map);
	
	// 내 모든 수강과목의 과제 조회하기
	public List<TempTaskVO> selectAllMyTask (TempTaskVO vo);
	
	// 과제 제출하기
	public void submitTask (Task_submitVO vo);
	
	// 시험문제 조회하기
	public List<TestVO> MyTest (String memid);
	
	// 시험문제 풀기
	public List<TestVO> MyTestDetail (TestVO vo);
	
	// 시험지 제출
	public void updateTest (TestVO vo);
	
	// 출석 체크
	public void chkIn (Class_chkVO vo);
	
	// 알림 강의 출석
	public List<TempNoticeClassVO> NoticeClass (String memid);
	
	// 알림 과제 여부
	public List<TempNoticeTaskVO> NoticeTask (String memid);
	
	// 알림 시험 여부
	public List<TestVO> NoticeTest(String memid);
	
	// 수강신청자 조회
	public List<TempCSVO> cistu (String subnum);
	
	public void confirmStu (String subnum);
	// 학생부분-----------------------------------------------------------------
	
	// 교수부분-----------------------------------------------------------------
	// 강의실과 관련된 메서드
	
	// 자신이 수업하고 있는 강의를 id값을 받아 리턴하는 메서드
	public List<SubjectVO> selectSubjectListPro (String memid);
	
	// 수업내용을 등록하는 메서드
	public int insertClass (ClassVO vo);
	
	// 위의 등록된 수업에 출석부를 등록하는 메서드
	public void insertClassChk (Class_chkVO vo);
	
	// 자신이 쓴 모든 공지사항을 리턴하는 메서드
	public List<TempBoardVO> selectAllMyNotice (String memid);
	
	// 자신의 수업을 듣는 모든 학생들의 리스트를 불러오는 메서드
	public List<ClassStudentVO> selectAllMyStudent (String subnum);
	
	// 과제등록 1
	public void insertTaskp (TaskVO vo);
	
	// 과제등록 2
	public void insertTasks (Task_submitVO vo);
	
	// 공지사항 등록
	public void insertNotice (BoardVO vo );
	
	// 공지사항 수정
	public void modifyPQna (BoardVO vo);
	
	// 공지사항 삭제
	public void deletePQna (String bnum);
	
	// 과목 개설
	public void insertSubject (SubjectVO vo );
	
	// status가 '수강신청' 인 과목 조회 (수강등록페이지)
	public List<SubjectVO> selectInSubject (String status);
	
	// 과목 삭제
	public void deleteSubject (SubjectVO vo );
	
	// 학생관리 페이지에서 학생조회
	public List<MemberVO> selectManageStudents(String subname);
	
	// 해당 강의의 출석부 조회
	public List<TempClass_chkVO> selectClaChk (TempClass_chkVO vo);
	
	// 학생들이 제출한 과제 조회
	public List<TempTask_submitVO> selectTasks (String subnum);
	
	// 과제 점수부여
	public void TaskScore (Task_submitVO vo);
	
	// 최종 성적이 부여되지 않은 학생들의 리스트
	public List<TempClassStudentVO> needScoreStudent (String subnum);
	
	// 최종 성적 부여하기
	public void insertScore (ClassStudentVO vo);
	
	// 시험 등록하기
	public void insertTest (TestVO vo);
	
	// 시험 조회하기
	public List<TempTestVO> selectTest (String subname);
	
	// 시험 조회하기2
	public List<TestVO> selectTestMenu ();
	
	
	// 교수부분-----------------------------------------------------------------
}
