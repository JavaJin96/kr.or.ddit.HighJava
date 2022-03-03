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
 * updateMember.jsp 여는 서블릿
 */
@WebServlet("/statusChangeList.do")
public class StatusChangeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		List<temp_StudentInfoVO> waitList = service.statusChangeList();
		List<temp_StudentInfoVO> totalList = service.allStudentList();
		System.out.println(waitList +"/t"+totalList);
		request.setAttribute("waitList", waitList);
		request.setAttribute("totalList", totalList);
		request.getRequestDispatcher("/work_kmk/system/updateMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
