package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/qnaBoardDelete.do")
public class qnaBoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		String boardNum = request.getParameter("boardNum");
		System.out.println(boardNum);
		service.deleteQna(boardNum);
		String result = "{\"sw\" : \"성공\" }";
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("applictaion/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		
	}

}
