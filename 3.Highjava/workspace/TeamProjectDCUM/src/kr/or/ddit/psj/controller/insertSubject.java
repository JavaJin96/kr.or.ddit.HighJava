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
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertSubject.do")
public class insertSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		HttpSession session = request.getSession();
		
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		String memid = mvo.getMem_id();
		String subnum = request.getParameter("subnum");
		String subname = request.getParameter("subname");
		String cnt = request.getParameter("cnt");
		
		SubjectVO svo = new SubjectVO();
		svo.setSub_num(subnum);
		svo.setSub_name(subname);
		svo.setSub_cnt(Integer.parseInt(cnt));
		svo.setMem_id(memid);
		svo.setStatus("수강신청");
		
		service.insertSubject(svo);

		Gson gson = new Gson();
		String res = gson.toJson(svo);
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(res);
	}

}
