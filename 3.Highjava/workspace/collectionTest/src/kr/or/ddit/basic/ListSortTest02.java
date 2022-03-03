package kr.or.ddit.basic;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest02 {

	public static void main(String[] args) {
		
		ArrayList<Member> memList = new ArrayList<>();
		
		memList.add(new Member(1,"홍길동", "010-1111-1111"));
		memList.add(new Member(5,"이순신", "010-2222-2222"));
		memList.add(new Member(9,"성춘향", "010-3333-3333"));
		memList.add(new Member(3,"강감찬", "010-4444-4444"));
		memList.add(new Member(6,"일지매", "010-5555-5555"));
		memList.add(new Member(2,"변학도", "010-6666-6666"));
		
		System.out.println("<<<<<정렬전>>>>>");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");
		
		Collections.sort(memList);
		System.out.println("<<<<<정렬후>>>>>  ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");
		
		
		// Member클래스의 회원번호의 내림차순으로 정렬하는 
		// 외부 정렬 기준 클래스를 이용하여 정렬하시오. (외부정렬기준 클래스명 : SortNumDesc)
		
		System.out.println("<<<<<정렬전>>>>>");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");
		
		Collections.sort(memList, new SortNumDesc());
		System.out.println("<<<<<정렬후>>>>>  ");
		for(Member mem : memList) {
			System.out.println(mem);
		}
		System.out.println("------------------------------------------------");
		
	}

}

class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member num1, Member num2) {
		
		
		if( num1.getNum() < num2.getNum()) {
			return 1;
		}
		else if(num1.getNum() > num2.getNum()) {
			return -1;
		}else {
			return 0;
		}
		
		
		//Integer(int형의 wrapper class)의 내부정렬기준을 사용하여 외부정렬 만들기 1)
//		return new Integer(num1.getNum()).compareTo(num2.getNum()) * 1;
		
		
		//Integer(int형의 wrapper class)의 내부정렬기준을 사용하여 외부정렬 만들기 2)
//		return Integer.compare(num1.getNum(), num2.getNum()) *1;
		//new Integer 객체 생성을 하지 않아도 , static 으로 메서드를 만들어 사용할 수 있다.
		
		
	}
	
}




// Member클래스의 회원이름을 기준으로 오름차순이 되도록 내부 정렬 기준을 추가하기
// (내부정렬기준) 이므로 Comparable 인터페이스를 구현한다.

class Member implements Comparable<Member>{
	private int num; //회원번호
	private String name; // 회원이름
	private String tel; // 전화번호
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getNum() {
		return this.num;
	}

	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}

	@Override
	public int compareTo(Member mem) {
		// this.getName()(앞쪽 데이터) , mem.getName()(뒤쪽 데이터)
		
		return this.getName().compareTo(mem.getName());
//		return this.getName().compareTo(mem.getName()) * -1;
		
	}
	

}