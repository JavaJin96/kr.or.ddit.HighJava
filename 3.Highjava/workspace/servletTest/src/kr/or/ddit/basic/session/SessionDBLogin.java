package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/sessionDBLogin.do")
public class SessionDBLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String memID = request.getParameter("id");
		String memPASS = request.getParameter("pw");
		
		MemberVO vo = new MemberVO();
		vo.setMem_id(memID);
		vo.setMem_pass(memPASS);
		
		MemberService service = MemberService.getInstance();
		
		MemberVO rVO = service.loginInfo(vo);
		
		HttpSession session = request.getSession();
		
		if(rVO != null) {
			session.setAttribute("loginUser", rVO);
		}
		
		response.sendRedirect(request.getContextPath() + "/basic/session/sessionDBLogin.jsp");
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
