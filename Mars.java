package varun;
import java.util.*;
public class Mars {
public static void main(String[] args)
	    {
		int n,m,t,max,i,c,f=0;        
	Scanner in = new Scanner(System.in);
	        n=in.nextInt();
	        m=in.nextInt();
	        int a[]= new int[n];
	        for(i=0;i<n;i++)
	        {
	        	a[i]=999999;
	        }
	        for(i=0;i<m;i++)
	        {
	        	c=in.nextInt();
	        	a[c]=0;
	        }
	        t=0;
	        max=-9999;
	         for(i=0;i<n;i++)
	        {
	        	if(a[i]==0)
	        	{
	        		f=1;
	        		t=0;
	        	}
	        	if(f==1 && a[i]!=0)
	        	{
	        		t++;
	        		a[i]=t;
	        	}
	        }
	         f=0;
	        t=0;
	         for(i=n-1;i>=0;i--)
		        {
		        	if(a[i]==0)
		        	{
		        		f=1;
		        		t=0;
		        	}
		        	if(f==1 && a[i]!=0)
		        	{
		        		t++;
		        		if(a[i]>t)
		        		{
		        			a[i]=t;
		        		}
		        	}
		        }
	         for(i=0;i<n;i++)
		     {
		    	System.out.print(" "+a[i]);
		     }
	         System.out.println();
		     for(i=0;i<n;i++)
		     {
		    	 if(a[i]>max)
		    	 {
		    		 max=a[i];
		    	 }
		     }

	       System.out.println(max);
	    }
	}



