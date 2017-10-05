package interview;
public class MergeSortLinkedList {
	public ListNode sortList(ListNode a) {
		return mergesort(a); 
	}
	ListNode mergesort(ListNode a)
	{
		if(a==null || a.next==null)return a;
		ListNode prt=part(a);
		return mergeLists(mergesort(a),mergesort(prt));
	}
	ListNode part(ListNode node)
	{
	    ListNode a=node;
		if(a==null || a.next==null)return a;
		ListNode slow,fast,ret,p;
		p=slow=fast=a;
		while(fast!=null)
		{
			fast=fast.next;
			if(fast!=null)
			{
			    p=slow;
				slow=slow.next;
				fast=fast.next;
			}
		}
		ret=slow;
		p.next=null;
		return ret;
	/*	 ListNode doubleRate;
	    ListNode prev;
	    
	    if (node == null || node.next == null)
	        return node;
	    
	    doubleRate = node;
	    prev = node;
	    
	    while (doubleRate.next != null && doubleRate.next.next != null) {
	        prev = node;
	        node = node.next;
	        doubleRate = doubleRate.next.next;
	    }
	    
	    prev = node;
	    node = node.next;
	    prev.next = null;
	    
	    return node;*/
	}
	ListNode mergeLists(ListNode a,ListNode b)
	{
		if(a==null)
		{
			return b;
		}
		if(b==null)
		{
			return a;
		}
		ListNode temp,s;
				if(a.val<=b.val)
		{
			temp=s=a;
			a=a.next;
		}
		else
		{
			temp=s=b;
			b=b.next;
		}
		while(a!=null && b!=null)
		{
			if(a.val<=b.val)
			{
				temp.next=a;
				a=a.next;
			}
			else
			{
				temp.next=b;
				b=b.next;
			}
			temp=temp.next;
		}
		if(a==null)
		{
			temp.next=b;
		}
	    if(b==null)
	    {
	    	temp.next=a;
	    }
		return s;
	}	}

