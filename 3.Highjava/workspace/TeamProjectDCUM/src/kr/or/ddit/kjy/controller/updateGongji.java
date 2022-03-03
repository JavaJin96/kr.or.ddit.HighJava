package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.GongjiServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;
import kr.or.ddit.kjy.service.IGongjiService;


@WebServlet("/updateGongji.do")
public class updateGongji extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("gongji_num");
		String title = request.getParameter("gongji_nm");
		String cont = request.getParameter("gongji_cont");
		
		GongjiVO gvo = new GongjiVO();
		gvo.setGongji_num(no);
		gvo.setGongji_nm(title);
		gvo.setGongji_cont(cont);
		
		IGongjiService service = GongjiServiceImpl.getInstance();
		
		int cnt = service.updateGongji(gvo);
		
		response.sendRedirect("http://localhost/test/gongjiView.do?gongji_num=" + no);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
