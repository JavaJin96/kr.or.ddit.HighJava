package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest04
 */
@WebServlet("/ServletTest04.do")
public class ServletTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 	Servlet클래스나 JSP 페이지의 환경에 관련된 정보는 javax.servlet.ServletContext인터페이스 타입의 객체를 이용해서 얻을 수 있다.
		 */
		ServletContext context = getServletContext();
		
		// 서버 정보 구하기
		String serverInfo = context.getServerInfo();
		
		// 
		int majorVersion = context.getMajorVersion();
		int minorVersion = context.getMinorVersion();
		
		// 서버 이름 구하기
		String servletName = getServletName();
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>웹 서버의 정보 </title></head>");
		out.println("<body>");
		out.println("<h2 style='color:maroon'>웹 서버의 종류(serverInfo) : " + serverInfo + "<br>");
		out.println("servletName : " + servletName + "<br>");
		out.printf("사용중인 Servlet 버전 : (%d.%d)<br><br>", majorVersion, minorVersion);
		
		/*
		 * 	웹 애플리케이션의 초기화 파라미터 : web.xml에 설정해 놓을 수 있다.
		 * 
		 * 	web.xml에서 코드 작성후
		 *   <context-param>
  				<param-name>userName</param-name>
  				<param-value>홍길동</param-value>
  			 </context-param>
  			 
  			 - web.xml에 설정된 초기화 파라미터 값을 구해오는 방법
  			  1. Servlet클래스에서는 ServletContext객체를 구하고 그 ServletConext객체의 getInitParameter()메서드를 호출하여 구한다.
  			  2. JSP문서에서는 application이라는 이름에 ServletContext객체가 저장되어 있다. 따라서 application.getInitParameter()
  			  	 메서드를 호출하여 구한다.
		 * 
		 */
		
		String userName = context.getInitParameter("userName");
		out.println("web.xml에 설정된 파라미터 userName값 : " + userName + "<br>");
		
		out.println("web.xml에 설정된 파라미터 uploadDir값  : " + context.getInitParameter("uploadDir"));
		
		
		
		out.println("</h2>");
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
