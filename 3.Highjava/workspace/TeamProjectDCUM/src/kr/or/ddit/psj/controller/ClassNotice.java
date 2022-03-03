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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/ClassNotice.do")
public class ClassNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		List<BoardVO> list = new ArrayList<>();
		
		String subName = (String) session.getAttribute("subName");
		
		
		SubjectVO svo = service.selectOneSubjectForName(subName);
		
		list = service.selectAllClassNoticeBysn2(svo.getSub_num());
		
		Gson gson = new Gson();
		String res = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		

	}

}
