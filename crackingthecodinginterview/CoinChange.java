package crackingthecodinginterview;
import java.util.*;
public class CoinChange {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int m = in.nextInt();
	        int c[] = new int[m];
	        int i,j;
	        for(i=0;i<m;i++)
	        {
	        	c[i]=in.nextInt();
	        }
	        Arrays.sort(c);
	        long dp[]= new long[n+1];
	        dp[0]=1;
	        for(i=0;i<m;i++)
	        {
	        	for(j=0;j<=n;j++)
	        	{
	        		if(j>=c[i])
	        		{
	        			dp[j]=dp[j]+dp[j-c[i]];
	        		}
	        		
	        	}
	        }
	        System.out.print(dp[n]);
	 }
}
