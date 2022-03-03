package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {

   public static void main(String[] args) {
	   
	   Scanner s = new Scanner(System.in);
	   
	   lotto : while(true) {
		   System.out.println("==============================");
		   System.out.println("Lotto 프로그램");
		   System.out.println("------------------------------");
		   System.out.println("1. Lotto 구입");
		   System.out.println("2. 프로그램 종료");
		   System.out.println("==============================");
		   System.out.println("행동을 입력해주세요>");
		   int input = Integer.parseInt(s.nextLine());
		   
		   switch(input) {
		   	case 1:
			   System.out.println("몇게임을 구입할까요?(한게임 : 1000원)");
			   int input2 = Integer.parseInt(s.nextLine());
			   randomNum(input2);
			   purchase(input2);
			   continue;
			   
		   	case 2:
		   		System.out.println("프로그램을 종료합니다.");
		   		System.out.println("이용해 주셔서 감사합니다.");
		   		break lotto;
		   }
	   }
	   
	  
	 

      
      
   }

   
   
   static void randomNum (int money) {
	   if(money < 100000) {
		   for(int i = 0; i < money / 1000; i++) {
			   HashSet<Integer> jackPot = new HashSet<>();
			   while(jackPot.size() < 6){
			         jackPot.add((int)(Math.random()*45)+1);
			      }  
			   ArrayList<Integer> list = new ArrayList<>(jackPot);
			   Collections.sort(list);
			   
			   System.out.print(i+1 + "번째 게임 : ");
			   for(int j = 0; j < list.size(); j++) {
				   System.out.print(list.get(j) + ",");
			   }
			   System.out.println("");
		   }
	   }

	  
      
   }
   
   static void purchase(int money) {
	  if(money < 1000) {
		  System.out.println("입력금액이 작습니다. 최소 한게임(1000원) 이상의 금액을 입력하세요.");
	  }else if(money > 100000) {
		  System.out.println("입력금액이 큽니다. 구매금액이 최대 10만원을 초과할 수 없습니다.");
	  }else {
		  System.out.println("받은 금액은" + money + "원 이며, 거스름돈은 " + money%1000 + "원 입니다."); 
	  }
	  
   }

   
   
   
}
