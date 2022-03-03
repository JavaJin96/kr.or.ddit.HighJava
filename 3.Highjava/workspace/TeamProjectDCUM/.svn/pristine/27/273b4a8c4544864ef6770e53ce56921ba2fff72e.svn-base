package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.kjy.service.CommunityServiceImpl;
import kr.or.ddit.kjy.service.GongjiServiceImpl;
import kr.or.ddit.kjy.service.ICommunityService;
import kr.or.ddit.kjy.service.IGongjiService;


@WebServlet("/updateCommunityForm.do")
public class updateCommunityForm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cnum = request.getParameter("cmu_num");
		
		ICommunityService service = CommunityServiceImpl.getInstance();
		
		CommunityVO cvo = service.selectCommu(cnum);
		
		request.setAttribute("commuVo", cvo);
		request.getRequestDispatcher("/work_kjy/community/updateCommunity.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
