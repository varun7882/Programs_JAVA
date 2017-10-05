package interview;

public class FlattenTree2 {
	public TreeNode flatten(TreeNode a) {
			TreeNode c=a,tc=a;
			while(c!=null)
			{
				c=tc;
				if(c.left!=null)
				{
					c=c.left;
				
				while(c.right!=null)
				{
					c=c.right;
				}
				c.right=tc.right;
				tc.right=tc.left;
				tc.left=null;
				}
				tc=tc.right;
			}
		return a;
	}
	
}
