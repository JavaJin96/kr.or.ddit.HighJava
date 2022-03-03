package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 
 *  문제 ) 이름, 주소, 전화번호를 멤버로 갖는 Phone 클래스를 만들고
 *  	Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 		(Map의 구조 : key 값  저장할 사람의 "이름"을 사용하고 , value 값은 : Phone 클래스의 인스턴스)
 * 	
 * 		아래 메뉴의 기능을 구현하시오.
 * 
 *  실행예시)
 *   	다음 메뉴를 선택하세요.
 *   
 *   	1. 전화번호 등록
 *   	2. 전화번호 수정
 *   	3. 전화번호 삭제
 *   	4. 전화번호 검색
 *   	5. 전화번호 전체 출력
 *   	0. 프로그램 종료
 *   ---------------------------
 *   번호입력 >> 1
 *   
 *   새롭게 등록할 전화번호 정보를 입력하세요.
 *   이름 >> 홍길동
 *   전화번호 >> 010-1111-1111
 *   주소>> 대전시 중구 대흥동
 *   
 *   '홍길동' 전화번호 등록 완료!!!!
 *   
 *   
 */


public class PhoneBookTest {
	Scanner s = new Scanner(System.in);
	HashMap<String, Phone> member = new HashMap<>();
	
	
	
	
	public static void main(String[] args) {
		

		PhoneBookTest p = new PhoneBookTest();
		p.Start();
	}
	
	

	
	
	
	
	void Start() {
		
		root : while(true) {
			
			menu();
			int input = Integer.parseInt(s.nextLine());
			switch(input) {
			case 1:
				insertNum();
				break;
			case 2:
				updateNum();
				break;
			case 3:
				deleteNum();
				break;
			case 4:
				viewNum();
				break;
			case 5:
				viewAllNum();
				break;
			case 0:
				System.out.println("시스템을 종료합니다.");
				break root;
			}
			

			
		}
		
		
		
	}
	
	
	
	
	void menu() {
		System.out.println("========================================");
		System.out.println("전화번호 등록 프로그램");
		System.out.println("----------------------------------------");
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 검색");
		System.out.println("5. 전화번호 전체출력");
		System.out.println("0. 프로그램 종료");
		System.out.println("----------------------------------------");
		System.out.println("행동을 입력해주세요 > ");
	}
	
	void insertNum() {
		 
		System.out.println("새롭게 등록할 전화번호와 정보를 입력해주세요.");
		System.out.println("이름  ");
		String name = s.nextLine();
		System.out.println("전화번호 (-포함 입력) ");
		String num = s.nextLine();
		System.out.println("주소  ");
		String addr = s.nextLine();
		
		member.put(name, new Phone(name, addr, num));
		System.out.println("정상적으로 등록되었습니다.");
	}
	
	void updateNum() {
		
		
		System.out.println("수정할 전화번호의 이름을 입력해주세요.");
		String name = s.nextLine();
		
		if(member.containsKey(name)) {
			System.out.println("수정할 전화번호를 입력해주세요.");
			String num = s.nextLine();
			System.out.println("수정할 주소를 입력해주세요.");
			String addr = s.nextLine();
			
			member.put(name, new Phone(name, addr, num));
			System.out.println("정상적으로 수정되었습니다.");			
		}
		else {
			System.out.println("일치하는 자료가 없습니다.");
		}
		
		
		/*	방법2)
		 * 
		 *  phone 객체를 가져와서 변경한다.
		 *  
		 *  
		 *  Phone p = map.get(name);
		 *  p.setTel(newTel);
		 *  p.setAddr(newAddr);
		 * 
		 * 
		 * 
		 */
		
		
	}
	
	void deleteNum() {
		System.out.println("삭제할 전화번호의 이름를 입력해주세요.");
		String name = s.nextLine();
		member.remove(name);
		System.out.println("정상적으로 삭제되었습니다.");
		
	}
	
	void viewNum() {
		System.out.println("검색할 전화번호의 이름을 입력해주세요.");
		String name = s.nextLine();
		System.out.println("이름 \t 전화번호 \t");
		System.out.println("--------------------------------");
		System.out.println(member.get(name).name+ " \t " +  member.get(name).num);
		System.out.println("--------------------------------");
		System.out.println("주소");
		System.out.println(member.get(name).addr);
		System.out.println("--------------------------------");
		System.out.println("조회되었습니다.");
		
	}
	
	void viewAllNum() {
		System.out.println("저장된 모든 전화번호 자료를 출력합니다.");
		System.out.println("번호 \t 이름 \t 전화번호 \t");
		System.out.println("--------------------------------");
		int count = 0;
		for(String key : member.keySet()) {
			count++;
			System.out.println(count + " \t " + member.get(key).name + " \t " + member.get(key).num);
			System.out.println("--------------------------------");
			System.out.println(member.get(key).addr);
		}
		System.out.println("출력이 완료되었습니다.");
	}

	

}


class Phone {
	
	String name;
	String addr;
	String num;
	
	public Phone(String name, String addr, String num) {
		super();
		this.name = name;
		this.addr = addr;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
