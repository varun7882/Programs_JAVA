package interview;

public class InvertTree {
	  public TreeNode invertTree(TreeNode root) {
		  postorder(root);
	  return root;  
	  }
	  void postorder(TreeNode t)
	  {
		  if(t==null)return;
		  postorder(t.left);
		  postorder(t.right);
		  TreeNode tt;
		  tt=t.left;
		  t.left=t.right;
		  t.right=tt;
	  }
}
