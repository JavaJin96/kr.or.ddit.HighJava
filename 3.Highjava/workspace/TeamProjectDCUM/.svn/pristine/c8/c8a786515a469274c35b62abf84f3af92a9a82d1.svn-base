package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class SearchPass
 */
@WebServlet("/resetPass.do")
public class ResetPass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mem_id = request.getParameter("mem_id");
		String mem_mail = request.getParameter("mem_mail");
		System.out.println(mem_mail);
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		Map<String, Object> map = new HashMap<>();
		map.put("mem_id", mem_id);
		map.put("mem_mail", mem_mail);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		int result = service.resetPass(map);
		System.out.println(result );
		if(result >0) {
			out.print(gson.toJson("초기화성공! 생년월일로 초기화 되었습니다."));
			out.flush();
		}else {
			out.print(gson.toJson("초기화실패! 정보를 확인해주세요."));
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
