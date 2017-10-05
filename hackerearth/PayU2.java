package hackerearth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class PayU2 {
   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter wr = new PrintWriter(System.out);
	         int n = Integer.parseInt(br.readLine());
	         String[] arr_a = br.readLine().split(" ");
	         int[] a = new int[n];
	         for(int i_a=0; i_a<arr_a.length; i_a++)
	         {
	         	a[i_a] = Integer.parseInt(arr_a[i_a]);
	         }

	         long out_ = solve(a);
	         System.out.println(out_);

	         wr.close();
	         br.close();
	    }
	    static long solve(int[] a){
	       int mx=Integer.MIN_VALUE;
	       long mod=1000000009;
	       for(int i=0;i<a.length;i++)
	       {
	    	  mx=Math.max(mx,a[i]);
	       }
	       int b[]=new int[mx+1];
	       int n=a.length,c=0;
	       for(int i=0;i<b.length;i++)
	       {
	    	  
	    	   b[i]=Integer.MIN_VALUE;
	   
	       }
	      
	       for (int i = 0; i < (1<<n); i++)
	        {
	    	   c=0;
	    	   int x=0;
	    	   for (int j = 0; j < n; j++)
	    	   {
	    		   if ((i & (1 << j)) > 0)
	                {
	                	c++;
	                    x=x^a[j];  
	                }
	            }
	    	   if(x<mx+1)
	    	   {
	    		  b[x]=Math.max(b[x], c);
	    	   }
	        }
	       long ans=0;
	       for(int j=0;j<b.length;j++)
	       {
	    	   if(b[j]==Integer.MIN_VALUE)
	    	   {
	    		   b[j]=0;
	    		 //  System.out.println(j);
	    	   }
	       }
	       for(int j=0;j<b.length;j++)
	       {
	    	   System.out.print(b[j]+" ");
	       }
	       for(int j=0;j<b.length;j++)
	       {
	    	  ans=(long) (((ans%mod)+(b[j]%mod*Math.pow(31, j)%mod)%mod)%mod);
	       }
	    return ans;
	    }
}