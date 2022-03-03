package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class ThreadTest13 {
	/*
	 *    10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
	 * 
	 *    말은 Horse라는 이름의 스레드 클래스로 작성하는데 
	 *    이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
	 *    그리고, 이 클래스는 등수를 오름차순으로 처리할 수 있는 내부 정렬기준이 있다. (Comparable 인터페이스 구현)
	 * 
	 *    경기 구간은 1~50 구간으로 되어 있다. 
	 * 
	 *    경기 중간에 각 말들의 위치를 나타내시오...
	 * 
	 *    예)
	 *    01번말 ----------->-----------------------------------
	 *    02번말 ---->------------------------------------------
	 *    03번말 ----------------------->-----------------------
	 *    04번말 -------------------------------->--------------
	 *    05번말 -------------------------------------------->--
	 * 
	 *    경기가 끝나면 등수 순으로 출력한다. 
	 * 
	 * 
	 */
	
		public static int rrank = 0;
		
	public int getRrank() {
			return rrank;
		}

		public void setRrank(int rrank) {
			this.rrank = rrank;
		}

	public static void main(String[] args) {
	 
		HorseState hs = new HorseState();
		hs.start();
		
	}

}

class HorseState extends Thread{
	
	
	
	Horse h[] = new Horse [] {
			new Horse("1번말"),
			new Horse("2번말"),
			new Horse("3번말"),
			new Horse("4번말"),
			new Horse("5번말"),
			new Horse("6번말"),
			new Horse("7번말"),
			new Horse("8번말"),
			new Horse("9번말"),
			new Horse("10번말")
	};
	
	// 배열을 리스트로 변경할때 문제점....(객체를 담은 배열이라 리스트에 담을 수 없는가? 그렇다면, 애초에 배열이 아닌 리스트로 객체를 담았어야 했나?

	
	Comparable<Horse> sort = new Comparable<Horse>() {

		@Override
		public int compareTo(Horse ho) {
			for(int i = 0; i < h.length; i++) {
				if(h[i].rank < ho.rank) {
					return -1;
				}else if(h[i].rank > ho.rank) {
					return 1;
				}else {return 0;}
			}
			return 0;
		}
	};
	
	@Override
		public void run() {
		for(Horse hc : h) {
			hc.start();
		}


		while(true) {
			for(int i = 0; i < h.length; i++) {
				if(h[0].flag == false && h[1].flag == false && h[2].flag == false && h[3].flag == false && h[4].flag == false &&
						h[5].flag == false && h[6].flag == false && h[7].flag == false && h[8].flag == false &&
						h[9].flag == false ) {
					//HashMap<String, Integer> map = new HashMap<>();
					ArrayList<Horse> rank = new ArrayList<Horse>();
					for(int k = 0; k < h.length; k++) {
						System.out.println(h[k].name + "의 등수는 : " + h[k].rank + "등 입니다.");
						//map.put(h[k].name, h[k].rank);
						rank.add(h[k]);
					}
					System.out.println("=============================================================");
					//System.out.println("오름차순 내부정렬 기준 사용후..");
					//sort.compareTo(rank.get(i));
					//System.out.println(rank.get(i).name);
					// 아니, 왜안되는거지????????????????? 객체 리스트 정렬 불가능?

					return;
				}
				System.out.print(h[i].name + " : ");
				for(int j = 0; j < 50; j++) {
					if(h[i].nowPosition == j) {
						System.out.print("●");
					}else {
						System.out.print("-");
					}
				}System.out.print(h[i].rank);
				System.out.println("");
			}
			System.out.println();
			System.out.println("***********************************************************");
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.interrupted();
			//break;

		}		


	}
}

class Horse extends Thread{
	public String name;
	public int nowPosition = 0;
	public int rank = 0;
	public boolean flag = true;
	ThreadTest13 th = new ThreadTest13();
	
	
	
	public int getNowPosition() {
		return nowPosition;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setNowPosition(int nowPosition) {
		this.nowPosition = nowPosition;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Horse(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 50; i++) {
			
			try {
				Thread.sleep((int)(Math.random() * 1000) );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			nowPosition++;
			//System.out.println(nowPosition);
		}
		flag = false;
		rank = th.rrank +1;
		th.setRrank(rank);
	}
	
	
	
	
	
}