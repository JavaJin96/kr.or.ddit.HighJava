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

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/classList.do")
public class classList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		List<SubjectVO> list = new ArrayList<>();
		
		// 세션에서 뽑은 ID값 파라미터로 넘겨주기
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		if(vo.getMem_sort_num().equals("1")) {
			list = service.selectAllMySubject(vo.getMem_id());
			
			// gson으로 json 처리
			Gson gson = new Gson();
			String res = gson.toJson(list);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(res);			
		}else if(vo.getMem_sort_num().equals("2")) {
			list = service.selectSubjectListPro(vo.getMem_id());
			
			// gson으로 json 처리
			Gson gson = new Gson();
			String res = gson.toJson(list);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.print(res);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
