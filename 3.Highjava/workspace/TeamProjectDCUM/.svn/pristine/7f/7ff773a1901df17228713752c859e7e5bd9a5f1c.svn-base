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
import kr.or.ddit.dcum.vo.SeatVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class InsertSeatrent
 */
@WebServlet("/insertSeatrent.do")
public class InsertSeatrent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		SeatVO svo = new SeatVO();
		Gson gson = new Gson();
		
		String mem_id = user.getMem_id();
		String seat_num = request.getParameter("seat_num");
		String seat_chk = seat_num +"/"+mem_id;
		svo.setMem_id(mem_id);
		svo.setSeat_num(seat_num);
		svo.setSeat_chk(seat_chk);
		int res = service.insertSeatrent(svo);
		System.out.println(res);
		System.out.println(svo);
		
		if(res > 0) {
			out.print(gson.toJson("예약이 완료되었습니다."));
		}else {
			out.print(gson.toJson("예약이 실패되었습니다."));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
