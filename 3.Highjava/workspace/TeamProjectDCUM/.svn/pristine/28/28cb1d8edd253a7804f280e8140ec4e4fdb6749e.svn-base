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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.ysh.service.StudentServiceImpl;

/**
 * 쪽지전송 옵션 리스트 2 서블릿입니다
 */
@WebServlet("/ViewSubject2.do")
public class ViewSubject2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ViewSubject2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		
		StudentServiceImpl service = StudentServiceImpl.getInstance();
				
		
		
		/*HttpSession session = request.getSession();
		MemberVO vo2 = (MemberVO) session.getAttribute("UserNames");
		*/
		
		SubjectVO vo2 = new SubjectVO();
		
		
		String str = request.getParameter("data");		
		System.out.println(str);
		
		
		List<ClassStudentVO> list = new ArrayList<>();
		
		
		Gson gson = new Gson();
		
		
		list = service.viewSubject2(str);
		System.out.println(list);
		
		response.setContentType("application/json; charset=utf-8");
		
		String res = gson.toJson(list);
		
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
		
		
		
		
		
		
	}

}
