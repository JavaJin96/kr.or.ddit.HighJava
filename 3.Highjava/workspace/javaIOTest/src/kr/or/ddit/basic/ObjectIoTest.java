package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIoTest {

	public static void main(String[] args) {
		
		// Member의 인스턴스 생성
		Member mem1 = new Member("홍길동", 20, "대전");
		Member mem2 = new Member("홍길서", 30, "서울");
		Member mem3 = new Member("홍길남", 40, "인천");
		Member mem4 = new Member("홍길북", 50, "울산");
		
		try {
			// 객체를 파일에 저장하기 
			FileOutputStream fos = new FileOutputStream("d://d_other/memObj.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			// 쓰기 작업...
			System.out.println("객체 저장하기 시작....");
			oos.writeObject(mem1);
			oos.writeObject(mem2);
			oos.writeObject(mem3);
			oos.writeObject(mem4);
			System.out.println("객체 저장하기 작업 끝...");
			
			oos.flush();
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//=======================================================================
		// 저장된 객체를 읽어와 그 내용을 화면에 출력하기
		// 기준이 되는 스트림과 보조스트림을 한번에 만들기
		
		try {
			
			ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream("d:/d_other/memObj.bin")
							)
					);
			
			
			Object obj;  // 읽어온 객체가 저장될 변수
			
			try {
				
				// readObject() 메서드가 데이터를 끝까지 다 읽어오면 EOFExciption 이 발생한다.
				while( (obj = ois.readObject()) != null) {
					// 읽어온 객체를 원래의 객체형으로 형변환해서 사용한다.
					Member mem = (Member)obj;
					
					System.out.println("이름 : " + mem.getName());
					System.out.println("나이 : " + mem.getAge());
					System.out.println("주소 : " + mem.getAddr());
					System.out.println("-------------------------------------");
					
					
				}
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (IOException e) {
			System.out.println("객체 읽기 작업 끝...");
		};
		
		
		
	}

}


// 데이터 저장용 클래스
class Member implements Serializable{
	/**
	 *  난수값을 이용한 ID를 생성?
	 */
	private static final long serialVersionUID = -1096438140999733430L;
	
	
	
	/**
	 *  저장한 데이터와 읽어올 데이터가 같은지를 검사하는 과정?!
	 */
//	private static final long serialVersionUID = 1L;
	
	
	// transient : 직렬화가 되지 않을 멤버변수를 지정한다. 직렬화가 되지 않은 멤버변수는 기본값으로 저장된다.(참조변수 = null; , 숫자타입의 변수 =0;) 
	
	private String name;
	private int age;
	private String addr;
	
	
	// 생성자
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
