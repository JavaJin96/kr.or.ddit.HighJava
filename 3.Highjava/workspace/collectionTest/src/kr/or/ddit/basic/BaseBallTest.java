package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
 *  Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 *  컴퓨터의 숫자는 난수를 이용하여 구한다.
 *  (스트라이크는 S, 볼은 B로 나타낸다.)
 *  
 *  예) 컴퓨터의 난수가 : 9 5 7 
 *  
 *  실행)
 *  숫자입력 : 3 5 6
 *  3 5 6 => 1S 0B
 *  숫자입력 : 7 8 9
 *  7 8 9 => 0S 2B
 *  숫자입력 : 9 7 5
 *  9 7 5 => 1S 2B
 *  숫자입력 : 9 5 7
 *  9 5 7 => 3S OB <게임끝 : 시도한 횟수 n회>
 *  
 *   축하합니다.
 *   당신은 n번째 만에 맞췄습니다.
 */

public class BaseBallTest {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		int strike = 0;
		int ball = 0;
		int count = 0;
		
		
		//난수 발생
		HashSet<Integer> ans = new HashSet<>();
		while(ans.size() < 3) {
			ans.add((int)(Math.random()*9)+1);
		}
		
		ArrayList<Integer> ans2 = new ArrayList<>(ans);
		Collections.shuffle(ans2);
		
		String [] ip = new String [3]; 
		
		
		System.out.println(ans2);
		while(strike < 3) {
			strike = 0;
			ball = 0;
			count++;
			System.out.println("정답을 입력해주세요. (공백을 두고 입력)");
			ip = s.nextLine().split(" ");
			
			
				
				if(Integer.parseInt(ip[0]) == ans2.get(0) ) {
					strike++;
				}
				else if(Integer.parseInt(ip[0]) == ans2.get(1) || Integer.parseInt(ip[0]) == ans2.get(2)) {
					ball++;
				}
				if(Integer.parseInt(ip[1]) == ans2.get(1) ) {
					strike++;
				}
				else if(Integer.parseInt(ip[1]) == ans2.get(0) || Integer.parseInt(ip[1]) == ans2.get(2)) {
					ball++;
				}
				if(Integer.parseInt(ip[2]) == ans2.get(2) ) {
					strike++;
				}
				else if(Integer.parseInt(ip[2]) == ans2.get(1) || Integer.parseInt(ip[2]) == ans2.get(0)) {
					ball++;
				}

			System.out.println("S : " + strike + "B : " + ball);
		}
		
		System.out.println("축하드립니다." + count + "번 만에 성공하셨습니다.");
		
	}

}
