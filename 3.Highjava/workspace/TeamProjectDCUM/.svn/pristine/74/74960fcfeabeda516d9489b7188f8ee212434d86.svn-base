package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.RentVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class SearchRent
 */
@WebServlet("/searchRoomrent.do")
public class SearchRoomrent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		String rent_date = request.getParameter("rent_date");
		String rent_num = request.getParameter("rent_num");
		System.out.println(rent_date + " / "+rent_num);
		Map<String, Object> map = new HashMap<>();
		map.put("rent_date", rent_date);
		map.put("rent_num", rent_num);
		
		List<RentVO> rlist = service.searchRoomrent(map);
		
		Gson g = new Gson();
		if(rlist!=null) {
			out.print(g.toJson(rlist));
		}else {
			out.print(g.toJson(""));
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
