package varun;
import java.util.*;
public class recipe {
	public static void main(String args[])
	{
		int t,n,i,j,f,k,ans,min;
		Scanner in= new Scanner(System.in);
		t=in.nextInt();
		for(i=0;i<t;i++)
		{
			ans=1;
			min=9999;
			n=in.nextInt();
			int a[]= new int[n];
			for(j=0;j<n;j++)
			{
				a[j]=in.nextInt();
				if(min>a[j])
				{
					min=a[j];
				}
			}
			//System.out.println(min);
			for(j=min;j>=2;j--)
			{
				f=1;
				for(k=0;k<n;k++)
				{
					if(a[k]%j!=0)
					{
						f=0;
						break;
					}
				}
				if(f==1)
				{
					ans=j;
					break;
				}
			}
			for(j=0;j<n;j++)
			{
			System.out.print(a[j]/ans+" ");
			}
		}
			
		
	}

}
