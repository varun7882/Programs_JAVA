package interview;
import java.util.*;
public class LongestSubstringWithoutRepeat {
	int c=1;
	public int lengthOfLongestSubstring(String a) {
		for(int i=0;i<a.length();i++)
		{
			int tc=0;
			Map<Character,Integer> m= new HashMap<Character,Integer>();
			for(int j=0;j<i;j++)
			{
				char x=a.charAt(j);
				tc++;
				if(m.containsKey(x))
				{
					break;
				}
				else
				{
					m.put(x,i);
				}
			}
			if(tc>c)
			{
				c=tc;
			}
		}
		return c;
	}
}
