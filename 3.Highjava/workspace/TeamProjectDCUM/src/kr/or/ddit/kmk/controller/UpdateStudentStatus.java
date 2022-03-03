package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class Hu_bokhak
 */
@WebServlet("/updateStudentStatus.do")
public class UpdateStudentStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		String mem_id = user.getMem_id();
		Map<String, Object> map = new HashMap<>();
		String status = null;
		
		String p = request.getParameter("status");
		System.out.println("학적상태=========파라미터:"+p);
		if(p.equals("휴학")) {
			status = "휴학신청";
		}else if(p.equals("복학")){
			status = "복학신청";
		}else if(p.equals("자퇴")) {
			status = "자퇴신청";
		}else if(p.equals("휴학신청")||p.equals("자퇴신청")) {
			status = "재학";
		}else if(p.equals("복학신청")) {
			status = "휴학";
		}
		
		map.put("mem_id", mem_id);
		map.put("status", status);
		int res = service.updateStatus(map);
//		System.out.println("재학상태 변경 결과=="+res);
//		if(p.equals("휴학")) {
//		// 휴,복학 ,자퇴 정보 저장
//		String hacki = request.getParameter("hacki");
//		String cause = request.getParameter("cause");
//		map.put("hacki",hacki );
//		map.put("cause",cause);
//		System.out.println("학기:"+hacki+"사유:"+cause);
//		session.setAttribute("status",map);
//		}else if(p.equals("자퇴")){
//			String cause = request.getParameter("cause");
//			map.put("cause",cause);
//			System.out.println("사유:"+cause);
//			session.setAttribute("status", map );
//		}else {
//			session.setAttribute("status", map );
//		}

		request.getRequestDispatcher("/allProfessorList.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
