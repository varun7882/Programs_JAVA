package codechef;
import java.util.*;
public class KIRLAB {
	public static void main(String args[]) {
	Scanner in =new Scanner(System.in);
	int t,n,i,ans,x; 
	t=in.nextInt();
	KIRLAB kb=new KIRLAB();
		while(t>0)
		{
			ans=0;
			n=in.nextInt();
			int u=-1;
			int[] a=new int[n];
			for(i=0;i<n;i++)
			{
				a[i]=in.nextInt();
			}
			try{
			for(i=0;i<n;i++)
			{
				if(u==-1)
				{
					if(a[i+1]>a[i])
					{
						x=kb.gcd(a[i+1],a[i]);
					}
					else
					{
						x=kb.gcd(a[i],a[i+1]);
					}
					if(x>1)
					{
						ans=ans+1;
						//System.out.println("added "+a[i]+" "+i);
						u=a[i];
					}
				}
				else
				{
					if(a[i]>u)
					{
						x=kb.gcd(a[i],u);
					}
					else
					{
						x=kb.gcd(u,a[i]);
					}
					if(x>1)
					{
						ans=ans+1;
						//System.out.println("added "+a[i]);
						u=a[i];
					}
				}
			}
			}
			catch(Exception e)
			{
				ans=0;
			}
			System.out.println(ans);
			t--;
		}
	}
	int gcd(int a,int b)
	{
		if(a%b==0)
		{
			return b;
		}
		else
		{
			return gcd(b,a%b);
		}
	}
}
