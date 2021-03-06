package kr.or.ddit.kmk.controller;

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
import kr.or.ddit.dcum.vo.RentVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class InsertRoomrent
 */
@WebServlet("/insertRoomrent.do")
public class InsertRoomrent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		RentVO rvo = new RentVO();
		Gson gson = new Gson();
		
		String rent_date = request.getParameter("rent_date");
		String rent_time = request.getParameter("rent_time");
		String rent_num = request.getParameter("rent_num");
		int rent_count = Integer.parseInt(request.getParameter("rent_count"));
		String mem_id = user.getMem_id();
		
		rvo.setRent_date(rent_date);
		rvo.setRent_time(rent_time);
		rvo.setRent_num(rent_num);
		rvo.setRent_count(rent_count);
		rvo.setMem_id(mem_id);
		
		int res = service.insertRoomrent(rvo);
		System.out.println("스터디룸 예약결과 ========="+res);
		if(res > 0 ) {
			out.print(gson.toJson("예약이 완료되었습니다."));
		}else {
			out.print(gson.toJson("기존예약 취소 후 예약해주세요"));
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
