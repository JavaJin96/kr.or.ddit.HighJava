package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.ddit.dcum.vo.CommunityVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * Servlet implementation class SelectMyBoard
 */
@WebServlet("/selectMyBoard.do")
public class SelectMyBoard extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션정보 불러오기(로그인한 회원 아이디)
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("loginUser");
		String mem_id = user.getMem_id();
		
		// 2. 서비스 메서드로 로그인한 회원이 쓴 보드 리스트 불러오기
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		List<CommunityVO> boardList = service.selectMyBoard(mem_id);
		
		// 3. 보드리스트 내용 리퀘스트 담아서 보내기
		request.setAttribute("boardList", boardList);
		request.getRequestDispatcher("/work_kmk/mypage/myBoard.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
