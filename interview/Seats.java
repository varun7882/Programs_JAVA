package interview;
import java.util.*;
public class Seats {
	public int seats(String a) {
		final int m=10000003;
		int i,ans=0;
		ArrayList<Integer> tmp= new ArrayList<Integer>();
		for(i=0;i<a.length();i++)
		{
			if('x'==a.charAt(i))
			{
				tmp.add(i);
			}
		}
		
			int k=tmp.size()/2;
			int md=tmp.get(k);
			int t=md;
			i=t-1;
			while(i>=0)
			{
				if(a.charAt(i)=='x')
				{
					ans=(ans%m+(t-i-1)%m)%m;
					t--;
				}
				i--;
			}
			t=md;
			i=t+1;
			while(i<a.length())
			{
				if(a.charAt(i)=='x')
				{
					ans=(ans%m+(i-t-1)%m)%m;
					t++;
				}
				i++;
			}		
		
		return ans;
	}
}
