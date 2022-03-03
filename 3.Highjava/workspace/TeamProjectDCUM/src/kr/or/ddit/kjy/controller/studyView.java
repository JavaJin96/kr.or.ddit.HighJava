package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.StudyApplyVO;
import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.kjy.service.IStudyService;
import kr.or.ddit.kjy.service.StudyServiceImpl;


@WebServlet("/studyView.do")
public class studyView extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String snum = request.getParameter("sb_num");
//		String smem = request.getParameter("mem_id");
		
		IStudyService service = StudyServiceImpl.getInstance();
		
		StudyVO svo = service.selectStudy(snum);
		List<StudyApplyVO> sivo = (List<StudyApplyVO>) service.getStudyStudent(snum);
		
		request.setAttribute("studyVo", svo);
		request.setAttribute("studentVo", sivo);
		
		request.getRequestDispatcher("/work_kjy/study/studyView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
