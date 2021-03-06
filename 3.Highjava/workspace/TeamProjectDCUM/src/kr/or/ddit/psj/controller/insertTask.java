package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.TaskVO;
import kr.or.ddit.dcum.vo.Task_submitVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertTask.do")
public class insertTask extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		Task_submitVO vo = new Task_submitVO();
		HttpSession session = request.getSession();
		MemberVO mvo = new MemberVO();
		mvo = (MemberVO) session.getAttribute("loginUser");
		
		String memid = mvo.getMem_id();
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String file = request.getParameter("file");
		String subname = request.getParameter("subname");
		
		System.out.println(subname);
		
		vo.setTask_title(title);
		vo.setTask_comt(cont);
		vo.setTask_name(subname);
		vo.setTask_chk("Y");
		vo.setMem_id(memid);
		vo.setPath(file);
		
		
		service.submitTask(vo);
		
		response.sendRedirect(request.getContextPath() + "/work_psj/homework/index.jsp");

	}

}
