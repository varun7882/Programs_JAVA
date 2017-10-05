package interview;
import java.util.*;
public class Anagrams {
	ArrayList<ArrayList<Integer>> ans= new ArrayList<ArrayList<Integer>>();
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		Map<ArrayList<Character>,Integer> m= new HashMap<ArrayList<Character>, Integer>();
		Map<ArrayList<Character>,ArrayList<Integer>> ansm= new HashMap<ArrayList<Character>,ArrayList<Integer>>();
		for(int i=0;i<a.size();i++)
		{
			String x=a.get(i);
			ArrayList<Character> tmp= new ArrayList<Character>();
			for(int j=0;j<x.length();j++)
			{
				tmp.add(x.charAt(j));
			}
			Collections.sort(tmp);
			if(!m.containsKey(tmp))
			{
				m.put(tmp,i+1);
				if(!ansm.containsKey(tmp))
				{
					ArrayList<Integer> xs= new ArrayList<Integer>();
					xs.add(i+1);
					ansm.put(tmp,xs);
				}
				else
				{
					ArrayList<Integer> xs=ansm.get(tmp);
					xs.add(i+1);
					ansm.put(tmp,xs);
				}
			}
			else
			{
				if(!ansm.containsKey(tmp))
				{
					ArrayList<Integer> xs= new ArrayList<Integer>();
					xs.add(i+1);
					ansm.put(tmp,xs);
				}
				else
				{
					ArrayList<Integer> xs=ansm.get(tmp);
					xs.add(i+1);
					ansm.put(tmp,xs);
				}
			}
		}
		 Collection<ArrayList<Integer>> st= ansm.values();
		 for(ArrayList<Integer> x:st)
		 {
			 ans.add(x);
		 }
		Collections.sort(ans, new Comparator<ArrayList<Integer>>()
		{

			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				for(int i=0;i<Math.min(o1.size(),o2.size());i++)
				{
					int cm=o1.get(i)-o2.get(i);
					if(cm!=0)
					{
						return cm;
					}
				}
				return o1.size()-o2.size();
			}
			
		});
		return ans;
	}
}
