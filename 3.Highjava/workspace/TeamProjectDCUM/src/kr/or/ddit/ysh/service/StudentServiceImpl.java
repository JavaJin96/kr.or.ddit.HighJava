package kr.or.ddit.ysh.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.ClassSubjectVO;
import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.dcum.vo.SubjectTiVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.util.SqlMapClientFactory;
import kr.or.ddit.ysh.dao.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService{
	
	private static StudentServiceImpl service;
	private StudentDaoImpl dao;
	
	public StudentServiceImpl() {
		dao = StudentDaoImpl.getInstance();
	}
	
	public static StudentServiceImpl getInstance(){
		
		if(service == null) service = new StudentServiceImpl();
		
		return service;
		
		
	}
	
	
	
	//학생의 성적을 불러오는 메서드
	@Override
	public List<ClassSubjectVO> selectStudent(String memid) {
		// TODO Auto-generated method stub
		return dao.selectStudent(memid);
	}
	//학생이 듣고있는 교과목을 불러오는 메서드
	@Override
	public List<SubjectTiVO> selectSubject(String memid) {
		// TODO Auto-generated method stub
		return dao.selectSubject(memid);
	}

	//수강신청을 불러오는 메서드


	
	//수강신청을 저장하는 메서드 저장값이기 떄문에 리턴은 필요없다
 	@Override
	public void viewClass(Map map) {
		// TODO Auto-generated method stub
		dao.viewClass(map);
	}

	
	//학적을 불러오는 메서드
	@Override
	public List studentList(String memid) {
		// TODO Auto-generated method stub
		return dao.studentList(memid);
	}

	//나의 메일함을 불러오는 메서드 
	@Override
	public List mailView(String memid) {
		// TODO Auto-generated method stub
		return dao.mailView(memid);
	}

	
	//매일 상세내역 보는 메서드
	@Override                         
	public MessageVO mailList(String memid) {
		// TODO Auto-generated method stub
		return (MessageVO)dao.mailList(memid);
	}

	
	//매일을 저장하는 매서드
	@Override
	public MessageVO mailinsert(MessageVO vo) {
		// TODO Auto-generated method stub
		return dao.mailinsert(vo);
	}

	//쪽지전송시 옵션선택하는 메서드
	@Override
	public List viewSubject(String memid) {
		// TODO Auto-generated method stub
		return dao.viewSubject(memid);
	}

	
	//쪽지전송시 리스트 생성 2
	@Override
	public List viewSubject2(String memid) {
		// TODO Auto-generated method stub
		return dao.viewSubject2(memid);
	}

	
	// 나에게 없는 강의목록을 불러오는 메서드
	@Override
	public List SubjectList(Map map) {
		return dao.SubjectList(map);
	}

	//내가 가지고있는 강의 목록을 불러오는 메서드
	public List<SubjectVO> SubjectList2 (String memid) {
		return dao.SubjectList2(memid);
	}

	//강의신청을 삭제하는 메서드
	@Override
	public String deleteSubeject(String subnum) {
		// TODO Auto-generated method stub
		return dao.deleteSubeject(subnum);
	}

	//메일을 삭제하는 메서드
	@Override
	public String DeleteMail(String mesnum) {
		// TODO Auto-generated method stub
		return dao.DeleteMail(mesnum);
	}

	//발신메일을 확인하는메서드
	@Override
	public List balView(String balmemid) {
		// TODO Auto-generated method stub
		return dao.balView(balmemid);
	}

	



	
	
	
	
	
	
	
}
