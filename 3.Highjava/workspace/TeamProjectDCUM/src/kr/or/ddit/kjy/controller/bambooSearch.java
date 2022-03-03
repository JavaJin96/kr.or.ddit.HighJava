package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;

@WebServlet("/bambooSearch.do")
public class bambooSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		String bcont = request.getParameter("sec_cont");
		
		IBambooService service = BambooServiceImpl.getInstance();
		
		List<BambooVO> bambooList = service.searchBamboo(bcont);
		
		request.setAttribute("bambooList", bambooList);
		
		request.getRequestDispatcher("/work_kjy/bamboo/bamboo.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
