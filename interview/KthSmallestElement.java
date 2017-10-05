package interview;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {
	public int kthsmallest(final List<Integer> a, int k) {
	    PriorityQueue<Integer> q= new PriorityQueue<Integer>(k,Collections.reverseOrder());
	    for(int i=0;i<a.size();i++)
	    {
	    	q.add(a.get(i));
	    	if(q.size()==k)
	    	{
	    		q.poll();
	    	}
	    }
	    
	    return 0;
	}
}
