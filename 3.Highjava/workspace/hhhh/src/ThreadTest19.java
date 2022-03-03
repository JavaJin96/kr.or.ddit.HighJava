

import java.util.Arrays;

/**
*
10마리의 말들이 경주하는 경마 프로그램 작성하기

말은 Horse라는 이름의 클래스로 구성하고,
이 클래스는 말이름(String), 등수(int)를 멤버변수로 갖는다.
그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는
기능이 있다.( Comparable 인터페이스 구현)

경기 구간은 1~50구간으로 되어 있다.

경기 중 중간중간에 각 말들의 위치를 >로 나타내시오.
예)
1번말 --->------------------------------------
2번말 ----->----------------------------------
...

오름차순 sort
경기가 끝나면 등수 순으로 출력한다.

스레드로 말 클래스 만들고 전역변수로 말이름, 등수
*/
public class ThreadTest19 {

   public static void main(String[] args) {
      Horse[] horses = new Horse[] {
            new Horse("01번말"), 
            new Horse("02번말"),
            new Horse("03번말"),
            new Horse("04번말"),
            new Horse("05번말"),
            new Horse("06번말"),
            new Horse("07번말"),
            new Horse("08번말"),
            new Horse("09번말"),
            new Horse("10번말")
            
      };
      GameState gs = new GameState(horses);
      
      for(Horse h : horses) {
         h.start();
         
      }
      gs.start();
      //-------------------------------------------
      for(Horse h : horses) {
         try {
            h.join();
         } catch (InterruptedException e) {
         }
      }
         try {
            gs.join();
         } catch (InterruptedException e) {
         }
         
         System.out.println();
         System.out.println("경기 끝...");
   
         //등수의 오름차순으로 정렬하기
         Arrays.sort(horses);
         
         for(Horse h : horses) {
            System.out.println(h);
            
         }
         
   }

}

class Horse extends Thread implements Comparable<Horse>{
   public static int currentRank =0; //공통으로 쓰는 말등수
   
   private String HorseName;
   private int rank;
   private int positison;
   public Horse(String horseName) {
      super();
      this.HorseName = horseName;
   }
   public String getHorseName() {
      return HorseName;
   }
   public void setHorseName(String horseName) {
      this.HorseName = horseName;
   }
   public int getRank() {
      return rank;
   }
   public void setRank(int rank) {
      this.rank = rank;
   }
   public int getPositison() {
      return positison;
   }
   public void setPositison(int positison) {
      this.positison = positison;
   }
   @Override
   public String toString() {
      return "경주마" + HorseName + "은(는)" + rank + "등 입니다.";
   }
   
   @Override
   public int compareTo(Horse horse) {
      return Integer.compare(this.rank, horse.getRank());
      
      
   }
   
   @Override
   public void run() {
      for(int i=1; i<= 50; i++) {  //말이 달리는 쓰레드
         this.positison = i;
         
         try {
            Thread.sleep((int)(Math.random() * 500));
         } catch (InterruptedException e) {
            

         }
         
      }
      //한마리의 말이 경주가 끝나면 등수를 구해서 설정한다.
      currentRank++;
      this.rank =currentRank;
      
   }
   
}

class GameState extends Thread{ //말을 달리게 하는메서드
   private Horse[] horses;

   //생성자
   public GameState(Horse[] hoses) {
      super();
      this.horses = hoses;
   }
   @Override
   public void run() { //말의 달리는 설정
      while(true) {
         //모든 말들의 경기가 종료되었는지 여부를 검사한다.
         
          if(Horse.currentRank == horses.length) {
             break;
          }
          
          for(int i=1; i<=10; i++) {
             System.out.println();
             
          }
          
          
         for(int i=0; i<horses.length; i++) {
            System.out.print(horses[i].getHorseName()+ " : ");
            for(int j=1; j<=50; j++) {
               if(horses[i].getPositison() == j) {
                  System.out.print("🐎");
               }else {
               System.out.print("-");
               
             }
            
            }   
            System.out.println();//줄바꿈
         }
         try {
            Thread.sleep(100); //0.1초마다 반복
         } catch (InterruptedException e) {
            // TODO: handle exception
         }
         
      }

   }
   
}











