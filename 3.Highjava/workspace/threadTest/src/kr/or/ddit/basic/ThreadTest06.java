package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
//		DataInput th1 = new DataInput(); 이 방법으로도 가능
		Thread th1 = new DataInput();
		
		CountDown th2 = new CountDown();
		
		th1.start();
		th2.start();
	}

}

// 데이터를 입력 받는 스레드
class DataInput extends Thread{
	// 입력 여부를 확인하기 위한 변수 선언 : 스레드에서 공통으로 사용할 변수 
	public static boolean inputCheak = false; // 입력이 완료되면 true로 변경된다.
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요.");
		inputCheak = true; // 입력이 완료되었으므로 true로 변경한다. 
		System.out.println("입력받은 값 : " + str);
	}
}

// 카운트 다운을 진행하는 스레드
class CountDown extends Thread{
	
	@Override
	public void run() {
		for(int i = 10; i >= 1; i--) {
			
			if(DataInput.inputCheak == true) {
				return; // run()메서드가 종료되면 스레드가 종료된다. 
			}
			System.out.println(i);
			
			// 입력이 완료되었는지 여부를 검사해서 입력이 완료되면 스레드를 종료시킨다.

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0); // 프로그램을 종료시키는 메서드

	}

}