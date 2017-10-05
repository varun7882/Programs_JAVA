package interview;
import java.util.*;
public class T2Sum {
	boolean f=false;
	 public int t2Sum(TreeNode A, int B) {
		 TreeNext np= new TreeNext(A);
		 TreePrev pp= new TreePrev(A);
		 int x,y;
		 x=np.getNext().val;
		 y=pp.getPrev().val;
		 while(x<y)
		 {
			if(x+y==B)
			{
				return 1;
			}
			else if(x+y<B)
			{
				x=np.getNext().val;
			}
			else
			{
				y=pp.getPrev().val;
			}
		 }
		 return 0;
	    }
	
}
class TreeNext
{
	Stack<TreeNode> st;
	TreeNode root,t;
	TreeNext(TreeNode root)
	{
		this.root=root;
		st= new Stack<TreeNode>();
		while(root!=null)
		{
			st.push(root);
			t=root;
			root=root.left;
		}
	}
	TreeNode getNext()
	{
		TreeNode gt=null,tt=null;
		if(!st.isEmpty())
		{
			tt=gt=st.pop();
		}
		else
		{
			return null;
		}
		tt=tt.right;
		while(tt!=null)
		{
			st.push(tt);
			tt=tt.left;
		}
		return gt;
	}
}
class TreePrev
{
	Stack<TreeNode> st;
	TreeNode root,t;
	TreePrev(TreeNode root)
	{
		this.root=root;
		st= new Stack<TreeNode>();
		while(root!=null)
		{
			st.push(root);
			t=root;
			root=root.right;
		}
	}
	TreeNode getPrev()
	{
		TreeNode gt=null,tt=null;
		if(!st.isEmpty())
		{
			tt=gt=st.pop();
		}
		else
		{
			return null;
		}
		tt=tt.left;
		while(tt!=null)
		{
			st.push(tt);
			tt=tt.right;
		}
		return gt;
	}
}