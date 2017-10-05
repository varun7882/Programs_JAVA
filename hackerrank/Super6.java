package hackerrank;
import java.util.*;
public class Super6 {
	  public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        int n=s.length();
	        int c=0,sm=0;
	        for(int i=0;i<n;i++)
	        {
	        	char x=s.charAt(i);
	        	sm=sm+Integer.valueOf(Character.toString(x));
	        }
	        int i=0,j=n-1;
	        while(i<j)
	        {
	        	char b=s.charAt(i);
	        	char e=s.charAt(j);
	        	if(b=='0')
	        	{
	        		i++;
	        	}
	        	else if(Integer.valueOf(Character.toString(e))%2!=0)
	        	{
	        		j--;
	        		sm=sm-Integer.valueOf(Character.toString(e));
	        	}
	        	else
	        	{
	        		if(sm%3==0)
	        		{
	        			c++;
	        		}
	        		if(Integer.valueOf(Character.toString(e))%3==0)
	        		{
	        		j--;
	        		sm=sm-Integer.valueOf(Character.toString(e));
	        		}
	        		else if(Integer.valueOf(Character.toString(b))%3==0)
	        		{
	        		i++;
	        		sm=sm-Integer.valueOf(Character.toString(b));
	        		}
	        		else
	        		{
	        			sm=sm-Integer.valueOf(Character.toString(e));
	        			sm=sm-Integer.valueOf(Character.toString(b));
	        			i++;
	        			j--;
	        		}
	        	}
	        }
	        System.out.println(c+n);
	     
	    }
}
