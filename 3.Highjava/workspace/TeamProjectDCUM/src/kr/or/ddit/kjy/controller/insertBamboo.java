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


@WebServlet("/insertBamboo.do")
public class insertBamboo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("sec_title");
		String cont = request.getParameter("sec_cont");
		String writer = request.getParameter("sec_writer");
		String id = request.getParameter("mem_id");
		
		BambooVO bvo = new BambooVO();
		
		bvo.setSec_title(title);
		bvo.setSec_cont(cont);
		bvo.setSec_writer(writer);
		bvo.setMem_id(id);
		
		
		IBambooService service = BambooServiceImpl.getInstance();
		
		int cnt = service.insertBamboo(bvo);
		
		response.sendRedirect(request.getContextPath() + "/bamboo.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
