package crackingthecodinginterview;
import java.util.*;
public class LeftRotation {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        k=k%n;
	        k=n-k;
	        for(int i = 0; i < n; i++)
	        {
	        	int d=i+n-k;;
	        	 System.out.print(a[d]+" ");
	        }
	      
	        System.out.println();
	      
	    }
}
