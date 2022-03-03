package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1) 5명의 별명을 입력받아 ArrayList에 저장하고, 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
 * 		(단, 입력한 모든 별명의 길이는 모두 다르게 입력한다.)
 * 
 * 문제2) 5명의 별명을 입력받아 ArrayList에 저장하고, 이들 중 별명의 길이가 제일 긴 별명들을 출력하시오.
 * 		(단, 별명의 길이는 같을 수 있다.)
 */

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<>();
		
		for(int i = 0; i < 5; i++) {
			list.add(s.nextLine());
		}
		String temp = "";
		for(int i = 0; i < list.size(); i ++) {
			if(list.get(i).length() > temp.length()) {
				temp = list.get(i); 
			}
		}
		System.out.println("가장 긴 사람 : " + temp);
	
	}

}
