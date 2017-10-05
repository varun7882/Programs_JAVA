package interview;
import java.util.*;
public class LargestContizero {
	 ArrayList<Integer> ans= new ArrayList<Integer>();
		public ArrayList<Integer> lszero(ArrayList<Integer> a) {
			int is=-1,e=-1,mxl=-1;
			int n=a.size();
			int sm[]= new int[n];
			int s=0;
			for(int i=0;i<a.size();i++)
			{
				s=s+a.get(i);
				sm[i]=s;
			}
			ArrayList<Integer> hs= new ArrayList<Integer>();
			for(int i=0;i<n;i++)
			{
				if(sm[i]==0)
				{
					if(mxl<i+1)
					{
						mxl=i+1;
						is=-1;
						e=i;
					}
				}
				if(!hs.contains(sm[i]))
				{
					hs.add(sm[i]);
				}
				else
				{
					int tis,te;
					tis=hs.lastIndexOf(sm[i]);
					te=i;
					System.out.println(tis+" "+te+" "+a.get(te));
					if(te-tis+1>mxl)
					{
						mxl=te-tis+1;
						is=tis;
						e=te;
					}
					hs.add(sm[i]);
				}
			}
			if(e!=-1)
			{
				for(int i=is+1;i<=e;i++)
				{
					ans.add(a.get(i));
				}
			}
			return ans;
	    }
}
