package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	문제)
 * 		'd:/d_other' 폴더에 있는 '보노보노.png' 파일을 'd:/d_ohter/연습용 폴더' 에 "복사본_보노보노.png'로 복사하는 프로그램을 작성하시오.
 * 		
 * 
 * 
 * 		File file = new file("d:/d_ohter", "국화.jpg")
 * 		
 * 		// 원본파일의 존재유무를 검사(존재하지 않으면 return)
 * 		if(!file.exists()){
 * 		return;
 * 		}
 * 
 * 		try{
 *		// 파일을 입출력할 스트림객체 생성
 *		FileInputStream fis = new FileInputStream(file);
 *		FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/복사본_국화.jpg); 
 * 		
 * 
 * 		
 * 		// 버퍼를 이용한 입출력 스트림 객체 생성
 * 		BufferedInputStream bis = new BufferedInputStream(fis);
 * 		BufferedOutputStream bos = new BufferedOutputStream(fos);
 * 		
 * 		
 * 		int data;
 * 		while( (data=bis.read()) != -1  ){
 * 		
 * 			bos.write(data);
 * 		}
 * 		bos.flush();
 * 		
 * 		// 버퍼 닫기
 * 		bis.close();
 * 		bos.close();
 * 		
 * 
 * 		int data;
 * 		while((data=fis.read()) != -1){
 * 
 * 		fos.write(data);
 * 
 * 
 * 		}
 * 		fos.close();
 * 		fis.close();
 * 
 * 
 * 
 * 
 * 
 * 		}catch{
 * 
 * 		}
 * 
 * 
 * 	
 * 		//배열을 이용하는 방법
 * 		byte[] data = new byte[1024]; //1kb씩 읽어라.
 * 		int len = 0;
 * 		while((len = fis.read(data))>0 ){
 * 			fos.write(data, 0, len);  // 배열의 0번째부터 읽어온 갯수만큼 출력해라.
 * 		}
 * 
 * 
 * 
 * 
 */
public class FileCopyTest {

	public static void main(String[] args) {
		int count = 0;
		try {
			FileInputStream fr = new FileInputStream("d:/d_other/보노보노.png");
			File png = new File("d:/d_other/연습용/보노보노3.png");
			FileOutputStream fo = new FileOutputStream(png);
			
			int c;
			
			try {
				while( (c=fr.read()) != -1) {
				count++;
				fo.write(c);	
				}
				System.out.println(" 데이터 가져오기 완료 " + count);

				
				fr.close();
				fo.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	}

}
