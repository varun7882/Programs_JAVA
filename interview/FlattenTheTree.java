package interview;
import java.util.*;
public class FlattenTheTree {
	public TreeNode flatten(TreeNode a) {
		if(a==null)return a;
		Stack<TreeNode> st= new Stack<TreeNode>();
		st.push(a);
		TreeNode p=null,c=a,tl,tr;
		while(true)
		{
			
			while(c.left!=null)
			{
				st.push(c.left);
				c=c.left;
			}
			if(st.empty())break;
			c=st.pop();
			tl=c.left;
			tr=c.right;
			c.left=null;
			if(tl!=null)
			{
			c.right=tl;
				if(p==null)
				{
					tl.right=tr;
				}
				else
				{
					p.right=tr;
				}
			}
			p=c;
			c=tr;
		}
		return a;
	}
}
