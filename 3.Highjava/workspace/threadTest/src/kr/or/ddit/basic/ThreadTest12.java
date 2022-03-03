package kr.or.ddit.basic;

// 3개의 스레드가 각각 알파벳을 A~Z까지 출력하는데 출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성하시오.

public class ThreadTest12 {
	
	public static void main(String[] args) {
		DisplayCharacter[] dc = new DisplayCharacter[]	{
				new DisplayCharacter("홍길동"),
				new DisplayCharacter("이순신"),
				new DisplayCharacter("강감찬")
		};
		
		for(DisplayCharacter d : dc) {
			d.start();
		}
		
		for(DisplayCharacter d : dc) {
			try {
				d.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		System.out.println();
		System.out.println("경 기 결 과");
		System.out.println("순위 : " + DisplayCharacter.rank);
	
	}

}


// A부터 Z까지 출력하는 스레드 만들기
class DisplayCharacter extends Thread {
	
	private String name;
	public static String rank = "";
	
	public DisplayCharacter(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for(char ch='A'; ch <= 'Z'; ch++) {
			System.out.println(name + "씨의 출력 문자 : " + ch);
			try {
				Thread.sleep( (int)(Math.random() * 300) + 201);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(name + "씨 출력 끝..");
		DisplayCharacter.rank += name + " ";
		
	}
}
