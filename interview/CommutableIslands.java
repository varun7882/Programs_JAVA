package interview;
import java.util.*;
public class CommutableIslands {
	int un[];
	 public int solve(int A, ArrayList<ArrayList<Integer>> B) {
		 un=new int[A];
		 int ans=0;
		 for(int i=0;i<A;i++)
		 {
			 un[i]=i;
		 }
		 Collections.sort(B,new Comparator<ArrayList<Integer>>()
				 {

					@Override
					public int compare(ArrayList<Integer> o1,
							ArrayList<Integer> o2) {
						return o1.get(2)-o2.get(2);
					}
			 
				 });
		 for(int i=0;i<B.size();i++)
		 {
			 ArrayList<Integer> t=B.get(i);
			 if(union(t.get(0),t.get(1)))
			 {
				 ans=ans+t.get(2);
			 }
		 }
		 return ans;
	    }
	 public boolean union(int x,int y)
	 {
		 int rtx,rty;
		 rtx=root(x);
		 rty=root(y);
		 if(rtx!=rty)
		 {
			 un[rtx]=rty;
			 return true;
		 }
		 return false;
	 }
	 public int root(int x)
	 {
		 
		 while(x!=un[x])
		 {
			 x=un[x];
		 }
		 return x;
	 }
}
