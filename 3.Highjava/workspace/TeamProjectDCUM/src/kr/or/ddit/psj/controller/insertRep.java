package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.Board_ReplyVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertRep.do")
public class insertRep extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		HttpSession session = request.getSession();
		Board_ReplyVO vo = new Board_ReplyVO();
		String cont = request.getParameter("cont");
		String bonum = request.getParameter("bonum");
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		String memname = mvo.getMem_name();
		cont = cont.replace("\r", "").replace("\n", "<br>");
		
		vo.setBoard_num(bonum);
		vo.setRe_writer(memname);
		vo.setRe_cont(cont);
		
		service.insertQnaRe(vo);
		
		response.sendRedirect(request.getContextPath() + "/work_psj/qnaboard/index.jsp");
		
		
		
	}

}
