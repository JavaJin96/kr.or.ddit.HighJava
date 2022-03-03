package kr.or.ddit.basic;

public class ArgTest {
	
	
	// 가변형 인수 : 메서드의 매개변수의 개수가 실행될 때마다 다를 때 사용한다.
	//  * 가변형 인수는 메서드안에서 배열로 처리된다.
	//  * 가변형 인수는 한가지 자료형만 사용할 수 있다.
	

	// 가번형 인수를 이용한 메서드
	public int sumArg(int...data) {
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	// 가번형 인수를 이용한 메서드
	// 가변형 인수와 일반적인 인수를 같이 사용할 경우에는 가변형 인수를 제일 뒤쪽에 배치해야 한다.
	public int sumArg2(String name, int...data) {
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	
	
	
	// 배열을 인수로 이용한 메서드
	public int sumArr (int [] data) {
		int sum = 0;
		for(int i = 0; i < data.length; i++) {
			sum += data[i];
		}
		
		return sum;
	}
	public static void main(String[] args) {
		ArgTest test = new ArgTest();
		
		int[] nums = {100, 200, 300};
		int result = test.sumArr(nums);
		System.out.println("결과값 : " + result);
		
		// 1,2,3,4,5 가 저장된 배열을 넣기
		System.out.println(test.sumArr(new int [] {1,2,3,4,5}));
		System.out.println("=======================================");
		System.out.println(test.sumArg(100,200,300));
		System.out.println(test.sumArg(1,2,3,4,5));
		
		
		
		System.out.println("=======================================");
		
		System.out.println(test.sumArg2("홍길동", 10,20,30,40));
		
		
		
		
	}

}
