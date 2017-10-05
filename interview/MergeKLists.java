package interview;
import java.util.*;
public class MergeKLists {
	ListNode ans,tmp;
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		boolean f=true;
		Queue<Integer> q= new PriorityQueue<Integer>();
		while(f)
		{
			f=false;
			for(int i=0;i<a.size();i++)
			{
				if(a.get(i)!=null)
				{
					f=true;
					q.offer(a.get(i).val);
					a.set(i,a.get(i).next);
				}
			}
			if(ans==null)
			{
				tmp=ans=new ListNode(q.poll());
			}
			else
			{
				tmp.next=new ListNode(q.poll());
				tmp=tmp.next;
			}
		}
		while(!q.isEmpty())
		{
			if(ans==null)
			{
				tmp=ans=new ListNode(q.poll());
			}
			else
			{
				tmp.next=new ListNode(q.poll());
				tmp=tmp.next;
			}
		}
		tmp.next=null;
		return ans;
	}
}

 class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }


