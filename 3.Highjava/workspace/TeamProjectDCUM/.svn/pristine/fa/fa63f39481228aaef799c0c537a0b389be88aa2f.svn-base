package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/confirmStu.do")
public class confirmStu extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		request.setCharacterEncoding("utf-8");
		String subnum = request.getParameter("subnum");
		
		service.confirmStu(subnum);
		
		String res = "{\"sw\" : \"성공\"  }";
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
	}

}
