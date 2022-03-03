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

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.ysh.service.IStudentService;
import kr.or.ddit.ysh.service.StudentServiceImpl;


//매일 전송하는 서블릿

@WebServlet("/MailInsert.do")
public class MailInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MailInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//응답받은데이터 객체생성
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	
		MessageVO vo = new MessageVO();
		
	//	vo.setMes_num(Integer.parseInt((request.getRemoteAddr())));
	//	vo.setMes_date(request.getParameter("sysdate"));
		vo.setBal_mem_id(request.getParameter("banam"));
		vo.setSu_mem_id(request.getParameter("sunam"));
		vo.setMes_cont(request.getParameter("cont"));
	
		
		
		IStudentService service = StudentServiceImpl.getInstance();
		
		MessageVO str = service.mailinsert(vo);
		
		
		
		
		Gson gson = new Gson();
		
		
		
		String result = gson.toJson(str);
		System.out.println(str);
		
		response.setContentType("application/json; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.print(result);
		
		
		
		
	
	
	}

}
