package kr.or.ddit.psj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.dcum.vo.EmployeeVO;
import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.ProfessorVO;
import kr.or.ddit.dcum.vo.StudentVO;
import kr.or.ddit.kmk.service.MemberServiceImpl;
import kr.or.ddit.psj.service.JoinServiceimpl;


@WebServlet("/join.do")
public class join extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		JoinServiceimpl service = JoinServiceimpl.getInstance();
		MemberServiceImpl service2 = MemberServiceImpl.getInstance();
		String sw = "";
		
		// 회원등록 폼 기본 입력 사항
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String bir = request.getParameter("bir");
		String male = request.getParameter("male");
		String add = request.getParameter("add");
		String mail = request.getParameter("mail");
		String hp = request.getParameter("hp");
		String sortNum = request.getParameter("sortnum");
		String sortNm = request.getParameter("sortnm");
		
		MemberVO mvo = new MemberVO();
		mvo.setMem_id(id);
		mvo.setMem_pass(pw);
		mvo.setMem_name(name);
		mvo.setMem_bir(bir);
		mvo.setMem_gender(male);
		mvo.setMem_add(add);
		mvo.setMem_mail(mail);
		mvo.setMem_hp(hp);
		mvo.setMem_sort_num(sortNum);
		mvo.setMem_sort_nm(sortNm);
		
		// 회원등록 폼 선택 입력 사항
		if(sortNum.equals("1")) {
			String startDate = request.getParameter("sd");
			String endDate = request.getParameter("ed");
			String departmentNumber = request.getParameter("dn");
			
			StudentVO svo = new StudentVO();
			svo.setMem_id(id);
			svo.setStart_date(startDate);
			svo.setEnd_date(endDate);
			svo.setDep_num(departmentNumber);
			
			
			int result1 = service.insertMember(mvo);
			int result2 = service.insertStudent(svo);
			int res = service2.insertStatus(id);
			System.out.println(res);
			
			if(result1 > 0 && result2 >0 && res>0) {
				sw = "OK";
			}else {
				sw = "NO";
			}
			System.out.println(sw);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			request.setAttribute("sw", sw);
			
			response.sendRedirect(request.getContextPath()+"/allStudentList.do");
			
		}else if(sortNum.equals("2")) {
			String professorRoomNumber = request.getParameter("prn");
			String professorRoomHp = request.getParameter("prh");
			String departmentNumber = request.getParameter("dn2");
			
			ProfessorVO pvo = new ProfessorVO();
			pvo.setMem_id(id);
			pvo.setPro_room_num(professorRoomNumber);
			pvo.setPro_room_hp(professorRoomHp);
			pvo.setDep_num(departmentNumber);
			System.out.println(departmentNumber);
			int result1 = service.insertMember(mvo);
			int result2 = service.insertProfessor(pvo);
			if(result1 > 0 && result2 >0) {
				sw = "OK";
			}else {
				sw = "NO";
			}
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			request.setAttribute("sw", sw);
			
			response.sendRedirect(request.getContextPath()+"/allProList.do");
		}else {
			sw = "NO";
		}
		
	}

}
