package hackerrank;
import java.util.*;
public class Lis {
	public static void main(String[] args) {
		  Scanner s=new Scanner(System.in);
	        int n,i,len=1;
	        n=s.nextInt();
	        int a[]=new int[n];
	        int p[]=new int[n];
	        int t[]=new int[n];
	        Arrays.fill(p,-1);
	        Arrays.fill(t,0);
	        for(i=0;i<n;i++)
	        {
	        	a[i]=s.nextInt();
	        }
	        for(i=1;i<n;i++)
	        {
	        	if(a[i]<a[t[0]])
	        	{
	        		t[0]=i;
	        	}
	        	else if(a[i]>a[t[len-1]])
	        	{
	        		p[i]=t[len-1];
	        		t[len]=i;
	        		len++;
	        	}
	        	else
	        	{
	        		int pos=0;
	        		t[pos]=i;
	        		p[i]=t[pos-1];
	        	}
	        }
	}

}
