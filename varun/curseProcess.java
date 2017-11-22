package varun;

import java.util.Iterator;
import java.util.PriorityQueue;

public class curseProcess {
	private long ra=0,ca=0,re,ce,ct=0;
	long [] send= new long [4];
	long [] cprocess(PriorityQueue r,PriorityQueue c,int n)
	{
		Iterator<Long> ir= r.iterator();
		Iterator<Long> ic= c.iterator();
		
		ct=0;
		while(ir.hasNext())
		{
			re=ir.next();
			ce=ic.next();
			if(re+ra<ce+ca)
			{
				send[0]=re+ra;
				send[1]=re;
				send[2]=re+n;
				send[3]=0;
				ca++;
				break;
			}
			else if(re+ra>ce+ca)
			{
				send[0]=ce+ca;
				send[1]=ce;
				send[2]=ce+n;
				send[3]=1;
				ra++;
				break;
			}
			else
			{
				ct++;
				continue;
			}
		}
		if(ct==n)
		{
			Iterator<Long> ir1= r.iterator();
			re=ir1.next();
			send[0]=re+ra;
			send[1]=re;
			send[2]=re+n;
			send[3]=0;
			ca++;
			return send;
		}
		else
		{
			return send;
		}
	}
}
