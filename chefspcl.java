package varun;
import java.util.*;
public class chefspcl {
	public static void main(String args[])
	{
		int d,l,i;
		String s,sc,s1,s2;
		Scanner st= new Scanner(System.in);
		fn f= new fn();
		d=st.nextInt();
		while(d-->0)
		{
			s=st.nextLine()	;
			sc=s;
			l=s.length();
			if(l!=1)
			{
				if(l%2==0)
				{
					if(f.check(s))
					{
						System.out.println("YES");
					}
				}
				else
				{
					for(i=0;i<l;i++)
					{
						sc=s;
						s1=sc.substring(0,i);
						s2=sc.substring(i+1);
						s1.concat(s2);
						if(f.check(s))
						{
							System.out.println("YES");
							break;
						}
					}
				}
			}
			else
			{
				System.out.println("NO");
			}
		}
	}

}
class fn 
{
	boolean check(String s)
	{
		int m=(s.length())/2;
		String s1,s2;
		s1=s.substring(0,m);
		s2=s.substring(m+1);
		if(s1.equals(s2))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}