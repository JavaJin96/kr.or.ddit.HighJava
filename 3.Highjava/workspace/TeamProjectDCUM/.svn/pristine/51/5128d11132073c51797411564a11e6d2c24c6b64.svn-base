package kr.or.ddit.kjy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.StudyApplyVO;
import kr.or.ddit.kjy.service.IStudyService;
import kr.or.ddit.kjy.service.StudyServiceImpl;


@WebServlet("/insertApply.do")
public class insertApply extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("sb_num");
		String id = request.getParameter("mem_id");
		String gender = request.getParameter("mem_gender");
		String name = request.getParameter("mem_name");
		
		StudyApplyVO svo = new StudyApplyVO();
		
		svo.setSb_num(no);
		svo.setMem_name(name);
		svo.setMem_gender(gender);
		svo.setMem_id(id);
		
		IStudyService service = StudyServiceImpl.getInstance();
		int cnt = service.insertApply(svo);
		
//		response.sendRedirect(request.getContextPath() + "/studyView.do?sb_num=" + no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studyView.do?sb_num=" + no);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
