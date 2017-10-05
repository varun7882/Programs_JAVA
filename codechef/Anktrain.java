package codechef;
import java.util.Scanner;
public class Anktrain {
	public static void main(String args[])
	{
		 int n,x,q;
	       Scanner in= new Scanner(System.in);
	       n=in.nextInt();
	        while(n>0)
	        {
	            x=in.nextInt();
	            StringBuilder ans=new StringBuilder("");
	            q=x%8;
	            switch(q)
	            {
	            case 0:
	               ans.append(Integer.toString(x-1,10));
	               ans.append("SL");
	               break;
	            case 1:
	            	ans.append(Integer.toString(x+3,10));
		               ans.append("LB");
	                break;
	            case 2:
	            	ans.append(Integer.toString(x+3,10));
		               ans.append("MB");
	                break;
	            case 3:
	            	ans.append(Integer.toString(x+3,10));
		               ans.append("UB");
	                break;
	            case 4:
	            	ans.append(Integer.toString(x-3,10));
		               ans.append("LB");
	                break;
	            case 5:
	            	ans.append(Integer.toString(x-3,10));
		               ans.append("MB");
	                break;
	            case 6:
	            	ans.append(Integer.toString(x-3,10));
		               ans.append("UB");
	                break;
	            case 7:
	            	ans.append(Integer.toString(x+1,10));
		              ans.append("SU");
	               break;
	            }
	            n--;
	            System.out.println(ans);
	        }
	}

}
