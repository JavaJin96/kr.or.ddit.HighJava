package kr.or.ddit.kmk.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.ws.util.StringUtils;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.StudentVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.dcum.vo.temp_StudentInfoVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;
import kr.or.ddit.psj.service.ClassServiceimpl;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login.do")
public class Login extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      List<SubjectVO> list = new ArrayList<>();
      
      String mem_id = request.getParameter("mem_id");
      String mem_pass = request.getParameter("mem_pass");
      
      MemberServiceImpl service = MemberServiceImpl.getInstance();
      ClassServiceimpl service2 = ClassServiceimpl.getInstance();
     
      Map<String, Object> map = new HashMap<>();
      map.put("mem_id", mem_id);
      map.put("mem_pass", mem_pass);
      MemberVO loginMember = service.loginChk(map);
      
      temp_StudentInfoVO studentInfo = service.studentAllInfo(mem_id);
      
      list = service2.selectAllMySubject(mem_id);
      
      HttpSession session = request.getSession();
      if(loginMember!=null) {
         session.setAttribute("loginUser", loginMember);
         session.setAttribute("mySubject", list);
         session.setAttribute("studentInfo", studentInfo);
         if(loginMember.getMem_sort_num().equals("2")) {
        	 System.out.println("--------------");
       	  String dep_name = service.ProDepInfo(mem_id);
       	  session.setAttribute("dep_name", dep_name);
       	  System.out.println(dep_name);
         }
      }
      else {
    	  session.setAttribute("login", "fail");
      }
      response.sendRedirect("http://localhost/TeamProjectDCUM/main/login.jsp");
   }

}