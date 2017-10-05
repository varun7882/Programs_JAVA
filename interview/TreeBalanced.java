package interview;
public class TreeBalanced {
	public int isBalanced(TreeNode a) {
		if(a==null)return 1;
		if(a.left==null && a.right!=null)
		{
			if(a.right.left!=null || a.right.right!=null)return 0;
		}
		if(a.left!=null && a.right==null)
		{
			if(a.left.left!=null || a.left.right!=null)return 0;
		}
		return isBalanced(a.left)&isBalanced(a.right);
	}
	
}
