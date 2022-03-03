package kr.or.ddit.kjy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BambooReplyVO;
import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;
import kr.or.ddit.kjy.service.IreBambooService;
import kr.or.ddit.kjy.service.reBambooServiceImpl;


@WebServlet("/bambooView.do")
public class bambooView extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String bnum = request.getParameter("sec_num");
		
		IBambooService service = BambooServiceImpl.getInstance();
		IreBambooService reservice = reBambooServiceImpl.getInstance();
		
		BambooVO bvo = service.selectBamboo(bnum);
		List<BambooReplyVO> rvo = reservice.getAllReBamboo(bnum);
		
		
		request.setAttribute("bambooVo", bvo);
		request.setAttribute("rebambooVo", rvo);
		
		request.getRequestDispatcher("/work_kjy/bamboo/bambooView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
