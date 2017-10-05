package interview;

import java.util.ArrayList;

public class Prequisites {
	int un[];
	 public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
		 A++;
		 un=new int[A];
		 
		 for(int i=1;i<=A;i++)
		 {
			 un[i]=i;
		 }
		 for(int i=0;i<B.size();i++)
		 {
			union(B.get(i),C.get(i));
		 }
		// it is incomplete
		 return 1;
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
