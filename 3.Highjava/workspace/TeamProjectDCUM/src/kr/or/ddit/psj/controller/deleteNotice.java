package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/deleteNotice.do")
public class deleteNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String bonum = request.getParameter("bnum");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		service.deletePQna(bonum);
		
		String res = "{\"sw\" : \"ok\" }";
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(res);
	}

}
