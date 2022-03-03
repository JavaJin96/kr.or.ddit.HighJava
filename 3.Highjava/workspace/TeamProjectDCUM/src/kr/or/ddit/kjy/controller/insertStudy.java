package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.StudyVO;
import kr.or.ddit.kjy.service.IStudyService;
import kr.or.ddit.kjy.service.StudyServiceImpl;


@WebServlet("/insertStudy.do")
public class insertStudy extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("sb_title");
		String cont = request.getParameter("sb_cont");
		String writer = request.getParameter("sb_writer");
		String sort = request.getParameter("sb_sort");
		int total = Integer.parseInt(request.getParameter("total_cnt"));
		String id = request.getParameter("mem_id");
		
		StudyVO svo = new StudyVO();
		
		svo.setSb_title(title);
		svo.setSb_cont(cont);
		svo.setSb_writer(writer);
		svo.setSb_sort(sort);
		svo.setTotal_cnt(total);
		svo.setMem_id(id);

		IStudyService service = StudyServiceImpl.getInstance();
		
		int cnt = service.insertStudy(svo);
		
		response.sendRedirect(request.getContextPath() + "/study.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
