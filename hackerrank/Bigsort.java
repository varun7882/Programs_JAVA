package hackerrank;
import java.util.*;

public class Bigsort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            s[unsorted_i] = in.next();
        }
        Arrays.sort(s,new Comparator<String>()
                   {
                      public int compare(String s1,String s2)
                          {
                          int cmp=s1.length()-s2.length();
                          if(cmp!=0)
                              {
                              return cmp;
                          }
                          for(int i=0;i<s1.length();i++)
                              {
                              cmp=Integer.valueOf(Character.toString(s1.charAt(i)))-Integer.valueOf(Character.toString(s2.charAt(i)));
                              if(cmp!=0)
                                  {
                                  return cmp;
                              }
                          }
                          return 0;
                      }
                   });
        
    }
}
