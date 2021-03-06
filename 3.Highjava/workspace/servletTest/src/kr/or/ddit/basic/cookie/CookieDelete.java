package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieDelete.do")
public class CookieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 쿠키 정보 삭제하기
		
		// 1. 쿠키데이터의 삭제는 쿠키의 '유지시간'을 0으로 설정하는 방법을 사용한다. : 쿠키의 수명은 쿠키를 저장하는 addCookie()메서드를 호출하기 전에 
		// 해당 쿠키객체변수의 setMaxAge()메서드를 사용해서 유지시간을 0으로 변경한다.
		// 형식) cookie객체변수.setMaxAge(0); : 유지시간이 0이면 해당 쿠키정보가 바로 삭제되고, 유지시간이 음수이면 웹브라우저가 종료될 때 쿠키정보가 삭제된다.

		// 2. 쿠키 정보들을 가져온다.
		Cookie[] cookieArr = request.getCookies();
	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie 삭제 연습 </title></head>");
		out.println("<body>");
		out.println("<h2>저장된 쿠키 정보 삭제하기</h2>");
		
		if(cookieArr == null || cookieArr.length == 0) {
			out.println("<div style='color:red;'>저장된 쿠키가 하나도 없습니다.</div>");
		}else {
			// 3. 쿠키 배열에서 삭제할 쿠키 정보를 구해온다.
			for(Cookie ck : cookieArr) {
				String cookieName = ck.getName();	// '쿠키 변수' 구하기
				
				// 예) gender쿠키를 삭제해보자
				if("gender".equals(cookieName)) {
					ck.setMaxAge(0); 	// 4. 유지시간을 0으로 설정한다.
					
					response.addCookie(ck); // 5. 새로 저장한다. 
				}	
			}
		}
		out.println("<a href='"+ request.getContextPath() +"/basic/cookie/cookieTest01.jsp'>시작문서로 가기</a>");
		out.println("</body></html>");
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
