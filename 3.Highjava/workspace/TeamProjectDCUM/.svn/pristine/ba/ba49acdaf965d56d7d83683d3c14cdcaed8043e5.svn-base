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

import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.ysh.service.StudentServiceImpl;

@WebServlet("/SubjectList.do")
public class SubjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SubjectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 수강신청 과목 리스트
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//클라이언트 요청시 전송데이터
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//서비스 객체얻기
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		String res = "수강신청";
		String memid = request.getParameter("memid");
		
		//서비스객체를 리스트로 값을 받아오기
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("res", res);
		map.put("memid", memid);
		
		

		
		List<SubjectVO> list = service.SubjectList(map);
		
		//결과값 생성
		Gson gson = new Gson();
		
		String str = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application;json charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(str);
		
		
		
		
		
		
		
		
		
		
	}

}
