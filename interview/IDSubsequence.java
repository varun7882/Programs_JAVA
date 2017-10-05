package interview;
import java.util.*;
public class IDSubsequence {
	 public int longestSubsequenceLength(final List<Integer> A) {
		 int n=A.size(),lis[],dis[];
		 lis=new int[n];
		 dis=new int[n];
		 int d[]=new int[n];
		 for(int j=0;j<n;j++)
		 {
			dis[j]=lis[j]=1;
			d[j]=A.get(j);
		 }
		 for(int i=1;i<n;i++)
		 {
			 for(int j=0;j<i;j++)
			 {
				 if(A.get(i)>A.get(j))
				 {
					 lis[i]=Math.max(lis[i], lis[j]+1);
				 }
				
			 }
		 }
		 for(int i=n-2;i>=0;i--)
		 {
			 for(int j=n-1;j>i;j--)
			 {
				 if(d[i]>d[j])
				 {
					 dis[i]=Math.max(dis[i], dis[j]+1);
				 }
				
			 }
		 }
		 int tmp=0;
			 for(int j=1;j<n;j++)
			 {
				int x=lis[j]+dis[j]-1;
				tmp=Math.max(tmp, x);
			 }
		 return tmp;
	    }
}
