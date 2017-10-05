package interview;
import java.util.*;
public class Subsets {
	private int n;
	
	ArrayList<ArrayList<Integer>> tans=new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
		n=a.size();
		if(n==0)
		{
			return tans;
		}
		Set<Integer> tmp=new TreeSet<Integer>();
		createsubsets(a,tmp,0);
		return tans;
	}
	void createsubsets(ArrayList<Integer> a,Set<Integer> tmp,int i)
	{
		if(i==n)
		{
			//Collections.sort(tmp);
			tans.add(new ArrayList<Integer>(tmp));
		}
		else
		{
			createsubsets(a,tmp,i+1);
			tmp.add(a.get(i));
			createsubsets(a,tmp,i+1);
			tmp.remove(a.get(i));
		}
	}
}
