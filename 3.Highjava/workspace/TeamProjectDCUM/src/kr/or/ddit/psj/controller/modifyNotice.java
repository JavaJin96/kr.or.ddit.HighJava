package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/modifyNotice.do")
public class modifyNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String bonum = request.getParameter("bnum");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		BoardVO bvo = new BoardVO();
		bvo.setBoard_title(title);
		bvo.setBoard_cont(cont);
		bvo.setBoard_num(bonum);
		
		service.modifyPQna(bvo);
		
		response.sendRedirect(request.getContextPath() + "/work_psj/notice/pindex.jsp");
		
		
	}

}
