package crackingthecodinginterview;
import java.util.*;
public class DavisStaircase {
	static long dp[];
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int s = in.nextInt();
	        for(int a0 = 0; a0 < s; a0++){
	            int n = in.nextInt();
	            dp= new long[n+1];
	            Arrays.fill(dp,-1);
	            dp[0]=1;
	            System.out.println(getWays(n));
	        }
	    }
	 static long getWays(int n)
	 {
	
		 if(n<0)return 0;
		 if(n==0)return 1;
		 if(dp[n]!=-1)return dp[n];
		 dp[n]= getWays(n-1)+getWays(n-2)+getWays(n-3);
		 return dp[n];
	 }
}
