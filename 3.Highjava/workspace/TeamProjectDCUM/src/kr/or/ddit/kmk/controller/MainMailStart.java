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
import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;
import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 * Servlet implementation class MainMailStart
 */
@WebServlet("/mainMailStart.do")
public class MainMailStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		System.out.println("========메세지불러오기");
		
		// 로그인한 아이디 = 발신인 아이디인 메세지 리스트 받기
		StudentServiceImpl service_mail = StudentServiceImpl.getInstance();
		MemberServiceImpl service_mem = MemberServiceImpl.getInstance();
		String bal_mem_id = loginUser.getMem_id();
		String bal_mem_name = loginUser.getMem_name();
		List<MessageVO> mailList = service_mail.mailView(bal_mem_id);
		request.setAttribute("mailList", mailList);
		// 수신자 이름 찾는 메서드
//		String su_mem_name = service_mem.findNameById(mem_id);
		
		System.out.println("========mailList : "+mailList);
		
		request.getRequestDispatcher("/work_kmk/mail/mailMain.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
