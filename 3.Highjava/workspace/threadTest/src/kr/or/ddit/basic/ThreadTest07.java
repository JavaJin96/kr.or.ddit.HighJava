package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

/*
 * 	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 
 * 	컴퓨터의 가위 바위 보는 난수를 이용해서 구하고,
 * 	사용자의 가위 바위 보는 showInputDialog() 메서드로 입력 받는다.
 * 
 * 	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 	5초 안에 입력이 없으면 게임에 진것으로 처리한 후 프로그램을 종료한다. 
 * 
 * 	5초 안에 입력 있으면 승패를 구해서 출력한다. 
 * 
 *  결과 예시)
 *  1) 5초 안에 입력을 못했을 때
 *  	- 결 과 - 
 *  시간 초과로 당신이 졌습니다. 
 *  
 *  2) 5초 안에 입력했을 때
 *  	- 결 과 -
 *  컴퓨터 : 가위 
 *  사용자 : 바위
 *  결과 : 당신이 이겼습니다. 
 * 
 */


public class ThreadTest07 {

	public static void main(String[] args) {
		Input th1 = new Input();
		Timer th2 = new Timer();
		
			th1.start();
			th2.start();			
		
	}

}

class Input extends Thread {
	
	public static boolean flag = false;
	public static String userInput = " ";
	public static int userInputn = 1;
	public static ArrayList<Integer> list = new ArrayList<>();
	public static int s = 1;
	public static int r = 2;
	public static int p = 3;
	public static String com = " ";
	
	
	
	@Override
	public void run() {
		do {
			userInput = JOptionPane.showInputDialog("가위 바위 보 시작!!(5초안에 입력!!)");
			
		}while( !"가위".equals(userInput) && !"바위".equals(userInput) && !"보".equals(userInput));
	
		flag = true;
		list.add(1);
		list.add(2);
		list.add(3);
		
			if(userInput.equals("가위")) {
				userInputn = 1;
			}else if(userInput.equals("바위")) {
				userInputn = 2;
			}else if(userInput.equals("보")){
				userInputn = 3;
			}
			
			Collections.shuffle(Input.list);
			
			if(list.get(0) == 1) {
				com = "가위";
			}else if(list.get(0) == 2) {
				com = "바위";
			}else if(list.get(0) == 3) {
				com = "보";
			}
			
			
			
			
			/*
			 * 	switch 문을 활용한 비교
			 * 
			 * 	String temp = userInput + com;
			 * 	String result = "";
			 * 
			 * 	seitch(temp){
			 * 	case "가위가위":
			 * 	case "바위바위":
			 * 	case "보보": result = "비겼습니다." break;
			 * 	case "가위보":
			 * 	case "바위가위":
			 * 	case "보바위": result = "당신이 이겼습니다."; break;
			 * 	default : result = "당신이 졌습니다.";
			 * 
			 * 	}
			 * 
			 */
			
			
			
			
			if(userInputn == 1) {
				if(userInputn == list.get(0)) {
					System.out.println("결과 출력 ");
					System.out.println("사용자 : " + userInput + "  컴퓨터 : " + Input.com);
					System.out.println("무승부입니다.");
					System.out.println(" ");
				}
				else if(list.get(0) == 2) {
					System.out.println("결과 출력");
					System.out.println("사용자 : " + Input.userInput + "  컴퓨터 : " + Input.com);
					System.out.println("패배했습니다.");
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				else if(list.get(0) == 3) {
					System.out.println("결과 출력");
					System.out.println("사용자 : " + Input.userInput + "  컴퓨터 : " + Input.com);
					System.out.println("승리했습니다.");
					System.out.println("축하합니다.");
				}
			}
			
			if(userInputn == 2) {
				if(userInputn == list.get(0)) {
					System.out.println("결과 출력 ");
					System.out.println("사용자 : " + userInput + "  컴퓨터 : " + Input.com);
					System.out.println("무승부입니다.");
					System.out.println(" ");
				}
				else if(list.get(0) == 3) {
					System.out.println("결과 출력");
					System.out.println("사용자 : " + Input.userInput + "  컴퓨터 : " + Input.com);
					System.out.println("패배했습니다.");
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				else if(list.get(0) == 1) {
					System.out.println("결과 출력");
					System.out.println("사용자 : " + Input.userInput + "  컴퓨터 : " + Input.com);
					System.out.println("승리했습니다.");
					System.out.println("축하합니다.");
				}
			}
			
			if(userInputn == 3) {
				if(userInputn == list.get(0)) {
					System.out.println("결과 출력 ");
					System.out.println("사용자 : " + userInput + "  컴퓨터 : " + Input.com);
					System.out.println("무승부입니다.");
					System.out.println(" ");
				}
				else if(list.get(0) == 1) {
					System.out.println("결과 출력");
					System.out.println("사용자 : " + Input.userInput + "  컴퓨터 : " + Input.com);
					System.out.println("패배했습니다.");
					System.out.println("프로그램을 종료합니다.");
					return;
				}
				else if(list.get(0) == 2) {
					System.out.println("결과 출력");
					System.out.println("사용자 : " + Input.userInput + "  컴퓨터 : " + Input.com);
					System.out.println("승리했습니다.");
					System.out.println("축하합니다.");
				}
			}
			
	}
	
}

class Timer extends Thread {
	
	@Override
	public void run() {
		for(int i = 5; i >= 1; i--) {
			if(Input.flag == true) {
				return;	
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("제한시간이 종료되었습니다.");
		System.out.println("프로그램을 종료합니다.");
		System.exit(0);
		
	}
}

















