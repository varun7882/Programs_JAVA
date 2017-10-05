package interview;
import java.util.*;
public class Fraction {
	public String fractionToDecimal(int num, int den) {
		int w=0;
		if(num>=den && num%den==0)
		{
			return String.valueOf(num/den);
		}
		if(num>den)
		{
			w=num/den;
		}
		int rem=num%den;
		Map<Integer,Integer> m= new HashMap<Integer, Integer>();
		StringBuilder ans= new StringBuilder("");
		while(rem!=0)
		{
			if(m.containsKey(rem))
			{
				break;
			}
			m.put(rem,1);
			int x=rem*10;
			int d=x/den;
			ans.append(d);
			rem=rem%den;
		}
		
			
	return String.valueOf(w)+"."+rem;
	}
}
