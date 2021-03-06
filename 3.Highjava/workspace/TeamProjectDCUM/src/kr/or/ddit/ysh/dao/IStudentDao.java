package kr.or.ddit.ysh.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.ClassSubjectVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.ManagStudentVO;
import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.dcum.vo.StudentVO;
import kr.or.ddit.dcum.vo.SubjectTiVO;
import kr.or.ddit.dcum.vo.SubjectVO;


public interface IStudentDao {
	
	//학생의 성적을 불러오는 메서드
	public List<ClassSubjectVO> selectStudent (String memid);
	
	//학생의 교과목을 불러오는 메서드 - 변경
	public List<SubjectTiVO> selectSubject(String memid);

	//수강신청 과목을 불러오는 메서드
	public List<SubjectVO> SubjectList(Map<String, Object> map);
	
	
	//수강신청 과목을 저장하는 메서드
	public void viewClass(Map<String, Object> map);
	
	//학생의 학적을 불러오는 메서드 
	public List<ManagStudentVO> studentList (String memid);
	
	//나의 쪽지함리스트를 불러오는 메서드
	public List<MessageVO> mailView (String memid);
	
	//나의 쪽지 상세정보를 불러오는 메서드
	public MessageVO mailList (String memid);
	
	
	//매일 저장하는 메서드
	public MessageVO mailinsert(MessageVO vo);

	//쪽지전송시 옵션리스트 생성
	public List<SubjectVO> viewSubject(String memid);
	
	//쪽지전송시 옵션리스트 2 생성
	public List<ClassStudentVO> viewSubject2(String memid);  

	//내가가지고 있는 수강목록을 불러오는 메서드,
	public List<SubjectVO> SubjectList2(String memid);
	
	//수강신청을 삭제하는 메서드 
	public String deleteSubeject(String subnum);

	//매일을 삭제하는 메서드
	public String DeleteMail(String mesnum);
	
	//발신 매일을 불러오는 메서드
	public List<MessageVO> balView(String balmemid);
	
	
}
