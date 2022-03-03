package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/qnaModify.do")
public class qnaModify extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		BoardVO vo = new BoardVO();
		
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String boardnum = request.getParameter("boardnum");
		
		vo.setBoard_title(title);
		vo.setBoard_cont(cont);
		vo.setBoard_num(boardnum);
		
		service.modifyQna(vo);
		
		response.sendRedirect(request.getContextPath() + "/work_psj/qnaboard/index.jsp");

	}

}
