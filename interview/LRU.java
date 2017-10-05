package interview;
import java.util.*;
public class LRU {
	int c,e=0;
	Node head,tail;
	Map<Integer,Integer> m;
	Map<Integer,Node> am;
	 public LRU(int c) {
	      this.c=c;  
	      m= new HashMap<Integer, Integer>();
	      am=new HashMap<Integer, Node>();
	    }
	    public int get(int k) {
	    	if(m.containsKey(k))
	    	{
	    		Node ad=am.get(k);
	    		if(ad==tail)
	    		{
	    			tail=ad.prev;
	    			tail.next=null;
	    		}
	    		Node p=ad.prev;
	    		p.next=ad.next;
	    		ad.next.prev=p;
	    		ad.next=head;
	    		head.prev=ad;
	    		head=ad;
	    		head.prev=null;
	    		return m.get(k);
	    	}
	        return -1;
	    }
	    public void set(int k, int v) {
	    	
	        if(e<c)
	        {
	        	if(!m.containsKey(k))
	        	{
		        	e++;
		        	m.put(k,v);
		        	if(head==null)
		        	{
		        		Node tmp=new Node(k);
		        		head=tail=tmp;
		        		am.put(k, tmp);
		        	}
		        	else
		        	{
		        		Node tmp= new Node(k);
		        		am.put(k,tmp);
		        		if(head==tail)
		        		{
		        			tail.prev=tmp;
		        		}
		        		tmp.next=head;
		        		head.prev=tmp;
		        		head=tmp;
		        		head.prev=null;
		        	}
	        	}
	        	else
	        	{
	        		m.put(k,v);
	        		Node ad=am.get(k);
		    		if(ad==tail)
		    		{
		    			tail=ad.prev;
		    			tail.next=null;
		    		}
		    		Node p=ad.prev;
		    		p.next=ad.next;
		    		ad.next.prev=p;
		    		ad.next=head;
		    		head.prev=ad;
		    		head=ad;
		    		head.prev=null;
	        		
	        	}
	        }
	        else
	        {
	        	if(!m.containsKey(k))
	        	{
	        		m.remove(tail.d);
	        		am.remove(tail);
	        		tail=tail.prev;
	        		tail.next=null;
	        		m.put(k,v);
	        		Node tmp= new Node(k);
	        		am.put(k,tmp);
	        		if(head==tail)
	        		{
	        			tail.prev=tmp;
	        		}
	        		tmp.next=head;
	        		head.prev=tmp;
	        		head=tmp;
	        		head.prev=null;
	        	}
	        	else
	        	{
	        		m.put(k,v);
	        		Node ad=am.get(k);
	        		ad.d=v;
		    		if(ad==tail)
		    		{
		    			tail=ad.prev;
		    			tail.next=null;
		    		}
		    		Node p=ad.prev;
		    		p.next=ad.next;
		    		ad.next.prev=p;
		    		ad.next=head;
		    		head.prev=ad;
		    		head=ad;
		    		head.prev=null;
	        		
	        	}
	        	
	        }
	    }
}
class Node
{
	Node next,prev;
	int d;
	public Node(int x)
	{
		d=x;
	}
}