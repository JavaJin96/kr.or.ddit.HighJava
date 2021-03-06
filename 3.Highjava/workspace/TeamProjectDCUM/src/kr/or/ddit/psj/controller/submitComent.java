package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/submitComent.do")
public class submitComent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		String subname = request.getParameter("subname");
		Map<String, String> map = new HashMap<>();
		map.put("sub_name", subname);
		map.put("data", "수강완료평가완료");
		
		service.submitComent(map);
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print("{\"gg\" : \"제출되었습니다.\"}");
		
	}

}
