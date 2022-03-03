package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 * 수강신청 목록을 삭제하는 메서드 입니다.
 */
@WebServlet("/DeleteSubject.do")
public class DeleteSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 받아오기
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//서비스 생성
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		//데이터 키값 이용해서 받기
		String subnum = request.getParameter("subnum");
		
		//xml 전송시켜주기
		subnum = service.deleteSubeject(subnum);
		
		//잘담겨있나 확인
		System.out.println(subnum);
		
		//gson 생성
		Gson gson = new Gson();
		
		//g손에 담아라
		subnum = gson.toJson(subnum);
			
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		
		//Writer 생성후 데이터 값 찍어보기
		PrintWriter out = response.getWriter();
		
		out.print(subnum);
		
		
		}

}
