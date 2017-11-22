package varun;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

 class Lowe2 {
     static int dp[]= new int[1000000];
     static int lim=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
       // int T = Integer.parseInt(br.readLine());
        	dp[0]=0;
           String temp[]=br.readLine().split(" ");
           for(int i=0;i<temp.length;i++)
           {
        	   System.out.println(solve(Integer.parseInt(temp[i])));
           }
         

         wr.close();
         br.close();
    }
    static int solve(int n){
    	
    	if(lim<n)
    	{
    	    int res=dp[lim];
            for(int i=lim+1;i<=n;i++)
            {
            	if(checkPalin(Integer.toString(i)) && checkPalin(Integer.toBinaryString(i)))
            	{
            		res++;
            	}
            	dp[i]=res;
            }
    	}
    	    
    return dp[n];
    }
    static boolean checkPalin(String s)
    {
    	int i=0,j=s.length()-1;
    	while(i<=j)
    	{
    		if(s.charAt(i)!=s.charAt(j))
    		{
    			return false;
    		}
    		i++;
    		j--;
    	}
    	return true;
    }
}