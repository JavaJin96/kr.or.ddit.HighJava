package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.synth.SynthSeparatorUI;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.TestVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/TestChk.do")
public class TestChk extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		int count = 0;
		String score = "";
		TestVO tvo = new TestVO();
		
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		String answer = request.getParameter("answer");
		String testname = request.getParameter("testname");
		
		String q1 = request.getParameter("qa");
		String q2 = request.getParameter("qa2");
		String q3 = request.getParameter("qa3");
		String q4 = request.getParameter("qa4");
		String q5 = request.getParameter("qa5");
		String q6 = request.getParameter("qa6");
		String q7 = request.getParameter("qa7");
		String q8 = request.getParameter("qa8");
		String q9 = request.getParameter("qa9");
		String q10 = request.getParameter("qa10");
		
		
				
		String answerarr [] = answer.split("/");
		System.out.println(answerarr);
		System.out.println(answerarr[0]);
		
		if(answerarr[0].equals(q1)) {
			count++;
		}
		if(answerarr[1].equals(q2)) {
			count++;
		}
		if(answerarr[2].equals(q3)) {
			count++;
		}
		if(answerarr[3].equals(q4)) {
			count++;
		}
		if(answerarr[4].equals(q5)) {
			count++;
		}
		if(answerarr[5].equals(q6)) {
			count++;
		}
		if(answerarr[6].equals(q7)) {
			count++;
		}
		if(answerarr[7].equals(q8)) {
			count++;
		}
		if(answerarr[8].equals(q9)) {
			count++;
		}
		if(answerarr[9].equals(q10)) {
			count++;
		}
		
	
		if(count >= 10) {
			score = "A+";
		}else if(count >= 8) {
			score = "A";
		}else if(count >= 7) {
			score = "B+";
		}else if(count >= 6) {
			score = "B";
		}else if(count >= 4) {
			score = "C";
		}else {
			score = "F";
		}
		
		
		
		tvo.setScore(score);
		tvo.setTest_name(testname);
		tvo.setMem_id(mvo.getMem_id());
		
		service.updateTest(tvo);
		
		request.setAttribute("score", score);
		request.getRequestDispatcher("/work_psj/Test/indexs.jsp").forward(request, response);
		
		session.setAttribute("score", score);
		System.out.println(session.getAttribute(score));
		
	}

}
