package interview;
import java.util.*;
public class Combsum {
	//private int n;
	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		Set<Integer> tmp= new TreeSet<Integer>();
		getans(a,b,tmp,0,0);
		return ans;
	}
	void getans(ArrayList<Integer> a,int b,Set<Integer> tmp,int sum,int i)
	{
		if(sum==b)
		{
			ArrayList<Integer> tans= new ArrayList<Integer>(tmp);
			if(!ans.contains(tans))
			{
				ans.add(tans);
			}
		}
		else if(sum<b && i<a.size())
		{
			for(int j=i;j<a.size();j++)
			{
				if(sum+a.get(j)<=b)
				{
					tmp.add(a.get(j));
					getans(a,b,tmp,sum+a.get(j),i+1);
				}
			}
		}
	}

}
