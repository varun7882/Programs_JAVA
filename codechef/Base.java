package codechef;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Base {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st=new StringTokenizer(br.readLine());
		int t;
		long n;
		t=Integer.parseInt(br.readLine());
		while(t>0)
		{
			long ans=0;
			String s= br.readLine();
			n=Long.parseLong(s);
			if(n==1)
			{
				System.out.println("INFINITY");
			}
			else if(n==0)
			{
				System.out.println("0");
			}
			else
			{
				for(int i=2;i<=n;i++)
				{
					if(Long.toString(n,i).charAt(0)=='1')
					{
						ans++;
					}
					System.out.println(Long.toString(n,i)+" "+i);
				}
				System.out.println(ans);
			}
			t--;
		}
	}
}
