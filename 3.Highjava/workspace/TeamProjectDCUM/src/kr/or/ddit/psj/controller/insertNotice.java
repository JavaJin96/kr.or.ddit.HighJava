package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.psj.service.ClassServiceimpl;

/**
 * Servlet implementation class insertNotice
 */
@WebServlet("/insertNotice.do")
public class insertNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		BoardVO bvo = new BoardVO(); 
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		String writer = vo.getMem_name();
		String memid = vo.getMem_id();
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		
		bvo.setBoard_writer(writer);
		bvo.setMem_id(memid);
		bvo.setBoard_title(title);
		bvo.setBoard_cont(cont);
		bvo.setClass_num("1");
		
		service.insertNotice(bvo);
		
		response.sendRedirect(request.getContextPath() + "/work_psj/notice/pindex.jsp");
		
	}

}
