package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// response 객체를 사용할 준비(인코딩, 출력객체 생성)
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		// html 태그 구성
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title></title></head>");
		out.println("<body>");
		
		
		// 전체 쿠키를 배열로 받아서 for문을 이용해 이름이 count인 쿠키들만 찾기
		Cookie [] cookieArr = request.getCookies();
		for(Cookie ck : cookieArr) {
			if(ck.getName().equals("count")) {
				// 방법1) 같은 Key로 저장하면, 덮어써지는 특성을 이용해 새로운 'count' 쿠키를 0으로 생성후 쿠키에 추가
				Cookie count = new Cookie("count", "0");
				response.addCookie(count);
				
				// 방법2) cookie의 MaxAge를 0으로 설정한다.
				/*ck.setMaxAge(0);
				response.addCookie(ck);
				break*/
				
			}
			
		}
		out.println("<h2>초기화 되었습니다.</h2>");	
		
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest02.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
