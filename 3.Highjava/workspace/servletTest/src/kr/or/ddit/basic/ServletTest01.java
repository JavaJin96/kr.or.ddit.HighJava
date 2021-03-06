package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 	Servlet이란? : Container에 의해 관리되는 자바 기반의 웹 컴포넌트로서, 동적인 웹 컨텐츠를 생성을 가능하게 하는 기술을 말한다.
 * 
 * 
 * 
 * 
 * 
 * 
 * 	http://localhost:80/servletTest/servletTest01.do
 * 
 * 	- http : 프로토콜
 * 	- localhost : 컴퓨터이름(도메인명), ipAdress
 * 	- 80 : port번호(80번은 웹서비스의 기본 포트번호이기 때문에 생략 가능)
 * 	- /servletTest : Context Path(개발할때는 보통 프로젝트 이름으로 지정한다.)
 * 	- /servletTest01.do : servlet 요청 URL패턴
 * 
 */


// 이 예제는 배포 서술자(DD, Deployment Descriptor : web.xml)를 이용해서 실행할 Servlet을 등록하여 처리하는 예제이다.

// Servlet클래스는 HttpServlet을 상속해서 작성한다.
public class ServletTest01 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Servlet클래스에서는 service()메서드 또는
	// doGet()메서드, doPost()메서드를 재정의 해서 처리할 내용을 기술한다.
	
	// doGet()메서드와 doPost()메서드는 service()메서드를 통해서 호출된다.
	
	// doGet()메서드나 doPost()메서드는 호출될 때 인수값으로
	// HttpServletRequest객체와 HttpServletResponse객체를 받아온다.
	// HttpServletRequest객체 : 서비스 요청에 관련된 정보와 메서드를 관리하는 객체
	// HttpServletResponse객체 : 서비스 응답에 관련된 정보와 메서드를 관리하는 객체
	
	
	// doGet()메서드 : GET방식의 요청을 처리하는 메서드
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8"); 	// 응답 문서의 인코딩 방식 설정
		
		response.setContentType("text/html; charset=utf-8"); 	// 응답 문서의 ContentType 설정 
		
		// 처리한 내용을 클라이언트에 응답으로 보내기 위해서 PrintWriter라는 스트림 객체를 생성한다. (response객체 이용)
		PrintWriter out = response.getWriter();
		
		// 응답을 보낸다. : HTML문서의 내용을 출력한다.
		
		// 방법1) append()메서드를 이용하기
		out.append("<!DOCTYPE html>")
		   .append("<html>")
		   .append("<head>")
		   .append("<meta charset='utf-8'>")
		   .append("<title> 첫번째 Servlet 연습 </title>")
		   .append("<head>")
		   .append("<body>")
		   .append("<h2 style='text-align:center'>")
		   .append("안녕하세요. 첫번째 Servlet 프로그램입니다. <br>")
		   .append("ContextPath : " + request.getContextPath())
		   .append("</h2>")
		   .append("</body>")
		   .append("</html>");
		   
		
		// 방법2) 
		
		
	}
	
	// doPost()메서드 : POST방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	
}
