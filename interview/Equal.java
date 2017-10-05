package interview;
import java.util.*;
public class Equal {
	ArrayList<Integer> ans= new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> tans= new ArrayList<ArrayList<Integer>>();
	 public ArrayList<Integer> equal(ArrayList<Integer> a) {
		 int i,j;
		 Map<Integer,ArrayList<Pair>> m=new HashMap<Integer,ArrayList<Pair>>();
		 for(i=0;i<a.size();i++)
		 {
			 for(j=i+1;j<a.size();j++)
			 {
				 int s=a.get(i)+a.get(j);
				 Pair p= new Pair(i,j);
				 if(m.containsKey(s))
				 {
					 ArrayList<Pair> tmp=m.get(s);
					 for(int k=0;k<tmp.size();k++)
					 {
						  Pair p1=tmp.get(k);
						  int a1=p1.x;
						  int b1=p1.y;
						  int c1=i;
						  int d1=j;
						  if(a1<c1 && b1!=d1 && b1!=c1)
						  {
							  ArrayList<Integer> an= new ArrayList<Integer>();
							  an.add(a1);
							  an.add(b1);
							  an.add(c1);
							  an.add(d1);
							  tans.add(an);
							  break;
						  }
					 }
					 tmp.add(p);
					 m.put(s,tmp);
				 }
				 else
				 {
					 ArrayList<Pair> tmp= new ArrayList<Pair>();
					 tmp.add(p);
					 m.put(s,tmp);
				 }
			 }
		 }
		 Collections.sort(tans, new Comparator<ArrayList<Integer>>()
				 {

					@Override
					public int compare(ArrayList<Integer> o1,ArrayList<Integer> o2) {
						for(int i=0;i<o1.size();i++)
						{
							int cm= o1.get(i)-o2.get(i);
							if(cm!=0)
							{
								return cm;
							}
						}
						return 0;
					}
			 
				 });
		 ans=tans.get(0);
		 return ans;
	    }
}
class Pair
{
	 int x,y;
	 Pair(int x,int y)
	 {
		 this.x=Math.min(x, y);
		 this.y=Math.max(x,y);
	 }
}