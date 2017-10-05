package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PayU1 {
	public static void main(String args[] ) throws Exception {
	       //BufferedReader
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       int t=Integer.parseInt(br.readLine());
	       while(t-->0)
	       {
	         int n=Integer.parseInt(br.readLine());
	         String [] balls=br.readLine().split(" ");
	         boolean f=false;
	         HashMap<String,Integer> mp=new HashMap<String,Integer>();
	         for(int i=0;i<n;i++)
	         {
	        	 if(mp.containsKey(balls[i]))
	        	 {
	        		 mp.put(balls[i], mp.get(balls[i])+1);
	        	 }
	        	 else
	        	 {
	        		mp.put(balls[i],1); 
	        	 }
	         }
	  
	         while(n>0)
	         {
	        	 if(mp.containsKey(String.valueOf(n)))
	        	 {
	        		 int x=mp.get(String.valueOf(n));
	        		 mp.remove(String.valueOf(n));
	        		 n=n-x;
	        	 }
	        	 else
	        	 {
	        		 f=true;
	        		 break;
	        	 }
	         }
	         if(f)
	         {
	        	 System.out.println("NO");
	         }
	         else
	         {
	        	 System.out.println("YES");
	         }
	       }
	    }
}
