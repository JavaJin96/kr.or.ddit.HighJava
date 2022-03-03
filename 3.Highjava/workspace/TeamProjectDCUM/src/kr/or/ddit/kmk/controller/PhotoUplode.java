package kr.or.ddit.kmk.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/photoUplode.do")
public class PhotoUplode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uploadPath = "D:/A_TeachingMaterial/3.HighJava/workspace/TeamProjectDCUM/WebContent/photo";
		
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdir();
		}
	
		String mem_id = request.getParameter("mem_id");
		
		String fileName = "" ;
		List<PhotoVO> photoList = new ArrayList<>();
		
		for(Part part : request.getParts()) {
//			fileName = extractFileName(part); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
