package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.kjy.service.IreCommunityService;
import kr.or.ddit.kjy.service.reCommunityServiceImpl;

@WebServlet("/deleteReCommunity.do")
public class deleteReCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("cmu_num");
		String reno = request.getParameter("cmu_re_num");
		
		IreCommunityService service = reCommunityServiceImpl.getInstance();
		int cnt = service.deleteReCommu(reno);
		
		
		response.sendRedirect(request.getContextPath()+"/communityView.do?cmu_num=" + no);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
