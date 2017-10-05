package interview;
import java.util.*;
public class VerticalTraversal2 {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	Map<Integer,ArrayList<Integer>> mp= new HashMap<Integer, ArrayList<Integer>>();
	 public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		 if(A==null)return ans;
		 Queue<Xval> q= new ArrayDeque<Xval>();
		 Xval r= new Xval(A,0);
		 q.add(r);
		 while(!q.isEmpty())
		 {
			 Xval t=q.poll();
			 int x=t.d;
			 if(mp.containsKey(x))
			 {
				 mp.get(x).add(t.t.val);
			 }
			 else
			 {
				 ArrayList<Integer> at= new ArrayList<Integer>();
				 at.add(t.t.val);
				 mp.put(x,at);
			 }
			 TreeNode l=t.t.left;
			 if(l!=null)
			 {
				 q.add(new Xval(l,x-1));
			 }
			 TreeNode rr=t.t.right;
			 if(rr!=null)
			 {
				 q.add(new Xval(rr,x+1));
			 }
		 }
		 Set<Integer> s= mp.keySet();
		 ArrayList<Integer> t= new ArrayList<Integer>();
		 for(Integer x:s)
		 {
			 t.add(x);
			 
		 }
		 Collections.sort(t);
		 for(Integer x:t)
		 {
			ArrayList<Integer> tt= mp.get(x);
			//Collections.reverse(tt);
			ans.add(tt);
			 
		 }
		 return ans;
	    }
}
class Xval
{
	TreeNode t;
	int d;
	Xval(TreeNode r,int h)
	{
		t=r;
		d=h;
	}
}
