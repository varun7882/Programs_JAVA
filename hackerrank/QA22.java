package hackerrank;

import java.util.Scanner;

public class QA22 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rq = in.nextInt();
        int cq = in.nextInt();
        long cmin=n+1,cmax=0,rmin=n+1,rmax=0,c1,c2;
        long cmind1=n+1,cmaxd1=0;
        long cmaxxd2=n+1,cmaxd2=n+1,ans;
        c1=rq-cq;
        c2=cq+rq;
        for(int a0 = 0; a0 < k; a0++){
            int ro = in.nextInt();
            int co = in.nextInt();
            if(ro==rq)
            {
            	if(co<cq)
            	{
            		if(co>cmax)
            		{
            			cmax=co;
            		}
            	}
            	else if(co>cq)
            	{
            		if(co<cmin)
            		{
            			cmin=co;
            		}
            	}
            }
            else if(co==cq)
            {
            	if(ro<rq)
            	{
            		if(ro>rmax)
            		{
            			rmax=ro;
            		}
            	}
            	else if(ro>rq)
            	{
            		if(ro<rmin)
            		{
            			rmin=ro;
            		}
            	}
            }
            else if(ro-co==c1)
            {
            	if(co<cq)
            	{
            		if(co>cmaxd1)
            		{
            			cmaxd1=co;
            		}
            	}
            	else if(co>cq)
            	{
            		if(co<cmind1)
            		{
            			cmind1=co;
            		}
            	}
            }
            else if(ro+co==c2)
            {
            	if(co<cq)
        	{
        		if(co>cmaxd2)
        		{
        			cmaxd2=co;
        		}
        	}
        	else if(co>cq)
        	{
        		if(co<cmaxxd2)
        		{
        			cmaxxd2=co;
        		}
        	}
            	
            }
        }
        ans=Math.abs(cq-cmax)+Math.abs(cq-cmin)+Math.abs(rq-rmin)+Math.abs(rq-rmax)-4;
        System.out.println(ans);
        long x=cq>rq?cq:rq;
        ans=ans+Math.abs(x-cmaxd1)+Math.abs(x-cmind1)-2;
        System.out.println(ans);
        ans=ans+Math.abs(x-cmaxd2)+Math.abs(x-cmaxxd2)-2;
        System.out.println(ans);
    }
}
