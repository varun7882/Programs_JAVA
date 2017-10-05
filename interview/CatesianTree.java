package interview;
import java.util.*;
public class CatesianTree {
	TreeNode ans;
	ArrayList<Integer> l;
	boolean f=true;
	public TreeNode buildTree(ArrayList<Integer> a) {
		l=a;
		TreeNode t=null;
		buildTree(t,0,a.size()-1);
		return ans;
	}
	TreeNode buildTree(TreeNode t,int b,int e)
	{
		if(b==e)
		{
			t=new TreeNode(l.get(b));
			if(f)
			{
				ans=t;
				f=false;
			}
		}
		else if(b<e)
		{
			int mx=Integer.MIN_VALUE,imx=-1;
			for(int i=b;i<=e;i++)
			{
				if(mx<l.get(i))
				{
					mx=l.get(i);
					imx=i;
				}
			}
			t= new TreeNode(mx);
			if(f)
			{
				ans=t;
				f=false;
			}
			t.left=buildTree(t.left,b,imx-1);
			t.right=buildTree(t.right,imx+1,e);
		}
		return t;
	}
}
