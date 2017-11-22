package varun;
import java.util.*;
public class javacollections {
public static void main(String[] args)
	    {
		Scanner st =new Scanner(System.in);
		ArrayList al= new ArrayList();
		LinkedList li= new LinkedList();
		HashSet hs= new HashSet();
		int i,j,n,c;
	    n=st.nextInt();
	   // al.add("1");
	    for(i=0;i<n;i++)
	    {
	    	c=st.nextInt();
	    	al.add(c);
	    	c=st.nextInt();
	    	li.add(c);
	    	c=st.nextInt();
	    	hs.add(c);
	    }
	    Iterator itr1= al.iterator();
	    Iterator itr2=li.iterator();
	    Iterator itr3=hs.iterator();
	    System.out.println("Array List");
	    while(itr1.hasNext())
	    {
	    	System.out.println(itr1.next());
	    }
	    System.out.println("Linked List");
	    while(itr2.hasNext())
	    {
	     	System.out.println(itr2.next());
	    }
	    System.out.println("Hashed List");
	    while(itr3.hasNext())
	    {
	     	
	    	System.out.println(itr3.next());
	    }
	    
	    }
	}



