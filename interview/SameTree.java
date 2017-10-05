package interview;
public class SameTree {
	public int isSameTree(TreeNode a, TreeNode b) {
		if(a==null && b!=null)return 0;
		if(a!=null && b==null)return 0;
		if(a==null && b==null)return 1;
		if(a.val!=b.val)
		{
			return 0;
		}
		return isSameTree(a.left,b.left)&isSameTree(a.right,b.right);
	}
}
