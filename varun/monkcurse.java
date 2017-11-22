package varun;
import java.util.Scanner;
import java.util.Iterator;
import java.util.PriorityQueue;
public class monkcurse
{
	public static void main(String args[]) 
	{
		int t,n,k,i,j,l;
		long s;
		//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner br= new Scanner(System.in);
		t=br.nextInt();
		for(i=0;i<t;i++)
		{
			long rs=0,cs=0;
		n=br.nextInt();
		k=br.nextInt();
		PriorityQueue<Long> rows= new PriorityQueue<Long>();
		PriorityQueue<Long> cols= new PriorityQueue<Long>();
		long [][] a= new long[n][n];
		for(j=0;j<n;j++)
		{
			rs=0;
			for(l=0;l<n;l++)
			{
				a[j][l]=br.nextInt();
				s=a[j][l];
				rs+=s;
			}
			rows.add(rs);
		}
		for(j=0;j<n;j++)
		{
			cs=0;
			for(l=0;l<n;l++)
			{
				s=a[l][j];
				cs+=s;
			}
			cols.add(cs);
		}
	/*	for(j=0;j<n;j++)
		{
			for(l=0;l<n;l++)
			{
				System.out.print(a[j][l]+" ");
			}
			System.out.println();
		}
		
		
	*/
		curseProcess cp= new curseProcess();
		s=0;
		/*Iterator<Long> titr= rows.iterator();
		Iterator<Long> titc= cols.iterator();
		while(titr.hasNext())
		{
			System.out.print(titr.next()+" ");
		}
		System.out.println();
		while(titc.hasNext())
		{
			System.out.print(titc.next()+" ");
		}
		System.out.println();*/
		for(j=0;j<k;j++)
		{
			long [] ret= new long[4];
			Iterator<Long> itr= rows.iterator();
			Iterator<Long> itc= cols.iterator();
			
			ret=cp.cprocess(rows,cols,n);
			/*for(l=0;l<4;l++)
			{
				System.out.print(ret[l]+" ");
			}
			System.out.println();*/
			
			s=s+ret[0];
			if(ret[3]==0)
			{
				while(itr.hasNext())
			{
				if(ret[1]==itr.next());
				{
					itr.remove();
					break;
				}
			}
				rows.add(ret[2]);
			}
			else
			{
				while(itc.hasNext())
				{
					if(ret[1]==itc.next());
					{
						itc.remove();
						break;
					}
				}
					cols.add(ret[2]);
			}
			/*Iterator<Long> ttitr= rows.iterator();
			Iterator<Long> ttitc= cols.iterator();
			while(ttitr.hasNext())
			{
				System.out.print(ttitr.next()+" ");
			}
			System.out.println();
			while(ttitc.hasNext())
			{
				System.out.print(ttitc.next()+" ");
			}
			System.out.println();*/
		}
		
		System.out.println(s);	
		//cp=null;
			
		}
		}
	}


