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

import kr.or.ddit.dcum.vo.BoardVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/classQna.do")
public class classQna extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// selectClassByname 으로 class_num 값
		// class_num 값넣고 board select
		
		request.setCharacterEncoding("utf-8");
		ClassVO vo = new ClassVO();
		List<BoardVO> list = new ArrayList<>();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		String classname = request.getParameter("className");
		
		vo = service.selectClassByName(classname);
		
		System.out.println(vo.getClass_num());
		list = service.selectInclassBoard(vo.getClass_num());
		
		Gson gson = new Gson();
		String res = gson.toJson(list);
		
		System.out.println(res);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(res);
		
		
	}

}
