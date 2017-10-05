package interview;
import java.util.*;
public class Nqueen {
	int n;
	ArrayList<ArrayList<String>> ans= new ArrayList<ArrayList<String>>();

	boolean [][]c;
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		n=a;
		if(n==1)
		{
			ArrayList<String> tans= new ArrayList<String>();
			tans.add("Q");
		    ans.add(tans);
		    return ans;
		}
		if(n==2)
		{
		     ans.add(new ArrayList<String>());
		    return ans;
		}
		c=new boolean[n][n];
		for(int i=0;i<n;i++)
		{
			Arrays.fill(c[i],false);
		}
		nqueen(0);
		return ans;
	}
	void nqueen(int r)
	{
		if(r==n)
		{
			ArrayList<String> tans=new ArrayList<String>();
			for(int i=0;i<n;i++)
			{
				StringBuilder tmp=new StringBuilder("");
				for(int j=0;j<n;j++)
				{
					if(c[i][j])
					{
						tmp.append("Q");
					}
					else
					{
						tmp.append(".");
					}
				}
				tans.add(tmp.toString());
			}
			ans.add(tans);
		}
		else
		{
			for(int j=0;j<n;j++)
			{
				if(issafe(r,j))
				{
					
					c[r][j]=true;
					nqueen(r+1);
					c[r][j]=false;
				}
			}
		}
	}
	boolean issafe(int i,int j)
	{
		for(int r=i-1;r>=0;r--)
		{
			if(c[r][j])
			{
				return false;
			}
		}
		for(int row=i-1,col=j-1;row>=0 && col>=0;row--,col--)
		{
			if(c[row][col])
			{
				return false;
			}
		}
		for(int row=i-1,col=j+1;row>=0 && col<n;row--,col++)
		{
			if(c[row][col])
			{
				return false;
			}
		}
		return true;
	}
}
