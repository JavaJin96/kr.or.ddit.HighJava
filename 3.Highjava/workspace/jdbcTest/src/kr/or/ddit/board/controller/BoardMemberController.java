package kr.or.ddit.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.BoardMemberServiceimpl;
import kr.or.ddit.board.vo.BoardMemberVO;

public class BoardMemberController {
	private Scanner s;
	private BoardMemberServiceimpl service;
	private boolean flag = true;
	private boolean flag2 = true;
	int input = 0;
	int input1 = 0;
	
	public BoardMemberController() {
		s = new Scanner(System.in);
		service = BoardMemberServiceimpl.getInstance();
	}
	
	public static void main(String[] args) {
		new BoardMemberController().start();
	}
	
	public void start() {
		
		while(true) {
			
			if(flag2 == true) input = menu();
			else if(flag2 == false) input = input1;
			
			switch(input) {
			case 1 :
				insert();
				break;
			case 2 :
				view();
				break;
			case 3 :
				input1 = search();
				break;
			case 0 :
				System.out.println("게시판을 종료합니다.");
				return;
			default :
				System.out.println("번호를 잘못 입력하셨습니다.");
				break;
			}
		}
		 
	}
	
	private int search() {
	
		
		flag = false;
		flag2 = false;
		int input = menu();
		
		return input;
		
		

	}

	private void view() {
		
	
		System.out.println("몇번 게시글을 열람할까요?");
		int input = Integer.parseInt(s.nextLine());
		
		service.cntup(input);
		
		List<BoardMemberVO> list = service.selectBoardDetail(input);
		// 이부분에 cnt넣기
		
		
		System.out.println("-----------------------------------------------------------");
		System.out.println("제목 : " + list.get(0).getBoard_title());
		System.out.println("작성자 : " + list.get(0).getBoard_writer());
		System.out.println("내용 : " + list.get(0).getBoard_content());
		System.out.println("작성일 : " + list.get(0).getBoard_date());
		System.out.println("조회수 : " + list.get(0).getBoard_cnt()) ;
		System.out.println("-----------------------------------------------------------");
		System.out.println("1. 수정 2. 삭제 3. 리스트로가기");
		int input2 = Integer.parseInt(s.nextLine());
		switch(input2) {
		case 1:
			update(list.get(0));
			break;
		case 2:			
			service.deleteBoard(input);
			System.out.println("삭제되었습니다.");
			break;
		case 3:
			return;
		}
	}

	private void insert() {
		BoardMemberVO mem = new BoardMemberVO();
		
		System.out.println("제목을 입력해주세요.");
		String title = s.nextLine();
		mem.setBoard_title(title);
		System.out.println("작성자를 입력해주세요.");
		String writer = s.nextLine();
		mem.setBoard_writer(writer);
		System.out.println("내용을 입력해주세요.");
		String content = s.nextLine();
		mem.setBoard_content(content);
		
		service.insertBoard(mem);
		System.out.println("새글이 추가되었습니다.");
		
	}
	
	private void update(BoardMemberVO mem) {
		System.out.println("수정할 제목을 입력해주세요.");
		String updateTitle = s.nextLine();
		System.out.println("수정할 내용을 입력해주세요.");
		String updateContent = s.nextLine();
		
		mem.setBoard_title(updateTitle);
		mem.setBoard_content(updateContent);
		service.updateBoard(mem);
		System.out.println("수정되었습니다.");
	}

	public int menu() {
		
		List<BoardMemberVO> list = new ArrayList<>();
		
		if(flag == true) {
			 list = service.selectBoard();	
		}else if(flag == false) {
			System.out.println("검색할 게시글의 제목을 입력해주세요.");
			String title = s.nextLine();
			System.out.println();
			list = service.search(title); 
			flag = true;
			flag2 = true;
		}
		
		
		System.out.println("==========================================================");
		System.out.println("ddit 게시판");
		System.out.println("==========================================================");
		System.out.println("번호 제목 작성자 조회수");
		System.out.println("----------------------------------------------------------");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getBoard_no());
			System.out.print(list.get(i).getBoard_title());
			System.out.print(list.get(i).getBoard_writer());
			System.out.println(list.get(i).getBoard_cnt());
		}
		
		
		System.out.println("----------------------------------------------------------");
		System.out.println("1. 새글작성 2. 게시글보기 3. 검색 0. 작업끝");
		System.out.println("작업을 입력해주세요.");
		int input = Integer.parseInt(s.nextLine());
		
		return input;
	}
	
	
	
	
	
	

}
