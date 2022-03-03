package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.ClassSubjectVO;
import kr.or.ddit.ysh.service.IStudentService;
import kr.or.ddit.ysh.service.StudentServiceImpl;

@WebServlet("/StudentSum.do")
public class StudentSum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public StudentSum() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	// 클라이언트 요청 전송데이터
		
		
	request.setCharacterEncoding("UTF-8");
	
	// service 객체얻기
	StudentServiceImpl service = StudentServiceImpl.getInstance();
	
	String memid = request.getParameter("memid");
	
	//service 객체 생성
	List<ClassSubjectVO> list = service.selectStudent(memid);
	
	
	//결과값을 출력 json 데이터 생성

	request.setAttribute("list",list);
	int result = 0;
	for(ClassSubjectVO vo : list) {
		result += vo.getSub_score();	
		}
	
	
	//jsp로 전송
	
	request.setAttribute("resultNum", result);
	request.getRequestDispatcher("work_ysh/Select.jsp").forward(request, response);
	
	
	}

}
