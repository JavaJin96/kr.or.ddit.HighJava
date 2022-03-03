package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제 ) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
 * 		이들 중 '김' 씨 성을 가진 사람을 모두 출력하시오.
 * 		(입력은 Scanner객체를 이용한다.)
 */

public class ArrayListTest02 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		
		list.add(s.nextLine());
		list.add(s.nextLine());
		list.add(s.nextLine());
		list.add(s.nextLine());
		list.add(s.nextLine());

		System.out.println(list);
		for(int i = 0 ; i < list.size(); i++) {
			if(list.get(i).substring(0,1).equals("김") == true ) {
				System.out.print(list.get(i));
				System.out.println();
			}
		}
		
		//이름에서 "김" 이 들어간 위치의 인덱스를 반환 
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).indexOf("김") == 0) {
				System.out.print(list.get(i));
				System.out.println();
			}
		}
		
		for(int i = 0; i <list.size(); i++) {
			if(list.get(i).contains("김") == true) {
				System.out.print(list.get(i));
				System.out.println();
			}
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).charAt(0) == '김' ) {
				System.out.print(list.get(i));
				System.out.println();
			}
		}
		
		// startWith : 문자의 시작이 (a) a일때 true 반환
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).startsWith("김") ) {
				System.out.print(list.get(i));
				System.out.println();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
