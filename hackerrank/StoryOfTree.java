package hackerrank;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class StoryOfTree {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> gr= new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<=n;i++)
            {
            	gr.add(new ArrayList<Integer>());
            }
            for(int a1 = 0; a1 < n-1; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                gr.get(u).add(v);
                gr.get(v).add(u);
            }
            int g = in.nextInt();
            int k = in.nextInt();
            Set<Pair> s= new HashSet<Pair>();
            for(int a1 = 0; a1 < g; a1++){
                int u = in.nextInt();
                int v = in.nextInt();
                Pair p= new Pair(u, v);
                s.add(p);
            }
            int v=0;
            for(Pair x:s)
            {
            	System.out.println(x.x+" "+x.y);
            }
            for(int i=1;i<=n;i++)
            {
            	int c=0;
            	boolean vis[]= new boolean[n+1];
                Arrays.fill(vis,false);
            	Queue<Integer> qu= new ArrayDeque<Integer>();
            	qu.offer(i);
            	vis[i]=true;
            	boolean f=true;
            	while(!qu.isEmpty() && f)
            	{
            		int x=qu.poll();
            		for(int j=0;j<gr.get(x).size();j++)
            		{
            			int y=gr.get(x).get(j);
            			if(!vis[y])
            			{
            			Pair p = new Pair(x,y);
            			if(s.contains(p))
            			{
            				c++;
            				if(c>=k)
            				{
            					v++;
            					f=false;
            					break;
            				}
            			}
            			vis[y]=true;
            			qu.offer(y);
            			}
            		}
            	}
            }
            if(v==0)
            {
            	System.out.println(v);
            }
            else if(v==n)
            {
            	System.out.println(1);
            }
            else
            {
            	int hcf=GCD(v,n);
            	v=v/hcf;
            	n=n/hcf;
            	System.out.println(v+"/"+n);
            }
        }
    }
  static int GCD(int a, int b) {
    	   if (b==0) return a;
    	   return GCD(b,a%b);
    	}
}
class Pair{
int x,y;
	Pair(int u,int v)
	{
		x=u;
		y=v;
	}
	 @Override
	   public boolean equals(Object obj)
		{
	        if (obj == null) {
	        return false;
	    }
	       Pair P=(Pair)obj;
			if(P.x==this.x && P.y==this.y)
			{
				return true;
			}
			return false;
		}
	 @Override
	 public int hashCode()
	 {
		 return this.x*123+this.y;
	 }
}