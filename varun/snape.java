package varun;
import java.util.*;
import java.lang.*;
public class snape {
	public static void main(String[] args)
    {
	int t,ls,b,i;
	double rsmn=0;
	double rsmx=0;        
    Scanner in = new Scanner(System.in);
        t=in.nextInt();
         for(i=0;i<t;i++)
         {
        	b=in.nextInt();
        	ls=in.nextInt();
        	rsmx= Math.sqrt((Math.pow(b, 2)+Math.pow(ls,2)));
        	rsmn=Math.sqrt((Math.pow(ls, 2)-Math.pow(b,2)));
        	 System.out.println(rsmn+" "+rsmx);
         }
        
    }

}
