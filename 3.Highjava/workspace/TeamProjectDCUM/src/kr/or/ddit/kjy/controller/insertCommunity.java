package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.CommunityServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;
import kr.or.ddit.kjy.service.ICommunityService;


@WebServlet("/insertCommunity.do")
public class insertCommunity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("cmu_title");
		String cont = request.getParameter("cmu_cont");
		String writer = request.getParameter("cmu_writer");
		String sort = request.getParameter("cmu_sort");
		String id = request.getParameter("mem_id");
		
		CommunityVO cvo = new CommunityVO();
		
		cvo.setCmu_title(title);
		cvo.setCmu_cont(cont);
		cvo.setCmu_writer(writer);
		cvo.setCmu_sort(sort);
		cvo.setMem_id(id);

		ICommunityService service = CommunityServiceImpl.getInstance();
		
		int cnt = service.insertCommu(cvo);
		
		response.sendRedirect(request.getContextPath() + "/community.do");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
