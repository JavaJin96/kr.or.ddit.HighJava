

import java.util.ArrayList;
import java.util.Collections;

public class whatEat {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("바꾼다");
		list.add("안바꾼다");
		list.add("바꾼다");
		list.add("안바꾼다");
		
		Collections.shuffle(list);
		System.out.println(list.get(0));
		
		
	}

}
