package varun;
import java.util.*;
class ambi 
{
 public static void main(String args[])
 {
	 int n,j;
	 Scanner in=new Scanner(System.in);
			 while(true)
			 {
				 n=in.nextInt();
				 if(n==0)
				 {
					 break;
				 }
				 int a[] = new int[1000001];
				 int b[]=  new int[1000001];
				 for(j=1;j<=n;j++)
				 {
					 a[j]=in.nextInt();
				 }
				 for(j=1;j<=n;j++)
				 {
					 b[a[j]]=j;
				 }
				 if(Arrays.equals(a,b))
				 {
					 System.out.println("ambiguous");
				 }
				 else
				 {
					 System.out.println("not ambiguous"); 
				 }
			 }
		
			 
 }
	
}
