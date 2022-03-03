package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;

public class WhatEat {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("다온");
		list.add("복록수");
		
		
		try {
			System.out.println("두구두구두구ㅜㄷ구두");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Collections.shuffle(list);
		System.out.println("오늘 갈 곳은요? : " + list.get(0));
		
	}

}
