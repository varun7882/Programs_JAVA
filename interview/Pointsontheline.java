package interview;
import java.util.*;
public class Pointsontheline {
	int s=2;
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		for(int i=0;i<a.size();i++)
		{
			 HashMap<Double,Integer> map=new HashMap<Double,Integer>();
			for(int j=i+1;j<a.size();j++)
			{
				if(!isequal(a.get(i),b.get(i),a.get(j),b.get(j)))
				{
					double m=getgrad(a.get(i),b.get(i),a.get(j),b.get(j));
					if(map.containsKey(m))
					{
						int x=map.get(m)+1;
						if(x>s)
						{
							s=x;
						}
						map.put(m,x);
					}
					else
					{
						map.put(m,2);
					}
				}
			}
		}
		return s;
	}
	boolean isequal(int x1,int y1,int x2,int y2)
	{
		if(x1!=x2)
		{
			return false;
		}
		else
		{
			if(y1!=y2)
			{
				return false;
			}
		}
		return true;
	}
	double getgrad(int x1,int y1,int x2,int y2)
	{
		int yy=y2-y1;
		int xx=x2-x1;
		double m=0;
		if(xx==0)
		{
			
			m=Double.MAX_VALUE;
		}
		else if(yy==0)
		{
		
			m=0;
		}	
		else
		{
			m=(double)yy/(double)xx;
		}
		return m;
	}
}
