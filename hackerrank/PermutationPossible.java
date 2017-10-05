package hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PermutationPossible {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int m = in.nextInt();
	        int[] s = new int[m];
	        for(int s_i=0; s_i < m; s_i++){
	            s[s_i] = in.nextInt();
	        }
	        Set<Integer> st=new HashSet<Integer>();
	    
	         for(int i=0; i < m; i++){
	            if(st.contains(s[i]))
	            {
	            	System.out.print("NO");
	            	break;
	            }
	            else
	            {
	            	st.add(s[i]);
	            }
	        }
	         System.out.print("YES");
	    }
}
