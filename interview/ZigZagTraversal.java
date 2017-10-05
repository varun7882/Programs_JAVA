package interview;
import java.util.*;
public class ZigZagTraversal {
	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
		Queue<TreeNodeDepth> q= new ArrayDeque<TreeNodeDepth>();
		q.add(new TreeNodeDepth(a, 0));
		int ld=0;
		ArrayList<Integer> t=new ArrayList<Integer>();;
		while(!q.isEmpty())
		{
	
			TreeNodeDepth tmp= q.poll();
			if(ld!=tmp.d)
			{
				if(ld%2==0)
				{
				ans.add(t);
				}
				else
				{
					Collections.reverse(t);
					ans.add(t);
				}
				t=new ArrayList<Integer>();
			}
			t.add(tmp.tree.val);
			TreeNode l,r;
			l=tmp.tree.left;
			r=tmp.tree.right;
			if(l!=null)
			{
				q.add(new TreeNodeDepth(l, tmp.d+1));
			}
			if(r!=null)
			{
				q.add(new TreeNodeDepth(r, tmp.d+1));
			}
			
			ld=tmp.d;
		}
			if(ld%2==0)
			{
			ans.add(t);
			}
			else
			{
				Collections.reverse(t);
				ans.add(t);
			}
			
		return ans; 
	}
}
class TreeNodeDepth
{
	TreeNode tree;
	int d;
	public TreeNodeDepth(TreeNode t,int f)
	{
		tree=t;
		d=f;
	}
}
