package hackerrank;
import java.util.*;
public class MelodiousPassword {
	static int n;
	static char[] cons="bcdfghjklmnpqrstvwxz".toCharArray();
	static char[] vols="aeiou".toCharArray();
	static StringBuilder ans= new StringBuilder(""); 
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	         n = in.nextInt();
	         getans(true);
	         getans(false);
	    }
	static void getans(boolean f)
	 {
		 if(ans.length()==n)
		 {
			System.out.println(ans);
			return ;
		 }
		 if(f)
		 {
			 for(int i=0;i<cons.length;i++)
			 {
				 ans.append(cons[i]);
				 getans(false);
				 ans.deleteCharAt(ans.length()-1);
			 }
		 }
		 else
		 {
			 for(int i=0;i<vols.length;i++)
			 {
				 ans.append(vols[i]);
				 getans(true);
				 ans.deleteCharAt(ans.length()-1);
			 }
		 }
	 }
}
