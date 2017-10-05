package interview;
import java.util.*;
public class OrderOfHeights {
	public ArrayList<Integer> order(ArrayList<Integer> hts, ArrayList<Integer> ifs) {
		ArrayList<Integer> ans;
		int n=hts.size();
		Integer tmp[]=new Integer[n];
		Arrays.fill(tmp, -1);
		PriorityQueue<Integer> q= new PriorityQueue<Integer>();
		Map<Integer,Integer> mp= new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++)
		{
			mp.put(hts.get(i),i);
			q.offer(hts.get(i));
		}
		int c=n;
		while(!q.isEmpty())
		{
			int x=q.poll();
			c--;
			int i=mp.get(x);
			int f=ifs.get(i);
			
				int t=0,tt=-1;
				while(t<n)
				{
					if(tmp[t]==-1)
					{
						tt++;
					}
					if(tt==f)break;
				}
				while(tmp[t]!=-1)
				{
					t++;
				}
				tmp[t]=x;
			
		}
		ans= new ArrayList<Integer>(Arrays.asList(tmp));
	return ans;
	}
}
