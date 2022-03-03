package kr.or.ddit.board.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import kr.or.ddit.board.service.BoardMemberServiceimpl;
import kr.or.ddit.board.vo.BoardMemberVO;

public class BoardMemberController {
	
	private Scanner s;
	private BoardMemberServiceimpl service;
	
	public BoardMemberController() {
		service = BoardMemberServiceimpl.getInstance();
		s = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		new BoardMemberController().start();
	}
	
	public void start() {
		
		while(true) {
			int input = menu();
			
			switch(input) {
			case 1 :
				insert();
				break;
			case 2 :
				select();
				break;
			case 3 :
				search();
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("번호를 잘못 입력하셨습니다.");
				System.out.println("다시 확인해주세요.");
				break;
			}
			
		}
		
	}

	private void search() {
		List<BoardMemberVO> list = new ArrayList<>();
		System.out.println("검색할 제목이나 키워드를 입력해주세요.");
		String stitle = "%"; 
		stitle += s.nextLine();
		stitle += "%";
		
		list = service.search(stitle);
		
		System.out.println("=======================================================================");
		System.out.println("DDIT 게시판");
		System.out.println("=======================================================================");
		System.out.println("번호 \t  제목 \t  작성자 \t  조회수 \t");
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getBoard_no() + "\t");
			System.out.print(list.get(i).getBoard_title() + "\t");
			System.out.print(list.get(i).getBoard_writer() + "\t");
			System.out.println(list.get(i).getBoard_cnt() + "\t");
		}
		System.out.println("=======================================================================");
		System.out.println("1. 새글작성 2. 게시글보기 3. 검색 0. 프로그램 종료");
		System.out.println("행동을 입력해주세요 >>");
		int input = Integer.parseInt(s.nextLine());
		
		switch(input) {
		case 1 :
			insert();
			break;
		case 2 :
			select();
			break;
		case 3 :
			search();
			break;
		case 0 :
			System.out.println("프로그램을 종료합니다.");
			return;
		default :
			System.out.println("번호를 잘못 입력하셨습니다.");
			System.out.println("다시 확인해주세요.");
			break;
		}
		
	}

	private int menu() {
		List<BoardMemberVO> list = new ArrayList<>(); 
		System.out.println("=======================================================================");
		System.out.println("DDIT 게시판");
		System.out.println("=======================================================================");
		System.out.println(" 번호 \t  제목 \t  작성자 \t  조회수 \t");
		list = service.selectBoard();
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getBoard_no() + "\t");
			System.out.print(list.get(i).getBoard_title() + "\t");
			System.out.print(list.get(i).getBoard_writer() + "\t");
			System.out.println(list.get(i).getBoard_cnt() + "\t");
		}
		System.out.println("=======================================================================");
		System.out.println("1. 새글작성 2. 게시글보기 3. 검색 0. 프로그램 종료");
		System.out.println("행동을 입력해주세요 >>");
		int input = Integer.parseInt(s.nextLine());
		return input;
	}
	
	private void insert () {
		BoardMemberVO mem = new BoardMemberVO();
		
		System.out.println("새로운 게시글을 등록합니다.");
		
		System.out.println("등록할 게시글의 제목을 입력해주세요.");
		String title = s.nextLine();
		
		System.out.println("등록할 게시글의 작성자를 입력해주세요.");
		String writer = s.nextLine();
		
		System.out.println("등록할 게시글의 내용을 입력해주세요.");
		String content = s.nextLine();
		
		mem.setBoard_title(title);
		mem.setBoard_writer(writer);
		mem.setBoard_content(content);
		
		
		int res = service.insertBoard(mem);
		if (res == 1) {
			System.out.println("글이 정상적으로 등록되었습니다.");
		}else {
			System.out.println("글이 등록되지 않았습니다.");
			System.out.println("다시 한번 확인해주세요.");
		}
		return;
		
	}
	
	private void select() {
		List<BoardMemberVO> list = new ArrayList<>();
		BoardMemberVO mem = new BoardMemberVO();
		System.out.println("조회할 게시글을 입력해주세요.");
		int input = Integer.parseInt(s.nextLine());
		
		// 쿼리문이 필요한 DAO는 각각 필요하지만, select라는 메서드를 service로 놓으면,
		// 안에 3개의 dao메서드가 포함되므로, service부분에서 3가지를 합쳐서 작성하는 편이 좋다.
		int cnt = service.getcnt(input) + 1;
		mem.setBoard_cnt(cnt);
		mem.setBoard_no(input);
		service.setcnt(mem);
		
		list = service.selectBoardDetail(input);
		System.out.println("=======================================================================");
		System.out.println("제목 : " + list.get(0).getBoard_title());
		System.out.println("작성자 : " + list.get(0).getBoard_writer());
		System.out.println("내용 : " + list.get(0).getBoard_content());
		System.out.println("작성일 : " + list.get(0).getBoard_date());
		System.out.println("조회수 : " + list.get(0).getBoard_cnt());
		System.out.println("=======================================================================");
		System.out.println("1. 수정 2. 삭제 3. 리스트로가기");
		System.out.println("행동을 입력해주세요.");
		int input2 = Integer.parseInt(s.nextLine());
		
		switch(input2) {
		case 1:
			update(input);
			break;
		case 2:
			service.deleteBoard(input);
			break;
		case 3:
			return;
		}
		
	}

	private void update(int no) {
		BoardMemberVO mem = new BoardMemberVO();
		System.out.println("수정작업을 시작합니다.");
		System.out.println("수정할 제목을 입력해주세요.");
		String updatetitle = s.nextLine();
		
		System.out.println("수정할 내용을 입력해주세요.");
		String updatecontent = s.nextLine();
		
		mem.setBoard_no(no);
		mem.setBoard_title(updatetitle);
		mem.setBoard_content(updatecontent);
		
		int res = service.updateBoard(mem);
		if(res == 1) {
			System.out.println("정상적으로 수정되었습니다.");
		}else {
			System.out.println("수정되지 않았습니다.");
			System.out.println("다시 시도해주세요.");
		}
		return;
		
	}
	
	
	
	
	
}
