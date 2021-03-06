package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.dcum.vo.TaskVO;
import kr.or.ddit.dcum.vo.Task_submitVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertTaskp.do")
public class insertTaskp extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		HttpSession session = request.getSession();
		List<ClassStudentVO> list = new ArrayList<>();
		
		String subName = (String) session.getAttribute("subName");
		
		SubjectVO svo = service.selectOneSubjectForName(subName);
		TaskVO tvo = new TaskVO();
		Task_submitVO ttvo = new Task_submitVO(); 
		
		String subnum = svo.getSub_num();
		String title = request.getParameter("title");
		String cont = request.getParameter("cont");
		String date = request.getParameter("date");
		String file = request.getParameter("file");
		
		tvo.setTask_name(title);
		tvo.setTask_date(date);
		tvo.setTask_cont(cont);
		tvo.setTask_score("0");
		tvo.setTask_chk("0");
		tvo.setSub_num(subnum);
		
		service.insertTaskp(tvo);
		
		ttvo.setTask_name(title);
		ttvo.setTask_date(date);
		ttvo.setTask_cont(cont);
		ttvo.setTask_score("N");
		ttvo.setTask_chk("N");
		ttvo.setSub_num(subnum);
		ttvo.setTask_title("");
		ttvo.setPath("");
		ttvo.setTask_comt("");
		
		list = service.selectAllMyStudent(subnum);
		for(int i = 0; i < list.size(); i ++) {
			String memid = list.get(i).getMem_id();
			ttvo.setMem_id(memid);
			service.insertTasks(ttvo);
		}
		
		response.sendRedirect(request.getContextPath() + "/work_psj/class/index.jsp");

		
	}

}
