package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		// 읽어온 정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		
		// 읽어올 파일명을 이용한 File객체 생성
		File file = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fis = null;
		try {
			// 파일 입력용 스트림 객체 생성
			fis = new FileInputStream(file);
			
			// 입력 스트림을 이용하여 파일 내용을 읽어와 Properties객체에 저장하기
			prop.load(fis); // fis스트림을 이용해서 prop에 key값과 value값을 분류한 후에 넣어준다.
			
			//--------------------------------------------------읽기 작업 끝(Properties파일을 읽는 단계)
			System.out.println("driver : " + prop.getProperty("driver"));
			System.out.println("url : " + prop.getProperty("url"));
			System.out.println("user : " + prop.getProperty("user"));
			System.out.println("pass : " + prop.getProperty("pass"));
			
		} catch (IOException e) {
			System.out.println("입출력 오류..");
			e.printStackTrace();
		} finally {
			if(fis != null) try {fis.close();} catch(IOException e) {}
		}
	}

}
