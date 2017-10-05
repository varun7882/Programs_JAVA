package hackerrank;
import java.util.*;
public class MinimumNumber {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String s="min(int, ";
	        StringBuilder ans= new StringBuilder("");
	        for(int i=0;i<n-1;i++)
	        {
	        	ans.append(s);
	        }
	        ans.append("int");
	        for(int i=0;i<n-1;i++)
	        {
	        	ans.append(")");
	        }
	        System.out.print(ans);
	       }
}
