package interview;
import java.util.*;
public class ShortestUniquePrefix {
	public ArrayList<String> prefix(ArrayList<String> a) {
		 ArrayList<String> ans= new ArrayList<String>();
		 TrieNode root= new TrieNode('*');
		 for(int i=0;i<a.size();i++)
		 {
			TrieNode.addContact(root, a.get(i)); 
		 }
		 for(int i=0;i<a.size();i++)
		 {
			ans.add(TrieNode.prefix(root, a.get(i)));
		 }
		 return ans;
	    }
}
class TrieNode
{
	Map<Character,TrieNode> mp;
	int ch;
	char c;
	boolean isWord;
	TrieNode(Character c)
	{
		mp= new HashMap<Character, TrieNode>();
		this.c=c;
		ch=0;
		isWord=false;
	}
	static void addContact(TrieNode root,String con)
	{
		int i=0;
		TrieNode t=root;
		while(i<con.length())
		{
			if(t.mp.containsKey(con.charAt(i)))
			{
				t.ch++;
				t=t.mp.get(con.charAt(i));
				i++;
			}
			else
			{
				break;
			}
		}
		if(i==con.length())return;
		while(i<con.length())
		{
			t.ch++;
			t.mp.put(con.charAt(i), new TrieNode(con.charAt(i)));
			t=t.mp.get(con.charAt(i));
			i++;
		}
		t.isWord=true;
	}
	static int findContact(TrieNode root,String con)
	{
		int i=0,ans=0;
		TrieNode t=root;
		while(i<con.length())
		{
			if(t.mp.containsKey(con.charAt(i)))
			{
				t=t.mp.get(con.charAt(i));
				i++;
			}
			else
			{
				break;
			}
		}
		if(i!=con.length())return 0;
		ans=t.ch;
		if(t.isWord)ans++;
		return ans;
	}
	static String prefix(TrieNode root,String con)
	{
		int i=0,wrd=0;
		TrieNode t=root;
		StringBuffer tmp= new StringBuffer("");
		while(i<con.length())
		{
			if(t.mp.containsKey(con.charAt(i)))
			{
				t=t.mp.get(con.charAt(i));
				tmp.append(t.c);
				wrd=t.ch;
				if(t.isWord)
				{
					wrd++;
				}
				if(wrd==1)
				{
					return tmp.toString();
				}
			}
			else
			{
				return "";
			}
			i++;
		}
		return "";
	}
}