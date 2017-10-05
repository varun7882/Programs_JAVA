package interview;
import java.util.*;
public class Sum2 {
	ArrayList<Integer> ans= new ArrayList<Integer>(); 
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
		Map<Integer,Integer> m= new HashMap<Integer,Integer>();
		for(int i=0;i<a.size();i++)
		{
			int x=b-a.get(i);
			if(m.containsKey(x))
			{
				ans.add(m.get(x));
				ans.add(i+1);
				break;
			}
			else
			{
				if(!m.containsKey(a.get(i)))
				{
					m.put(a.get(i), i+1);
				}
			}
		}
		return ans;
	}
}
