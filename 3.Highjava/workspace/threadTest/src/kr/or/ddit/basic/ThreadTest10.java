package kr.or.ddit.basic;

// yield()메서드 연습

public class ThreadTest10 {

	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1번스레드");
		YieldThread th2 = new YieldThread("2번스레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("11111111111==============================================");
		
		th1.work = false;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("22222222222==============================================");
		
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("33333333333==============================================");
		
		th1.stop = true;
		th2.stop = true;
		
	}

}

// yield() 메서드 연습용 스레드
class YieldThread extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	// 생성자
	public YieldThread(String name) {
		// super : 부모의 참조값이 저장되어 있는 참조 변수
		// super(값); : 부모의 생성자를 호출한다.
		super(name); // new Thread(name)와 같으며, 스레드의 이름을 설정해주는 메서드
	}
	
	@Override
	public void run() {
		while(!stop) {	// stop변수값이 true가 되면 반목문을 종료한다.
			if(work) {
				// getName()메서드 : 스레드의 이름을 반환하는 메서드
				System.out.println(getName() + "작업중 ..");
			}else {
				System.out.println(getName() + "양보..");
				Thread.yield();
			}
		}
	}
	
	
}
