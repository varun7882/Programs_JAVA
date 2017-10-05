package interview;
import java.util.*;
public class GrayCode {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	
	public ArrayList<Integer> grayCode(int a) {
	//	ArrayList<Integer> tmp= new ArrayList<Integer>();
		long n=(long) Math.pow(2,a);
		for(int i=0;i<n;i++)
		{
			int x=i^(i/2);
			ans.add(x);
		}
		return ans;
	}
}
