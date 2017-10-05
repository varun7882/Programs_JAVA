package hackerrank;
import java.util.*;
public class SubstringQueries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String[] s = new String[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.next();
        }
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
           System.out.println(f(s[x],s[y]));
        }
    }
    static int f(String a,String b)
        {
    	int na=a.length(),nb=b.length(),l;
    	l=na>nb?nb-1:na-1;
    	for(int i=l;i>0;i--)
    	{
    		for(int j=0;j<=na-i;j++)
    		{
    			if(b.indexOf(a.substring(j,j+i+1))!=-1)
    			{
    				return i;
    			}
    		}
    	}
        return 0;
    }
}
