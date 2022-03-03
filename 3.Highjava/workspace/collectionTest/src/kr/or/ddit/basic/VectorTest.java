package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		// Vector 객체 생성
		// 배열의 단점을 보완하기 위함(크기의 유동성)
		Vector v1 = new Vector();
		
		System.out.println("크기 : " + v1.size());
		
		// 데이터 추가하기 : add 메서드 사용
		// 반환값 : 추가 성공 (true) 추가 실패 (false)
		v1.add("aaaa");
		// 객체만 저장할 수 있다. new ~ 객체화 시켜주는 과정 (raper class ,래퍼클래스) 
		v1.add(new Integer(111));
		v1.add(123); // Arraylist 와 같이 자동으로 객체화를 시켜준다. : 오토박싱(넣을때)/오토언박싱(뺄때)
		v1.add('a');
		v1.add(true);
		boolean chk = v1.add(3.14);
		
		System.out.println(v1);
		System.out.println("크기 : " + v1.size());
		System.out.println("반환값 : " + chk);
		
		v1.addElement("CCC");
		
		System.out.println("v1 => " + v1.toString());
		// toString 이 생략되어 있음
		
		// 데이터 추가 : add(index, 데이터)
		// 지정한 index 번째에 데이터를 끼워넣는다.
		// 반환값은 없다.
		
		v1.add(1,"kKK");
		System.out.println("v1 => " + v1.toString());
		
		// 데이터 수정 : set(index, 새로운데이터)
		// 지정한 index 번째에 데이터를 덮어쓴다.
		// 반환값 : 원래의 데이터 
		
		String temp = (String)v1.set(1, "ZZZ");
		System.out.println("v1 => " + v1);
		System.out.println("temp => " + temp);
		
		
		// 데이터 삭제 : remove(index)
		// 지정한 index 번째의 데이터를 삭제한다.
		// 반환값 : 삭제된 데이터

		String temp2 = (String)v1.remove(0);
		System.out.println("삭제 후 : " + v1);
		System.out.println("삭제된 데이터 : " + temp);
		
		// 데이터 삭제 : remove(삭제할 데이터)
		// 삭제할 데이터를 찾아서 삭제한다.
		// 삭제할 데이터가 여러개 존재하면 앞에서 부터 삭제된다.
		// 반환값 : 삭제성공(true) / 삭제실패(false)
		// 삭제할 데이터가 정수형종류 이거나 char형일 경우에는 반드시 객체로 변환해서 사용해야 한다.
		
		boolean temp3 = v1.remove("CCC");
		System.out.println("삭제 후 : " + v1);
		System.out.println("삭제 결과 : " + temp3);
		
		v1.remove(new Integer (123));
		System.out.println("삭제 후 : " + v1);
		
		v1.remove(new Character('a'));
		System.out.println("삭제 후 : " + v1);
		
		v1.remove(true);
		v1.remove(3.14);
		System.out.println("삭제 후 : " + v1);
		
		// 데이터 꺼내오기 : get(index)
		// 지정한 index 번째의 데이터를 꺼내서 반환한다.
		
		int data = (int)v1.get(1);
		System.out.println("1번째 자료 : " + data);
		
		//-------------------------------------------------------------
		/* 제네릭 타입(Generic Type) : 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법
		 * 이렇게 선언하면 다른종류의 데이터는 저장할 수 없다.
		 * 이 때 < > 안에 지정하는 데이터 타입은 클래스형이어야 한다.
		 * 데이터를 꺼내올 때 별도의 형변환이 필요없다.
		 * 
		 */
		Vector<String> v2 = new Vector<String>(); // String 만 저장할 수 있는 Vector
		Vector<Integer> v3 = new Vector<Integer>(); // Integer 만 저장할 수 있는 Vector
		
		v2.add("안녕하세요");

		String temp4 = v2.get(0);
		System.out.println("temp3 = " + temp4);
		
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();
		
		//---------------------------------------------------------------------------------------
		v2.clear(); //전체 데이터 삭제
		System.out.println("v2의 크기 : " + v2);
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBBB");
		v4.add("DDDD");
		
		System.out.println("v2 : " + v2);
		System.out.println("v4 : " + v4);
		
		// 데이터 삭제 : removeAll(Collection 객체)
		// Collection 객체가 가지고 있는 모든 데이터를 삭제한다.
		
		v2.removeAll(v4); // v2가 가지고 있는 데이터 중에 v4가 가지고 있는 데이터를 삭제해라.
		System.out.println("삭제후 v2 " + v2);
		
		//---------------------------------------------------------------------------------------------
		v2.clear();
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		// 벡터 전체의 데이터를 차례로 가져와 처리할 때는 반복문을 사용하면 된다.
		// 주로 for문 사용
		
		for(int i = 0; i < v2.size(); i++) {
			System.out.println(i + "번째 자료 : " + v2.get(i));
		}
		
		System.out.println("---------------------------------------");
		// 향상된 for 문
		for(String s : v2) {
			System.out.println(s);
		}
		
		System.out.println("---------------------------------------");
		
		
		
		
		
	}

}
