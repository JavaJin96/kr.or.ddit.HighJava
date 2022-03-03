package kr.or.ddit.basic.singleton;

public class SingletonTest {

	public static void main(String[] args) {
		// MySingleton single = new MySingleton();  
		// : 싱글톤에서 생성자에 private을 쓰는 이유
		// 외부에서 new 명령으로 생성 불가
		
		MySingleton single2 = MySingleton.getInstance();
		MySingleton single3 = MySingleton.getInstance();
		
		System.out.println("single2의 참조값 : " + single2);
		System.out.println("single3의 참조값 : " + single3);
		
		System.out.println(single2 == single3);
		
		single2.test();
		
	}

}
