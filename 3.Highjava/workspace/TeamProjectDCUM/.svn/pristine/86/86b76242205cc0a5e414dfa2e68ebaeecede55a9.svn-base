package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * allstudentList.jsp 여는 서블릿 (모든 학생리스트 담기)
 */
@WebServlet("/allStudentList.do")
public class AllStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		List<temp_StudentInfoVO> slist = service.allStudentList();
		request.setAttribute("slist", slist);
		request.getRequestDispatcher("work_kmk/system/allstudentList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
