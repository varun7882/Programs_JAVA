package hackerrank;
import java.util.Arrays;
import java.util.Scanner;
public class WUS {
public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
     String s = in.next();
     int n = in.nextInt();
     boolean []t=new boolean[2600000];
     Arrays.fill(t,false);
     char c='1';
     int sum=0;
  //   System.out.print((int)'a');
     for(int i=0;i<s.length();i++)
     {
    	 if(c!=s.charAt(i))
    	 {
    		 sum=0;
    	 }
    	 c=s.charAt(i);
    	 sum=sum+(int)c-96;
    	 if(t[sum]==false)
    	 {
    		 t[sum]=true;
    	 }
     }
     for(int a0 = 0; a0 < n; a0++){
         int x = in.nextInt();
         if(t[x])
         {
        	 System.out.print("Yes");
         }
         else
         {
        	 System.out.print("No");
         }
     }

}

}
