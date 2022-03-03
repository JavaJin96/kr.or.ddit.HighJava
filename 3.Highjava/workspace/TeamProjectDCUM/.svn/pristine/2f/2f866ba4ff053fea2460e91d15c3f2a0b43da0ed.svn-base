package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * updateStudentStatus.jsp 이동 
 */
@WebServlet("/allProfessorList.do")
public class AllProfessorList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		String mem_id = user.getMem_id();
		temp_StudentInfoVO studentInfo = service.studentAllInfo(mem_id);
		List<MemberVO> prolist = service.findProfessor(mem_id);
		String pro_name = prolist.get(0).getMem_name();
		System.out.println(pro_name);
		request.setAttribute("studentInfo", studentInfo);
		request.setAttribute("pro_name", pro_name);
//		List<temp_StudentInfoVO> slist = service.allStudentList();
//		request.setAttribute("slist", slist);
		request.getRequestDispatcher("/work_kmk/mypage/updateStudentStatus.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
