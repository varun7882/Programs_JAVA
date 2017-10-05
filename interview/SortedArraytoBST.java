package interview;
import java.util.*;
public class SortedArraytoBST {
	List<Integer> l;
	public TreeNode sortedArrayToBST(final List<Integer> a) {
		l=a;
		TreeNode t=null;
		return buildTree(t,0,a.size()-1);
	}
	TreeNode buildTree(TreeNode t,int b,int e)
	{
		if(b<=e)
		{
			int m=(b+e)/2;
			t= new TreeNode(l.get(m));
			t.left=buildTree(t.left,b,m-1);
			t.right=buildTree(t.right,m+1,e);
		}
		return t;
	}
}
