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
 * Servlet implementation class DeleteRoom
 */
@WebServlet("/deleteRoom.do")
public class DeleteRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		Map<String, Object> map = new HashMap<>();
		String rent_num= request.getParameter("rent_num");
		String mem_id = user.getMem_id();
		map.put("mem_id", mem_id);
		map.put("rent_num", rent_num);
		
		int res = service.deleteRoom(map);

		
		if(res > 0 ) {
			out.print(gson.toJson("예약이 취소되었습니다."));
		}else {
			out.print(gson.toJson("예약취소가 실패되었습니다."));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
