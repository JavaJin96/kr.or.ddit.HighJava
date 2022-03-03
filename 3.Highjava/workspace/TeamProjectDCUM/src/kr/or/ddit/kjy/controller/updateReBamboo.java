package kr.or.ddit.kjy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BambooReplyVO;
import kr.or.ddit.kjy.service.IreBambooService;
import kr.or.ddit.kjy.service.reBambooServiceImpl;


@WebServlet("/updateReBamboo.do")
public class updateReBamboo extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("sec_num");
		String reno = request.getParameter("sec_re_num");
		String reply = request.getParameter("sec_re_cont");
		String writer = request.getParameter("sec_re_writer");
		
		BambooReplyVO rvo = new BambooReplyVO();
		rvo.setSec_re_num(reno);
		rvo.setSec_re_cont(reply);
		rvo.setSec_re_writer(writer);
		
		IreBambooService service = reBambooServiceImpl.getInstance();
		
		int cnt = service.updateReBamboo(rvo);
		
//		response.sendRedirect("http://localhost/test/bambooView.do?sec_num=" + no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bambooView.do?sec_num=" + no);
		dispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
