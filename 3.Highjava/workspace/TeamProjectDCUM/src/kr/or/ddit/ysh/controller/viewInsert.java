package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.ysh.service.IStudentService;
import kr.or.ddit.ysh.service.StudentServiceImpl;

@WebServlet("/viewInsert.do")
public class viewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public viewInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 수강신청 과목이 저장되는 서블릿 입니다.
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String subnum = request.getParameter("subnum");
		String mem_id = request.getParameter("userid");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("subnum",subnum);
		map.put("mem_id",mem_id);
		
		
		IStudentService service = StudentServiceImpl.getInstance();
		
		service.viewClass(map);
		
		Gson gson = new Gson();
		
		String result = gson.toJson(map);
		
		System.out.println(result);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		
	}

}
