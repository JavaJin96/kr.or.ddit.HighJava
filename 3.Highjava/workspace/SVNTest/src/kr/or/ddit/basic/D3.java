package kr.or.ddit.basic;

public class D3 {

	public static void main(String[] args) {
		
		System.out.println("준비");
		
		
		try {
			for(int i = 24; i > 0; i --) {
				Thread.sleep(1000);
				System.out.println("카운트다운!");
				System.out.println(i);
				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("시스템을 종료합니다.~~~~~~");
		
		
	}	

}
