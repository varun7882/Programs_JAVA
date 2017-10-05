package interview;

import java.util.Arrays;

public class WaysofDecoding {
	int dp[],n;
	String s;
	public int numDecodings(String a) {
	     n=a.length();
	    dp=new int[n];
	    Arrays.fill(dp, -1);
	    if(a.charAt(n-1)=='0')
	    {
	    	dp[n-1]=0;
	    }
	    else
	    {
	    	dp[n-1]=1;
	    }
	   // Arrays.fill(dp, -1);
	    s=a;
	   int ans=getWays(0);
	    return ans;
	}
	int getWays(int i)
	{
		if(i>=s.length())return 1;
		if(dp[i]!=-1)
		{
			return dp[i];
		}
		int x=0,y=0;
		if(isOk(s.charAt(i)))
		{
			 x=getWays(i+1);
		}
		else
		{
			return 0;
		}
		if(i+1<n && isOk(s.charAt(i),s.charAt(i+1)))
		{
			y=getWays(i+2);
		}
		dp[i]=x+y;
		return dp[i];
	}
	boolean isOk(char a,char b)
	{
		int x=Integer.parseInt(Character.toString(a));
		int y=Integer.parseInt(Character.toString(b));
		if(x>2)return false;
		if(x==2 && y>6)return false;
		return true;
	}
	boolean isOk(char a)
	{
		int x=Integer.parseInt(Character.toString(a));
		if(x==0)return false;
		return true;
	}
}
