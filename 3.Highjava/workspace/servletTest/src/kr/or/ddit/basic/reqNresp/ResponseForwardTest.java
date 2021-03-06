package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responseForwardTest.do")
public class ResponseForwardTest extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩 설정
		request.setCharacterEncoding("utf-8");
		
		// 처음 요청할 때 클라이언트가 보낸 데이터를 받아 올 수 있다.
		String userName = request.getParameter("username");
		
		// setAttribute()메서드로 보낸 데이터는 getAttribute()메서드로 받을 수 있다.
		// 형식) getAttribute("key값");
		String tel = (String)request.getAttribute("tel");
		
		
		// 응답을 하기위한 준비
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>forward연습</title></head>");
		out.println("<body>");
		out.println("<h2>forward이동 결과 </h2>");
		out.println("<ul>");
		out.println("<li> 이름 : " + userName + "</li>");
		out.println("<li> 전화 : " + tel + "</li>");
		out.println("</ul>");
		out.println("</body></html>");
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
