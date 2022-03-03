package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.psj.service.JoinServiceimpl;


@WebServlet("/joinSelectP.do")
public class joinSelectP extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		JoinServiceimpl service = JoinServiceimpl.getInstance();
		List<MemberVO> list = new ArrayList<>();
		
		String num1 = request.getParameter("num1");
		String num2 = "";
		int num3 = Integer.parseInt(num1);
		int result = 0;
		list = service.selectOneMember(num3);
		
		if(list.size() == 0) {
			num2 = num1 + "00";
			result = Integer.parseInt(num2);
		}else if (list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				result = Integer.parseInt(list.get(i).getMem_id()) + 1;
			}
		}
		
			 
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String res = "{\"res\" :\"" + result + "\"}";
		out.print(res);
		
		
	}

}
