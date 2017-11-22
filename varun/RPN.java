package varun;
import java.util.*;
class RPN {
 public static void main(String args[])
 {
	int i,t,j; 
	String s;
	char temp;
	Scanner in= new Scanner(System.in);
	t=in.nextInt();
	for(j=0;j<t;j++)
	{
		Stack st1= new Stack();
	   s=in.next();
		char[] a = s.toCharArray();
		try{
			st1.push("x");
			for(i=0;i<a.length;i++)
			{
				if(a[i]=='(' || a[i]=='+' || a[i]=='-' || a[i]=='*' || a[i]=='/' || a[i]=='^')
				{
					st1.push(a[i]);
				}
				else if(a[i]==')')
				{
					do
					{	
					temp= (Character)(st1.pop());
					if(Character.toString(temp)!="(")
					{	
					System.out.print(temp);
					}
					}while((Character)(st1.pop())!='(');
				}
				else
				{
					if(Character.toString(a[i])!="(")
					{	
					System.out.print(a[i]);
					}
				}
			}
		}
		catch(Exception e )
		{
	
		}
		System.out.println();
  }	
 }
}
