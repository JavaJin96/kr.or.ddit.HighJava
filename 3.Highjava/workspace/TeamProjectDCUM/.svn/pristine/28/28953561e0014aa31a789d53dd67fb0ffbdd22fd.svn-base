package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;


@WebServlet("/Mypage.do")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		Gson gson = new Gson();
		String res = gson.toJson(vo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; chartset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(res);
		
	}

}
