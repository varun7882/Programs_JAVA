package hackerrank;
import java.util.Scanner;


public class Game2Stacks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int g = in.nextInt();
        for(int a0 = 0; a0 < g; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            long x = in.nextLong();
            int[] a = new int[n];
            int ln=n,lm=m;
            long s=0,ans;
            boolean f=true;
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
                s=s+a[a_i];
                if(s>x && f)
                {
                	f=false;
                	ln=a_i-1;
                }
            }
            f=true;
            s=0;
            int[] b = new int[m];
            for(int b_i=0; b_i < m; b_i++){
                b[b_i] = in.nextInt();
                s=s+b[b_i];
                if(s>x && f)
                {
                	f=false;
                	lm=b_i-1;
                }
            }
          long asum[]= new long[ln+1];
          long bsum[]= new long[lm+1];
          s=0;
          for(int i=0;i<=ln;i++)
          {
        	s=s+a[i];
        	asum[i]=s;
          }
          s=0;
          for(int i=0;i<=lm;i++)
          {
        	s=s+b[i];
        	bsum[i]=s;
          }
          int i=0,j=lm;
          long tmp,tans,ans2;
          ans2=ans=Math.max(ln+1,lm+1);
          while(i<=ln && j>=0)
          {
        	 tmp=asum[i]+bsum[j];
        	 if(tmp>x)
        	 {
        		j--; 
        	 }
        	 else
        	 {
        		tans=i+1+j+1;
        		if(tans>ans)
        		{
        			ans=tans;
        		}
        		i++;
        	 }
          }
          System.out.println(Math.max(ans,ans2));
        }
    }
}
