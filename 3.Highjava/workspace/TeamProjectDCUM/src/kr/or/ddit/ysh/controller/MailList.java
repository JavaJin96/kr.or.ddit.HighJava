package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 * 메일 리스트를 불러오는 서블릿 입니다.
 */
@WebServlet("/MailList.do")
public class MailList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MailList() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		//요청,응답 값의 반응 하는 request . response
		request.setCharacterEncoding("utf-8");
			
		//객체생성
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		String str = request.getParameter("memid");
		String sw = request.getParameter("sw");
		System.out.println(sw);
		
		List<MessageVO> list =  new ArrayList<>();
		MessageVO vo = new MessageVO();
		String result = "";
		Gson gson = new Gson();
		
		if(sw.equals("1")) {
			 list = service.mailView(str);		
			 result = gson.toJson(list);
			 
		}else if(sw.equals("2")) {
			vo = service.mailList(str);
			result = gson.toJson(vo);
		}
		
		System.out.println(result);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		
		
		
		
		
		
		
		
		
		
		
	}

}
