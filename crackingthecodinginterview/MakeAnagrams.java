package crackingthecodinginterview;
import java.util.*;
public class MakeAnagrams {
	 public static int numberNeeded(String f, String s) {
		 int d=0;
	      Map<Character,Integer> m= new HashMap<Character, Integer>();
	      for(int i=0;i<f.length();i++)
	      {
	    	  char x=f.charAt(i);
	    	  if(m.containsKey(x))
	    	  {
	    		  m.put(x, m.get(x)+1);
	    	  }
	    	  else
	    	  {
	    		  m.put(x,1);
	    	  }
	      }
	      for(int i=0;i<s.length();i++)
	      {
	    	  char x=s.charAt(i);
	    	  if(m.containsKey(x))
	    	  {
	    		  int v=m.get(x);
	    		  if(v==1)
	    		  {
	    			  m.remove(x);
	    		  }
	    		  else
	    		  {
	    			  m.put(x, v-1);
	    		  }
	    	  }
	    	  else
	    	  {
	    		 d++;
	    	  }
	      }
	      if(!m.isEmpty())
	      {
	    	  Set<Character> ss=m.keySet();
	    	  for(Character x:ss)
	    	  {
	    		  d=d+m.get(x);
	    	  }
	      }
	      return d;
	    }
	  
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        String a = in.next();
	        String b = in.next();
	        System.out.println(numberNeeded(a, b));
	    }
}
