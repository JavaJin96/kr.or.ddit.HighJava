package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;

/**
 * updateMember.jsp에서 승인/반려 클릭시 여기로옴
 */
@WebServlet("/updateStatusByProfessor.do")
public class UpdateStatusByProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		String mem_id = request.getParameter("student_id");
		String mem_name = request.getParameter("mem_name");
		String result = request.getParameter("result");
		
		Map<String, Object> map = new HashMap<>();
		String status = null;
		
		String p = request.getParameter("status");
		System.out.println("교수승인=========파라미터:"+p);
		if(result.equals("승인")) {
			if(p.equals("휴학신청")) {
				status = "휴학";
			}else if(p.equals("복학신청")){
				status = "복학";
			}else if(p.equals("자퇴신청")) {
				status = "자퇴";
			}
		}else if(result.equals("반려")){
			if(p.equals("복학신청")) {
				status = "휴학";
			}else {
				status = "재학";
			}
		}
		
		map.put("mem_id", mem_id);
		map.put("status", status);
		int res = service.updateStatus(map);
		if(result.equals("승인")) {
			out.print(gson.toJson(p+"요청이 승인 되었습니다."));
		}else if(result.equals("반려")){
			out.print(gson.toJson(p+"요청이 반려 되었습니다."));
		}else {
			out.print(gson.toJson("처리실패_관리자문의"));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
