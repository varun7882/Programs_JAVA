package varun;
import java.util.*;
public  class TestCollection {
	public static void main(String[] args) {
		PriorityQueue<Integer>  st=new PriorityQueue<Integer>(20,Collections.reverseOrder());
		st.offer(1);
		st.offer(2);
		st.offer(2);
		//st.offer(2);
		st.remove(2);
		st.remove(2);
		System.out.println(st.peek());
	
	}
}

