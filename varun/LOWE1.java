package varun;
import java.io.*;
import java.util.*;

 class LOWE1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int N = Integer.parseInt(br.readLine().trim());
         int M;
         String[] temp=br.readLine().split(" ");
         M=Integer.parseInt(temp[0]);
         //col=Integer.parseInt(temp[1]);
         ArrayList<ArrayList<Integer>> graph=new ArrayList<ArrayList<Integer>>();
         ArrayList<Pair> list=new ArrayList<Pair>();
        for(int i=0;i<=N;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
         for(int i=0;i<M;i++)
        {
            int u,v;
            temp=br.readLine().split(" ");
            u=Integer.parseInt(temp[0]);
            v=Integer.parseInt(temp[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
            list.add(new Pair(u,v));
        }
       for(int i=0;i<list.size();i++)
       {
        Pair p=list.get(i);
        System.out.println(BFS(graph,p.x,p.y)*BFS(graph,p.y,p.x));
       }
         wr.close();
         br.close();
    }
   static int BFS(ArrayList<ArrayList<Integer>> graph,int s,int c)
    {
        Queue<Integer> q=new ArrayDeque<Integer>();
        boolean vis[]=new boolean[graph.size()];
        Arrays.fill(vis, false);
        int res=0;
        vis[s]=true;
        q.offer(s);
        res++;
   
   
        while(!q.isEmpty())
        {
            int x=q.poll();
            for(int i=0;i<graph.get(x).size();i++)
            {
            	int y=graph.get(x).get(i);
                if(!vis[y] && y!=c)
                {
                	vis[y]=true;
                    q.offer(graph.get(x).get(i));
                    res++;
                }
            }
        }
        return res;
    }
}
class Pair
{
    public Pair(int u,int v)
    {
       x=u;
       y=v;
    }
    int x,y;
}