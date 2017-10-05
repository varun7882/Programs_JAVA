package varun;
import java.util.*;
public class cpath {
	public static void main(String args[])
	{
		int n,k,i,p,tw,c;
		int m,M;
		M=1000000007;
		TreeMap <Integer,Integer> t= new TreeMap <Integer,Integer>();
		Scanner in= new Scanner(System.in);
		n=in.nextInt();
		k=in.nextInt();
		int a[]= new int[n];
		int j[]= new int[n];
		for(i=0;i<n;i++)
		{
			a[i]=in.nextInt();
		}
		p=0;
		m=1;
		for(i=1;i<n;i++)
		{
			if(i-k>0)
			{
				j[i]=t.get(t.firstKey());
				System.out.println(i+" j "+j[i]);
				t.remove(a[i-k]);
			}
			t.put(a[i],i);
		}
		c=i=n-1;
		while(i>k)
		{
			tw=j[i];
			//System.out.println("dsl");
			m=(m%M)*(a[tw]%M)%M;
			System.out.println(+a[tw]);
			i=tw;
		}
		m=((m%M)*(a[0]%M)*(a[n-1]%M))%M;
		System.out.println(m);
	}

}
