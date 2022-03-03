package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.kjy.service.IStudyService;
import kr.or.ddit.kjy.service.StudyServiceImpl;


@WebServlet("/studySearch.do")
public class studySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String stitle = request.getParameter("sb_title");
		
		IStudyService service = StudyServiceImpl.getInstance();
		
		List<StudyVO> studyList = service.searchStudy(stitle);
		
		request.setAttribute("studyList", studyList);
		
		request.getRequestDispatcher("/work_kjy/study/study.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
