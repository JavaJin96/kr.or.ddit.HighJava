package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		// Session 저장하기
		
		// 1. Session객체를 생성하거나 현재 Session정보 가져오기
		// 형식1) request객체.getSession() 또는 request객체.getSession(true)
		// : 현재 Session이 존재하면 현재 Session을 반환하고, 존재하지 않으면 새로운 Session을 생성해서 반환한다.
		// 형식2) request객체.getSession(false)
		// : 현재 Session이 존재하면 현재 Session을 반환하고, 존재하지 않으면 새로운 Session을 생성하지 않고 null을 반환한다.
		
		HttpSession session = request.getSession();
		
		// 2. 생성된 Session에 데이터 저장하기 : setAttribute()메서드 이용
		// 형식) session객체.setAttribute("key값" , 데이터값) : key값 = 문자열 / 데이터값 = Java의 모든 종류의 데이터
		
		session.setAttribute("testSession", "연습용 세션");
		session.setAttribute("userName", "이순신");
		session.setAttribute("age", 30);
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title> Session 연습 </title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터들을 저장했습니다.</h2><br><br>");
		out.println("<a href='" +request.getContextPath()+ "/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
