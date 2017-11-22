package varun;
import java.util.*;
public class way3 {
	public static void main(String args[])
	{
		Scanner st= new Scanner(System.in);
		int t,d,i,j,x1,y1,x2,y2,x3,y3;
		double a,b,c;
		t=st.nextInt();
		for(i=0;i<t;i++)
		{
			    d=st.nextInt();
				x1=st.nextInt();
				y1=st.nextInt();
				x2=st.nextInt();
				y2=st.nextInt();
				x3=st.nextInt();
				y3=st.nextInt();
				a = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
				b = Math.sqrt((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
				c = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
				if((d>=a && d>=b) || (d>=a && d>=c) || (d>=c && d>=b) || (d>=c && d>=b && d>=a))
				{
					System.out.println("yes");
				}
				else
				{
					System.out.println("no");
				}
				
		}
	}

}
