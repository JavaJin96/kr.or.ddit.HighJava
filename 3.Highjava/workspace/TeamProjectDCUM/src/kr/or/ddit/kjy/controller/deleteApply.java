package kr.or.ddit.kjy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.kjy.service.IStudyService;
import kr.or.ddit.kjy.service.StudyServiceImpl;


@WebServlet("/deleteApply.do")
public class deleteApply extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("sb_num");
		String id = request.getParameter("mem_id");
		
		IStudyService service = StudyServiceImpl.getInstance();
		int cnt = service.deleteApply(id);
		
//		response.sendRedirect(request.getContextPath()+"/studyView.do?sb_num=" + no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studyView.do?sb_num=" + no);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	

}
