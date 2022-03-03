package kr.or.ddit.basic;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {
	/*
	  문제 ) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고
	  	   Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
	  	   (Map의 구조 => key값 : 저장할 사람의 '이름'을 사용 value : Phone 클래스의 인스턴스)
	  	   
	  	   HashMap<String, Phone>
	  	   
	  	    아래 메뉴의 기능을 구현하시오
	
	실행예시) 다음 메뉴를 선택하시오.
	
	1.전화번호 등록
	2.전화번호 수정
	3.전화번호 삭제
	4.전화번호 검색
	5.전화번호 전체출력
	0.프로그램 종료
	---------------------
	번호입력 >> 1
	
	새롭게 등록할 전화번호 정보를 입력하세요.
	이름 >> 홍길동
	전화번호 >> 010-1111-1111
	주소>> 대전시 중구 대흥동
	
	'홍길동' 전화번호 등록 완료!!!
	
	----------------------------------
	
	다음 메뉴를 선택하시오.
	
	1.전화번호 등록
	2.전화번호 수정
	3.전화번호 삭제
	4.전화번호 검색
	5.전화번호 전체출력
	0.프로그램 종료
	---------------------
	번호입력 >> 5
	-----------------------------
	번호	이름	전화번호	주소
	-----------------------------
	1	홍길동	010-1111-1111 대전시 중구 대흥동
	~~~
	-------------------------------------
	출력완료
	
	다음 메뉴를 선택하시오.
	
	1.전화번호 등록
	2.전화번호 수정
	3.전화번호 삭제
	4.전화번호 검색
	5.전화번호 전체출력
	0.프로그램 종료
	---------------------
	번호입력 >> 0
	
	프로그램을 종료합니다.
	
	- 추가 조건)
		1) '6. 전화전호 저장' 메뉴를 추가하고 구현한다.
			(파일명은 'phoneData.dat' 로 만든다.)
		2) 프로그램이 시작될 때 저장된 파일이 있으면 그 데이터를 읽어와Map에 셋팅한다.
		3) 프로그램을 종료할 때 Map의 데이터가 변경되거나 추가 또는 삭제되면 저장 후 종료되도록 한다.

	
	 */
	
	
	
	// 출력용 스트림 객체 생성
	// Map 자체를 저장한다.
	/*
	 * 	oos.wirteObject(PhoneBookMap);
	 * 	catch (IOException e) {
	 * 	sysout("저장실패" + e.getMessage())
	 * }
	 * finally{
	 * if(oos != null ) try(oop.close()) catch(IOException e){}
	 * }
	 * 
	 * 
	 * 
	 */
	
	// 데이터를 불러오는 메서드
	/*
	 * 		저장된 데이터를 읽어와 Map객체형으로 반환하는 메서드
	 * 		저장된 파일이 없거나 읽기 오류일 때는 null을 반환한다. 
	 * 	 private HashMap<String, Phone> load(){
	 * 		HashMap<String,Phone> pMap = null; //읽어올 데이터가 저장될 변수
	 * 		
	 * 		
	 * 		// 저장할 때 사용한 File객체
	 * 		File file = new File(fileName);
	 * 			if(!file.exists()){ // 저장된 파일이 없으면 
	 * 				return null;
	 * 		}		
	 * 
	 * 		
	 * 		// 저장된 파일이 있으면.. 
	 * 		ObjectInputStream ois = null;
	 * 		try{
	 * 			// 입력용 스트림 객체 생성
	 * 			ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)()));
	 * 
	 * 			try {pMap = (HashMap<String, Phone>) ois.readObject();}
	 * 			catch(ClassNotFoundException){
	 * 			return null;			
	 * }
	 * 		}catch(IOException){
	 * 			return null;
	 * 		}
	 * 			
	 * 		return pMap;
	 * 
	 * 
	 * 	}
	 */
	
	/*
	 *  생성자 public PhoneBookTest(){
		에서 phoneBookMap = load();
		if(phoneBookmap == null) {
		phonebookMap = new hachMap<String, Phone>;	
		}
		}	
	 */
	
	
	
	private static final Object Phone = null;

	Scanner sc = new Scanner(System.in);
	
	HashMap<String, Phone> user = new HashMap<>();
	
	
	
	public static void main(String[] args) {
		
		new PhoneBookTest().phoneStart();
		
	}
	
	private void phoneStart() {
		
		
		
		while(true) {
			
		
		int choice = displayPhone();
		
		switch(choice) {
		case 1:
			insertPhone();
			saveData();
			break;
		case 2:
			setPhone();
			saveData();
			break;
		case 3:
			deletePhone();
			saveData();
			break;
		case 4:
			roadData();
			listPhone();
			break;
		case 5:
			roadData();
			listAll();
			break;
		case 6:
			saveData();
			break;
		case 0:
			System.out.println();
			System.out.println("프로그램을 종료합니다");
			return;
			
		
			}
		}
		
	}
	private void saveData() {
		
		
		try {
			FileOutputStream fos = new FileOutputStream("d:/d_other/phoneData.dat");
			
			
			try {
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(user);
				System.out.println("저장이 완료되었습니다.");
				
				oos.flush();
				oos.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	private void roadData() {
		try {
			FileInputStream fis = new FileInputStream("d:/d_other/phoneData.dat");
			try {
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Object obj;
				try {
					
					try {
						while( (obj = ois.readObject()) != null ) {
							
							
							// 추출한 object 타입 obj를 캐스팅하여 p에 담는다.
							HashMap<String, Phone> p =  (HashMap<String, kr.or.ddit.basic.Phone>) obj;
							
							// p를 현재 프로그램에서 사용중인 hashMap user에 할당한다.
							user = p;
						}
						
					} catch (EOFException e) {
						// TODO: handle exception
					}
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int displayPhone() {
		
		System.out.println("다음 메뉴를 선택하시오.");
		System.out.println();
		System.out.println("1.전화번호 등록");
		System.out.println("2.전화번호 수정");
		System.out.println("3.전화번호 삭제");
		System.out.println("4.전화번호 검색");
		System.out.println("5.전화번호 전체 출력");
		System.out.println("6.전화번호 저장");
		System.out.println("0.프로그램 종료");
		System.out.println("-------------------------------");
		System.out.print("번호입력 >> ");
		int input = Integer.parseInt(sc.nextLine());
		
		return input;
	}
	
	private void insertPhone() {
		
		System.out.println("-------------------------------");
		
		System.out.println("이름 >> ");
		String name  = sc.nextLine();
		
		System.out.println("전화번호 >> ");
		String phone  = sc.nextLine();
		
		System.out.println("주소 >> ");
		String add  = sc.nextLine();
		
		user.put(name, new Phone(name,phone,add));
		
		System.out.println("'" + name + "'" + "전화번호 등록완료");
		
	}
	
	private void setPhone() {
		try {
			System.out.println("-------------------------------");
			System.out.println("수정할 사람의 이름 >> ");
			String name = sc.nextLine();
			if(user.get(name).name.equals(name)) {
			System.out.println("-------------------------------");
			System.out.println("수정할 전화번호 >> ");
			String phone  = sc.nextLine();
			System.out.println("수정할 주소 >> ");
			String add  = sc.nextLine();
			user.put(name, new Phone(name, phone, add));
			}else {
				System.out.println("이름을 다시 확인해 주세요.");
				System.out.println("-------------------------------");
			}
			
		} catch (Exception e) {
			System.out.println("이름을 다시 확인해 주세요.");
			System.out.println("-------------------------------");
		}
		
	}
	
	private void deletePhone() {
		try {
			System.out.println("-------------------------------");
			
			System.out.println("삭제할 전화번호의 이름 : ");
			String name = sc.nextLine();
			if(user.get(name).name.equals(name)) {
				user.remove(name);
				System.out.println("정삭적으로 삭제 되었습니다.");
			}else {
				System.out.println("이름을 다시 확인해 주세요.");
				System.out.println("-------------------------------");
			}
		} catch (Exception e) {
			System.out.println("이름을 다시 확인해 주세요.");
			System.out.println("-------------------------------");
		}
		
		
	}
	
	
	private void listPhone() {
		try {
			System.out.println("-------------------------------");
			
			System.out.println("검색할 전화번호의 이름 : ");
			String name = sc.nextLine();
			if(user.get(name).name.equals(name)) {
			System.out.println("-------------------------------");
			System.out.println("이름\t전화번호\t주소 ");
			System.out.println("-------------------------------");
			System.out.println(user.get(name).name + "\t" + user.get(name).phone + "\t" + user.get(name).add);
			System.out.println("-------------------------------");
			}else {
				System.out.println("이름을 다시 확인해 주세요.");
				System.out.println("-------------------------------");
			}
		} catch (Exception e) {
			System.out.println("이름을 다시 확인해 주세요.");
			System.out.println("-------------------------------");
		}
		
		
	}
	
	private void listAll() {
		System.out.println("-------------------------------");
		int number = 0;
		System.out.println("-------------------------------");
		System.out.println("번호\t이름\t전화번호\t주소 ");
		System.out.println("=============================================================");
		for(String key : user.keySet()) {
			number++;
			System.out.println(number + "\t" + user.get(key).name +"\t" +user.get(key).phone + "\t" + user.get(key).add );
			System.out.println("---------------------------------------------------------");
		}
		System.out.println("=============================================================");
	
		
	}
	
	
	
	
}

class Phone  implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	String name;
	String phone;
	String add;
	public Phone(String name, String phone, String add) {
		super();
		this.name = name;
		this.add = add;
		this.phone = phone;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

}
