package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class requestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		int num3 = Integer.parseInt(request.getParameter("num1"));
		int num4 = Integer.parseInt(request.getParameter("num2"));
		double num1 = Double.parseDouble(request.getParameter("num1"));
		double num2 = Double.parseDouble(request.getParameter("num2"));
		String oper = request.getParameter("ope");
		double res = 0;
		
		boolean calcOK = true; // 계산 성공 여부를 나타내는 변수
		
		if(oper.equals("+")) {
			res = num1 + num2; 
		}else if(oper.equals("-")) {
			res = num1 - num2;
		}else if(oper.equals("*")) {
			res = num1 * num2;
		}else if(oper.equals("/")) {
			if(num2 != 0) {
				res = num1 / num2;				
			}else if(num2 == 0) {
				calcOK = false;
			}
			
		}else {
			if(num2 != 0) {
				res = num1 % num2;				
			}else if(num2 == 0) {
				calcOK = false;
			}
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>계산 결과</title></head>");
		out.println("<body>");
		out.println("<h1>계산 결과</h1>");
		if(calcOK == true) {
			out.println("<p>" + num3 + oper + num4 + "=" + res + "</p>");			
		}else {
			out.println("<p>" + num3 + oper + num4 + "= 계산할 수 없음</p>");						
		}
		out.println("</body></html>");
		
		
		
	}

}
