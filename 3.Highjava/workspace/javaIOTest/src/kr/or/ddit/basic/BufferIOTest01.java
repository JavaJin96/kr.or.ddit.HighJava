package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferIOTest01 {

	public static void main(String[] args) {
		// 입출력의 성능 향상을 위하여 Buffered 스트림을 사용한다.
		
		try {
			// 기반 스트림 객체 생성
			FileOutputStream fout = new FileOutputStream("d:/d_other/bufferTest.txt");
			
			
			// 버퍼의 크기가 5인 Buffered 스트림 객체 생성
			// 버퍼의 크기를 지정하지 않으면 기본크기인 8kb(8196byte)로 설정된다.
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(int i ='1'; i <= '9'; i++) {
				bout.write(i);
			}
			// flush() 메소드를 통해서 버퍼가 차지 않아도 쓰기작업을 실행했다.
			//bout.flush();
			
			// close() 메소드를 통해서 버퍼가 차지 않아도 쓰기작업을 실행했다.
			bout.close();
			
			// close() 메소드를 통해서 쓰기작업을 실행한다고 해도, flush()메소드를 사용해주는 것이 좋다.
			
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
		
		
	}

}
