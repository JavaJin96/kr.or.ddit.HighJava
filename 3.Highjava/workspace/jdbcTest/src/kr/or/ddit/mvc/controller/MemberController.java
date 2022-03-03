package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceimpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberController {
	
	private Scanner scan;
	private IMemberService service; //service객체 변수 선언
	
	//생성자
	public MemberController() {
		scan = new Scanner(System.in);
		//service = new MemberServiceimpl();
		service = MemberServiceimpl.getInstance();
	}

	public static void main(String[] args) {
       new MemberController().memberStart();
	}

	public void memberStart(){
		while(true){
			int choice = displayMenu();
			switch(choice){
				case 1 :	// 추가 
					insertMember(); break;
				case 2 : 	// 삭제
					deleteMember(); break;
				case 3 : 	// 수정  ==> 전체 항목 수정
					updateMember(); break;
				case 4 : 	// 전체 자료 출력
					displayMember(); break;
				case 5 : 	// 수정	==> 원하는 항목만 수정
					updateMember2(); break;
				case 0 : 	// 종료
					System.out.println("작업을 마칩니다.");
					return;
				default : 
					System.out.println("번호를 잘못 입력했습니다. 다시입력하세요.");
			}
		}
	}

	// 원하는 항목만 수정
	private void updateMember2() {
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID >> ");
		String memId = scan.next();
		
		int count = service.getMemberCount(memId);
		if(count==0){ // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID입니다.");
			System.out.println("수정 작업을 중단합니다.");
			return;
		}
		String updateField = null;
		
		
		System.out.println("1. 비밀번호 2. 이름 3. 전화번호 4. 주소");
		System.out.print("수정할 항목을 입력하세요. >> ");
		int input = Integer.parseInt(scan.next());
		
		
		switch(input) {
		case 1 :
			updateField = "MEM_PASS";
			break;
		case 2 :
			updateField = "MEM_NAME";
			break;
		case 3 :
			updateField = "MEM_TEL";
			break;
		case 4 :
			updateField = "MEM_ADDR";
			break;
		}
		
		System.out.print("수정할 내용을 입력하세요.");
		String updateData = scan.next();
		
		
		
		
		Map<String, String> updateMap = new HashMap<>();
		
		updateMap.put("memid", memId);
		updateMap.put("field", updateField);
		updateMap.put("data", updateData);
		
		int cnt = service.updateMember2(updateMap);
		if(cnt>0){
			System.out.println("수정 스엉공");
		}else{
			
			System.out.println("수정 실패");
		}
		
		
		
	}
	
	
	
	
	// 전체 자료 출력
	  private void displayMember() {
		
		List<MemberVO> cnt = service.selectMember();
		
		if(cnt == null || cnt.size()==0) {
			System.out.println("등록된 회원이 없습니다.");
			return;
		}
		
		System.out.println("==========================================================");
		System.out.println("전체자료열람");
		System.out.println("==========================================================");
		for(MemberVO memVo:cnt){
			
			System.out.println("회원 ID : " + memVo.getMem_id());
			System.out.println("비밀번호 : " + memVo.getMem_pass());
			System.out.println("회원 이름 : " + memVo.getMem_name());
			System.out.println("전화번호 : " + memVo.getMem_tel());
			System.out.println("회원주소 : " + memVo.getMem_addr());
			System.out.println("-----------------------------------------------------------");

		}
	  }

	// 수정  ==> 전체 항목 수정
	private void updateMember() {
		
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요.");
		System.out.print("수정할 회원ID >> ");
		String memId = scan.next();
		
		int count = service.getMemberCount(memId);
		if(count==0){ // 없는 회원이면...
			System.out.println(memId + "은(는) 없는 회원ID입니다.");
			System.out.println("수정 작업을 중단합니다.");
			return;
		}
		
		System.out.println();
		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 회원이름 >> ");
		String newMemName = scan.next();
		
		System.out.print("새로운 비밀번호 >> ");
		String newMemPass = scan.next();
		
		System.out.print("새로운 전화번호 >> ");
		String newMemTel = scan.next();
		
		scan.nextLine();
		System.out.print("새로운 회원주소 >> ");
		String newMemAddr = scan.nextLine();
		
		//입력한 데이터들을 VO객체에 저장한다.
				MemberVO memVo = new MemberVO();
				memVo.setMem_id(memId);
				memVo.setMem_name(newMemName);
				memVo.setMem_pass(newMemPass);
				memVo.setMem_tel(newMemTel);
				memVo.setMem_addr(newMemAddr);
				
				int cnt = service.updateMember(memVo);
				if(cnt>0){
					System.out.println("수정 스엉공");
				}else{
					
					System.out.println("수정 실패");
				}
	}

	private void insertMember(){

		System.out.println();
		System.out.println("추가할 회원 정보를 입력하세요.");
		
		int count = 0;
		String memId = null;  // 회원ID가 저장될 변수
		do{
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			count = service.getMemberCount(memId);
			
			if(count>0){
				System.out.println(memId + "은(는) 이미 등록된 회원ID입니다.");
				System.out.println("다른 회원ID를 입력하세요.");
			}
			
		}while(count>0);
		
		System.out.print("회원이름 >> ");
		String memName = scan.next();
		
		System.out.print("비밀번호 >> ");
		String memPass = scan.next();
		
		System.out.print("전화번호 >> ");
		String memTel = scan.next();
		
		scan.nextLine();  // 입력 버퍼 비우기
		System.out.print("회원주소 >> ");
		String memAddr = scan.nextLine();
		
		//입력한 데이터들을 VO객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(memId);
		memVo.setMem_name(memName);
		memVo.setMem_pass(memPass);
		memVo.setMem_tel(memTel);
		memVo.setMem_addr(memAddr);
		
		int cnt = service.insertMember(memVo);
		if(cnt>0){
			System.out.println("추가 스엉공");
		}else{
			System.out.println("추가 실패");
		}
		
	}
	
	
	private void deleteMember(){
		System.out.println();
		System.out.println("삭제할 회원 정보를 입력하세요.");
		
		String memId = null;  // 회원ID가 저장될 변수
		
			System.out.print("회원ID >> ");
			memId = scan.next();
			
			int cnt = service.deleteMember(memId);
			if(cnt>0){
				System.out.println("삭제 스엉공");
			}else{
				System.out.println("삭제 실패");
			}
		
	}

	// 메뉴를 출력하고 선택한 작업 번호를 반환하는 메서드
		private int displayMenu(){
			System.out.println();
			System.out.println("==============================================================================================");
			System.out.println("맴버관리 프로그램");
			System.out.println("==============================================================================================");
			System.out.println("1. 자료추가 2. 자료삭제 3. 자료수정 4. 전체자료출력 5. 부분자료수정 0. 프로그램 종료");
			System.out.println("==============================================================================================");			
			System.out.println("행동을 입력해주세요>>>>");
			int num = scan.nextInt();
			return num;
		}
	
}