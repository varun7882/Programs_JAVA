package crackingthecodinginterview;
import java.util.*;
public class RansomNote {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
       String mag=scanner.nextLine();
       String mags[]=mag.split(" ");
       String ran=scanner.nextLine();
       String rans[]=ran.split(" ");
       Map<String,Integer> mm= new HashMap<String, Integer>();
       for(int i=0;i<m;i++)
	       {
    	   String x=mags[i];
    	   if(mm.containsKey(x))
	       		{
	 		  mm.put(x, mm.get(x)+1);
	       		}
	 	  else
	 	  {
	 		  mm.put(x,1);
	 	  }
       }
       boolean answer=true;
       for(int i=0;i<n;i++)
	      {
	    	  String x=rans[i];
	    	  if(mm.containsKey(x))
	    	  {
	    		  int v=mm.get(x);
	    		  if(v==1)
	    		  {
	    			  mm.remove(x);
	    		  }
	    		  else
	    		  {
	    			  mm.put(x, v-1);
	    		  }
	    	  }
	    	  else
	    	  {
	    		 answer=false;
	    		 break;
	    	  }
	      }
        scanner.close();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
