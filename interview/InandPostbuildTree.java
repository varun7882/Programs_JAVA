package interview;
import java.util.*;
public class InandPostbuildTree {
	ArrayList<Integer> a,b;
	Map<Integer,Integer> ha,hb;
	public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
		a=inorder;
		b=postorder;
		ha= new HashMap<Integer, Integer>();
		hb= new HashMap<Integer, Integer>();
		for(int i=0;i<a.size();i++)
		{
			ha.put(a.get(i),i);
			hb.put(b.get(i),i);
		}
		TreeNode t=null;
		return makeTree(t,0,a.size()-1);
	}
	TreeNode makeTree(TreeNode t,int ai,int ae)
	{
		int i,x,y,id=-1,mx=Integer.MIN_VALUE;
		if(ai<=ae)
		{
			for(i=ai;i<=ae;i++)
			{
				 x=a.get(i);
				 y=hb.get(x);
				if(y>mx)
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
}
