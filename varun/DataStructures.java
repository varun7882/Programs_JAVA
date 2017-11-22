package varun;
import java.util.*;
public class DataStructures
{
	 public static void main(String args[])
	 {
		 Scanner st= new Scanner(System.in);
		 ArrayList al= new ArrayList();
		 LinkedList ll=new LinkedList();
		 PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		 al.add(1);
		 al.add(2);
		 al.add(3);
		 ll.add("10");
		 ll.add("20");
		 ll.add("30");
		 q.add(300);
		 q.add(200);
		 q.add(100);
		 q.add(90);
		
		 System.out.println(al);
		 System.out.println(ll);
		 System.out.println(q);
		 
		 
	 }
}
