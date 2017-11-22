package varun;
import java.util.*;
public class remiss
{
	public static void main(String args[])
	{
		int t,n,m,i;
		Scanner st= new Scanner(System.in);
		t= st.nextInt();
		for(i=0;i<t;i++)
		{
			n=st.nextInt();
			m=st.nextInt();
			if(n>m)
			{
				System.out.print(n);
			}
			else
			{
				System.out.print(m);	
			}
			System.out.println(" "+(n+m));
		}
	}
}
