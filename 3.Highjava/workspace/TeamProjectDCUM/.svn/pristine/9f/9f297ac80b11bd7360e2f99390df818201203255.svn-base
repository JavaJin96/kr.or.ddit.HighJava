package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.ManagStudentVO;
import kr.or.ddit.kjy.service.IBambooService;
import kr.or.ddit.ysh.service.IStudentService;
import kr.or.ddit.ysh.service.StudentServiceImpl;


@WebServlet("/StudentList.do")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public StudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청시 데이터 받기
		request.setCharacterEncoding("utf-8");
		
		//서비스 객체얻기
		IStudentService service =StudentServiceImpl.getInstance();
		
		//데이터 얻어오기
		String res = request.getParameter("memid");
		
		
		
		//리스트로변환
		List<ManagStudentVO> list = service.studentList(res);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(list);
	
		System.out.println(result);
		
		response.setContentType("application/gson; charset=utf-8");
		
		PrintWriter out =response.getWriter();
		
		out.print(result);
		
		
	}

}
