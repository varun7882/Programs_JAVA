package interview;
import java.util.*;
public class MagiciansandChocolates {
	int s=0;
	final int mod=1000000009;
	 public int nchoc(int A, ArrayList<Integer> B) {
		 Queue<Integer> q= new PriorityQueue<Integer>(10,Collections.reverseOrder());
		 for(int i=0;i<B.size();i++)
		 {
			 q.offer(B.get(i));
		 }
		 for(int i=0;i<A;i++)
		 {
			 int x=q.poll();
			 s=(s%mod+x%mod)%mod;
			 q.offer(x/2);
		 }
		 return s;
	    }
}
