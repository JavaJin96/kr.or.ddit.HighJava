package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertQna.do")
public class insertQna extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		BoardVO bvo = new BoardVO(); 
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		String name = mvo.getMem_name();
		String memid = mvo.getMem_id();
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String subject = request.getParameter("subject");
		String classn = request.getParameter("class");
		ClassVO cvo = service.selectClassByName(classn);
		cont = cont.replace("\r", "").replace("\n", "<br>");
		
		bvo.setBoard_writer(name);
		bvo.setBoard_cont(cont);
		bvo.setBoard_title(title);
		bvo.setClass_num(cvo.getClass_num());
		bvo.setMem_id(memid);
		
		service.insertQna(bvo);
		
		response.sendRedirect(request.getContextPath()+"/work_psj/qnaboard/index.jsp");
		
		
		
	}

}

// 모든 class가 같은 모든 댓글