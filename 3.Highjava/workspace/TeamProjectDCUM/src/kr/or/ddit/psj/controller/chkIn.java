package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.Class_chkVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/chkIn.do")
public class chkIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		String classname = request.getParameter("className");
		
		ClassVO cvo = service.selectClassByName(classname);
		
		Class_chkVO ccvo = new Class_chkVO();
		
		ccvo.setMem_id(mvo.getMem_id());
		ccvo.setClass_num(classname);
		ccvo.setStatus("Y");
		
		service.chkIn(ccvo);
		
		String res = "{\"sw\" : \"1\"}";
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
	}

}
