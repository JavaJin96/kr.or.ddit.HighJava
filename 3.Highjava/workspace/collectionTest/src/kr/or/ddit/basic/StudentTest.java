package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 *  문제) 학번(int), 이름(String), 국어점수, 영어점수, 수학점수, 총점, 등수를 맴버로 갖는 Stuendt 클래스를 만든다.
 *  이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서 초기화 처리를 한다.
 *  
 *  이 Student 객체는 List에 저장하여 관리한다.
 *  
 *  List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
 *  총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬이 되는 외부 정렬기준 클래스를 작성하여 각각의 방식으로 정렬한
 *  결과를 출력하시오.
 *  
 *  (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */


public class StudentTest {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<>();
		
		
		//5명의 학생 정보 입력
//		for(int i = 0; i < 5; i++) {
//			System.out.println("학번을 입력해주세요>");
//			int studentNum = Integer.parseInt(s.nextLine());
//			System.out.println("이름을 입력해주세요>");
//			String name = s.nextLine();
//			System.out.println("국어점수를 입력해주세요>");
//			int kor = Integer.parseInt(s.nextLine());
//			System.out.println("영어점수를 입력해주세요>");
//			int eng = Integer.parseInt(s.nextLine());
//			System.out.println("수학점수를 입력해주세요>");
//			int math = Integer.parseInt(s.nextLine());
//			
//			students.add(new Student(studentNum, name, kor, eng, math));
//		}
		
		students.add(new Student(1, "박상진", 90, 90, 90));
		students.add(new Student(2, "양승혁", 80, 80, 80));
		students.add(new Student(3, "정석철", 60, 60, 60));
		students.add(new Student(4, "신가영", 90, 90, 90));
		students.add(new Student(5, "이기석", 90, 90, 90));
		students.add(new Student(6, "조화랑", 70, 70, 70));
		students.add(new Student(7, "양동현", 70, 70, 70));
		students.add(new Student(8, "김승섭", 60, 60, 60));
		students.add(new Student(9, "신혜령", 50, 40, 40));
		students.add(new Student(10, "박지원", 70, 70, 70));
		
		//과목 합 구하기
		for(int i = 0; i < students.size(); i++) {
			students.get(i).sumScore= students.get(i).kor + students.get(i).eng + students.get(i).math;
		}
		
		//석차 구하기
		for(int i = 0; i < students.size(); i++) {
			for(int j = 0; j < students.size(); j++) {
				if(students.get(i).sumScore < students.get(j).sumScore) {
					students.get(i).rank += 1;
				}
			}
		}
	
	System.out.println("외부정렬기준사용(총점의 역순/같을시 이름 오름차순)");
	Collections.sort(students, new sort());
	for(Student st : students) {
		System.out.println(st);
	}
	
	System.out.println("=================================");
	
	System.out.println("내부정렬기준사용(학번 오름차순)");
	Collections.sort(students);
	for(Student st : students) {
		System.out.println(st);
	}
		
			
	}

}

class Student implements Comparable<Student>{
	 int studentNum;
	 String name;
	 int kor;
	 int eng;
	 int math;
	 int sumScore;
	 int rank = 1;;
	
	Student (int studentNum, String name, int kor, int eng, int math) {
		this.studentNum = studentNum;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	@Override
	public String toString() {
		return "Student [studentNum=" + studentNum + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", sumScore=" + sumScore + ", rank=" + rank + "]";
	}

	void getSumScore () {
		this.sumScore = this.kor + this.eng + this.math;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setSumScore(int sumScore) {
		this.sumScore = sumScore;
	}


	//학번을 오름차순으로 정렬하는 내부정렬 기준
	@Override
	public int compareTo(Student s) {
		if(this.getStudentNum() > s.getStudentNum()) {
			return 1;
		}
		else if(this.getStudentNum() < s.getStudentNum()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	// wrapper class를 이용한 내부정렬기준 만들기
//	return Integer.compare(this.getNum(), s.getNum());
	
	
}

// 총점의 역순으로 정렬하고, 같을시 이름을 기준으로 오름차순으로 정렬하는 외부정렬기준
class sort implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.sumScore < s2.sumScore) {
			return -1;
		}
		else if(s1.sumScore > s2.sumScore) {
			return 1;
		}
		else {
			return s1.getName().compareTo(s2.getName());
		}
		
//		if(s1.getSum() == s2.getSum()){
//		return s1.getName().compareTo(s2.getName());
//	}else {
//		return Integer.compare(s1.sumScore, s2.sumScore);
//		
//	}
	
		
		
	}	
		
}
	
	