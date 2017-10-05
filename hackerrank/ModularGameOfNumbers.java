package hackerrank;

import java.util.*;

public class ModularGameOfNumbers {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int p = in.nextInt();
	        int q = in.nextInt();
	        int[] a = new int[p];
	        for(int a_i=0; a_i < p; a_i++){
	            a[a_i] = in.nextInt();
	        }
	        int[] b = new int[q];
	        for(int b_i=0; b_i < q; b_i++){
	            b[b_i] = in.nextInt();
	        }
	        Set<Integer> s= new HashSet<Integer>();
	        int sm=0;
	        for(int i=0;i<p;i++)
	        {
	        	for(int j=0;j<q;j++)
	        	{
	        		sm=(a[i]%n+b[j]%n)%n;
	        		s.add(sm);
	        	}
	        }
	        int i=1;
	        for(Integer x:s)
	        {
	        	if(x==i)
	        	{
	        		i++;
	        	}
	        	else
	        	{
	        		System.out.println(i);
	        		return ;
	        	}
	        }
//	        for(i=1;;i++)
//	        {
//	        	i=i%n;
//	        	if(!s.contains(i))
//	        	{
//	        		System.out.println(i);
//	        		return ;
//	        	}
//	        	if(i>=n)break;
//	        }
	        System.out.println(i);
	    }
}
