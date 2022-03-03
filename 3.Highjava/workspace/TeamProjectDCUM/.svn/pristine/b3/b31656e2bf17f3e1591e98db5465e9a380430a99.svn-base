package kr.or.ddit.kjy.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.BambooVO;
import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.kjy.service.BambooServiceImpl;
import kr.or.ddit.kjy.service.GongjiServiceImpl;
import kr.or.ddit.kjy.service.IBambooService;
import kr.or.ddit.kjy.service.IGongjiService;


@WebServlet("/updateGongjiForm.do")
public class updateGongjiForm extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String gnum = request.getParameter("gongji_num");
		
		IGongjiService service = GongjiServiceImpl.getInstance();
		
		GongjiVO gvo = service.selectGongji(gnum);
		
		request.setAttribute("gongjiVo", gvo);
		request.getRequestDispatcher("/work_kjy/gongji/updateGongji.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
