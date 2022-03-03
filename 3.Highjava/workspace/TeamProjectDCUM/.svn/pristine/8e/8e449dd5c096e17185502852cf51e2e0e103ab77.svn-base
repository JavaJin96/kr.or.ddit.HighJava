package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.kjy.service.GongjiServiceImpl;
import kr.or.ddit.kjy.service.IGongjiService;

@WebServlet("/insertGongji.do")
public class insertGongji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("gongji_nm");
		String cont = request.getParameter("gongji_cont");
		
		GongjiVO gvo = new GongjiVO();
		
		gvo.setGongji_nm(title);
		gvo.setGongji_cont(cont);
		
		
		IGongjiService service = GongjiServiceImpl.getInstance();
		
		int cnt = service.insertGongji(gvo);
		
		response.sendRedirect(request.getContextPath() + "/gongji.do");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
