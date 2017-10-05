package interview;
import java.util.*;
public class Bulbs {
	 public int bulbs(ArrayList<Integer> a) {
	 int c=0;
	 boolean f=true;
	 for(int i=0;i<a.size();i++)
	 {
		if(bulbState(a.get(i),f)==0)
		{
			c++;
			f=!f;;
		}
	 }
	 return c;
	 }
	 int bulbState(int x,boolean f)
	 {
		 if(f)
		 {
			 return x;
		 }
		 else
		 {
			 return ~x;
		 }
	 }
}
