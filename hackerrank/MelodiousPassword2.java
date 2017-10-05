package hackerrank;
import java.util.*;
public class MelodiousPassword2 {
	static int n;
	static char[] cons="bcdfghjklmnpqrstvwxz".toCharArray();
	static char[] vols="aeiou".toCharArray();
	static ArrayList<Character> ans = new ArrayList<Character>();
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	         n = in.nextInt();
	         getans(true);
	         getans(false);
	    }
	 static void getans(boolean f)
	 {
		 if(ans.size()==n)
		 {
			 for(int i=0;i<n;i++)
			 {
			System.out.print(ans.get(i));
			 }
			 System.out.println();
			return ;
		 }
		 if(f)
		 {
			 for(int i=0;i<cons.length;i++)
			 {
				 ans.add(cons[i]);
				 getans(false);
				 ans.remove(ans.size()-1);
			 }
		 }
		 else
		 {
			 for(int i=0;i<vols.length;i++)
			 {
				 ans.add(vols[i]);
				 getans(true);
				 ans.remove(ans.size()-1);
			 }
		 }
	 }
}
