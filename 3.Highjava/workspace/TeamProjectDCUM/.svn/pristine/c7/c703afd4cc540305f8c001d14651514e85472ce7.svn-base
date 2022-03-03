package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.CommuReplyVO;
import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.kjy.service.CommunityServiceImpl;
import kr.or.ddit.kjy.service.ICommunityService;
import kr.or.ddit.kjy.service.IreCommunityService;
import kr.or.ddit.kjy.service.reCommunityServiceImpl;

@WebServlet("/communityView.do")
public class communityView extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String cnum = request.getParameter("cmu_num");
		
		ICommunityService service = CommunityServiceImpl.getInstance();
		IreCommunityService reservice = reCommunityServiceImpl.getInstance();
		
		CommunityVO cvo = service.selectCommu(cnum);
		List<CommuReplyVO> crvo = reservice.getAllReCommu(cnum);
		
		request.setAttribute("commuVo", cvo);
		request.setAttribute("reCommuVo", crvo);
		
		request.getRequestDispatcher("/work_kjy/community/communityView.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
