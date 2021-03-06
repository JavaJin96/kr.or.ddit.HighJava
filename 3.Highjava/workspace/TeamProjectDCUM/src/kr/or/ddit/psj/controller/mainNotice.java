package kr.or.ddit.psj.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import kr.or.ddit.dcum.vo.MemberVO;
import kr.or.ddit.dcum.vo.TempNoticeClassVO;
import kr.or.ddit.dcum.vo.TempNoticeTaskVO;
import kr.or.ddit.dcum.vo.TestVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/mainNotice.do")
public class mainNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		String memid = mvo.getMem_id();
		
		List<TempNoticeClassVO> clist = service.NoticeClass(memid);
		session.setAttribute("ncl", clist.size());
		
		List<TempNoticeTaskVO> tlist = service.NoticeTask(memid);
		session.setAttribute("nta", tlist.size());
		
		List<TestVO> t2list = service.NoticeTest(memid);
		session.setAttribute("nte", t2list.size());
		System.out.println(session.getAttribute("nte"));
		
		Gson gson = new Gson();
		
		Map<String, Object> resmap = new HashMap<>();
		
		/*JsonElement rclist = gson.toJsonTree(clist);
		JsonElement rtlist = gson.toJsonTree(tlist);
		JsonElement rt2list = gson.toJsonTree(t2list);*/
		
		
		resmap.put("clist", clist);
		resmap.put("tlist", tlist);
		resmap.put("t2list", t2list);
		
		String res = gson.toJson(resmap);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print(res);
		
		
		
	}

}
