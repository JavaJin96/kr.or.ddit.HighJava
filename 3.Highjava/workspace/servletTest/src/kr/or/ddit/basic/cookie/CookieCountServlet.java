package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieCountServlet
 */
@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Count증감 연습</title></head>");
		out.println("<body>");
		
		// 'count'라는 쿠키변수가 있는지 검사하는 과정
		// 전체 쿠키들을 가져와서 검사한다.
		Cookie [] cookieCnt = request.getCookies();
			for(Cookie ck : cookieCnt) {
				// for 문을 돌면서 (전체 배열을 검사하면서) 이름이 count 인 쿠키 찾기
				if(ck.getName().equals("count")) {
					// 쿠키에 count라는 쿠키가 있을 때
					if(ck.getValue() == null) {
						Cookie count = new Cookie("count", "0");
						response.addCookie(count);
					}else {
						// 쿠키에 count가 존재하면, 기존에 존재하는 count의 값에 1을 증감해준다.
						int newnum = Integer.parseInt(ck.getValue())+1;
						String newnum2 = newnum + "";
						
						// String.valueOf(newnum) 메서드를 사용하거나.
						// 기존의 방법처럼 +""; 공백문자열을 더해서 형변환 할 수 있다.
						
						Cookie count = new Cookie("count",newnum2);
						response.addCookie(count);		
					}					
				}else {
					// 쿠키에 count라는 쿠키가 없으면, count라는 쿠키를 초기값 0으로 추가해준다.
					Cookie count = new Cookie("count", "0");
					response.addCookie(count);
				}
			}
		
		
		// 추가되거나 수정된 쿠키를 출력한다.
		for(Cookie ck : cookieCnt) {
			if(ck.getName().equals("count")) {
				// if문은 전체에서 count 쿠키만 출력하기 위함
				out.println("<h2>어서오세요. 당신은 " + ck.getValue() + " 번째 방문입니다. </h2>");												
			}
		}
		
		// 페이지 이동 경로 잘 생각하기.
		// request.getContextPath() + 파일경로
		// jsp 내부에서는 <%= request.getContextPath()%> 파일경로
		// 파일경로 혼동되는 부분 많으니, 잘 외워두자..헷갈리지말자..
		out.println("<a href='"+ request.getContextPath() +"/cookieCountServlet.do'>Cookie Count 증가하기</a> <br><br><hr>");
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
