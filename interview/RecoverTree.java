package interview;
import java.util.*;
public class RecoverTree {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	int l=Integer.MIN_VALUE;
	public ArrayList<Integer> recoverTree(TreeNode a) {
		inorder(a);
		if(ans.size()==2)return ans;
		ArrayList<Integer> t= new ArrayList<Integer>();
		t.add(ans.get(0));
		t.add(ans.get(ans.size()-1));
		return t;
	}
	void inorder(TreeNode t)
	{
		if(t==null)return;
		inorder(t.left);
		if(l>t.val)
		{
			ans.add(l);
			ans.add(t.val);
		}
		l=t.val;
		inorder(t.right);
	}
}
