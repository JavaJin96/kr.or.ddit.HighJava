package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Scanner;




public class HotelManage {
   
   Scanner s = new Scanner(System.in);
   HashMap<Integer, Room> client = new HashMap<>();  
   
   
   // private HashMap<Integer, Room> hotelMap;
   // private Scanner scan; 
   // 객체를 호출만 하고 생성과 초기화는 생성자에서 진행하자!!
   
   
   HotelManage () {

	   	for(int i = 201; i < 210; i++) {
	   		client.put(i, new Room(i, "싱글룸"));
	   	}
	   	for(int i = 301; i < 310; i++) {
	   		client.put(i, new Room(i, "더블룸"));
	   	}
	   	for(int i = 401; i < 410; i++) {
	   		client.put(i, new Room(i, "스위트룸"));
	   	}
	   	
	   	 /*	hotelMap = new HashMap<>();
	   	 	scan = new Scanner(System.in);
	   	
	   	 * 	for(int i=2; i <= 4; i++){
	   	 * 	String roomType = null;
	   	 * 	switch(i){
	   	 * 		case 2: roomType = "싱글룸"; break;
	   	 * 
	   	 * 		case 3: roomType = "더블룸"; break;
	   	 * 
	   	 * 		case 4: roomType = "스위트룸"; break;
	   	 * 
	   	 * 		}
	   	 * 
	   	 * 		for(int j=1; j <= 9; j++){
	   	 * 			int roomNum = i * 100 + j;
	   	 * 			Room r = new Room(roomNum, roomType);
	   	 * 			hotelMap.put(roomNum, r);	
	   	 * 		}
	   	 * 
	   	 * }
	   	 * 
	   	 * 
	   	 */
	      
   }
   
   
   
   
   public static void main(String[] args) {
	   HotelManage hm = new HotelManage();
	   hm.start();
	   
	   // new HotelManage().start();
	   // 객체의 생성과 메서드 호출을 동시에 할 수 있다!

   }
   
   private void start() {
	  
	  do {
		  menu();
		  int input = Integer.parseInt(s.nextLine());
		  switch(input) {
		  case 1:
			  checkIn();
			  break;
		  case 2:
			  checkOut();
			  break;
		  case 3:
			  viewRoom();
			  break;
		  case 4:
			  System.out.println("이용해 주셔서 감사합니다.");
			  return;
			  
		  // case문에서의 default : 번호를 잘못 입렸했을때(입력값에 지정된 값이 아닌 값이 들어왔을때)
		  // default : {System.out.println("번호를 잘못 입력하셨습니다.")
		  // System.out.println("")
		  }
		  
	  }while(true);
   }
   
   private void checkIn() {
      
      
      System.out.println("--------------------------------------------------");
      System.out.println("체크인");
      System.out.println("--------------------------------------------------");
      System.out.println("* 201 ~ 209 : 싱글룸");
      System.out.println("* 301 ~ 309 : 더블룸");
      System.out.println("* 401 ~ 409 : 스위트룸");
      System.out.println("--------------------------------------------------");
      System.out.print("방 번호 입력 >> ");
      int roomNum = Integer.parseInt(s.nextLine());

      if(client.containsKey(roomNum) == false) {
    	  System.out.println("존재하지 않는 방번호 입니다.");
    	  System.out.println("다시 확인해주세요.");
		  try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		  System.out.println("");

      }else {
    	  if(client.get(roomNum).user == null) {
    		  System.out.print("고객명을 입력해주세요>>");
    		  String name = s.nextLine();
    		  Room room = new Room(roomNum, client.get(roomNum).getRoomType());
    		  
    		  // 입력받은 투숙객 이름을 해당 객실에 저장하기
    		  // hotelMap.get(num).setGuestName(name);
    		  // 맵에 key(방번호)의 value room객체를 불러온뒤 room.set~ 메서드로 값을 넣어준다.
    		  
    		  client.put(roomNum, room);
    		  room.setUser(name);
    		  
    		  System.out.println("정상적으로 체크인 되었습니다.");
    		  try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		  System.out.println("");

    	  }else {
    		  
    		  System.out.println("해당 객실은 예약이 완료되었습니다.");
    		  System.out.println("다른 객실을 이용해주세요.");
    		  try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		  System.out.println("");

    		  
    	  }
    	  
      }
      
      return;
      
      

   }
   
   private void checkOut() {
	   System.out.println("--------------------------------------------------");
	   System.out.println("체크아웃");
	   System.out.println("--------------------------------------------------");
	   System.out.print("체크아웃 할 객실을 입력해주세요>>");
	   int roomnum = Integer.parseInt(s.nextLine());
	   if(client.containsKey(roomnum) == false) {
	    	  System.out.println("존재하지 않는 방번호 입니다.");
	    	  System.out.println("다시 확인해주세요.");
    		  try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	      }else {
	    	  if(/*client.get(roomnum).user == null*/  client.get(roomnum).getUser() != null) {
	    		  // client.get(roomnum).getuser() != null; 로도 표현가능
	    		  System.out.println("해당 객실은 체크인 처리가 안되어있습니다.");
	    		  System.out.println("객실 번호를 확인해주세요.");
	    		  try {
	  				Thread.sleep(1500);
	  			} catch (InterruptedException e) {
	  				e.printStackTrace();
	  			}
	    		  System.out.println("");
	    		  
	    	  }else {
	    		  Room room = new Room(roomnum, client.get(roomnum).roomType);
	    		  client.put(roomnum, new Room(roomnum, client.get(roomnum).roomType));
	    		  room.setUser("-");
	    		  
	    		  System.out.println("체크아웃 처리 되었습니다.");
	    		  try {
	  				Thread.sleep(1500);
	  			} catch (InterruptedException e) {
	  				e.printStackTrace();
	  			}
	    		  System.out.println("");
	    		  
	    	  }
	    	  
	      }
	   
	   // 체크 아웃 작업 : 해당 방번호의 투숙객 이름을 null로 변경한다.
	   // String name = hotelMap.get(num).getGuestName();
	   // hotelMap.get(num).setGuestName(null);
	   
	   
	   return;
   }
   
   private void viewRoom() {
	   
	   
	   // 방번호를 순서대로 나오게 하기 위해서 방번호(Map의 Key값)만 List에 저장한 후 정렬하여 사용한다.
	   // 리스트 만들기 : ArrayList <Integer> numList = new arrayList<>(hotelMap.keySet());
	   // 정렬하기 : Collections.sort(numList); 
	   // 반복문 사용하여 순서대로 출력하여 value 값 불러오기
	   
	   
	   
	   
	   
	   System.out.println("--------------------------------------------------");
	   System.out.println("객실상태");
	   System.out.println("--------------------------------------------------");
	   System.out.println("방번호 \t 방종류 \t 투숙객");
	   
	   // Room r = hotelMap.get(num)
	   // r.getRoomNum()
	   // r.getRoomType()
	   // r.user()
	   
	   for(int i = 201; i < 210; i++) {
		   if(client.get(i).user == null) {
			   System.out.println(client.get(i).roomNum + "\t" + client.get(i).roomType
					   + "\t" + "-");	   
		   }else {
			   System.out.println(client.get(i).roomNum + "\t" + client.get(i).roomType
					   + "\t" + client.get(i).user);
		   }
	   }
	   for(int i = 301; i < 310; i++) {
		   if(client.get(i).user == null) {
			   System.out.println(client.get(i).roomNum + "\t" + client.get(i).roomType
					   + "\t" + "-");	   
		   }else {
			   System.out.println(client.get(i).roomNum + "\t" + client.get(i).roomType
					   + "\t" + client.get(i).user);
		   }
	   }
	   for(int i = 401; i < 410; i++) {
		   if(client.get(i).user == null) {
			   System.out.println(client.get(i).roomNum + "\t" + client.get(i).roomType
					   + "\t" + "-");	   
		   }else {
			   System.out.println(client.get(i).roomNum + "\t" + client.get(i).roomType
					   + "\t" + client.get(i).user);
		   }
	   }
   }

   private void menu()  {
      System.out.println("**************************************************");
      System.out.println("대덕인재 호텔 입니다. 어서오십시오");
      System.out.println("**************************************************");
      
      System.out.println("--------------------------------------------------");
      System.out.println("어떤 업무를 하시겠습니까");
      System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
      System.out.print("선택>>");
      
   }




   public HashMap<Integer, Room> getClient() {
      return client;
   }




   public void setClient(HashMap<Integer, Room> client) {
      this.client = client;
   }

}

class Room {
	
	   int roomNum;
	   String roomType;
	   String user;
	   
	   public Room(int roomNum, String roomType) {
		      super();
		      this.roomNum = roomNum;
		      this.roomType = roomType;
		   }
	   
	
   public int getRoomNum() {
      return roomNum;
   }


   public void setRoomNum(int roomNum) {
      this.roomNum = roomNum;
   }


   public String getRoomType() {
      return roomType;
   }


   public void setRoomType(String roomType) {
      this.roomType = roomType;
   }


   public String getUser() {
      return user;
   }


   public void setUser(String user) {
      this.user = user;
   }



   
}
