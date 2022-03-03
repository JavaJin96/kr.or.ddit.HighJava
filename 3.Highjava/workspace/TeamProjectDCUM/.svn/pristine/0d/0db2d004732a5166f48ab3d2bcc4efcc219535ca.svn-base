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


@WebServlet("/joinSelectE.do")
public class joinSelectE extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		JoinServiceimpl service = JoinServiceimpl.getInstance();
		List<MemberVO> list = new ArrayList<>();
		
		int res = 0;
		String resultNum = "1001";
		String result = "a" + resultNum;
		
		list = service.selectAllMember();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getMem_id().equals(result)) {
				 res = Integer.parseInt(resultNum)+1;
				 break;
			}else {
				 res = Integer.parseInt(resultNum);
			}
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String fres = "a" + res;
		String result00 = "{\"res\" :\"" + fres + "\"}";
		out.print(result00);
		
	}

}
