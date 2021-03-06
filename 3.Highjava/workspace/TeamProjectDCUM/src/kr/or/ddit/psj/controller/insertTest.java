package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.dcum.vo.TestVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertTest.do")
public class insertTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		
		 String subname = request.getParameter("subname");
		 String testname = request.getParameter("test");
		 String q1 = request.getParameter("q1");
		 String q2 = request.getParameter("q2");
		 String q3 = request.getParameter("q3");
		 String q4 = request.getParameter("q4");
		 String q5 = request.getParameter("q5");
		 String q6 = request.getParameter("q6");
		 String q7 = request.getParameter("q7");
		 String q8 = request.getParameter("q8");
		 String q9 = request.getParameter("q9");
		 String q10 = request.getParameter("q10");
		 String answer = request.getParameter("answer");
		
		 SubjectVO svo = service.selectOneSubjectForName(subname);
		 
		 
		 
		 List<ClassStudentVO> list = service.selectAllMyStudent(svo.getSub_num());
		 for(int i = 0 ; i < list.size(); i++) {
			TestVO tvo = new TestVO();
			 
			 tvo.setMem_id(list.get(i).getMem_id());
			 tvo.setSub_num(svo.getSub_num());
			 tvo.setSub_name(subname);
			 tvo.setTest_name(testname);
			 tvo.setQ1(q1);
			 tvo.setQ2(q2);
			 tvo.setQ3(q3);
			 tvo.setQ4(q4);
			 tvo.setQ5(q5);
			 tvo.setQ6(q6);
			 tvo.setQ7(q7);
			 tvo.setQ8(q8);
			 tvo.setQ9(q9);
			 tvo.setQ10(q10);
			 tvo.setAnswer(answer);
			 
			 service.insertTest(tvo);
			 
		 }
		 
	}

}
