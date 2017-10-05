package interview;
import java.util.*;
public class Dnums {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	 public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		 int i,s=A.size(),j;
		
		 if(s<=B)
		 {
			 Set<Integer> tss= new HashSet<Integer>();
			 for(i=0;i<s;i++)
			 {
				 tss.add(A.get(i));
			 }
			 ans.add(tss.size());
			 return ans;
		 }
		 Set<Integer> tss= new HashSet<Integer>();
		 for(i=0;i<B;i++)
		 {
			 tss.add(A.get(i));
		 }
		 ans.add(tss.size());
		 Map<Integer,Integer> ts= new HashMap<Integer, Integer>();
		 for(i=0;i<s;i++)
		 {
			 if(i<B)
			 {
				if(ts.containsKey(A.get(i)))
				{
					int x=ts.get(A.get(i));
					ts.put(A.get(i),x+1);
				}
				else
				{
					ts.put(A.get(i),1);
				}
			 }
			 else
			 {
				j=i-B;
				int e=A.get(j);
				int x=ts.get(e);
				if(x==1)
				{
					ts.remove(e);
				}
				else
				{
					ts.put(e,x-1);
				}
				if(ts.containsKey(A.get(i)))
				{
					 x=ts.get(A.get(i));
					ts.put(A.get(i),x+1);
				}
				else
				{
					ts.put(A.get(i),1);
				}
				Set<Integer> tt= ts.keySet();
				ans.add(tt.size());
			 }
		 }
		 return ans;
	    }
}
