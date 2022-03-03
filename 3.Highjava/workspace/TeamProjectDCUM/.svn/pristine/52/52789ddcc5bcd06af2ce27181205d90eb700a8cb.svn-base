package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class UpdateInfo
 */
@WebServlet("/updateInfo.do")
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String mem_bir = request.getParameter("mem_bir") ;
		String mem_add = request.getParameter("mem_add") ;
		String mem_mail= request.getParameter("mem_mail");
		String mem_hp  = request.getParameter("mem_hp")  ;
		MemberVO loginUser  = (MemberVO) session.getAttribute("loginUser")  ;
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		MemberVO mvo = new MemberVO();
		
		String mem_id = loginUser.getMem_id();
		String mem_pass = loginUser.getMem_pass();
		
		mvo.setMem_bir(mem_bir);
		mvo.setMem_add(mem_add);
		mvo.setMem_mail(mem_mail);
		mvo.setMem_hp(mem_hp);
		mvo.setMem_id(mem_id);
		
		int res =service.updateStudent(mvo);
		temp_StudentInfoVO newInfo = service.studentAllInfo(loginUser.getMem_id());
		
		Gson gson = new Gson();
		if(res > 0) {
			session.setAttribute("studentInfo", newInfo);
			out.print(gson.toJson(res));
			out.flush();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
