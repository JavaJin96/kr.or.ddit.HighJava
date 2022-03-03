package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


@WebServlet("/ClassComent.do")
public class ClassComent extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		HttpSession session = request.getSession();
		List<SubjectVO> list = new ArrayList<>();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		Map<String, String> map = new HashMap<>();
		map.put("memid", vo.getMem_id());
		map.put("status", "수강완료평가없음");
		
		list = service.selectClaComent(map);
		
		System.out.println(list);
		
		Gson gson = new Gson();
		String res = gson.toJson(list);
		
		System.out.println(res);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
	}

}
