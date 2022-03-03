package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.SeatVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class SearchSeatrent
 */
@WebServlet("/searchSeatrent.do")
public class SearchSeatrent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		List<SeatVO> seatlist = service.searchSeatrent();
		Gson g = new Gson();
		if(seatlist!=null) {
			out.print(g.toJson(seatlist));
		}else {
			out.print(g.toJson(""));
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
