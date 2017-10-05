package crackingthecodinginterview;
import java.util.*;
public class ConnectedCells {
	  static int ans=0,c=-1,N,M;
		static boolean vis[][];
	    static int grid[][];
		 public static void main(String[] args) {
		        Scanner in = new Scanner(System.in);
		        int n = in.nextInt();
		        int m = in.nextInt();
		        N=n;
		        M=m;
		        grid = new int[n][m];
		        vis=new boolean[n][m];
		        for(int grid_i=0; grid_i < n; grid_i++){
		            for(int grid_j=0; grid_j < m; grid_j++){
		                grid[grid_i][grid_j] = in.nextInt();
		                vis[grid_i][grid_j]=false;
		            }
		        }
		        for(int i=0;i<n;i++)
		        {
		        	for(int j=0;j<m;j++)
		        	{
	                    for(int k=0;k<n;k++)
	                        {
	                        Arrays.fill(vis[k],false);
	                    }
		        		if(!vis[i][j] && grid[i][j]==1)
		        		{
		        			dfsv(i,j);
		        		}
		        	}
		        }
		        System.out.println(ans);
		    }
		static void dfsv(int i,int j)
		 {
			 vis[i][j]=true;
			 c++;
			 ans=Math.max(ans,c);
			 int x,y;
			 x=i-1;
			 y=j-1;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				// c--;
			 }
			 x=i-1;
			 y=j;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				 //c--;
			 }
			 x=i-1;
			 y=j+1;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				 //c--;
			 }
			 x=i;
			 y=j+1;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				// c--;
			 }
			 x=i+1;
			 y=j+1;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				// c--;
			 }
			 x=i+1;
			 y=j;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				// c--;
			 }
			 x=i+1;
			 y=j-1;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				// c--;
			 }
			 x=i;
			 y=j-1;
			 if(x>=0 && y>=0 && x<N && y<M && !vis[x][y] && grid[i][j]==1)
			 {
				 dfsv(x,y);
				// c--;
			 }
	        c--;
		 }
}
