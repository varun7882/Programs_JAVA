package crackingthecodinginterview;
import java.util.*;
public class Primality {
	static int N=2000000001;
	static boolean prime[]= new boolean[N];
	 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        Arrays.fill(prime, true);
        prime[1]=false;
        for(int i=2;i<=Math.sqrt(N);i++)
        {
        	if(prime[i])
        	{	
	        	for(int j=2*i;j<=N;j=j+i)
	        	{
	        		prime[j]=false;
	        	}
        	}
        }
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            if(prime[n])
            {
            	System.out.println("Prime");
            }
            else
            {
            	System.out.println("Not prime");
            }
        }
    }
}
