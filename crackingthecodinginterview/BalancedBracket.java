package crackingthecodinginterview;
import java.util.*;
public class BalancedBracket {
	 
    public static boolean isBalanced(String s) {
        if(s.length()%2!=0)return false;
        Stack<Character> ss= new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
        	char x=s.charAt(i);
        	if(x=='(' || x=='{' || x=='[')
        	{
        		ss.push(x);
        	}
        	else
        	{
        		char y=ss.pop();
        		if(y!=x)
        			{
        			System.out.println("mismatch se");
        			return false;
        			}
        	}
        }
        if(!ss.empty())
        	{
        	System.out.println("stack se");
        	return false;
        	}
        return true;
    }
}
