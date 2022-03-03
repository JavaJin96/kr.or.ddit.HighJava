package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;


@WebServlet("/updateBamboo.do")
public class updateBamboo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("sec_num");
		String title = request.getParameter("sec_title");
		String cont = request.getParameter("sec_cont");
		String writer = request.getParameter("sec_writer");
		
		BambooVO bvo = new BambooVO();
		bvo.setSec_num(no);
		bvo.setSec_title(title);
		bvo.setSec_cont(cont);
		bvo.setSec_writer(writer);
		
		
		IBambooService service = BambooServiceImpl.getInstance();
		
		int cnt = service.updateBamboo(bvo);
		
//		response.sendRedirect("http://localhost/test/bambooView.do?sec_num=" + no);
		request.getRequestDispatcher("/bambooView.do?sec_num=" + no).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
