package varun;
import java.lang.reflect.Array;
import java.util.*;
class destroy
{
	public static void main(String args[])
	{
	int t,n,i,j,max=0,k;
    Scanner in= new Scanner(System.in);
	t=in.nextInt();
	for(i=0;i<t;i++)
	{
				n=in.nextInt();
				int a[]=new int[n];
				for(j=0;j<n;j++)
				{
					a[j]=in.nextInt();
				}
			Arrays.sort(a);
			max=(n%2==0)?n/2:(n+1)/2;
			k=1;
			for(j=1;j<n;j++)
			{
				if(a[j]==a[j-1])
				{
					k++;
				}
				else
				{
					if(max<k)
					{
						max=k;
					}
					k=1;
				}
			}
			if(max<k)
			{
				max=k;
			}
			System.out.println(max);
			
    }
 }
}

