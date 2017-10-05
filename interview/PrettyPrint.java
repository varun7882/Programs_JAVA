package interview;

import java.util.ArrayList;

public class PrettyPrint {
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    ArrayList<ArrayList<Integer>> ans=new ArrayList<ArrayList<Integer>>();
	    int n=2*a-1,mn;
	    for(int i=0;i<n;i++)
	    {
	        ArrayList<Integer> tmp=new ArrayList<Integer>();
	        for(int j=0;j<n;j++)
	        {
	           mn=i<j?i:j;
	           
	           tmp.add(a-mn);
	           
	        }
	      //  System.out.println();
	        ans.add(tmp);
	    }
	    return ans;
	}
}
