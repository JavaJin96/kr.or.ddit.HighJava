package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;


@WebServlet("/deleteBamboo.do")
public class deleteBamboo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bnum = request.getParameter("sec_num");
		
		IBambooService service = BambooServiceImpl.getInstance();
		int cnt = service.deleteBamboo(bnum);
		
		response.sendRedirect(request.getContextPath() + "/bamboo.do");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
