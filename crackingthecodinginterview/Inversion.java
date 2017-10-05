package crackingthecodinginterview;
import java.util.*;
public class Inversion {
	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int t = in.nextInt();
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();
	            int arr[] = new int[n];
	            for(int arr_i=0; arr_i < n; arr_i++){
	                arr[arr_i] = in.nextInt();
	            }
	            System.out.println(countInversions(arr));
	        }
	    }
	    public static long countInversions(int[] arr){
			   long ans=0;
			  ans= div(arr,0,arr.length-1);
			   return ans;
		    }
		 static  long div(int []a,int l,int h)
		 {
	         long t=0;
	         if(l<h)
	             {
				 
			 int m=l+(h-l)/2;
			 t=t+div(a,l,m);
			 t=t+div(a,m+1,h);
			return t+mer(a,l,m,h);
	         }
	         return t;
		 }
		 static long mer(int a[],int l,int m,int h)
		{
			long t=0;
			int n1=m-l+1,n2=h-m;
			int a1[]= new int[n1];
			int a2[]=new int[n2];
			int k=l;
			for(int i=0;i<n1;i++)
			{
			a1[i]=a[k];
			k++;
			}
			for(int i=0;i<n2;i++)
			{
			a2[i]=a[k];
			k++;
			}
			int i,j;
			i=j=0;
	         k=0;
	       //  System.out.println(a.length);
			while(i<n1 && j<n2)
			{
				if(a1[i]>a2[j])
				{
					t=t+(m-i);
	                a[k]=a2[j];
	                j++;
				}
				else
				{
	                a[k]=a1[i];
					i++;
				}
	            k++;
			}
			while(i<n1)
			{
				t++;
	            a[k]=a1[i];
	            k++;
				i++;
			}
			while(j<n2)
	            {
	             a[k]=a2[j];
	            k++;
				j++;
	        }
			return t;
		}
	    
}
