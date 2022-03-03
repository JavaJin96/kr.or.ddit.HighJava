package kr.or.ddit.kjy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.kjy.service.CommunityServiceImpl;
import kr.or.ddit.kjy.service.ICommunityService;

@WebServlet("/updateCommunity.do")
public class updateCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("cmu_num");
		String title = request.getParameter("cmu_title");
		String cont = request.getParameter("cmu_cont");
		String writer = request.getParameter("cmu_writer");
		String sort = request.getParameter("cmu_sort");
		
		CommunityVO cvo = new CommunityVO();
		cvo.setCmu_num(no);
		cvo.setCmu_title(title);
		cvo.setCmu_cont(cont);
		cvo.setCmu_writer(writer);
		cvo.setCmu_sort(sort);
		
		
		ICommunityService service = CommunityServiceImpl.getInstance();
		
		int cnt = service.updateCommu(cvo);
		
//		response.sendRedirect(request.getContextPath() + "/communityView.do?cmu_num=" + no);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/communityView.do?cmu_num=" + no);
	    dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
