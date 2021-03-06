package kr.or.ddit.basic.fileupload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/images/imageSrcView.do")
public class ImageSrcView extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String filePath = "d:/d_other/uploadFiles";
		String fileName = request.getParameter("filename");
		
		String imgPath = filePath + File.separator + fileName;
		
		File file = new File(imgPath);
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		if(file.exists()) {	// 이미지 파일이 있을 때...
			try {
				// 출력용 스트림객체 생성 (response객체 이용)
				bos = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트릠 객체 생성
				bis = new BufferedInputStream(new FileInputStream(file)); 
				
				byte[] temp = new byte [1024];
				int len = 0;
				while((len = bis.read(temp)) > 0) {
					bos.write(temp, 0, len);
				}
				bos.flush();
				
			} catch (IOException e) {
				System.out.println("입출력 오류 입니다.");
				e.printStackTrace();
				// TODO: handle exception
			} finally {
				if(bis != null) try {bis.close();} catch(IOException e) {}
				if(bos != null) try {bos.close();} catch(IOException e) {}
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
