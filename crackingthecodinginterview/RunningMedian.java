package crackingthecodinginterview;
import java.text.DecimalFormat;
import java.util.*;
public class RunningMedian {
	static DecimalFormat d= new DecimalFormat("##.0");
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	       int c=0,x,y,t;
	       Double ans;
	      
	       PriorityQueue<Integer> lower= new PriorityQueue<Integer>(10,Collections.reverseOrder());
	       PriorityQueue<Integer> upper= new PriorityQueue<Integer>();
	       for(int i=0;i<n;i++)
	       {
	    	   c++;
	    	   if(c==1)
	    	   {
	    		   lower.add(a[i]);
	    		   ans=getval(a[i]);
	    		   System.out.println(ans);
	    		   continue;
	    	   }
	    	   if(c==2)
	    	   {
	    		   x=lower.poll();
	    		   y=a[i];
	    		   upper.add(Math.max(x,y));
	    		   lower.add(Math.min(x,y));
	    		   ans=getval(x,y);
	    		   System.out.println(ans);	
	    		   continue;
	    	   }
	    	   x=lower.peek();
	    	   y=upper.peek();
	    	  if(lower.size()==upper.size())
	    	  {
	    		  if(a[i]<=x)
	    		  {
	    			 t=lower.poll();
	    			 lower.add(a[i]);
	    			 upper.add(t);
	    		  }
	    		  else
	    		  {
	    			upper.add(a[i]);  
	    		  }
	    		  ans=getval(upper.peek());
	    	  }
	    	  else
	    	  {
	    		if(a[i]>=y)
	    		{
	    			upper.add(a[i]);
	    			t=upper.poll();
	    			lower.add(t);

	    		}
	    		else
	    		{
	    			lower.add(a[i]);
	    		}
	    		ans=getval(lower.peek(),upper.peek());
	    	  }
	    	  System.out.println(ans);
	       }
	    	   
	 }
	static Double getval(double x,double y)
	 {
		 return new Double(d.format((x+y)/2.0));
	 }
	 static Double getval(double x)
	 {
		 return new Double(d.format(x));
	 }
}
