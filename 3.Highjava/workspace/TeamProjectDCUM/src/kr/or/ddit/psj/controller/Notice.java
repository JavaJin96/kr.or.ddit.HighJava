package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.dcum.vo.GongjiVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.TempBoardVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/Notice.do")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<TempBoardVO> list = new ArrayList<>();
		HttpSession session = request.getSession();
		
		
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		list = service.selectAllMyClassNotice(vo.getMem_id());
		Gson gson = new Gson();
		String res = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
		
		
	}

}
