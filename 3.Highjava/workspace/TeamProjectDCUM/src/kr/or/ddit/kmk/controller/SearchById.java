package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class SearchById
 */
@WebServlet("/searchById.do")
public class SearchById extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		String mem_id = request.getParameter("mem_id");
		
		temp_StudentInfoVO sivo = new temp_StudentInfoVO();
		sivo =  service.studentAllInfo(mem_id);
		
		String mem_name = sivo.getMem_name();
		Gson g = new Gson();
		if(sivo!=null) {
			out.print(g.toJson(mem_name));
		}else {
			out.print(g.toJson(""));
		}
//		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
