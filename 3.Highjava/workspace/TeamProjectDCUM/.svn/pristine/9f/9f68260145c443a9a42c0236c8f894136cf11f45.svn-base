package kr.or.ddit.kjy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.CommuReplyVO;
import kr.or.ddit.kjy.service.IreCommunityService;
import kr.or.ddit.kjy.service.reCommunityServiceImpl;


@WebServlet("/insertReCommunity.do")
public class insertReCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String writer = request.getParameter("cmu_re_writer");
		String reply = request.getParameter("cmu_re_cont");
		String no = request.getParameter("cmu_num");
		String id = request.getParameter("mem_id");
		
		CommuReplyVO cvo = new CommuReplyVO();
		cvo.setCmu_num(no);
		cvo.setCmu_re_cont(reply);
		cvo.setCmu_re_writer(writer);
		cvo.setMem_id(id);
		
		IreCommunityService service = reCommunityServiceImpl.getInstance();
		
		int cnt = service.insertReCommu(cvo);
		
		
//		response.sendRedirect("http://localhost/test/communityView.do?cmu_num=" + no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/communityView.do?cmu_num=" + no);
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
