package varun;
import java.io.*;
public class Crc {
	public static void main(String args[]) throws IOException 
	{
		String msg,crcg;
		int i,msgn,crcgn,newmsgn,j,a,b,c,f=0;
		char msga[]= new char[10000];
		char newmsga[]= new char[10000];
		char crcga[]= new char[1000];
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("Enter the messesge in form 0's and 1's of length at max 1000 bits");
		msg=br.readLine();
		System.out.println("Enter the crc generator i.e. the key at max 100 bits");
		crcg= br.readLine();
		msga = msg.toCharArray();
		crcga=crcg.toCharArray();
		msgn=msga.length;
		crcgn=crcga.length;
		System.out.println("msg ");
		for(i=0;i<msgn;i++)
		{
			System.out.print(msga[i]);
		}
		for(i=0;i<msgn+crcgn-1;i++)
		{
			if(i<msgn)
			{
			newmsga[i]=msga[i];
			}
			else
			{
				newmsga[i]='0';
			}
		}
		System.out.println();
		System.out.println("new msg ");
		for(i=0;i<msgn+crcgn-1;i++)
		{
			System.out.print(newmsga[i]);
		}
		newmsgn=newmsga.length;
		i=0;
		c=0;
		//System.out.println(Character.getNumericValue('0'));
		//System.out.println(Character.getNumericValue('1'));
		//System.out.println(Character.getNumericValue('0')^Character.getNumericValue('1'));
		//System.out.println((char)(1+'0'));
		/*while(newmsgn-i>crcgn-1)
		{
			f=0;
			for(j=0;j<crcgn;j++)
			{
				a=Character.getNumericValue(crcga[j]);
				b=Character.getNumericValue(newmsga[i+j]);
				System.out.println("a="+a);
				System.out.println("b="+b);
				b=a^b;
				System.out.println(b);
				if(b==1 && f==0)
				{
					c=i+j;
					f=1;
				}
				newmsga[i+j]=(char)(b+'0');
				System.out.println("substituted bit="+newmsga[i+j]);
			}
			if(f==1)
			{	
			i=c;
			}
			else
			{
				i=i+j;
			}
		}*/
		System.out.println();
		for(i=0;i<msgn+crcgn-1;i++)
		{
			System.out.print(newmsga[i]);
		}
		
		
	}

}
