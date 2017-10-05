package interview;
import java.util.*;
public class Preorder {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	public ArrayList<Integer> preorderTraversal(TreeNode a) {
		Stack<TreeNode> s= new Stack<TreeNode>();
		TreeNode t=a;
		while(true)
		{
			while(t!=null)
			{
				ans.add(t.val);
				s.push(t);
				t=t.left;
			}
			if(s.empty())
			{
				break;
			}
			t=s.pop();
			t=t.right;
		}
		return ans;
	}

}
