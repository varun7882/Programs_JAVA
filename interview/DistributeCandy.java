package interview;
import java.util.*;
public class DistributeCandy {
	public int candy(ArrayList<Integer> rts) {
		int g=0,n=rts.size(),p=Integer.MIN_VALUE,ans=0;
		int tmp[]= new int[n];
		for(int i=0;i<n;i++)
		{
			if(rts.get(i)>p)
			{
				g++;
			}
			else
			{
				g=1;
			}
			tmp[i]=g;
			p=rts.get(i);
		}
		g=0;
		p=Integer.MIN_VALUE;
		for(int i=n-1;i>=0;i--)
		{
			if(rts.get(i)>p)
			{
				g++;
			}
			else
			{
				g=1;
			}
			tmp[i]=Math.max(tmp[i], g);
			p=rts.get(i);
		}
		for(int i=0;i<n;i++)
		{
			ans=ans+tmp[i];
		}
	return ans;
	}
}
