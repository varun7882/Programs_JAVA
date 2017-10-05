package interview;
import java.util.*;
public class Postorder {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	public ArrayList<Integer> postorderTraversal(TreeNode a) {
		Stack<TreeNode> s= new Stack<TreeNode>();
		TreeNode t=a,prev=null;
		s.push(a);
		while(!s.empty())
		{
			t=s.peek();
			if(prev==null ||prev.left==t|| prev.right==t)
			{
				if(t.left!=null)
				{
					s.push(t.left);
				}
				else if(t.right!=null)
				{
					s.push(t.right);
				}
				else
				{
					s.pop();
					ans.add(t.val);
				}
			}
			else if(t.left==prev)
			{
				if(t.right!=null)
				{
					s.push(t.right);
				}
				else
				{
					ans.add(t.val);
					s.pop();
				}
			}
			else
			{
				ans.add(t.val);
				s.pop();
			}
			prev=t;
		}
		return ans;
	}
}
