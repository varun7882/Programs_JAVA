package hackerearth;


import java.io.*;
import java.util.*;
 
 
public class Accorite_MonkandMonster {
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
    	//	StringBuilder Q=new StringBuilder(Qs);
    	//	StringBuilder P=new StringBuilder(Ps);
	    	int lp=P.length(),lq=Q.length();
	    	int dp[]=new int[lp+1];
	    	Arrays.fill(dp,0);
	    	boolean mat[]=new boolean[lp+1];
	    	Arrays.fill(mat, false);
	    	for(int i=0;i<=lp-lq;i++)
	    	{
	    		int e=i+lq;
	    		boolean f=true;
	    		int k=0;
	    		for(int j=i;j<e;j++,k++)
	    		{
	    			if(P.charAt(j)!=Q.charAt(k))
	    			{
	    				f=false;
	    				break;
	    			}
	    		}
	    		mat[i]=f;
	    	}
	    	for(int i=lq;i<=lp;i++)
	    	{
	    		for(int j=0;j<=i-lq;j++)
	    		{
	    			
	    			//System.out.println(P.substring(j, e)+" "+Q);
	    			if(mat[j])
	    			{
	    				//System.out.println("hey "+j);
	    				dp[i]=Math.max(dp[i], dp[j]+cost[j]);
	    			}
	    			
	    		}
	    		/*System.out.println("For length "+i);
	    		for(int k=0;k<dp.length;k++)
		    	{
		    		System.out.print(dp[k]+" ");
		    	}
	    		System.out.println();
	    		*/
	    	}
	    	/*System.out.println("Finally ");
	    	for(int i=0;i<dp.length;i++)
	    	{
	    		System.out.print(dp[i]+" ");
	    	}
	    	System.out.println();*/
	    return dp[lp];
	    }
}
