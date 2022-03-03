package kr.or.ddit.kjy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.kjy.service.IStudyService;
import kr.or.ddit.kjy.service.StudyServiceImpl;


@WebServlet("/updateStudy.do")
public class updateStudy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("sb_num");
		String title = request.getParameter("sb_title");
		String cont = request.getParameter("sb_cont");
		String writer = request.getParameter("sb_writer");
		String sort = request.getParameter("sb_sort");
		int total = Integer.parseInt(request.getParameter("total_cnt"));
		
		StudyVO svo = new StudyVO();
		svo.setSb_num(no);
		svo.setSb_title(title);
		svo.setSb_cont(cont);
		svo.setSb_writer(writer);
		svo.setSb_sort(sort);
		svo.setTotal_cnt(total);
		
		IStudyService service = StudyServiceImpl.getInstance();
		int cnt = service.updateStudy(svo);
		
//		response.sendRedirect(request.getContextPath() + "/studyView.do?sb_num=" + no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/studyView.do?sb_num=" + no);
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
