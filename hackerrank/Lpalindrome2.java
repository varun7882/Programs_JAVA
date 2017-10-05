package hackerrank;

import java.io.*;
import java.util.Scanner;

public class Lpalindrome2 {
	public static void main(String[] args)throws IOException {
		//BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		Scanner br=new Scanner(System.in);
		String t= br.next();
		int start=0,l;
		int maxlen=1;
		l=t.length();
		for(int i=1;i<l-1;i++)
		{
			int s,e;
			s=i-1;
			e=i;
			while( s>=0 && e<l &&t.charAt(s)==t.charAt(e))
			{
				s--;
				e++;
				//System.out.print(s+" ");
			}
			if(e-s-1>maxlen)
			{
				maxlen=e-s-1;
				start=s+1;
			}
			s=i-1;
			e=i+1;
			while(t.charAt(s)==t.charAt(e)&& s>=0 && e<l)
			{
				s--;
				e++;
			}
			if(e-s-1>maxlen)
			{
				maxlen=e-s-1;
				start=s+1;
			}
		}
		for(int i=start;i<start+maxlen;i++)
		{
			System.out.print(t.charAt(i));
		}
	}

}
