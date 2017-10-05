package interview;
import java.util.*;
public class LetterPhone {
	ArrayList<String> ans=new ArrayList<String>();
    int l;
	public ArrayList<String> letterCombinations(String a) {
	   l=a.length();
	   StringBuilder tmp=new StringBuilder("");
	   makelist(ans,a,tmp,0);
	   Collections.sort(ans);
	   return ans;
	}
    private void makelist(ArrayList<String> ans,String a,StringBuilder tmp,int i)
	{
	    if(i==l)
	    {
	        ans.add(tmp.toString());
	    }
	    else
	    {
	    	char c=a.charAt(i);
	    	int st=tmp.length();
	    	switch(c)
	    	{
	    	case '0':
	    		tmp.append('0');
	    		i++;
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '1':
	    		tmp.append('1');
	    		i++;
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '2':
	    		i++;
	    		tmp.append('a');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());
	    		tmp.append('b');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());
	    		tmp.append('c');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '3':
	    		i++;
	    		tmp.append('d');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());
	    		tmp.append('e');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('f');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '4':
	    		i++;
	    		tmp.append('g');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('h');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('i');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '5':
	    		i++;
	    		tmp.append('j');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('k');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('l');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '6':
	    		i++;
	    		tmp.append('m');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('n');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('o');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '7':
	    		i++;
	    		tmp.append('p');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('q');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('r');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('s');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '8':
	    		i++;
	    		tmp.append('t');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('u');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('v');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	case '9':
	    		i++;
	    		tmp.append('w');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('x');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('y');
	    		makelist(ans,a,tmp,i);
	    		tmp.delete(st,tmp.length());;
	    		tmp.append('z');
	    		makelist(ans,a,tmp,i);
	    		break;
	    	}
	    }
	}
}
