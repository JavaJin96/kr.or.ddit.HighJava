package kr.or.ddit.ysh.controller;

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
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 *쪽지전송시 체크 옵션 리스트
 */
@WebServlet("/ViewSubject.do")
public class ViewSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response 응답 요청
		response.setCharacterEncoding("utf-8");
		
		//service 객체생성
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		// session 으로 세션 데이터 생성
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		//string 객체 생성
		String memid = mvo.getMem_id();
		
		//vo 생성
		SubjectVO vo = new SubjectVO();
		
		
		
		//list 생성	
		List<SubjectVO> list = new ArrayList<>();
		
		//gson 생성
		Gson gson = new Gson();
		
		
		//list 객체에 vo 담아주기
		list = service.viewSubject(memid);
		System.out.println(list);
		
		
		//
		String res = gson.toJson(list);
		
		response.setContentType("application/json; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
		
		
		
		
		
		
	}

}
