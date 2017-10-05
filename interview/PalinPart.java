package interview;
import java.util.*;
public class PalinPart {
	ArrayList<ArrayList<String>> ans= new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> partition(String a) {
		if(a.length()==0 || a.length()==1)
		{
			ArrayList<String> tmp= new ArrayList<String>();
			tmp.add(a);
			ans.add(tmp);
			return ans;
		}
		int i,j;
		for(i=1;i<=a.length();i++)
		{
			boolean f= true;
			ArrayList<String> tmp= new ArrayList<String>();
			for(j=0;j+i<a.length();j=j+i)
			{
				if(isPalin(a,j,j+i-1))
				{
					tmp.add(a.substring(j,j+i));
				}
				else
				{
					f=false;
				}
			}
			if(j<a.length())
			{
				if(isPalin(a,j,a.length()-1))
				{
					tmp.add(a.substring(j,j+i));
				}
				else
				{
					f=false;
				}
			}
			if(f)
			{
				ans.add(tmp);
			}
		}
		Collections.sort(ans,new Comparator<ArrayList<String>>()
				{
				 public int compare(ArrayList<String> o1,ArrayList<String> o2)
				{
					int n,m,cmp;
					n=o1.size();
					m=o2.size();
					for(int i=0;i<Math.min(n,m);i++)
					{
						cmp=o1.get(i).length()-o2.get(i).length();
						if(cmp!=0)
						{
							return cmp;
						}
					}
					return n-m;
				}
				});
		return ans;
	}
	boolean isPalin(String a, int f,int e)
	{
		int i,j;
		i=f;j=e;
		while(i<=j)
		{
			if(a.charAt(i)!=a.charAt(j))
			{
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
