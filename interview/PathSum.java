package interview;

public class PathSum {
	public int hasPathSum(TreeNode a, int b) {
		if(hasSum(a,0,b))return 1;
		return 0;
	}
	boolean hasSum(TreeNode t,int s,int b )
	{
		if(t.left==null && t.right==null && s==b)return true;
		if(t.left==null && t.right==null)return false;
		if(s>b)return false;
		if(t.left==null)
		{
			return hasSum(t.right,s+t.val,b);
		}
		if(t.right==null)
		{
			return hasSum(t.left,s+t.val,b);
		}
		return hasSum(t.left,s+t.val,b)|| hasSum(t.right,s+t.val,b);
	}
}
