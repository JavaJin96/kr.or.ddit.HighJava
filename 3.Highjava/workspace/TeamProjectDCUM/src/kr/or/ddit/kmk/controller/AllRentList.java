package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SeatVO;
import kr.or.ddit.dcum.vo.Temp_ReservationVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class AllRentList
 */
@WebServlet("/allRentList.do")
public class AllRentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		String mem_id = loginUser.getMem_id();
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		System.out.println("렌트리스트 : "+mem_id);
		List<Temp_ReservationVO> roomlist = service.selectRoomById(mem_id);
		List<Temp_ReservationVO> seatlist = service.selectSeatById(mem_id);
		
		
		request.setAttribute("roomlist", roomlist );
		request.setAttribute("seatlist", seatlist);
		request.getRequestDispatcher("/work_kmk/mypage/rentList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
