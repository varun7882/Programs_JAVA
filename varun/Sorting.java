package varun;
import java.util.*;
public class Sorting {
	public static void main(String args[])
	{
		Scanner st= new Scanner(System.in);
		HeapSort hs= new HeapSort();
		int n,a[];
		System.out.println("Enter the number of elements");
		n=st.nextInt();
		a= new int[n+1];
		for(int i=1;i<=n;i++)
		{
			a[i]=st.nextInt();
		}
		System.out.println("Array is...");
		for(int i=1;i<=n;i++)
		{
			System.out.println(a[i]);
		}
		hs.Hsort(a,n);
		System.out.println("Sorted Array is...");
		for(int i=1;i<=n;i++)
		{
			System.out.println(a[i]);
		}
	}
}


