package kr.or.ddit.psj.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import kr.or.ddit.dcum.vo.ClassStudentVO;
import kr.or.ddit.dcum.vo.ClassVO;
import kr.or.ddit.dcum.vo.Class_chkVO;
import kr.or.ddit.dcum.vo.SubjectVO;
import kr.or.ddit.psj.service.ClassServiceimpl;


@WebServlet("/insertClass.do")
public class insertClass extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ClassServiceimpl service = ClassServiceimpl.getInstance();
		
		String name = request.getParameter("name");
		String content = request.getParameter("comment");
		String path = "";
		String subName = (String) session.getAttribute("subName");
		System.out.println(name);
		System.out.println(content);
		
		
		SubjectVO vo= service.selectOneSubjectForName(subName);
		String subNum = vo.getSub_num();
		
		
		File cf = new File("D:\\A_TeachintMaterial\\3. Highjava\\workspace\\TeamProjectDCUM\\WebContent\\classfiles");
		
		
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		fileItemFactory.setRepository(cf);
		ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
		
		// multipart 형식으로 저장된 객체를 쉽게 parsing 하는 과정
		try {
			List<FileItem> items = fileUpload.parseRequest(request);
			// List에 사이즈만큼 반복하면서 .isFormFiled() 의 값이 true 인지 false 인지 확인한다.
			// true = text , false = file (즉 false일때 파일이므로 저장하는 과정을 진행하면 된다.)
			for(FileItem item : items) {
				if(item.isFormField()) {
					System.out.println(item.getString("utf-8"));
					System.out.println(item.getName());
					System.out.println("응~ 파일 아니야~");
				}else {
					String separator = File.separator;
					int index = item.getName().lastIndexOf(separator);
					String fileName = item.getName().substring(index + 1);
					File uploadFile = new File("D:\\A_TeachintMaterial\\3. Highjava\\workspace\\TeamProjectDCUM\\WebContent\\classfiles" + separator + fileName);
					path = "http://localhost/TeamProjectDCUM/classfiles/"  + fileName;
					//path.replace("\\", "//");
					System.out.println(path);
					item.write(uploadFile);
				}
			}
			ClassVO vo2 = new ClassVO();
			Class_chkVO cvo = new Class_chkVO();
			
			List<ClassStudentVO> list22 = service.selectAllMyStudent(subNum);
			cvo.setClass_num(items.get(0).getString("utf-8"));
			cvo.setStatus("N");
			for(int i = 0 ; i < list22.size(); i++) {
				cvo.setMem_id(list22.get(i).getMem_id());
				service.insertClassChk(cvo);
			}
			
			
			// 파라미터값 setting
			vo2.setClass_name(items.get(0).getString("utf-8"));
			vo2.setSub_num(subNum);
			vo2.setPath(path);
			vo2.setContent(items.get(1).getString("utf-8"));
			service.insertClass(vo2);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
