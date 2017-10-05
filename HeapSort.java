package varun;
public class HeapSort {
	void Hsort(int a[],int n)
	{
		buildmaxheap(a,n);
		int t,s;
		s=n;
		for(int i=n;i>=1;i--)
		{
			t=a[1];
			a[1]=a[i];
			a[i]=t;
			s=s-1;
			heapify(a,1,s);
		}
	}
	void buildmaxheap(int a[],int n)
	{
		for(int i =n/2;i>=1;i--)
		{
			heapify(a,i,n);
		}
		
	}
	void heapify(int a[],int i,int s)
	{
		int l,r,largest,t;
		l=2*i;
		r=l+1;
		largest=i;
		 if(l<=s && a[l]>a[i])
		 {
			 largest=l;
		 }
		 if(r<=s && a[r]>a[largest])
		 {
			 largest=r;
		 }
		if(largest!=i)
		{
			t=a[i];
			a[i]=a[largest];
			a[largest]=t;
			heapify(a,largest,s);
		}
	}
}
