package interview;
import java.util.*;
public class LeastCommonAncestor {	
	ArrayList<TreeNode> s= new ArrayList<TreeNode>();
	ArrayList<TreeNode> tp,up,vp;
	int u,v,ans=-1;
	boolean f=false;
	public int lca (TreeNode t,int a,int b)
	{
		u=a;
		v=b;
		int i;
		findNode(t,u);
		if(!f)return -1;
		f=false;
		up=tp;
		s.clear();
		findNode(t,v);
		if(!f)return -1;
		vp=tp;
			for(i=0;i<up.size();i++)
		{
			System.out.println(up.get(i).val);
		}
		System.out.println("va hai");
		for(i=0;i<vp.size();i++)
		{
		    	System.out.println(vp.get(i).val);
		}
		for(i=0;i<Math.min(up.size(),vp.size());i++)
		{
			if(up.get(i)!=vp.get(i))
			{
				break;
			}
		}
		return up.get(i-1).val;
	}
	void findNode(TreeNode t,int u)
	{
		if(t==null || f)return;
		if(t.val==u)
			{
			f=true;
				s.add(t);
			tp= new ArrayList<TreeNode>(s);
			return;
			}
		s.add(t);
		findNode(t.left,u);
		findNode(t.right,u);
		s.remove(t);
	}
}

