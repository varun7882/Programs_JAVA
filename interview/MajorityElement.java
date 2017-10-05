package interview;
import java.util.*;
public class MajorityElement {
	public int majorityElement(final List<Integer> a) {
		int ans=0,c=1;
		for(int i=1;i<a.size();i++)
		{
			if(a.get(ans)==a.get(i))
			{
				c++;
			}
			else
			{
				c--;
			}
			if(c==0)
			{
				ans=i;
				c=1;
			}
		}
		return a.get(ans);
	}
}
