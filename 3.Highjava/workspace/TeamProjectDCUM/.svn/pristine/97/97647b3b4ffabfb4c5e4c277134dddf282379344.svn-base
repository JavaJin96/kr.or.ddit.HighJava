package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/pSelectStudent.do")
public class pSelectStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subname = request.getParameter("subname");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		List<MemberVO>list = new ArrayList<>();
		
		list = service.selectManageStudents(subname);
		
		Gson gson = new Gson();
		String res = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
	}

}
