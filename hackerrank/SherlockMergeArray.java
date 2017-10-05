package hackerrank;
import java.util.*;
public class SherlockMergeArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] m = new int[n];
        boolean[] p= new boolean[n+1];
        Arrays.fill(p,false);
        for(int m_i=0; m_i < n; m_i++){
            m[m_i] = in.nextInt();
        }
     //   int sbd=0;
        for(int i=0;i<n;i++)
        {
        	p[m[i]]=true;
        }
       
    }
} 