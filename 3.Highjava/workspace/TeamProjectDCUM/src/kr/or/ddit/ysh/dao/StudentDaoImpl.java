package kr.or.ddit.ysh.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.ClassSubjectVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.ManagStudentVO;
import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.dcum.vo.SubjectTiVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.util.SqlMapClientFactory;

public class StudentDaoImpl implements IStudentDao {
	
	//싱글톤
	private static StudentDaoImpl dao;
	private SqlMapClient client;
	
	public StudentDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	public static StudentDaoImpl getInstance() {
		if(dao == null) dao = new StudentDaoImpl();
		return dao;
	}
	
	
	//학생 성적 구하는 메서드
	public List<ClassSubjectVO> selectStudent(String memid) {
		List<ClassSubjectVO> list = new ArrayList<>();
		
		
		try {
			list = client.queryForList("dum.selectStudent", memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//학생교과목을 불러오는 메서드
	@Override
	public List<SubjectTiVO> selectSubject(String memid) {
		List<SubjectTiVO> list = null;		
		
		try {
			list = client.queryForList("dum.selectSubject", memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		return list;
	}
	
	//수강 목록을 갖고오는 메서드
	@Override
	public List<SubjectVO> SubjectList(Map<String,Object>map) {
		List<SubjectVO> list = new ArrayList<>();
		
		try {
			list = client.queryForList("dum.SubjectList", map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	//수강신청 값을 저장하는 메서드 리턴값 없애고 void 로 전부 지정
	@Override
	public void viewClass(Map<String, Object> map) {
		
		
		try {
			client.insert("dum.viewClass",map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	
	//학생의 학적을 불러오는 메서드
	@Override
	public List<ManagStudentVO> studentList(String memid) {
		List<ManagStudentVO> list = new ArrayList<>();

		try {
			list = client.queryForList("dum.studentList",memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//본인 메일함을 불러오는 메서드 리턴 값 memid
	
	@Override
	public List<MessageVO>mailView(String memid) {
		List<MessageVO> list = new ArrayList<>();
		
		try {
			list = client.queryForList("Stu.mailView", memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//나의 쪽지함 상세보기를 불러오는 메서드
	@Override
	public MessageVO mailList(String memid) {
			MessageVO vo = new MessageVO();
		
		try {
			vo= (MessageVO)client.queryForObject("Stu.mailList",memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return vo;
	}
	
	
	//매일을 저장하는 메서드
	@Override
	public MessageVO mailinsert(MessageVO vo) {
			
					
		try {
			vo = (MessageVO)client.insert("Stu.mailinsert",vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return null;
	}
	
	//쪽지전송시 리스트를 띄워주는 옵션
	@Override
	public List<SubjectVO> viewSubject(String memid) {
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		
		
		try {
			list = client.queryForList("Stu.viewSubject", memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		
		return list;
	}
	
	//쪽지전송 리스트2 생성
	@Override
	public List<ClassStudentVO> viewSubject2(String memid) {
		List<ClassStudentVO> list = new ArrayList<ClassStudentVO>();
		
		
		try {
			list = client.queryForList("Stu.viewSubject2",memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//내가 가지고있는 강의 목록을 불러오는메서드
	@Override
	public List<SubjectVO> SubjectList2(String memid) {
		List<SubjectVO> list = new ArrayList<>();
		
		try {
			list = client.queryForList("Stu.SubjectList2", memid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
	
	//수강신청을 삭제하는 메서드
	@Override
	public String deleteSubeject(String subnum) {
		
		int no = 0;
		
		try {
			no = client.delete("Stu.deleteSubeject" , subnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//매일을 삭제하는 메서드
	@Override
	public String DeleteMail(String mesnum) {
		
		
		try {
			client.delete("Stu.DeleteMail" , mesnum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	
	//발신 메시지를 불러오는 메서드
	@Override
	public List<MessageVO> balView(String balmemid) {
		
		List list = new ArrayList<>();
		
		
		try {
			list = client.queryForList("Stu.balView" , balmemid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return list;
	}
	
	
	
	
	
	
	
	
}
