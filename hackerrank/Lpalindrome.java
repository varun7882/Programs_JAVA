package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lpalindrome {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String t=br.readLine();
		int l;
		char x,y;
		l=t.length();
		if(l==1)
		{
			System.out.println(t);
		}
		else
		{
			Boolean a[][]=new Boolean[l][l];
			int maxlen=1;
			int start=0,f=0;
		for(int i=0;i<l;i++)
		{
			Arrays.fill(a[i],false);
		}
			for(int i=0;i<l-1;i++)
			{
				x=t.charAt(i);
				y=t.charAt(i+1);
				if(x==y)
				{
					a[i][i+1]=true;
					if(f==0)
					{
						start=i;
						maxlen=2;
						f=1;
					}
				}
			}
			for(int k=3;k<=l;k++)
			{
				for(int i=0;i<l-k+1;i++)
				{
					int e=i+k-1;
					if(t.charAt(i)==t.charAt(e)&& a[i+1][e-1])
					{
						a[i][e]=true;
						if(maxlen<k)
						{
							maxlen=k;
							start=i;
						}
					}
				}
			}
			//System.out.println(t);
			//System.out.println(l);
			//System.out.println(t.charAt(90));
		//	System.out.println(t.charAt(99));
			//System.out.println(start);
			//System.out.println(maxlen);
			for(int i=start;i<start+maxlen;i++)
			{
				System.out.print(t.charAt(i));
				//System.out.print(-1);
			}
		}
	}
}
