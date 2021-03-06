package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Session 삭제하기
		
		// 1. Session객체 생성 또는 현재 Session구하기
		HttpSession session = request.getSession();
		
		// 2-1. Session에 저장된 개별 Session데이터 삭제하기
		// 형식) session객체.removeAttribute("삭제할key값");
		// : Session자체는 삭제되지 않고 지정한 'key값' 에 해당하는 개별 Session데이터를 삭제한다.
		/*session.removeAttribute("testSession");*/
		
		// 2-2. Session객체 자체를 삭제하기
		// 형식) session객체.invaildate(); 메서드 사용하기
		session.invalidate();
		
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title> Session 읽기 </title></head>");
		out.println("<body>");
		out.println("<h2> Session 삭제하기 </h2>");
		
		out.println("<br><hr><br>");

		out.println("<a href='" +request.getContextPath()+ "/basic/session/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
