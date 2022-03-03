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

import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/Subjectlist2.do")
public class Subjectlist2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subName = request.getParameter("data");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		SubjectVO vo = new SubjectVO();
		List<ClassVO> list2 = new ArrayList<>();
		
		vo = service.selectOneSubjectForName(subName);
		String subnum = vo.getSub_num();
		
		list2 = service.selectClass(subnum);
		Gson gson = new Gson();
		String res = gson.toJson(list2);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(res);
		
		
	}

}
