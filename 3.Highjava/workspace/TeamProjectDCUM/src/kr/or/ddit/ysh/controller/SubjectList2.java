package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 * 내가 가지고있는 강의 목록을 불러오는 리스트
 */
@WebServlet("/SubjectList2.do")
public class SubjectList2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubjectList2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 요청
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		//서비스 객체 생성
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		//보낸 값 가져오기
		String memid = request.getParameter("memid");
		System.out.println(memid);
		
		//리스트에 담아주기
		List<SubjectVO> list = new ArrayList<SubjectVO>();
		list = service.SubjectList2(memid);
		
		//값확인
		System.out.println(list);
		
		Gson gson = new Gson();
		
		//gson 에 담는다
		String res = gson.toJson(list);
		
		//Writer 생성
		response.setCharacterEncoding("utf-8");
	
		response.setContentType("application/json; charset=utf-8");
		
		
		
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
		
		
		
		
		
	}

}
