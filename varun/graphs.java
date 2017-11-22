package varun;
import java.lang.reflect.Array;
import java.util.*;
public class graphs {
	public static void main(String args[])
	{
		int v,e,i;
		Scanner st= new Scanner(System.in);
		//System.out.println("enter the number of vertices");
		//v=st.nextInt();
		graph g1= new graph(4);
		    g1.addEdge(0,1);
	        g1.addEdge(0,2);
	        g1.addEdge(1,2);
	        g1.addEdge(2,0);
	        g1.addEdge(2,3);
	        g1.addEdge(3,3);
	 
		g1.print(g1);
		System.out.println("BFS run is");
		g1.Bfs(2);
		g1.dfs(2);
	}
}
 class graph
{
	private int v,i;
	private LinkedList<Integer> a[];
	
	
	graph(int V)
	{
		v=V;
		a= new LinkedList[v] ;
		for(i=0;i<v;i++)
		{
		a[i]= new LinkedList<Integer>();
		}
		
	}
	void addEdge(int s,int d)
	{
		a[s].add(d);
	}
	void print(graph g)
	{
		System.out.println("The vertices of graphs are :");
		for(i=0;i<g.v;i++)
		{
			System.out.println(i+" =>"+g.a[i]);
		}
	}
	void Bfs(int s)
	{
		int x,n;
		boolean visit[]= new boolean[v];
		//Arrays.fill(visit, false);
		LinkedList<Integer> q=new LinkedList<Integer>();
		visit[s]=true;
		q.add(s);
		while(q.size()!=0)
		{
			x=q.poll();
			System.out.print(" "+x);
			Iterator<Integer> it= a[x].iterator();
			while(it.hasNext())
			{
				n=it.next();
				//System.out.println("checking "+n);
				if(!visit[n])
				{
				visit[n]=true;
				//System.out.println(n+"visited ");
				q.add(n);
				}
			}
			
			
		}
	}
	
	void dfsvisit(int v,boolean visitd[])
	{
		
		visitd[v]=true;
		System.out.print(" "+v);
		Iterator<Integer> it= a[v].iterator();	
		while(it.hasNext())
		{
			int n=it.next();
			if(!visitd[n])
			{
				dfsvisit(n,visitd);
			}
		}
	}
	void dfs(int s)
	{
		
		//Arrays.fill(visit, false);
		boolean visitd[]= new boolean[v];
		System.out.println();
		System.out.println("DFS run is ");
		dfsvisit(s,visitd);
	}
	
}
 