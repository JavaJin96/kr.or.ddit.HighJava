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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.TempTaskVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/selectOldMyTask.do")
public class selectOldMyTask extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		List<TempTaskVO> list = new ArrayList<>();
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		TempTaskVO tvo = new TempTaskVO();
		
		tvo.setMem_id(mvo.getMem_id());
		tvo.setTask_chk("Y");
		
		list = service.selectAllMyTask(tvo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Gson gson = new Gson();
		String res = gson.toJson(list);
		out.print(res);
	}

}
