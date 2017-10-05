package interview;
import java.util.*;
public class Comb {
	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
	private int n;
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		this.n=n;
		Set<Integer> tmp= new HashSet<Integer>();
		createsubsets(tmp,1,k);
		Collections.sort(ans, new Comparator<ArrayList<Integer>>() {

			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				int a;
				a=o1.size();
				//b=o2.size();
				for(int i=0;i<a;i++)
				{
					int cmp=o1.get(i).compareTo(o2.get(i));
					if(cmp!=0)
					{
						return cmp;
					}
				}
				return 0;
			}
		});
		return ans;
	}
		void createsubsets(Set<Integer> tmp,int i,int k)
	{
		if(tmp.size()==k)
		{
			ArrayList<Integer> tans= new ArrayList<Integer>(tmp);
			if(!ans.contains(tans))
			{
			ans.add(tans);
			}
		}
		if(i!=n+1)
		{
			createsubsets(tmp,i+1,k);
			tmp.add(i);
			createsubsets(tmp,i+1,k);
			tmp.remove(i);
		}
	}

}
