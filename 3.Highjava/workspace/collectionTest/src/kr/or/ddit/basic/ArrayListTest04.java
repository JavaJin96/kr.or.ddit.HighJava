package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {

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
		
		for(int i = 0; i < list.size(); i ++) {
			if(temp.length() == list.get(i).length()) {
				System.out.println("가장 긴 사람들 : " + list.get(i));
			}
		}
		
		
	}

}
