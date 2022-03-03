package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.MessageVO;
import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 * 발신메세지 확인하는 메서드
 */
@WebServlet("/BalView.do")
public class BalView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BalView() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		//값 요청
		StudentServiceImpl service = StudentServiceImpl.getInstance();
		
		//보내온 값 확인
		String balmem = request.getParameter("balmemid");
		
		
		//리스트 객체 생성후 담기
		List<MessageVO> list = service.balView(balmem);
		
		//G손 생성
		Gson gson = new Gson();
		
		String balmemid = gson.toJson(list);
		
		response.setContentType("application/gson; charset=utf-8");
		
		PrintWriter out =response.getWriter();
		
		out.print(balmemid);
		
		
		
		
		
		
		
		
		
	}

}
