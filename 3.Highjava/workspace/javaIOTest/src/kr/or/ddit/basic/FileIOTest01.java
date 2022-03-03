package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		// FileInputStream을 이용한 파일 내용 일기
		try {
			// 읽어올 파일정보를 인수값으로 받는 FileInputStream객체 생성
			
			// 방법1 : 파라미터에 직접 주소값을 입력
//			FileInputStream fin = new FileInputStream("d://d_other/test.txt");
			
			// 방법2 : file객체의 정보를 토대로 파라미터에 넣어주는 방법
			File file = new File("d://d_other/test.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int c;	// 읽어올 데이터를 저장할 변수
			
			while( (c=fin.read()) != -1) {
				// 읽어온 데이터를 화면에 출력
				System.out.print((char)c);
			}
			
			// 작업 완료 후
			fin.close();
			
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다.");
			e.printStackTrace();
			// TODO: handle exception
		}
		
		
	}

}
