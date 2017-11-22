package hackerearth;
import java.io.*;
import java.util.*;
public class Accotile_Monk_And_Monster {
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	        int T = Integer.parseInt(br.readLine().trim());
	        for(int t_i=0; t_i<T; t_i++)
	        {
	            String P = br.readLine();
	            String Q = br.readLine();
	            int cost_size = Integer.parseInt(br.readLine().trim());
	            String[] arr_cost = br.readLine().split(" ");
	            int[] cost = new int[cost_size];
	            for(int i_cost=0; i_cost<arr_cost.length; i_cost++)
	            {
	            	cost[i_cost] = Integer.parseInt(arr_cost[i_cost]);
	            }

	            int out_ = amount_to_pay(Q, P, cost);
	            System.out.println(out_);
	         }

	         wr.close();
	         br.close();
	    }
	    static int amount_to_pay(String Q, String P, int[] cost)
	    {
	    	int lp=P.length(),lq=Q.length();
	    	int dp[][]=new int[lp+1][lp+1];
	    	for(int i=0;i<=lp;i++)
	    		Arrays.fill(dp[i],0);
	    
	    	for(int i=lq;i<=lp;i++)
	    	{
	    		for(int j=0;j<=i-lq;j++)
	    		{
	    			int e=j+lq;
	    			//System.out.println(P.substring(j, e)+" "+Q);
	    			if(P.substring(j, e).equals(Q))
	    			{
	    			//	System.out.println("hey "+j);
	    				dp[0][i]=Math.max(dp[0][i], dp[0][j]+cost[j]);
	    			}
	    			
	    			
	    		}
	    		System.out.println("For length "+i);
	    		for(int k1=0;k1<dp.length;k1++)
		    	{
	    			for(int k2=0;k2<dp.length;k2++)
	    			{
		    		System.out.print(dp[k1][k2]+" ");
	    			}
	    			System.out.println();
		    	}
	    		System.out.println();
	    		
	    	}
	    	/*System.out.println("Finally ");
	    	for(int i=0;i<dp.length;i++)
	    	{
	    		System.out.print(dp[i]+" ");
	    	}
	    	System.out.println();*/
	    return dp[0][lp];
	    }
}
