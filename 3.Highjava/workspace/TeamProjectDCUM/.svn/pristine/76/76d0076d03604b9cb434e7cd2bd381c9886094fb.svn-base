package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.kjy.service.GongjiServiceImpl;
import kr.or.ddit.kjy.service.IGongjiService;


@WebServlet("/gongji.do")
public class gongji extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IGongjiService service = GongjiServiceImpl.getInstance();
		
		List<GongjiVO> gongjiList = service.getAllGongji();
		
		request.setAttribute("gongjiList", gongjiList);
		
		request.getRequestDispatcher("/work_kjy/gongji/gongji.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
