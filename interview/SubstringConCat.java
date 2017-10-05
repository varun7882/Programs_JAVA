package interview;
import java.util.*;
public class SubstringConCat {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
		int n=a.length();
		if(n==0)
		{
			return ans;
		}
		int s=b.size();
		if(s==0)
		{
			return ans;
		}
		int wl=b.get(0).length();
		if(wl==0)
		{
			return ans;
		}
		Map<String,Integer> mp= new HashMap<String, Integer>();
		for(int i=0;i<b.size();i++)
		{
			if(mp.containsKey(b.get(i)))
			{
				mp.put(b.get(i),mp.get(b.get(i))+1);
			}
			else
			{
				mp.put(b.get(i),1);
			}
		}
		int c=s,j=0;
		for(int i=0;i<n-(s*wl);i++)
		{
			c=s;
			j=i;
			while(j+wl<=n && mp.containsKey(a.substring(j,j+wl)) &&mp.get(a.substring(j,j+wl))>0)
			{
				mp.put(a.substring(j,j+wl), mp.get(a.substring(j,j+wl)));
				j=j+wl;
				c--;
				if(c==0)
				{
					ans.add(i);
					break;
				}
			}
			for(int k=0;k<b.size();k++)
			{
				mp.put(b.get(k),1);
			}
		}
		return ans;
	}
}
