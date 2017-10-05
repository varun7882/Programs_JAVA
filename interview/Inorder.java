package interview;
import java.util.*;
public class Inorder {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	public ArrayList<Integer> inorderTraversal(TreeNode a) {
		Stack<TreeNode> s= new Stack<TreeNode>();
		TreeNode t=a;
		while(true)
		{
			while(t!=null)
			{
				s.push(t);
				t=t.left;
			}
			if(s.empty())
			{
				break;
			}
			t=s.pop();
			ans.add(t.val);
			t=t.right;
		}
	return ans;
	}
}

  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }