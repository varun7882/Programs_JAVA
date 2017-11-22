package varun;
import java.util.*;
class chefandfruit {
	public static void main(String args[])
	{
		int t,n,m,k,i,d;
		Scanner in=new Scanner(System.in);
		t=in.nextInt();
		for(i=0;i<t;i++)
		{
			n=in.nextInt();
			m=in.nextInt();
			k=in.nextInt();
			if(n==m)
			{
				d=n-m;
			}
			else if(n>m)
			{
				d=n-m;
				
			}
			else
			{
				d=m-n;
			}
			if(k>=d)
			{
				d=0;
			}
			else
			{
				d=d-k;
			}
			System.out.println(d);
		}
	}

}
