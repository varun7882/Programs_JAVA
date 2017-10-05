package interview;
import java.util.*;
public class Sub2 {
	public int diffPossible(final List<Integer> a, int b) {
		Map<Integer,Integer> m= new HashMap<Integer, Integer>();
		for(int i=0;i<a.size();i++)
		{
			int x=a.get(i)+b;
			int y=a.get(i)-b;
			if(m.containsKey(x)||m.containsKey(y))
			{
				return 1;
			}
			else
			{
				m.put(a.get(i),i);
			}
		}
		return 0;
	}
}
