package hackerrank;
import java.util.*;
public class LCS {
	public static void main(String[] args) {
		  Scanner s=new Scanner(System.in);
	        int n,m,i,j;
	        n=s.nextInt();
	        m=s.nextInt();
	        int lcs[][]= new int [n+1][m+1];
	        int a[]=new int[n+1];
	        int b[]=new int[m+1];
	        char pt[][]=new char[n+1][m+1];
	        for(i=1;i<=n;i++)
	        {
	        	a[i]=s.nextInt();
	        }
	        for(i=1;i<=m;i++)
	        {
	        	b[i]=s.nextInt();
	        }
	       for(i=0;i<=n;i++)
	       {
	    	   lcs[i][0]=0;
	       }
	       for(i=0;i<=m;i++)
	       {
	    	   lcs[0][i]=0;
	       }
	       for(i=1;i<=n;i++)
	       {
	    	   for(j=1;j<=m;j++)
	    	   {
	    		   if(a[i]==b[j])
	    		   {
	    			   lcs[i][j]=lcs[i-1][j-1]+1;
	    			   pt[i][j]='d';
	    		   }
	    		   else
	    		   {
	    			   if(lcs[i-1][j]>=lcs[i][j-1])
	    			   {
	    				   lcs[i][j]=lcs[i-1][j];
	    				   pt[i][j]='u';
	    			   }
	    			   else
	    			   {
	    				   lcs[i][j]=lcs[i][j-1];
	    				   pt[i][j]='b';
	    			   }
	    		   }
	    	   }
	       }
	  
	       LCS ls=new LCS();
	       ls.printsq(pt, a, n, m);
	       
	}
	void printsq(char pt[][],int a[],int i,int j)
	{
		if(i==0 || j==0)
		{
			return ;
		}
		else
		{
			if(pt[i][j]=='d')
			{
				printsq(pt,a,i-1,j-1);
				System.out.print(a[i]+" ");
			}
			else if(pt[i][j]=='u')
			{
				printsq(pt,a,i-1,j);
			}
			else
			{
				printsq(pt,a,i,j-1);
			}
		}
	}
}
