package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		try {
			// 기반이 되는 스트림 생성
			FileOutputStream fos = new FileOutputStream("d:/d_other/test.dat");
			
			// 자료형 단위로 출력할 보조스트림인 DataOutputStream 객체 생성
			DataOutputStream dos = new DataOutputStream(fos);
			
			
			
			
			// 00000000 00000000 00000000 11001000 = 200 
			// 가장앞 : 부호비트 0 : + 1 : -
			// 7개의 비트 : 지수비트 
			// 0  / 0000000  / 00000000 00000000 11001000
			// 부호 / 지수  // 숫자
			
			dos.writeInt(200);  // 정수형
			dos.writeFloat(123.45f);  // 실수형
			dos.writeBoolean(false);  // 논리형
			dos.writeUTF("ABCDabcd");  // 문자열
			
			System.out.println("출력 완료...");
			
			dos.close();  // 스트림 닫기.
			
			// 출력했던 자료 읽어오기
			FileInputStream fis = new FileInputStream("d:/d_other/test.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			// DataInputStream 으로 데이터를 읽어올 때는 출력할 때의 순서와 같은 순서로 읽어야 한다. 
			System.out.println("정수형 : " + dis.readInt());
			System.out.println("실수형 : " + dis.readFloat());
			System.out.println("논리형 : " + dis.readBoolean());
			System.out.println("문자열 : " + dis.readUTF());
			
			System.out.println("읽기 작업 완료....");
			
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
		
	}

}
