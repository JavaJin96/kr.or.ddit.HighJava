package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class UpdatePass
 */
@WebServlet("/updatePass.do")
public class UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		System.out.println("---------------");
		
		HttpSession session = request.getSession();
		MemberVO loginMember = (MemberVO)session.getAttribute("loginUser");
		
		String newpass = request.getParameter("mem_pass");
		String userid = loginMember.getMem_id();
		
		Map<String, Object> map = new HashMap<>();
		map.put("mem_id", userid);
	    map.put("mem_pass",newpass);
		
	    MemberServiceImpl service = MemberServiceImpl.getInstance();
		int result = service.updatePass(map);
		if(result>0) {
			loginMember.setMem_pass(newpass);
		}
		System.out.println(newpass);
		response.sendRedirect(request.getContextPath()+"/work_kjy/main.jsp");
	}
}
