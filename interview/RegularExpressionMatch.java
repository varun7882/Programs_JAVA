package interview;
public class RegularExpressionMatch {
	public int isMatch(final String s, final String p) {
		int m=s.length(),n=p.length();
		boolean dp[][]= new boolean[n+1][m+1];
		dp[0][0]=true;
		for(int i=1;i<=m;i++)
		{
			dp[0][i]=false;
		}
		for(int i=1;i<=n;i++)
		{
			if(dp[i-1][0])
			{
				if(p.charAt(i-1)=='*')
				{
					dp[i][0]=true;
				}
				else
				{
					dp[i][0]=false;
				}
			}
			else
			{
				dp[i][0]=false;
			}
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				
					if(p.charAt(i-1)=='*')
					{
						if(dp[i-1][j] || dp[i][j-1])
						{
							dp[i][j]=true;
						}
						else
						{
							dp[i][j]=false;
						}
					}
					else if(p.charAt(i-1)=='?')
					{
						
						if(dp[i-1][j-1])
						{
							dp[i][j]=true;
						}
						else
						{
							dp[i][j]=false;
						}
					}
					else
					{
						if(dp[i-1][j-1] && p.charAt(i-1)==s.charAt(j-1))
						{
							dp[i][j]=true;
						}
						else
						{
							dp[i][j]=false;
						}
					}
			}
		}
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		if(dp[n][m])return 1;
		return 0;
	}
}
