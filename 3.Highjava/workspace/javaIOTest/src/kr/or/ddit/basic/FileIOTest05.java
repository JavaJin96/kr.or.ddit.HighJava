package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {

	public static void main(String[] args) {
		
		/*
		 * 	한글이 저장된 파일의 인코딩 방식을 지정해서 읽어오기
		 * 
		 */
		
		try {
//			FileReader fr = new FileReader("d://d_other/test_utf8.txt");
//			FileReader fr = new FileReader("d://d_other/test_ansi.txt");
			
//			FileInputStream fis = new FileInputStream("d:/d_other/test_utf8.txt");
			FileInputStream fis = new FileInputStream("d:/d_other/test_ansi.txt");
			
			/*
			 *  인코딩 방식을 지정해서 읽어오기
			 *  - 인코딩방식 문자
			 *  1) MS949 : 윈도우의 기본 한글 인코딩 방식(ANSI방식과 같다.)
			 *  2) UTF : 유니코드 UTF-8 인코딩 방식
			 *  3) US-ASCII : 영문 전용 인코딩 방식
			 */
			
			
//			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			InputStreamReader isr = new InputStreamReader(fis,"MS949");
			
			int c;
			while( (c=isr.read()) != -1) {
				System.out.print( (char)c );
			}
			
			
			
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

}
