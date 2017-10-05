package crackingthecodinginterview;
import java.util.*;
public class BFSconnected {
public static class Graph {
        
        ArrayList<ArrayList<Integer>> g;
        int n;
        public Graph(int size) {
            g= new ArrayList<ArrayList<Integer>>();
            n=size;
            for(int i=0;i<size;i++)
            {
            	g.add(new ArrayList<Integer>());
            }
        }

        public void addEdge(int first, int second) {
            g.get(first).add(second);
            g.get(second).add(first);
        }
        
        public int[] shortestReach(int s) { 
            int [] ans= new int[n];
            boolean[] vis= new boolean[n];
            Arrays.fill(ans,-1);
            Arrays.fill(vis,false);
            ans[s]=0;
            Queue<Integer> q= new ArrayDeque<Integer>();
            q.offer(s);
            vis[s]=true;
              while(!q.isEmpty())
            {
            	int x=q.poll();
            	
	            	for(int i=0;i<g.get(x).size();i++)
	            	{
	            		int y=g.get(x).get(i);
	            		if(!vis[y])
	            		{
	            			vis[y]=true;
	            		ans[y]=ans[x]+6;
	            		q.add(y);
	            		}
	            	}
            	
            }
            return ans;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int queries = scanner.nextInt();
        
        for (int t = 0; t < queries; t++) {
            
            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();
            
            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                
                // add each edge to the graph
                graph.addEdge(u, v);
            }
            
            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);
 
            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();            
        }
        
        scanner.close();
    }
}
