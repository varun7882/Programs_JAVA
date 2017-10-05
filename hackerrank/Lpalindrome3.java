package hackerrank;
import java.io.*;
public class Lpalindrome3 {
		public static void main(String[] args) throws IOException{
			int rc,c,i,im,ex=0,maxlen=-1,maxc=0,n,df,st;
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			String s= br.readLine();
			int l=s.length();
			n=2*l+1;
			int a[]=new int[n];
			c=1;
			rc=2;
			a[0]=0;
			a[1]=1;
			for(i=2;i<n;i++)
			{
				df=rc-i;
				im=2*c-i;
				ex=0;
				if(df>0)
				{
					if(a[im]<df)
					{
						a[i]=a[im];
					}
					else if(a[im]==df && i==n-1)
					{
						a[i]=a[im];
					}
					else if(a[im]==df && i<n-1)
					{
						a[i]=a[im];
						ex=1;
					}
					else if(a[im]>df)
					{
						a[i]=df;
						ex=1;
					}
				}
				else
				{
					ex=1;
					a[i]=0;
				}
				if(ex==1)
				{
					try
					{
					while((((i+a[i])<n-1 && (i-a[i])>0))&&(((i+a[i]+1)%2==0)||(s.charAt((i+a[i]+1)/2)==s.charAt((i-a[i]-1)/2))))
					{
						a[i]++;
					}
					}
					catch(Exception e)
					{
						//System.out.println(a[i]+" "+i);
					}
					 /* while (((i + a[i]) < n && (i - a[i]) > 0) && 
				                ( ((i + a[i] + 1) % 2 == 0) || 
				                (s.charAt((i + a[i] + 1)/2) == s.charAt((i-a[i]-1)/2) )))
				            {
				                a[i]++;
				            }*/
				}
				if(a[i]>maxlen)
				{
					maxlen=a[i];
					maxc=i;
				}
				if(a[i]+i>rc)
				{
					rc=a[i]+i;
					c=i;
				}
			}
			st=(maxc-maxlen)/2;
			for(i=st;i<st+maxlen;i++)
			{
				System.out.print(s.charAt(i));
			}
		}
}
