package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.kjy.service.CommunityServiceImpl;
import kr.or.ddit.kjy.service.ICommunityService;


@WebServlet("/communitySearch.do")
public class communitySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String ccont = request.getParameter("cmu_cont");
		
		ICommunityService service = CommunityServiceImpl.getInstance();
		
		List<CommunityVO> commuList = service.searchCommu(ccont);
		
		request.setAttribute("commuList", commuList);
		
		request.getRequestDispatcher("/work_kjy/community/community.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
