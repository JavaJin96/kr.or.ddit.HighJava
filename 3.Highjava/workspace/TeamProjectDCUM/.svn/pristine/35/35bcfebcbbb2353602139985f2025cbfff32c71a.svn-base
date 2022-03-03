package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class DeleteSeat
 */
@WebServlet("/deleteSeat.do")
public class DeleteSeat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		String mem_id = user.getMem_id();
		Map<String, Object> map = new HashMap<>();
		String seat_num=request.getParameter("seat_num");
		map.put("mem_id", mem_id);
		map.put("seat_num",seat_num);
		
		int delRes = service.deleteSeat(map);
		if(delRes > 0 ) {
			out.print(gson.toJson("열람실 사용종료 되었습니다."));
		}else {
			out.print(gson.toJson("사용 종료가 실패했습니다."));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
