package kr.or.ddit.baisc.json;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/lprodListNonAjaxServlet.do")
public class LprodListNonAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Dao 객체 생성
		LprodListDao dao = LprodListDao.getInstance();
		
		List<LprodVO> list = dao.seletAll();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 데이터를 request객체의 setAttribute()메서드를 이용하여 저장한다.
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/views/lprod/lprodListView.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
