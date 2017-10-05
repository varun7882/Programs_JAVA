package interview;
import java.util.*;
public class LargerTreeDistance{
	ArrayList<ArrayList<Integer> >g =new ArrayList<ArrayList<Integer>>(); 
	boolean vis[];
	int ans=0,c=0,u;
    public int solve(ArrayList<Integer> A) 
    {
    	int i,n=A.size();
    	if(n==0 || n==1)return 0;
    	if(n==2)return 1;
    	vis= new boolean[n];
    	for(i=0;i<n;i++)
    	{
    		g.add(new ArrayList<Integer>());
    	}
    	for(i=0;i<A.size();i++)
    	{
    		int x=A.get(i);
    		if(x!=-1)
    		{
    			g.get(i).add(x);
    			g.get(x).add(i);
    		}
    	}
    	dfsv(0);
    	c=0;
    	Arrays.fill(vis,false);
    	dfsv(u);
		return ans;
	}
    void dfsv(int x)
    {
    	c++;
    	u=x;
    	vis[x]=true;
    	ans=Math.max(c,ans);
    	for(int i=0;i<g.get(x).size();i++)
    	{
    		int y=g.get(x).get(i);
    		if(!vis[y])
    		{
    			dfsv(y);
    			c--;
    		}
    	}
    }
}
