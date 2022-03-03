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

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.Board_ReplyVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/selectRe.do")
public class selectRe extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String boardnum = request.getParameter("boardnum");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		List<Board_ReplyVO> list = new ArrayList<>();
		
		
		list = service.selectBoardReply(boardnum);
		
		Gson gson = new Gson();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("applictaion/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String res = gson.toJson(list);
		out.print(res);
		
		
	}

}
