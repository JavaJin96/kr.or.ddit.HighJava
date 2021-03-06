package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.Task_submitVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertTaskScore.do")
public class insertTaskScore extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		String score = request.getParameter("score");
		String tasknum = request.getParameter("tasknum");
		
		Task_submitVO tvo = new Task_submitVO();
		
		tvo.setTask_score(score);
		tvo.setTask_num(tasknum);
		
		service.TaskScore(tvo);
		
		response.sendRedirect(request.getContextPath()+"/work_psj/p_manageStudent/index.jsp");
		
	}

}
