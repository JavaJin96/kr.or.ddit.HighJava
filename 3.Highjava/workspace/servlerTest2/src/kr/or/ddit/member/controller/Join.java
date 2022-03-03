package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceimpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/Join.do")
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;
       




	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IMemberService service = MemberServiceimpl.getInstanse();
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		
		List<MemberVO> list = service.AllMemberList();
		
		
		String result = "";
		for( int i = 0; i < list.size(); i++ ) {
			if(list.get(i).getMem_id().equals(id)) {
				result += "{ \"sw\" : \"1\" }";
			}else {
				result += " { \"sw\" : \"2\" }";
			}
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
