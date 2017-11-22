package varun;
import java.util.Scanner;
public class cupcakes {
	public static void main(String args[])
	{
		int t,i,j;
		long n,k,max,pack;
		Scanner in = new Scanner(System.in);
		t=in.nextInt();
		for(i=0;i<t;i++)
		{
			n= in.nextLong();
			pack=n;
			if(pack%2==0)
			{
				pack=(pack/2)+1;
			}
			else
			{
				pack=(pack+1)/2;
			}
		System.out.println(pack);
		}
	}
}
