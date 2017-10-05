package interview;
import java.util.*;
public class PathsSum {
	ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<Integer> at= new ArrayList<Integer>();
		if(root==null)return ans;
		at.add(root.val);
		getAns(root,sum-root.val,at);
		return ans;
	}
	void getAns(TreeNode t,int s,ArrayList<Integer> at)
	{
		if(t.left==null && t.right==null && s==0)
		{
			ans.add(new ArrayList<Integer>(at));
			return;
		}
		if(t.left==null && t.right==null)return ;
		if(t.left==null)
		{
			at.add(t.right.val);
			getAns(t.right,s-t.right.val,at);
			at.remove(at.size()-1);
		}
		else if(t.right==null)
		{
			at.add(t.left.val);
			getAns(t.left,s-t.left.val,at);
			at.remove(at.size()-1);
		}
		else
		{
		at.add(t.right.val);
		getAns(t.right,s-t.right.val,at);
		at.remove(at.size()-1);
		at.add(t.left.val);
		getAns(t.left,s-t.left.val,at);
		at.remove(at.size()-1);
		}
	}
}
