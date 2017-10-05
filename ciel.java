package varun;
import java.util.*;
public class ciel {
	public static void main(String args[])
	{
		int t,n,i,one,zero,s;

		Scanner in = new Scanner(System.in);
		t= in.nextInt();
		for(i=0;i<t;i++)
		{
			s=one=0;
			zero=0;
			n=in.nextInt();
			while(n>2048)
			{
				n=n-2048;
				s++;
			}	
				while(n>0)
				{
					if(n%2==0)
					{
						zero++;
					}
					else
					{
						one++;
					}
				
				n=n/2;
				}
				s=s+one;
			System.out.println(s);	
		}
		
	}

}
