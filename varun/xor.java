package varun;
import java.util.Scanner;
public class xor {
	public static void main(String args[])
	 {
		 long l,r,i,s,j,t,pt;
		 Scanner st =new Scanner(System.in);
		 t=st.nextLong();
		 for(j=0;j<t;j++)
		{
		 	 l=st.nextLong();
			 r=st.nextLong();
			 s=0;
			 pt=t=0;
			for(i=1;i<=l;i++)
			{
				t=pt^i;
				pt=t;
			}
			s=t;
			for(i=l+1;i<=r;i++)
			{
		//	
			}
			System.out.println(s);
	    }
	}
}
