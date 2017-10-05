package geeksforgeeks;
import java.util.*;

public class KLargestElement {
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		int t;
		t=s.nextInt();
		while(t-->0)
		{
			int n,k;
			n=s.nextInt();
			k=s.nextInt();
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>(k,Collections.reverseOrder());
		for(int i=0;i<n;i++)
		{
			int x=s.nextInt();
			pq.add(x);
			if(pq.size()>k)
			{
				pq.poll();
			}
		}
		while(!pq.isEmpty())
		{
		System.out.print(pq.poll());	
		}
		}
	}
}
