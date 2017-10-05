package interview;
import java.util.*;
class PopulateRight {
	 public void connect(TreeLinkNode root) {
	        Queue<TreeLinkNodeDepth> q= new ArrayDeque<TreeLinkNodeDepth>();
	        q.add(new TreeLinkNodeDepth(root, 0));
	        TreeLinkNodeDepth curr,prev=null;
	        while(!q.isEmpty())
	        {
	        	curr=q.poll();
	        	if(prev==null)
	        	{
	        		curr.tln.next=null;
	        	}
	        	else
	        	{
	        		if(prev.d==curr.d)
	        		{
	        		prev.tln.next=curr.tln;
	        		}
	        		else
	        		{
	        			prev.tln.next=null;
	        		}
	        	}
	        	TreeLinkNode l,r;
	        	l=curr.tln.left;
	        	r=curr.tln.right;
	        	if(l!=null)
	        	{
	        		q.add(new TreeLinkNodeDepth(l,curr.d+1));
	        	}
	        	if(r!=null)
	        	{
	        		q.add(new TreeLinkNodeDepth(r, curr.d+1));
	        	}
	        	prev=curr;
	        }
	    }
}
 class TreeLinkNode {
	      int val;
	     TreeLinkNode left, right, next;
	     TreeLinkNode(int x) { val = x; }
	 }
 class TreeLinkNodeDepth
 {
	 TreeLinkNode tln;
	 int d;
	 public TreeLinkNodeDepth(TreeLinkNode t,int f) {
		 
		tln=t;
		d=f;
	}
 }
