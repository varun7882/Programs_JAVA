package varun;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class SEATL {
	public static void main(String args[]) throws IOException
	{
		int T,n,m,a[][],i,j;
		String inp[];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());
		while(T-->0)
		{
			int ans=-1,x,maxi,maxj,rn,cn;
			HashMap<Integer,HashMap<Integer,Integer>> row= new HashMap<Integer,HashMap<Integer,Integer>>();
			HashMap<Integer,HashMap<Integer,Integer>> col= new HashMap<Integer,HashMap<Integer,Integer>>();
			HashMap<Integer,Integer> el = new HashMap<Integer,Integer>();
			inp=br.readLine().split(" ");
			n=Integer.parseInt(inp[0]);
			m=Integer.parseInt(inp[1]);
			a= new int[n][m];
			for(i=0;i<n;i++)
			{
				inp=br.readLine().split(" ");
				for(j=0;j<m;j++)
				{
					a[i][j]=Integer.parseInt(inp[j]);
					/*if(!row.containsKey(a[i][j]))
					{
						row.put(a[i][j], new HashMap<Integer,Integer>());
					}
					if(!col.containsKey(a[i][j]))
					{
						col.put(a[i][j], new HashMap<Integer,Integer>());
					}*/
					if(el.containsKey(a[i][j]))
					{
						el.put(a[i][j],el.get(a[i][j])+1);
					}
					else
					{
						el.put(a[i][j],1);
					}
					
				}
			}
			 ans = 1;
			for (int key : el.keySet()){
				if (el.get(key)>2){
					row.put(key, new HashMap<Integer, Integer>());
					col.put(key, new HashMap<Integer, Integer>());
				}
				else if (el.get(key)==2) ans=2;
			}

			for(i=0;i<n;i++)
			{
				for(j=0;j<m;j++)
				{
					if(row.containsKey(a[i][j]))
					{
					if(row.get(a[i][j]).containsKey(i))
					{
						row.get(a[i][j]).put(i, row.get(a[i][j]).get(i)+1);
					}
					else
					{
						row.get(a[i][j]).put(i,1);
					}
					}
					if(row.containsKey(a[i][j]))
					{
					if(col.get(a[i][j]).containsKey(j))
					{
						col.get(a[i][j]).put(j, col.get(a[i][j]).get(j)+1);
					}
					else
					{
						col.get(a[i][j]).put(j,1);
					}
					}
				}
				
			}
			/*for(i=0;i<n;i++)
			{
				for(j=0;j<m;j++)
				{
					System.out.print(a[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println(row);
			System.out.println(col);*/
			
			rn=0;
			cn=0;
			int tans;
			for(Entry<Integer, HashMap<Integer, Integer>> e:row.entrySet() )
			{
				HashSet<Integer> ro = new HashSet<Integer>();
				HashSet<Integer> co = new HashSet<Integer>();
				maxi=0;
				maxj=0;
				tans=0;
				x=e.getKey();
			//	System.out.println(e.getValue());
				for(int k:e.getValue().keySet())
				{
					maxi=Math.max(maxi, e.getValue().get(k));
				}
				//System.out.println(col.get(x));
				for(int k:e.getValue().keySet())
				{
					if(maxi==e.getValue().get(k))
					{
					ro.add(k);	
					}
				}
				for(int k:col.get(x).keySet())
				{
					maxj=Math.max(maxj, col.get(x).get(k));
				}
				//System.out.println(col.get(x));
				for(int k:col.get(x).keySet())
				{
					if(maxj==col.get(x).get(k))
					{
					co.add(k);	
					}
				}
				
			    ans=Math.max(ans, maxi+maxj-1);
			    if(ans<maxi+maxj)
			    {
			    	for(int rnn:ro)
			    	{
			    		for(int cnn:co)
			    		{
			    			if(a[rnn][cnn]!=x)
			    			{
			    				ans=Math.max(ans,maxi+maxj);
			    			}
			    		}
			    		
			    	}
			    }
			}

			System.out.println(ans);	
		}
	}
}
