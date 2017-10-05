package interview;
import java.util.*;
public class sum4 {
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
		ArrayList<Integer> ta=a;
		for(int i=0;i<ta.size()-3;i++)
		{
			int j,k,l,x;
			j=i+1;
			k=j+1;
			l=ta.size()-1;
			x=b-ta.get(i)-ta.get(j);
			while(k<l)
			{
				int y=a.get(k)+a.get(l);
				if(y==x)
				{
					ArrayList<Integer> tmp= new ArrayList<Integer>();
					tmp.add(ta.get(i));
					tmp.add(ta.get(j));
					tmp.add(ta.get(k));
					tmp.add(ta.get(l));
					ans.add(tmp);
					Collections.sort(tmp);
					break;
				}
				else if(y<x)
				{
					k++;
				}
				else
				{
					l--;
				}
			}
		}
		Collections.sort(ans, new Comparator<ArrayList<Integer>>()
				{
					public int compare(ArrayList<Integer> o1,
							ArrayList<Integer> o2) {
						for(int i=0;i<o1.size();i++)
						{
							int cmp=o1.get(i)-o2.get(i);
							if(cmp==0)
							{
								return cmp;
							}
						}
						return 0;
					}
			
				});
		return ans;
	}
}
