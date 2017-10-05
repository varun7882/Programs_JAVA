package interview;
import java.util.*;
public class InandPrebuildTree {
	 ArrayList<Integer> a,b;
		public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
		    	a=inorder;
			b=preorder;
			TreeNode t=null;
			return makeTree(t,0,a.size()-1);
		}
			TreeNode makeTree(TreeNode t,int ai,int ae)
		{
			int i,x,y,id=-1,mx=Integer.MAX_VALUE;
			if(ai<=ae)
			{
				for(i=ai;i<=ae;i++)
				{
					 x=a.get(i);
					 y=b.indexOf(x);
					if(y<mx)
					{
						mx=y;
						id=i;
					}
				}
				t=new TreeNode(b.get(mx));
				t.left=makeTree(t.left,ai,id-1);
				t.right=makeTree(t.right,id+1,ae);
			}
			return t;
		}
			TreeNode makeTree(TreeNode t,int ai,int ae,int p)
			{
				int i,id=-1;
				if(ai<=ae)
				{
					int x=b.get(p);
					for(i=ai;i<=ae;i++)
					{
					    if(x==a.get(i))
					    {
					        id=i;
					        break;
					    }
					}
					t= new TreeNode(x);
					t.left=makeTree(t.left,ai,id-1,p+1);
					t.right=makeTree(t.right,id+1,ae,p+(id-ai+1));
				}
				return t;
			}
}
