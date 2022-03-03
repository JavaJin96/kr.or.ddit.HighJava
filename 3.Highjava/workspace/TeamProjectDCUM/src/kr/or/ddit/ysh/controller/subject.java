package kr.or.ddit.ysh.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;

import com.sun.xml.internal.fastinfoset.vocab.Vocabulary;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.ysh.service.IStudentService;
import kr.or.ddit.ysh.service.StudentServiceImpl;


@WebServlet("/subject.do")
public class subject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public subject() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청 전송데이터
		request.setCharacterEncoding("UTF-8");
		
		//로그인 세션 정보 가져오기
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO)session.getAttribute("loginUser");
		
		
		
		// service 객체얻기
		IStudentService service = StudentServiceImpl.getInstance();
		
		//service 객체 생성
		List<SubjectVO> list2 = service.selectSubject(vo.getMem_id());
		
		//결과값을 출력 json 데이터 생성
		
		request.setAttribute("list2",list2);
		
		
		//jsp로 전송
		
		request.getRequestDispatcher("work_ysh/subject.jsp").forward(request, response);
		
		
		
		
	}

}
