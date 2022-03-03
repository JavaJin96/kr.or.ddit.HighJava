package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertSScore.do")
public class insertSScore extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		String score = request.getParameter("score");
		String memid = request.getParameter("memid");
		
		ClassStudentVO cvo = new ClassStudentVO();
		cvo.setSub_score(Integer.parseInt(score));
		cvo.setSub_num(memid);
		
		service.insertScore(cvo);
		
		response.sendRedirect(request.getContextPath()+"/work_psj/p_manageStudent/index.jsp");
	}

}
