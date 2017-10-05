package interview;
import java.util.*;
public class VerticalTraversal {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	Map<Integer,ArrayList<Integer>> mp= new HashMap<Integer, ArrayList<Integer>>();
	 public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		 inorder(A,0);
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
	 void inorder(TreeNode t,int x)
	 {
		 if(t==null)return;
		 inorder(t.left,x--);
		 if(mp.containsKey(x))
		 {
			 mp.get(x).add(t.val);
		 }
		 else
		 {
			 ArrayList<Integer> at= new ArrayList<Integer>();
			 at.add(t.val);
			 mp.put(x,at);
		 }
		 inorder(t.right,x++);
	 }
}
