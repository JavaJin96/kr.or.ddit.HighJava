package kr.or.ddit.basic;

import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DialogTest {

	public static void main(String[] args) {       

		// SWING의 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();
		
		// 선택할 파일의 확장자 설정
		FileNameExtensionFilter doc = new FileNameExtensionFilter("일종의 설명 : MS Word File", "docx", "doc");
		FileNameExtensionFilter img = new FileNameExtensionFilter("Image File", new String [] {"png", "jpg", "gif" });
		FileNameExtensionFilter txt = new FileNameExtensionFilter("Text File", new String [] {"txt"});
		
		chooser.addChoosableFileFilter(doc);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(txt);
		
		chooser.setFileFilter(txt);		// 확장자 목록 중에 기본적으로 선택될 확장자 지정
		
		
		chooser.setCurrentDirectory(new File("d:/d_other")); // 가장 처음부터 뜨는 경로 지정
		
		
		
		int result = chooser.showOpenDialog(new Panel());	// 열기용 다이얼로그
		//int result = chooser.showSaveDialog(new Panel());	// 저장용 다이얼로그
		
		// '저장' 또는 '열기' 버튼을 눌렀을 경우...
		if(result == JFileChooser.APPROVE_OPTION) {
			// 선택한 파일 정보 가져오기
			File seletedFile = chooser.getSelectedFile();
			System.out.println("선택한 파일 : " + seletedFile.getAbsolutePath());
		}
		
		
		
	}

}
