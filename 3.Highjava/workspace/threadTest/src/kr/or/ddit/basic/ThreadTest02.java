package kr.or.ddit.basic;

public class ThreadTest02 {

	public static void main(String[] args) {
		// 멀티 스레드 프로그램
		
		// 스레드를 사용하는 방법
		
		// 방법1) Thread 클래스를 상속한 class를 작성한 후 이 class의 인스턴스를 생성한 후
		// 이 인스턴스의 start()메서드를 호출해서 실행한다.
		
		MyThread1 th1 = new MyThread1(); // 인스턴스 생성
		th1.start();
		
		
		// 방법2) Runnable 인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성한다. 
		// Thread객체를 생성할 때 생성자의 인수값으로 Runnable 인스턴스를 넣어준다.
		// 이 때 생성된 Thread객체의 start() 메서드를 호출해서 실행한다.
		
		MyRunner r = new MyRunner();
		Thread th2 = new Thread(r);
		th2.start();
		
		
		// 방법3) 익명 구현체를 이용하는 방법
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				for( int i = 0; i < 200; i++) {
					System.out.print("@");
					try {
						// Thread.sleep(시간) : 주어진 시간동안 작업을 잠시 멈춘다.( 1000 == 1초)
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		
		
		Thread th3 = new Thread(r2);
		th3.start();
		
		
		
		
		
		
		System.out.println("main 메서드 끝 ....");
		
	}

}

interface test{
	public void mytest(int x);
}

// 방법1
class MyThread1 extends Thread{
	
	// run메서드를 재정의 한다.
	@Override
	public void run() {
		// 이 run()메서드 안에서는 스레드가 처리해야 할 내용을 기술한다.  
		for( int i = 0; i < 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간) : 주어진 시간동안 작업을 잠시 멈춘다.( 1000 == 1초)
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}


// 방법2
class MyRunner implements Runnable{

	// run메서드를 재정의 한다.
	@Override
	public void run() {
		for( int i = 0; i < 200; i++) {
			System.out.print("$");
			try {
				// Thread.sleep(시간) : 주어진 시간동안 작업을 잠시 멈춘다.( 1000 == 1초)
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
		}
	}
}




















