package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueTest {
	
	/*
	 * 
	 *  Stack : 후입선출(Last In First Out; LIFO)
	 *  
	 *  Queue : 선입선출(First In First Out; FIFO)
	 *  
	 *  Stack과 Queue는 자료를 꺼내가면 꺼내간 자료를 Stack과 Queue에서 삭제한다.
	 *  
	 *  Java에서 Stack과 Queue의 역활을 하는 Class
	 *  Stack : LinkedList와 Stack이라는 Class 존재
	 *  Queue : LinkedList를 이용해서 사용할 수 있다. (Java에서는 따로 존재하지 않음)
	 * 
	 */

	public static void main(String[] args) {
		
		/*
		 *  Stack의 명령
		 *  1. 자료 입력 : push(입력값)
		 *  2. 자료 출력 : pop() : 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 *  		   peek() : 삭제없이 자료를 꺼니온다.
		 */
		
		
		
		//방법1
		Stack<String> stack = new Stack<>();
		
		//방법2
//		LinkedList<String> stack2 = new LinkedList<>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("stack : " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("stack : " + stack);
		
		stack.push("성춘향");
		System.out.println("stack : " + stack);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("stack : " + stack);
		
		System.out.println("삭제없이 데이터 꺼내오기 : " + stack.peek());
		System.out.println("stack : ");
		System.out.println("====================================================");
		
		/*
		 *  Queue의 명령
		 *  1. 자료입력 : offer(입력값)
		 *  2. 자료출력 : poll() : 자료를 꺼내오고 꺼내온 자료를 Queue에서 삭제한다.
		 *  		   peek() : 삭제없이 자료를 꺼내온다.
		 *  
		 */
		
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		System.out.println("Queue : " + queue);
		String data2 = queue.poll();
		System.out.println("꺼내온 값 : " + data2);
		System.out.println("꺼내온 값 : " + queue.poll());
		
		System.out.println("Queue : " + queue);
		
		queue.offer("성춘향");
		System.out.println("Queue : " + queue);
		System.out.println("꺼내온 값 : " + queue.poll());
		
		System.out.println("삭제없이 꺼내오기 : " + queue.peek());
		System.out.println("Queue : " + queue);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
