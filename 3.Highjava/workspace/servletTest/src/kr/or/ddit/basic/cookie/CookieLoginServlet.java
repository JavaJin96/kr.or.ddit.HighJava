package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 로그인 창에서 입력한 값 가져오기
		String userId = request.getParameter("userid");	// ID값
		String userPass = request.getParameter("userpass");	// Password값
		String chkId = request.getParameter("chkid");	// 체크박스의 값
		
		// 쿠키 객체 생성
		Cookie cookie = new Cookie("userID", userId);
		
		// 체크박스의 체크 여부를 검사하여 처리하기
		if(chkId != null) {
			// 체크박스가 체크되었을 때
			// 쿠키 저장하기
			response.addCookie(cookie);
		}else {
			// 체크박스가 체크되지 않았을 때
			// 쿠키 삭제하기
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		// 로그인 성공 여부를 판단하기
		if(userId.equals("test") && userPass.equals("1234")) {
			// 로그인 성공
			// cookieMain.jsp로 이동하기
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieMain.jsp");
		}else {
			// 로그인 실패
			// cookieLogin.jsp로 이동하기
			response.sendRedirect(request.getContextPath()+"/basic/cookie/cookieLogin.jsp");
		}
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
