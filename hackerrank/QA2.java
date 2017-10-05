package hackerrank;
import java.math.BigInteger;
import java.util.Scanner;
public class QA2 {
public static void main(String[] args) {
	 Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     int k = in.nextInt();
     int rQ = in.nextInt();
     int cQ = in.nextInt();
     int i,j;
     BigInteger ans=new BigInteger("0");
     boolean [][]a=new boolean[n+1][n+1];
     a[rQ][cQ]=true;
     for(int a0 = 0; a0 < k; a0++){
         int rO = in.nextInt();
         int cO = in.nextInt();
         if(rO<=n && rO>0 && cO<=n && cO>0)
         {
         a[rO][cO]=true;
         }
     }
     for(i=rQ-1;i>0;i--)
     {
    	 if(a[i][cQ])
    	 {
    		 //System.out.print("hey");
    		 break;
    	 }
    	 //System.out.print("hey");
    	 ans=ans.add(BigInteger.ONE);
     }
     for(i=rQ+1;i<=n;i++)
     {
    	 if(a[i][cQ])
    	 {
    		 break;
    	 }
    	ans= ans.add(BigInteger.ONE);
    	}
     for(i=cQ-1;i>0;i--)
     {
    	 if(a[rQ][i])
    	 {
    		 break;
    	 }
    	 ans=ans.add(BigInteger.ONE);
     }
     for(i=cQ+1;i<=n;i++)
     {
    	 if(a[rQ][i])
    	 {
    		 break;
    	 }
    	ans= ans.add(BigInteger.ONE);
     }
     for(i=rQ-1,j=cQ-1;i>0 && j>0;i--,j--)
     {
    	if(a[i][j])
    	{
    		break;
    	}
    	 ans=ans.add(BigInteger.ONE);
     }
     for(i=rQ-1,j=cQ+1;i>0 && j<=n;i--,j++)
     {
    	if(a[i][j])
    	{
    		break;
    	}
    	ans= ans.add(BigInteger.ONE);
     }
     for(i=rQ+1,j=cQ-1;i<=n && j>0;i++,j--)
     {
    	if(a[i][j])
    	{
    		break;
    	}
    	 ans=ans.add(BigInteger.ONE);
     }
     for(i=rQ+1,j=cQ+1;i<=n && j<=n;i++,j++)
     {
    	if(a[i][j])
    	{
    		break;
    	}
    	ans= ans.add(BigInteger.ONE);
     }
     System.out.println(ans);
}
}
