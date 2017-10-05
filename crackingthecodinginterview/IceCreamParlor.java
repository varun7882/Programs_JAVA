package crackingthecodinginterview;
import java.util.*;
public class IceCreamParlor {
	 public static int binarySearch(int f, int l, IceCream[] a, int x) {
	        int t=-1;
	        if(f<=l)
	        {
	        	int m=(f+l)/2;
	        	if(a[m].flavor==x)
	        	{
	        		return a[m].index;
	        	}
	        	else if(a[m].flavor<x)
	        	{
	        		t=binarySearch(m+1, l, a, x);
	        	}
	        	else
	        	{
	        		t=binarySearch(l, m-1, a, x);
	        	}
	        }
	        return t;
	    }

	    public static void main(String[] args) {
	        
	        int t;
	        int n, m;
	 
	        Scanner in = new Scanner(System.in);
	        t = in.nextInt();
	       for(int test = 0; test < t; test++) {       
	            
	            m = in.nextInt();
	            n = in.nextInt(); 
	            IceCream[] arr = new IceCream[n];
	    
	            for (int i = 0; i < n; i++)
	                arr[i] = new IceCream(in.nextInt(), i + 1);
	            
	            Arrays.sort(arr);
	            for(int i = 0; i < n ; i++) {
	                int search = m - arr[i].flavor;
	                    int index = binarySearch( 0, n - 1, arr, search);
	                    if( index != -1 ) {
	                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
	                        break;

	                    }
	            } 
	            
	        }
	        
	    }
}
class IceCream implements Comparable<Object>{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
      this.flavor=flavor;
      this.index=index;
    }
   
    @Override
    public int compareTo(Object o) {
       IceCream c=(IceCream)o;
       return this.flavor-c.flavor;
    }

    @Override
    public boolean equals(Object o){
    	IceCream c=(IceCream)o;
    	if(this.flavor==c.flavor)return true;
    	return false;
    }
        
}