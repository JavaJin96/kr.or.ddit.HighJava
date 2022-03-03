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
 * 매일을 삭제하는 메서드
 */
@WebServlet("/DeleteMail.do")
public class DeleteMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//데이터 요청값 받기
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//서비스 객체받기
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		//데이터 받아오기
		String mesnum = request.getParameter("mesnum");
		
		//xml 전송
		mesnum = service.DeleteMail(mesnum);
		
		//받아온 데이터값 확인
		System.out.println(mesnum);
		
		//gson 
		Gson gson = new Gson();
		
		//담기
		mesnum = gson.toJson(mesnum);
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; chartset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(mesnum);
		
		
	}

}
