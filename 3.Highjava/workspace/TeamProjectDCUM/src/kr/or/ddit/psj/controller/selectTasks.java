package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.dcum.vo.Task_submitVO;
import kr.or.ddit.dcum.vo.TempTask_submitVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/selectTasks.do")
public class selectTasks extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Task_submitVO tvo = new Task_submitVO();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		String subname = request.getParameter("subname");
		
		SubjectVO svo = service.selectOneSubjectForName(subname);
		
		List<TempTask_submitVO> list = service.selectTasks(svo.getSub_num());
		Gson gson = new Gson();
		
		String res = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
		
	}

}
