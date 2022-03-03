package kr.or.ddit.basic;

/*
 * 	은행의 입출금을 스레드를 처리하는 예제 (동기화 처리 예제)
 */


public class ThreadTest16 {
	
	private int balance;	// 잔액이 저장될 변수
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	// 입금하는 메서드 
	public void deposit(int money) {
		balance += money;
	}
	
	// 출금하는 메서드( 출금 성공 : true, 출금 실패 : false를 반환하도록 한다.)
	public synchronized boolean withdraw(int money) {
		if(balance >= money) {
			for(int i=1; i < 1_000_000_000; i++) {} // 시간 끌기용 
			
			balance -= money;
			
			System.out.println("메서드 안에서 balance : " + getBalance());
			
			return true;
			
		}else {
			return false;
		}
	}
	

	public static void main(String[] args) {
		ThreadTest16 acount = new ThreadTest16();
		acount.setBalance(10000);	// 잔액을 10000원으로 설정
		
		// 익명 구현체로 스레드 구현
		
		Runnable test = new Runnable() {
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000);	// 6000원 출금하기
				System.out.println("스레드에서 result = " + result + ", balance = " + acount.getBalance());
			}
		};
		//--------------------------------------------------
		
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();
			
	}

}





