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


@WebServlet("/joinSelectS.do")
public class joinSelectS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		JoinServiceimpl service = JoinServiceimpl.getInstance();
		List<MemberVO> list = new ArrayList<>();
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		int result = 0;
		
		String resultNum = num1 + "" + num2;
		int resultNum2 = Integer.parseInt(resultNum);
		
		list = service.selectOneMember(resultNum2);
		if(list.size() == 0) {
			resultNum = resultNum + "00";
			result = Integer.parseInt(resultNum);			
		}else if(list.size() > 0) {
			for(int i = 0; i < list.size(); i++) {
				result = Integer.parseInt(list.get(i).getMem_id()) +1;
			}
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String res = "{\"res\" :\"" + result + "\"}";
		out.print(res);
		
		
		
	}

}
