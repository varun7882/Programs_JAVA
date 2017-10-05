package interview;
import java.util.*;
public class WindowString {
	public String minWindow(String S, String T) {
		Map<Character,Integer> m= new HashMap<Character, Integer>();
		int n=T.length();
		for(int i=0;i<T.length();i++)
		{
			char x=T.charAt(i);
			if(m.containsKey(x))
			{
				int y=m.get(x);
				y=y+1;
				m.put(x,y);
			}
			else
			{
				m.put(x,1);
			}
		}
		int i=0,j=0,ws=Integer.MAX_VALUE,st=0;
		while(i<S.length() && j<S.length())
		{
			if(n<=0)
			{
				if(j-i<ws)
				{
					st=i;
				//	System.out.println("hey");
					ws=j-i;
				}
				char x=S.charAt(i);
				if(m.containsKey(x))
				{
				    //	System.out.println("hey "+x+" "+S.charAt(j));
					int y=m.get(x);
					y=y+1;
					m.put(x,y);
					n++;
				}
				i++;
				
			}
			else
			{
				char x=S.charAt(j);
				if(m.containsKey(x))
				{
					int y=m.get(x);
				
					y=y-1;
					m.put(x,y);
					n--;
				}
			//	System.out.println("h");
				j++;
			}
		}
		while(n<=0)
		{
			if(j-i<ws)
			{
				st=i;
			//	System.out.println("hey");
				ws=j-i;
			}
			char x=S.charAt(i);
			if(m.containsKey(x))
			{
			    //	System.out.println("hey "+x+" "+S.charAt(j));
				int y=m.get(x);
				y=y+1;
				m.put(x,y);
				n++;
			}
			i++;
		}
		if(ws!=Integer.MAX_VALUE)
		{
			return S.substring(st,ws);
		}
		return "";
	}
}
