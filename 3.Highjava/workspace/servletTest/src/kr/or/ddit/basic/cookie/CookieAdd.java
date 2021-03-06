package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieAdd.do")
public class CookieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// Cookie 저장하는 방법
		// 1. Cookie객체를 생성한다. : '쿠키변수' 와 '쿠키값'을 문자열로 지정하여 생성한다.
		// 형식) Cookie 쿠키변수= new Cookie("쿠키변수", "쿠키값");
		// : 쿠키값으로 한글을 사용할 경우 URLEncoder.encode()메서드로 인코딩한 후 사용한다.
		Cookie nameCookie = new Cookie("name", "홍길동");
		Cookie nameCookie2 = new Cookie("name", URLEncoder.encode("홍길동", "utf-8"));
		// 한글이 깨져서 나올때는 인코딩을 직접 해줘야한다.
		// 다만, 인코딩을 하면 URLDecoder.decode("대상문자열" , "인코딩코드")메서드를 사용해 decoding 한 후 출력해야한다. 
		Cookie ageCookie = new Cookie("age", "26");
		Cookie genderCookie = new Cookie("gender", "Male");
		
		
		// 2. 쿠키 속성을 설정한다.
		// -쿠키변수.setPath("적용경로"); : 지정한 경로와 그 하위 경로에서 사용 가능하다. 생략하면 쿠키를 설정할 당시의 경로가 설정된다.
		// -쿠키변수.setMaxAge(유지시간); : 단위(초) (지정한 단위만큼 쿠키를 저장하다가 시간이 지나면 쿠키를 삭제한다.)
		//							  : -1(음수) : 브라우저가 종료될 때까지 유지(기본값)
		//							  : 0 : 즉시 쿠키가 삭제된다.
		// -쿠키변수.setDomain("적용도메인명"); : 예) ".ddit.or.kr" :www.ddit.or.kr, mail.ddit.or.kr, cafe.ddit.or.kr
		// -쿠키변수.setSecure(보안여부); : 보안 적용 : true / false
		
		
		// 3. response객체를 이용하여 쿠키를 웹브라우저에 응답으로 보내면 웹브라우저가 이 쿠키를 받아서 저장한다.
		// 형식) response.addCookie(1번에서 만든 쿠키변수)
		response.addCookie(nameCookie);
		response.addCookie(ageCookie);
		response.addCookie(genderCookie);
		
		
		// response 생성
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>쿠키 저장 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Cookie 데이터가 저장되었습니다. </h2><br><br>");
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest01.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
