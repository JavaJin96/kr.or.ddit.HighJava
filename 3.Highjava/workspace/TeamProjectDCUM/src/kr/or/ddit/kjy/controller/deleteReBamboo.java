package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;
import kr.or.ddit.kjy.service.IreBambooService;
import kr.or.ddit.kjy.service.reBambooServiceImpl;


@WebServlet("/deleteReBamboo.do")
public class deleteReBamboo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("sec_num");
		String reno = request.getParameter("sec_re_num");
		
		IreBambooService service = reBambooServiceImpl.getInstance();
		int cnt = service.deleteReBamboo(reno);
		
		response.sendRedirect(request.getContextPath()+"/bambooView.do?sec_num=" + no);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
