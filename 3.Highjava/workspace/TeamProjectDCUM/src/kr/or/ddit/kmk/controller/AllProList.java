package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.Temp_ProfessorVO;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * allProfessorList.jsp 여는 서블릿 (모든 직원리스트 담기)
 */
@WebServlet("/allProList.do")
public class AllProList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		List<temp_StudentInfoVO> slist = service.allStudentList();
		request.setAttribute("slist", slist);
		List<Temp_ProfessorVO>  prolist = service.printProAllInfo();
		request.setAttribute("prolist", prolist);
		request.getRequestDispatcher("work_kmk/system/allProfessorList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
