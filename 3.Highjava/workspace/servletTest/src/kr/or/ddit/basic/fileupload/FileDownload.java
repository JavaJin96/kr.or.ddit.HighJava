package kr.or.ddit.basic.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 파일을 다운로드하는 서블릿 
@WebServlet("/fileDownload.do")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터로 넘어온 파일명을 구한다.
		String fileName = request.getParameter("filename");
		
		// 업로드된 파일들이 저장될 폴더 설정
		String uploadPath = "d://d_other/uploadFiles";
				
		// 저장될 폴더가 없으면 새로 만들어 놓는다.
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		
		response.setCharacterEncoding("utf-8");
		// 다운 받을 파일의 File객체 생성
		File downFile = new File(f, fileName);
		
		// 파일이 있을 때의 경우
		if(downFile.exists()) {
			// contentType 설정하는 법 : application/octet-stream으로 기술해야 한다.
			response.setContentType("application/octet-stream; charset=utf-8");
			
			// response에 content-disposition 속성을 설정한다.
			String headerKey = "content-disposition";
//			String headerValue = "attachment; filename=\"" + fileName + "\";";
			String headerValue = "attachment; " + getEncodedFileName(request, fileName);
			
			response.setHeader(headerKey, headerValue);
			
			// 파일 입출력에 관련한 Stream을 선언한다.
			BufferedOutputStream out = null;
			BufferedInputStream fis = null;
			
			try {
				// 출력용 스트림객체 생성 : response객체 이용
				out = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성
				fis = new BufferedInputStream(new FileInputStream(downFile));
				byte[] buffer = new byte[1024];
				int len = 0;
				// byte배열을 이용하여 파일내용을 읽어서 출력용 스트림으로 출력한다.
				while((len = fis.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				
				out.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류");
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				if(fis != null) try {fis.close();} catch (IOException e) {}
				if(out != null) try {out.close();} catch (IOException e) {}
			}
			
		}else { // 파일이 없을 때
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>" + fileName + "파일이 존재하지 않습니다. </h3>");
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// 다운로드 파일명이 한글일 때 한글이 깨지는 것을 방지하는 메서드
	private String getEncodedFileName(HttpServletRequest request, String filename) {
		String encodedFileName = "";
		String userAgent = request.getHeader("User-Agent");
		try {
			
			//MSIE 10버전 이하의 웹브라우저, Trident = 익스플로러 
			if(userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				encodedFileName = "filename=\"" + URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "\\ ") + "\"";
			}else {	// 모든 웹브라우저
				encodedFileName = "filename*=UTF-8''" + URLEncoder.encode(filename, "utf-8").replaceAll("\\+", "%20");
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("지원하지 않는 인코딩 방식");
			// TODO: handle exception
		}
		return encodedFileName;
		
	}

}
